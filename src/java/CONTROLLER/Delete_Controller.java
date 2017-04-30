package CONTROLLER;

import MODELOS.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class Delete_Controller 
{
    private JdbcTemplate jdbcTemplace;
    
    public Delete_Controller()
    {
        Conectar con = new Conectar();
        this.jdbcTemplace = new JdbcTemplate(con.Conectar());
    }
    
    @RequestMapping("delete.htm")
    public ModelAndView home(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplace.update("delete from usuarios where id=? ", id);
       return new ModelAndView("redirect:/home.htm");
    }
}
