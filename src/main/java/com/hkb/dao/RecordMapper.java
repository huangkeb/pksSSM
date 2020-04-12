package com.hkb.dao;

import com.hkb.pojo.Record;

import java.util.List;
import java.util.Map;

public interface RecordMapper {
    public int insertRecord(Record record);

    public List<Record> selectRecord(Map<String,Object> map);
}
