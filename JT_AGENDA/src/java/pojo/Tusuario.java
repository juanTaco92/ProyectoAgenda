package pojo;
// Generated 23/06/2016 19:23:37 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Tusuario generated by hbm2java
 */
public class Tusuario  implements java.io.Serializable {


     private BigDecimal codigousuario;
     private String nombre;
     private String apellidopaterno;
     private String apellidomaterno;
     private String correoelectronico;
     private String contrasena;
     private Date fechanacimiento;
     private String sexo;
     private String telefono;

    public Tusuario() {
    }

	
    public Tusuario(BigDecimal codigousuario) {
        this.codigousuario = codigousuario;
    }
    public Tusuario(BigDecimal codigousuario, String nombre, String apellidopaterno, String apellidomaterno, String correoelectronico, String contrasena, Date fechanacimiento, String sexo, String telefono) {
       this.codigousuario = codigousuario;
       this.nombre = nombre;
       this.apellidopaterno = apellidopaterno;
       this.apellidomaterno = apellidomaterno;
       this.correoelectronico = correoelectronico;
       this.contrasena = contrasena;
       this.fechanacimiento = fechanacimiento;
       this.sexo = sexo;
       this.telefono = telefono;
    }
   
    public BigDecimal getCodigousuario() {
        return this.codigousuario;
    }
    
    public void setCodigousuario(BigDecimal codigousuario) {
        this.codigousuario = codigousuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidopaterno() {
        return this.apellidopaterno;
    }
    
    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }
    public String getApellidomaterno() {
        return this.apellidomaterno;
    }
    
    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }
    public String getCorreoelectronico() {
        return this.correoelectronico;
    }
    
    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Date getFechanacimiento() {
        return this.fechanacimiento;
    }
    
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




}


