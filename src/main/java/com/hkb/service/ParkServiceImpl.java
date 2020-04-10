package com.hkb.service;

import com.hkb.Utils.Constant;
import com.hkb.dao.ParkMapper;
import com.hkb.pojo.Park;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

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

    public List<Park> selectPark() {
        ParkMapper mapper = sqlSession.getMapper(ParkMapper.class);
        return mapper.selectPark();
    }

    public List<Park> selectEmptyPark() {
        ParkMapper mapper = sqlSession.getMapper(ParkMapper.class);
        return mapper.selectEmptyPark();
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
}
