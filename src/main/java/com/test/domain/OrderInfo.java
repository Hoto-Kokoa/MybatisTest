package com.test.domain;

public class OrderInfo {
    private Integer id;
    private String orderNo;
    private Double price;
    private String createTime;

    private String ids;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getOrderNo () {
        return orderNo;
    }

    public void setOrderNo (String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice (Double price) {
        this.price = price;
    }

    /*public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }*/

    public String getCreateTime () {
        return createTime;
    }

    public void setCreateTime (String createTime) {
        this.createTime = createTime;
    }

    public String getIds () {
        return ids;
    }

    public void setIds (String ids) {
        this.ids = ids;
    }

    @Override
    public String toString () {
        return "OrderInfo{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                '}';
    }
}
