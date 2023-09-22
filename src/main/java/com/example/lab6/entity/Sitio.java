package com.example.lab6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "site")
@Getter
@Setter
public class Sitio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID",nullable = false)
    private Integer idsitio;

    @Column(name = "SiteName", length =255)
    private String nombresitio;
    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Locacion locacion;

    @Column(name = "InstallationDate")
    private Date fechainstalacion;

    @Column(name = "Latitude")
    private String latitud;

    @Column(name = "Longitude")
    private String longitud;


}
