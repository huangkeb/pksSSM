package com.hkb.dao;

import com.hkb.pojo.Park;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkMapper {
    public int addCar(Park park);

    public int deleteCar(@Param("carno") String carno);

    public List<Park> selectPark();

    public Park selectParkByNo(@Param("carno") String carno);

    public List<Park> selectEmptyPark();
}
