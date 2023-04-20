package com.example.countryandtown.city.entity;

import com.example.countryandtown.country.entity.Country;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "name2")
    private String name2;
    private String hieCode;
    private String hieDesc;
    private String dohCode;
    @ManyToOne()
    @JoinColumn(name = "country_id"
            ,referencedColumnName = "id"
            ,insertable = false,updatable = false)
       private Country country;
    private long country_id;
}
