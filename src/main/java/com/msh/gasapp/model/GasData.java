package com.msh.gasapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "company_id")
    private Company company;

    public GasData(Timestamp timestamp, int value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
