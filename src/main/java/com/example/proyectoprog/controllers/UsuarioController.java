package com.example.proyectoprog.controllers;
import com.example.proyectoprog.dao.UsuarioDao;
import com.example.proyectoprog.models.Usuario;
import com.example.proyectoprog.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired private JWTUtil jwtUtil;

    @RequestMapping(value="usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization")String token){
        String usuarioId= jwtUtil.getKey(token);
        if (usuarioId==null){
            return new ArrayList<>();
        }
        List <Usuario> user=usuarioDao.getUsuarios();
        return user;
    }

    @RequestMapping(value="usuarios/{id}", method= RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization")String token, @PathVariable Long id) {

        String usuarioId=jwtUtil.getKey(token);
        if (usuarioId==null){
            return;
        }
        usuarioDao.eliminar(id);

    }

    @RequestMapping(value="usuarios", method= RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash=argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);

    }

    @PostMapping("usuarios/login")
    public Usuario login(@RequestBody Usuario usuario) {
        return usuarioDao.obtenerUsuarioPorCredenciales(usuario);
    }




}
