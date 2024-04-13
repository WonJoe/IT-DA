package com.itda.location;

import java.security.Timestamp;

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
@Table(name = "Location")
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private float lat;

    @Column(nullable = false)
    private float lng;

    @Column(nullable = false)
    private float adjustedLat;

    @Column(nullable = false)
    private float adjustedLng;

    @Column(nullable = false)
    private Timestamp createdLocationTime;

    // Post 엔티티와의 일대일 관계를 설정합니다.
    // @OneToOne(mappedBy = "location")
    // private Post post;

    
    
}
