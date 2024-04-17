package com.itda.location;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
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
    private double lat;

    @Column(nullable = false)
    private double lng;

    @Column(nullable = true)
    private double adjustedLat;

    @Column(nullable = true)
    private double adjustedLng;
    
    // @Column(nullable = false)
    // private Timestamp createdLocationTime = getRoundedTimestamp();

    @Column(nullable = false)
    private Timestamp createdLocationTime;
    
    @Column(nullable = false)
    private String address;

    @PrePersist
    public void prePersist() {
        this.createdLocationTime = new Timestamp(System.currentTimeMillis());
    }
    
}


