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
@Table(name = "Post")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 30)
    private String title;

    @Column(nullable = false,length = 100)
    private String contents;

    @Column(nullable = true,length = 150)
    private String test;

    // @OneToOne
    // @JoinColumn(name = "location_id")
    // private Location location;


}

