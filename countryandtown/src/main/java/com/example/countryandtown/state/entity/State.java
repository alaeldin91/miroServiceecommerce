package com.example.countryandtown.state.entity;

import com.example.countryandtown.country.entity.Country;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "state")
public class State {
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
    @JoinColumn(name = "country_id" ,referencedColumnName = "id",insertable = false,updatable = false)
    private Country country;
    @Column(nullable = false)
    private long country_id;
}
