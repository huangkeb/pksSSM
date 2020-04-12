package com.hkb.service;

import com.hkb.Utils.Constant;
import com.hkb.dao.ParkMapper;
import com.hkb.dao.RecordMapper;
import com.hkb.pojo.Park;
import com.hkb.pojo.Record;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service("park")
public class ParkServiceImpl implements ParkService{
    public SqlSessionTemplate sqlSession;

    @Autowired
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public String addCar(String carno,String cartype) {
        ParkMapper mapper = sqlSession.getMapper(ParkMapper.class);
        //数据处理
        switch (Integer.parseInt(cartype)){
            case 1:{
                cartype = "小型汽车";
                break;
            }
            case 2:{
                cartype = "大型客车";
            }
            case 3:{
                cartype = "载货卡车";
                break;
            }
            case 4:{
                cartype = "施工挂车";
            }
            case 5:{
                cartype = "小型轿车";
                break;
            }
            case 6:{
                cartype = "小型客车";
            }
        }
        List<Park> parks = mapper.selectEmptyPark();
        Date data_time = new Date();
        java.sql.Timestamp intime = new java.sql.Timestamp(data_time.getTime());
        Random ra =new Random();
        Park empty = parks.get(ra.nextInt(parks.size()));
        String Parkno = empty.getParkno();
        Park park = new Park(Parkno,carno,cartype,intime);
        int success = mapper.addCar(park);
        if(success == 1){
            return Parkno;
        }
        else return Constant.CarInFailure;
    }

    public String deleteCar(String carno) {
        ParkMapper parkMapper = sqlSession.getMapper(ParkMapper.class);
        RecordMapper recordMapper = sqlSession.getMapper(RecordMapper.class);
        Park park = parkMapper.selectParkByNo(carno);
        String parkno = park.getParkno();
        String cartype = park.getCartype();
        Timestamp intime = park.getIntime();
        Date data_time = new Date();
        Timestamp outtime = new Timestamp(data_time.getTime());//当前时间
        Calendar cale = Calendar.getInstance();
        Calendar calendar = new GregorianCalendar(cale.get(Calendar.YEAR),cale.get(Calendar.MONTH),cale.get(Calendar.DAY_OF_MONTH),8,0,0);
        Date date = calendar.getTime();
        Timestamp deadline = new Timestamp(date.getTime());//收费标准变化时间点
        long waittime =  outtime.getTime() - intime.getTime();
        int wait = (int)(waittime/60000);
        int cost = 0;
        int waithour = wait/60;
        int waitmin = wait%60;
        int day = waithour/24;
        int waitHour = waithour%24;
        cost+=16*day;
        if(outtime.after(deadline)){
            if(waitmin<60&&waitmin>15&&waitHour ==0){
                cost+=4;
            }
            else if(waitHour<4&&waitHour>=1){
                cost+=4*waitHour;
                int minter = wait - day*24*60 - waitHour*60;
                minter /=30;
                minter+=1;
                cost+=minter*2;
            }
            else if(waitHour>=4){
                cost+=16;
            }
        }
        else{
            cost+=4;
        }
        if(cartype.equals("大型客车")||cartype.equals("施工挂车")||cartype.equals("载货卡车")){
            cost*=2;
        }
        Record record = new Record(parkno,carno,cartype,intime,outtime,wait,cost);
        int delete = parkMapper.deleteCar(carno);
        int insert = recordMapper.insertRecord(record);
        if(delete == 1 && insert == 1){
            return String.valueOf(cost);
        }
        else {
            return Constant.CarOutFailure;
        }
    }

    public List<Park> selectPark() {
        ParkMapper mapper = sqlSession.getMapper(ParkMapper.class);
        return mapper.selectPark();
    }

    public String carInCheck(String carno) {
        ParkMapper mapper = sqlSession.getMapper(ParkMapper.class);
        Park park = mapper.selectParkByNo(carno);
        if(park == null){
            List<Park> parks = mapper.selectEmptyPark();
            if(parks.size() != 0) return Constant.AllowIn;
            else return Constant.ParkFull;
        }
        else {
            return Constant.CarExist;
        }
    }

    public String carOutCheck(String carno) {
        ParkMapper mapper = sqlSession.getMapper(ParkMapper.class);
        Park park = mapper.selectParkByNo(carno);
        if(park == null){
            return Constant.CarNotExist;
        }
        else return Constant.CarExist;
    }
}
