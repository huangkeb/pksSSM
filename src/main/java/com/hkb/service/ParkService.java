package com.hkb.service;

import com.hkb.pojo.Park;

import java.util.List;

public interface ParkService {
    public String addCar(String carno,String cartype);

    public List<Park> selectPark();

    public List<Park> selectEmptyPark();

    public String carInCheck(String carno);
}
