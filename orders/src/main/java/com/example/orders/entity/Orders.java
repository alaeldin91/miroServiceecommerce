package com.example.orders.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order-tracking-name")
    private String orderTrackingName;
    private int totalQuantity;
    private String status;

    @Column(name = "created-date")
    @CreationTimestamp
    private Date createdDate;
    @Column(name = "update_date")
    @UpdateTimestamp
    private Date updateDate;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address",referencedColumnName = "id")
    private Address billingAddress;
  @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private Set<OrdersItem> ordersItems = new HashSet<>();
    public  void add(OrdersItem item){
    if (item != null){
        if (ordersItems ==null){
       ordersItems = new HashSet<>();
        }
        ordersItems.add(item);
        item.setOrder(this);
    }

    }
}
