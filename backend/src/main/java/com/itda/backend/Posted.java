package com.itda.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Table(name = "Posted")
@Entity
public class Posted {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false,length = 30)
    public String even;

    @Column(nullable = false,length = 100)
    public String thought;

    @Column(nullable = false,length = 100)
    public String test;


}

