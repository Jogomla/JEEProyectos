package cl.duoc.crudweb.spring.dao;


import cl.duoc.crudweb.spring.to.UsuarioTO;

import java.util.List;

public interface IUsuarioDAO {

    UsuarioTO obtenerUsuario();

    UsuarioTO getUsuarioByEmailAndPass(String email);

    List<UsuarioTO> getAllUsers();

    void addUsuario(UsuarioTO usuarioTO);

    void updateUsuario(UsuarioTO usuarioTO);

    void deleteUsuario(UsuarioTO usuarioTO);

}
