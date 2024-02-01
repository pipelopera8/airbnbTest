package com.flypass.airbnb.model;

import com.flypass.airbnb.general.Enum.EnumStatusHouse;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Table(name = "tfps_casas")
@Data
public class House {

    @Id
    @Column(name = "cdcasa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dscasa")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cdubicacion")
    private Location location;

    @Column(name = "cddisponibilidad")
    private EnumStatusHouse status;

    @Column(name = "dsurl_casa")
    private String image;

    @Column(name = "vrprecio")
    private BigDecimal amount;


}
