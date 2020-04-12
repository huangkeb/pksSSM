package com.hkb.controller;

import com.hkb.pojo.Record;
import com.hkb.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/record")
public class RecordController {
    private RecordService recordService;

    @Autowired
    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping("/query")
    public String selectRecord(String carno, String begintime, String endtime, Model model){
        List<Record> records = recordService.selectRecord(carno, begintime, endtime);
        model.addAttribute("records",records);
        return "display";
    }
}
