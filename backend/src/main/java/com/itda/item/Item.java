package com.itda.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Table(name = "Item")
@Entity
public class Item {

    @Id
    @Column(name = "user_no")
    private Long userNo;
    
    @Column(nullable = true)
    private int pinn;

    @Column(nullable = true)
    private int dia;

    
    
    
}
