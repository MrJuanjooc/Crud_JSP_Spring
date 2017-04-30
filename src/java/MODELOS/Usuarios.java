
package MODELOS;


public class Usuarios 
{
 private int id;
 private String Nombre, Correo, Telefono;

    public Usuarios() 
    {
        
    }

    public Usuarios(String Nombre, String Correo, String Telefono) {
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }

    public Usuarios(int id, String Nombre, String Correo, String Telefono) {
        this.id = id;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
 
 
}
