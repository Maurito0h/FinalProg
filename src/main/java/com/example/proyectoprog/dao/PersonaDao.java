package com.example.proyectoprog.dao;

import com.example.proyectoprog.models.Persona;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface PersonaDao {
    List <Persona> getPersonas();
    }



