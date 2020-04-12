package com.hkb.service;

import com.hkb.pojo.Park;

import java.util.List;

public interface ParkService {
    public String addCar(String carno,String cartype);

    public String deleteCar(String carno);

    public List<Park> selectPark();

    public String carInCheck(String carno);

    public String carOutCheck(String carno);
}
