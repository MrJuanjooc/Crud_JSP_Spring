
package MODELOS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class Usuarios_Validar implements Validator
{
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,)$";
    
    private Pattern pattern;
    private Matcher matcher;
    
    @Override
    
    public boolean supports (Class<?> type)
    {
        return Usuarios.class.isAssignableFrom(type);
    }
    
    @Override
    
    public void validate (Object o, Errors errors)
    {
        Usuarios usuarios = (Usuarios)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre" , "El campo Nombre es obligatorio");
        ValidationUtils.rejectIfEmpty(errors, "correo", "required.correo", "El campo Correo es obligatorio");
        
        if (!(usuarios.getCorreo()!= null && usuarios.getCorreo().isEmpty())) 
        {
            this.pattern = Pattern.compile(EMAIL_PATTERN);
            this.matcher = pattern.matcher(usuarios.getCorreo());
            
            if (!matcher.matches()) 
            {
                errors.rejectValue("correo", "correo.incorrect",
                                    "EL CORREO ES INCORRECTO" + usuarios.getCorreo()+ " No es valido");     
            }
        }  
            
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono",
                                                        "required.telefono", "EL CAMPO TELÉFONO ESOBLIGATORIO");
        
    }
}
