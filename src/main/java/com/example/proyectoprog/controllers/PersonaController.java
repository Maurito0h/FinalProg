package com.example.proyectoprog.controllers;
import com.example.proyectoprog.dao.PersonaDao;
import com.example.proyectoprog.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private PersonaDao personaDao;

    @RequestMapping(value="persona")
    public List<Persona> getPersonas(){
        List <Persona> user=personaDao.getPersonas();
        return user;
    }


}

