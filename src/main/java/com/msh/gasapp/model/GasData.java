package com.msh.gasapp.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "gas_data")
public class GasData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "value")
    private int value;
}
