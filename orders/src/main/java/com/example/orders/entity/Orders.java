package com.example.orders.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

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

}
