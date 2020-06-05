package com.briup.estore.bean;

import java.io.Serializable;
import java.util.Date;

public class OrderForm implements Serializable {
    private Integer id;

    private Double cost;

    private Date orderdate;

    private Integer shopaddressId;

    private Integer customerId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getShopaddressId() {
        return shopaddressId;
    }

    public void setShopaddressId(Integer shopaddressId) {
        this.shopaddressId = shopaddressId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cost=").append(cost);
        sb.append(", orderdate=").append(orderdate);
        sb.append(", shopaddressId=").append(shopaddressId);
        sb.append(", customerId=").append(customerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}