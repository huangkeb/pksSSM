package com.hkb.controller;

import com.hkb.Utils.Constant;
import com.hkb.pojo.Park;
import com.hkb.service.ParkService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/park")
public class ParkController {

    private ParkService parkService;
    @Autowired
    public void setParkService(ParkService parkService) {
        this.parkService = parkService;
    }

    @RequestMapping("/state")
    public String state(Model model){//查看车位
        List<Park> parks = parkService.selectPark();
        model.addAttribute("stateList",parks);
        return "state";
    }

    @PostMapping("/getIn")
    public String getIn(Model model,String carno,String cartype){
        String message = parkService.addCar(carno, cartype);
        if (message.equals(Constant.CarInFailure)){
            model.addAttribute("message","系统错误，请稍后重试！");
        }
        else {
            model.addAttribute("message","车辆入库成功，您的车位是"+message+"号");
        }
        model.addAttribute("title","车辆入库结果");
        return "result";
    }

    @PostMapping("/getInCheck")
    @ResponseBody
    public String getInCheck(String carno){//车辆入库前Ajax校验接口
        return parkService.carInCheck(carno);
    }

    @PostMapping("/getOutCheck")
    @ResponseBody
    public String getOutCheck(String carno){
        return parkService.carOutCheck(carno);
    }

    @PostMapping("/getOut")
    public String getOut(String carno,Model model){
        String message = parkService.deleteCar(carno);
        model.addAttribute("title","车辆出库结果");
        if(message.equals(Constant.CarOutFailure)){
            model.addAttribute("message","系统错误，请稍后重试！");
            return "result";
        }
        model.addAttribute("message","出库成功，您本次的费用为"+message+"元,祝您一路平安！");
        return "pay";
    }
}
