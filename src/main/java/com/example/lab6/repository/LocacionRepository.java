package com.example.lab6.repository;

import com.example.lab6.entity.Locacion;
import com.example.lab6.entity.Sitio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacionRepository extends JpaRepository<Locacion, Integer> {
}
