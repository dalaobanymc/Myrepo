package ssm.model;

import java.util.Date;

public class Logistics {
    private long logisticsId;
    private long goodsId;
    private long userId;
    private long MerchantsId;
    private long courierId;
    private String placeNow;
    private String logisticsState;

    public long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMerchantsId() {
        return MerchantsId;
    }

    public void setMerchantsId(long merchantsId) {
        MerchantsId = merchantsId;
    }

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public String getPlaceNow() {
        return placeNow;
    }

    public void setPlaceNow(String placeNow) {
        this.placeNow = placeNow;
    }

    public String getLogisticsState() {
        return logisticsState;
    }

    public void setLogisticsState(String logisticsState) {
        this.logisticsState = logisticsState;
    }
}
