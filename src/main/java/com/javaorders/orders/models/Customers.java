package com.javaorders.orders.models;


import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customers
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    @Column(nullable = false)

    private String name;
    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private Double openingamt;
    private Double receiveamt;
    private Double payment;
    private Double outstandingamt;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    Agents agentcode;

    public Customers() {
    }

    public Customers(String name, String custcity, String workingarea, String custcountry, String grade, Double openingamt, Double receiveamt, Double payment, Double outstandingamt, String phone, Agents agentcode) {
        this.name = name;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.payment = payment;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agentcode = agentcode;
    }

    public long getCustcode() {
        return custcode;
    }

    public void setCustcode(long custcode) {
        this.custcode = custcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String custname) {
        this.name = name;
    }

    public String getCustcity() {
        return custcity;
    }

    public void setCustcity(String custcity) {
        this.custcity = custcity;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public String getCustcountry() {
        return custcountry;
    }

    public void setCustcountry(String custcountry) {
        this.custcountry = custcountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getOpeningamt() {
        return openingamt;
    }

    public void setOpeningamt(Double openingamt) {
        this.openingamt = openingamt;
    }

    public Double getReceiveamt() {
        return receiveamt;
    }

    public void setReceiveamt(Double receiveamt) {
        this.receiveamt = receiveamt;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getOutstandingamt() {
        return outstandingamt;
    }

    public void setOutstandingamt(Double outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agents getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(Agents agentcode) {
        this.agentcode = agentcode;
    }
}
