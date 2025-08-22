package com.example.proyectoprog.controllers;

import com.example.proyectoprog.dao.UsuarioDao;
import com.example.proyectoprog.models.Usuario;
import com.example.proyectoprog.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtutil;

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        Usuario usuariologueado=usuarioDao.obtenerUsuarioPorCredenciales(usuario);

        if (usuariologueado!=null){
            String tokenJwt=jwtutil.create(String.valueOf(usuariologueado.getId()), usuariologueado.getEmail());

            return tokenJwt;
    }
    return "Fail";
}
}