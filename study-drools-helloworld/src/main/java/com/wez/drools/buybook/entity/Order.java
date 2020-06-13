package com.wez.drools.buybook.entity;

public class Order {
    
    private Integer originalPrice;//订单原始价格，即优惠前价格
    private Integer realPrice;//订单真实价格，即优惠后价格
    
    public String toString() {
        return "Order{" +
                "originalPrice=" + originalPrice +
                ", realPrice=" + realPrice +
                '}';
    }
    
    public Integer getOriginalPrice() {
        return originalPrice;
    }
    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }
    public Integer getRealPrice() {
        return realPrice;
    }
    public void setRealPrice(Integer realPrice) {
        this.realPrice = realPrice;
    }

}
