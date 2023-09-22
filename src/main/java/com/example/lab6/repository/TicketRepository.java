package com.example.lab6.repository;

import com.example.lab6.dto.SitioMinimoDto;
import com.example.lab6.dto.SitiosEstadisticaDto;
import com.example.lab6.entity.Sitio;
import com.example.lab6.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(value = "SELECT s.SiteName as nombreSitio, count(*) as cantidadTickets FROM ticket t \n" +
            "inner join site s on t.SiteID = s.SiteID\n" +
            "group by s.SiteID;  ",
            nativeQuery = true)
    List<SitiosEstadisticaDto> obtenerEstadisticasSitio();


    @Query(value = "Select MIN(cantidadtickets) as minimo\n" +
            "    FROM (SELECT s.SiteName as nombresitio, count(*) as cantidadtickets FROM ticket t\n" +
            "    inner join site s on t.SiteID = s.SiteID\n" +
            "    group by s.SiteID) as minimoTicket;",
            nativeQuery = true)
    List<SitioMinimoDto> obtenerMinimo();


}

