package com.javaorders.orders.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderid;

    @Column
    private double ordamount;
    private double advanceamount;
    private String orddescription;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custcode",nullable = false)
    Customers custcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agentcode", nullable = false)
    Agents agentcode;

    public Orders() {
    }

    public Orders(double ordamount, double advanceamount, Customers custcode, Agents agentcode,String orddescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orddescription = orddescription;
        this.custcode = custcode;
        this.agentcode = agentcode;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrddescription() {
        return orddescription;
    }

    public void setOrddescription(String orddescription) {
        this.orddescription = orddescription;
    }

    public Customers getCustcode() {
        return custcode;
    }

    public void setCustcode(Customers custcode) {
        this.custcode = custcode;
    }

    public Agents getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(Agents agentcode) {
        this.agentcode = agentcode;
    }
}
