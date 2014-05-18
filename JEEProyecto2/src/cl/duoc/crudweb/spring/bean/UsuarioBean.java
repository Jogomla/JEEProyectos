package cl.duoc.crudweb.spring.bean;

import cl.duoc.crudweb.spring.dao.IUsuarioDAO;
import cl.duoc.crudweb.spring.to.UsuarioTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UsuarioBean implements IUsuarioBean {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    public UsuarioTO obtenerUsuarioDefault() {
        return usuarioDAO.obtenerUsuario();
    }


    public UsuarioTO getUsuario(String email) {

        return usuarioDAO.getUsuarioByEmailAndPass(email);

    }

    public List<UsuarioTO> getAllUsuarios() {

        return usuarioDAO.getAllUsers();

    }

    public void addUser(UsuarioTO usuarioTO) {

        usuarioDAO.addUsuario(usuarioTO);

    }


    public void updateUser(UsuarioTO usuarioTO) {

        usuarioDAO.updateUsuario(usuarioTO);

    }

    public void deleteUser(UsuarioTO usuarioTO) {

        usuarioDAO.deleteUsuario(usuarioTO);

    }

    public void setUsuarioDAO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
