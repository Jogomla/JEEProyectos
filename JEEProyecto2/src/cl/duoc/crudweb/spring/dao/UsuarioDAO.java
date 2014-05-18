package cl.duoc.crudweb.spring.dao;


import cl.duoc.crudweb.spring.to.UsuarioTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends GenericDAO implements IUsuarioDAO {

    @Autowired
    private DataSource datasource;

    public UsuarioTO obtenerUsuario() {

        UsuarioTO usuarioTO = new UsuarioTO();

        usuarioTO.setNombre("carlos");
        usuarioTO.setEmail("carlo@profesor.duoc.cl");

        return usuarioTO;
    }

    public UsuarioTO getUsuarioByEmailAndPass(String email) {

        UsuarioTO usuario = null;

        try {
            con = datasource.getConnection();

            if (con != null) {

                String query = "select email, password from usuario where email = ?";
                ps = con.prepareStatement(query);
                ps.setString(0, email);
                rs = ps.executeQuery();

                while (rs.next()) {
                    usuario = new UsuarioTO();
                    usuario.setEmail(rs.getString("email"));
                    usuario.setPassword(rs.getString("password"));
                }

            }
        } catch (SQLException sqlEx) {

            sqlEx.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            close(con);
            close(ps);
            close(rs);

        }

        return usuario;
    }

    public List<UsuarioTO> getAllUsers() {

        List<UsuarioTO> usuarios = new ArrayList<UsuarioTO>();

        try {
            con = datasource.getConnection();

            if (con != null) {

                String query = "select email, password from usuario order by email";
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    UsuarioTO usuario = new UsuarioTO();
                    usuario.setEmail(rs.getString("email"));
                    usuario.setPassword(rs.getString("password"));
                    usuarios.add(usuario);
                }

            }
        } catch (SQLException sqlEx) {

            sqlEx.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            close(con);
            close(ps);
            close(rs);

        }

        return usuarios;
    }


    public void addUsuario(UsuarioTO usuarioTO) {

        try {
            con = datasource.getConnection();

            if (con != null) {

                String query = "insert into usuario(email,password) values (?,?)";
                ps = con.prepareStatement(query);
                ps.setString(1, usuarioTO.getEmail());
                ps.setString(2, usuarioTO.getPassword());
                ps.execute();

            }
        } catch (SQLException sqlEx) {

            sqlEx.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            close(con);
            close(ps);
            close(rs);

        }

    }


    public void updateUsuario(UsuarioTO usuarioTO) {
        try {
            con = datasource.getConnection();

            if (con != null) {

                String query = "update usuario set password = ? where email = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, usuarioTO.getPassword());
                ps.setString(2, usuarioTO.getEmail());
                ps.execute();

            }
        } catch (SQLException sqlEx) {

            sqlEx.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            close(con);
            close(ps);
            close(rs);

        }
    }


    public void deleteUsuario(UsuarioTO usuarioTO) {
        try {
            con = datasource.getConnection();

            if (con != null) {

                String query = " delete from usuario where email = ? ";
                ps = con.prepareStatement(query);
                ps.setString(1, usuarioTO.getEmail());
                ps.execute();

            }
        } catch (SQLException sqlEx) {

            sqlEx.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            close(con);
            close(ps);
            close(rs);

        }
    }

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }
}
