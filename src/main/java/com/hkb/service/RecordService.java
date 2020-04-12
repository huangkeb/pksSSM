package com.hkb.service;

import com.hkb.pojo.Record;

import java.util.List;
import java.util.Map;

public interface RecordService {
    public List<Record> selectRecord(String carno,String begin,String end);
}
