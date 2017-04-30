
package CONTROLLER;

import MODELOS.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public class Home_Controller 
{
    private JdbcTemplate jdbcTemplade;
    
    public Home_Controller()
    {
        Conectar con = new Conectar();
        this.jdbcTemplade = new JdbcTemplate(con.Conectar());
    }
    
    @RequestMapping("home.htm")
    public ModelAndView home() 
    {
        ModelAndView mav = new ModelAndView();
        String sql="SELECT * FROM Usuarios order by id desc";
        List datos = this.jdbcTemplade.queryForList(sql);
        mav.addObject("datos" , datos);
        mav.setViewName("home");
        
        return mav;
    }
}
