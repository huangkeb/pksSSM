package com.hkb.service;

import com.hkb.dao.RecordMapper;
import com.hkb.pojo.Record;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService{
    private SqlSessionTemplate sqlSession;

    @Autowired
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Record> selectRecord(String carno, String begin, String end) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(!carno.equals("")){
            map.put("carno",carno);
        }
        if(!begin.equals("")){
            Timestamp begintime = null;
            Timestamp endtime = null;
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = format.parse(begin);
                date2 = format.parse(end);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            begintime = new Timestamp(date1.getTime());//开始时间
            endtime = new Timestamp(date2.getTime());//结束时间
            map.put("begin",begintime);
            map.put("end",endtime);
        }
        RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);
        List<Record> records = mapper.selectRecord(map);
        return records;
    }
}
