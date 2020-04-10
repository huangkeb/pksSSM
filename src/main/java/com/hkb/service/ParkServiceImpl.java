package com.hkb.service;

import com.hkb.dao.ParkMapper;
import com.hkb.pojo.Park;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("park")
public class ParkServiceImpl implements ParkService{
    public SqlSessionTemplate sqlSession;

    @Autowired
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Park> selectPark() {
        ParkMapper mapper = sqlSession.getMapper(ParkMapper.class);
        return mapper.selectPark();
    }
}
