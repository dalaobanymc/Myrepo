package ssm.model;

import java.util.Date;

public class Courier {
    private long courierId;
    private String courierName;
    private String courierTel;
    private String courierArea;
    private String courierGoodsNum;

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getCourierTel() {
        return courierTel;
    }

    public void setCourierTel(String courierTel) {
        this.courierTel = courierTel;
    }

    public String getCourierArea() {
        return courierArea;
    }

    public void setCourierArea(String courierArea) {
        this.courierArea = courierArea;
    }

    public String getCourierGoodsNum() {
        return courierGoodsNum;
    }

    public void setCourierGoodsNum(String courierGoodsNum) {
        this.courierGoodsNum = courierGoodsNum;
    }
}
