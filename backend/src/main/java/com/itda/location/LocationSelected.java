package com.itda.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "LocationSelected")
@Entity
public class LocationSelected {

    @Id
    @Column(name = "user_no")
    private Long userNo;

    @Column(nullable = true)
    private Long selected;
    
}
