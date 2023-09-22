package com.example.demojpa.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Column(name = "order_date",columnDefinition = "DATETIME(6)")
    private LocalDateTime orderDate;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    public Order() {
    }

    public Order(LocalDateTime orderDate, Customer customer, Employee employee) {
        this.orderDate = orderDate;
        this.customer = customer;
        this.employee = employee;

    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}