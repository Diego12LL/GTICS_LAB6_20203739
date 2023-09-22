package com.example.lab6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID",nullable = false)
    private Integer idticket;
    @ManyToOne
    @JoinColumn (name = "SiteID")
    private Sitio idsitio;

    @Column(name = "TechnicianID")
    private int idtecnico;



}