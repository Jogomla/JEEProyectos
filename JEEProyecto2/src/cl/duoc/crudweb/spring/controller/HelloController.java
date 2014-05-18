package cl.duoc.crudweb.spring.controller;

import cl.duoc.crudweb.spring.bean.IUsuarioBean;
import cl.duoc.crudweb.spring.to.UsuarioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private IUsuarioBean usuarioBean;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "default", method = RequestMethod.GET)
    public String defaultUsuario(ModelMap model) {
        model.addAttribute("usuario", usuarioBean.obtenerUsuarioDefault());
        return "usuario";
    }

    @RequestMapping(value = "lista", method = RequestMethod.GET)
    public String listaUsuarios(ModelMap model) {
        model.addAttribute("usuarios", usuarioBean.getAllUsuarios());
        return "listaUsuarios";
    }

    @RequestMapping(value = "agregarUsuario", method = RequestMethod.GET)
    public String agregarUsuario(ModelMap model) {
        return "agregarUsuario";
    }

    @RequestMapping(value = "addUsuario", method = RequestMethod.GET)
    public String addUsuario(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap model) {
        UsuarioTO usuarioTO = new UsuarioTO();
        usuarioTO.setEmail(email);
        usuarioTO.setPassword(password);
        usuarioBean.addUser(usuarioTO);
        model.addAttribute("usuarios", usuarioBean.getAllUsuarios());
        return "listaUsuarios";
    }


    public void setUsuarioBean(IUsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
}