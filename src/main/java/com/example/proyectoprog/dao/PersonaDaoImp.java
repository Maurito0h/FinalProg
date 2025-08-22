package com.example.proyectoprog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.proyectoprog.models.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class PersonaDaoImp implements PersonaDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Persona> getPersonas() {
        String query="from Persona";
        return entityManager.createQuery(query, Persona.class).getResultList();
    }
}
