package com.hkb.controller;

import com.hkb.pojo.Park;
import com.hkb.service.ParkService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/park")
public class ParkController {

    private ParkService parkService;
    @Autowired
    public void setParkService(ParkService parkService) {
        this.parkService = parkService;
    }

    @RequestMapping("/state")
    public String state(Model model){
        List<Park> parks = parkService.selectPark();
        model.addAttribute("stateList",parks);
        return "state";
    }
}
