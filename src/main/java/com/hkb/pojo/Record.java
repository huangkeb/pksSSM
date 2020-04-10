package com.hkb.pojo;

import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Alias("Record")
public class Record {
    private String parkno = "";
    private String carno = "";
    private String cartype = "";
    private Timestamp intime;
    private Timestamp outtime;
    private int waittime = 0;
    private int cost = 0;

    public Record() {
    }

    public Record(String parkno, String carno, String cartype, Timestamp intime, Timestamp outtime, int waittime, int cost) {
        this.parkno = parkno;
        this.carno = carno;
        this.cartype = cartype;
        this.intime = intime;
        this.outtime = outtime;
        this.waittime = waittime;
        this.cost = cost;
    }

    public String getParkno() {
        return parkno;
    }

    public void setParkno(String parkno) {
        this.parkno = parkno;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public Timestamp getIntime() {
        return intime;
    }

    public void setIntime(Timestamp intime) {
        this.intime = intime;
    }

    public Timestamp getOuttime() {
        return outtime;
    }

    public void setOuttime(Timestamp outtime) {
        this.outtime = outtime;
    }

    public int getWaittime() {
        return waittime;
    }

    public void setWaittime(int waittime) {
        this.waittime = waittime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Record{" +
                "parkno='" + parkno + '\'' +
                ", carno='" + carno + '\'' +
                ", cartype='" + cartype + '\'' +
                ", intime=" + intime +
                ", outtime=" + outtime +
                ", waittime=" + waittime +
                ", cost=" + cost +
                '}';
    }
}
