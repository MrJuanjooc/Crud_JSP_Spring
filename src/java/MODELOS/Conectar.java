
package MODELOS;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Conectar 
{
    public DriverManagerDataSource Conectar()
    {
        DriverManagerDataSource DataSource = new DriverManagerDataSource();
        DataSource.setDriverClassName("com.mysql.jdbc.Driver");
        DataSource.setUrl("jdbc:mysql://localhost/persona");
        DataSource.setUsername("root");
        DataSource.setPassword("");
        
        return DataSource;
    }

  
}
