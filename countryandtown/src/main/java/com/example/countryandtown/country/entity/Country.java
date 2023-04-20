package com.example.countryandtown.country.entity;


import com.example.countryandtown.state.entity.State;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id",
        scope=Country.class)
public class Country {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
@Column(name = "name",nullable = false,length = 200)
    private String name;
@Column(name = "name2",length = 200)
    private String name2;
  private long countryId;
  private String alpha2Code;
  private String alpha3Code;
  private String hieCode;
  private String hieDesc;
  private String hieNationalityDesc;
  @OneToMany()
    private Set<State> state;
}
