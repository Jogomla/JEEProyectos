package cl.duoc.crudweb.spring.bean;


import cl.duoc.crudweb.spring.to.UsuarioTO;

import java.util.List;

public interface IUsuarioBean {

    UsuarioTO obtenerUsuarioDefault();

    UsuarioTO getUsuario(String email);

    List<UsuarioTO> getAllUsuarios();

    void addUser(UsuarioTO usuarioTO);

    void updateUser(UsuarioTO usuarioTO);

    void deleteUser(UsuarioTO usuarioTO);
    
    //Comentario de cambios
}
