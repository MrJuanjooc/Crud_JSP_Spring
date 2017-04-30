/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODELOS.Conectar;
import MODELOS.Usuarios;
import MODELOS.Usuarios_Validar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JUAN
 */
@Controller
@RequestMapping("edit.htm")
public class Edit_Controller 
{
    Usuarios_Validar usuarios_Validar;
    private JdbcTemplate jdbcTemplate;
    
    public Edit_Controller()
    {
        //this.usuarios_Validar = new Usuarios_Validar();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.Conectar());
        
    }
    
    @RequestMapping (method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        Usuarios datos= this.SelectUsuarios(id);
        mav.setViewName("edit");
        mav.addObject("usuarios",new Usuarios(id,datos.getNombre(),datos.getCorreo(),datos.getTelefono()));
        return mav;
    }
    
    @RequestMapping (method = RequestMethod.POST)
    public ModelAndView form
            (
                    @ModelAttribute ("usuarios") Usuarios u,
                    BindingResult result,
                    SessionStatus status,
                    HttpServletRequest request
                        
            )
            {
              //this.usuarios_Validar.validate(u, result);
                if(result.hasErrors())
        {
             ModelAndView mav=new ModelAndView();
            int id=Integer.parseInt(request.getParameter("id"));
            Usuarios datos=this.SelectUsuarios(id);
            mav.setViewName("edit");
            mav.addObject("usuarios",new Usuarios(id,datos.getNombre(),datos.getCorreo(),datos.getTelefono()));
            return mav;
                }
                
                else
                {
                    int id=Integer.parseInt(request.getParameter("id"));
                    this.jdbcTemplate.update
                    (
                        "update usuarios set nombre=?, correo=?,telefono=? where id=?",u.getNombre(), u.getCorreo(), u.getTelefono(), id);
                    return new ModelAndView("redirect:/home.htm");
                }
            }
    
    public Usuarios SelectUsuarios(int id)
    {
        final Usuarios user = new Usuarios();
        String quer = "SELECT * FROM usuarios WHERE id='" + id+"'";
        return (Usuarios) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<Usuarios>() 
             {
                public Usuarios extractData(ResultSet rs) throws SQLException, DataAccessException
              {
                  if (rs.next()) 
                  {
                    user.setNombre(rs.getString("nombre"));
                    user.setCorreo(rs.getString("correo"));
                    user.setTelefono(rs.getString("telefono"));   
                  }
                  return user;
              } 
           
            }
        );
        
    }
}
