/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanRequest;

import clases.encrypt ;
import Dao.DaoTUsuario;
import HibernateUtil.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Tusuario;

/**
 *
 * @author USER
 */
@ManagedBean
@RequestScoped
public class MbRUsuario {

    /**
     * Creates a new instance of MbRUsuario
     * 
     * 
     * 
     */
    
    private Tusuario usuario;   
    private List<Tusuario> listaTUsuario;
    private String txtContrasenaRepita;
    private Session session;
    private Transaction transaction;

     
    public MbRUsuario() {
        
        
        this.usuario=new Tusuario ();
        this.usuario.setCodigousuario(BigDecimal.ZERO);
        this.usuario.setSexo   ("M");
    }   
    
    
    public void register () throws Exception
    {
        this.session=null;
        this.transaction=null;
        
        try
         {
             this.session=HibernateUtil.getSessionFactory().openSession();
             this.transaction=session.beginTransaction();
             
             if(!this.usuario.getContrasena().equals(this.txtContrasenaRepita))   {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Las Contrasenas no Coinciden"));
                return ;
         }
        DaoTUsuario daoTUsuario= new DaoTUsuario();
        
            if (daoTUsuario.getByCorreoElectronico(this.session, this.usuario.getCorreoelectronico()) !=null)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El usuario ya se encuentra registrado en el sistema"));
        
                return;
            }
        
        this.usuario.setContrasena(encrypt.Sha512(this.usuario.getContrasena()));        
        daoTUsuario.register(this.session, this.usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (FacesMessage.SEVERITY_INFO, "Correcto","El Registro fue actualizado Correctamente") );
        
        //RequestContext.getCurrentInstance().execute("limpiarFormuilario ('frmRegistrarUsuario')");
        
        this.transaction.commit();
        
        this.usuario=new Tusuario();
        this.usuario.setCodigousuario(BigDecimal.ZERO);
        this.usuario.setSexo ("M");
        }
        catch(Exception ex)
        {
            if(this.transaction!=null)
            {
                this.transaction.rollback();
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador"+ex.getMessage()));
        }
        finally
        {
            if (this.session!=null)
            {
                this.session.close();
            }
        }
        
       
    }
    
    public List<Tusuario> getAll()
    {
        
        this.session= null; //HibernateUtil.getSessionFactory().openSession();
        this.transaction= null; //this.session.beginTransaction();
        
        try
        {
            DaoTUsuario daoTUsuario= new DaoTUsuario();
            this.session=HibernateUtil.getSessionFactory().openSession();
        this.transaction=this.session.beginTransaction();
        
        this.listaTUsuario= daoTUsuario.getAll(this.session);
        
        this.transaction.commit();
        
        return this.listaTUsuario;
        }
        catch (Exception ex)
        {
            if (this.transaction!=null)
            {
                 this.transaction.rollback();
            }
            
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador"+ex.getMessage()));
        return null;
        }
        
        finally
        {
            if (this.session!=null)
            {
                this.session.close();
            }
        }
    }
    
    public Tusuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Tusuario usuario) {
        this.usuario = usuario;
    }

    public List<Tusuario> getListaTUsuario() {
        return listaTUsuario;
    }

    public void setListaTUsuario(List<Tusuario> listaTUsuario) {
        this.listaTUsuario = listaTUsuario;
    }

    public String getTxtContrasenaRepita() {
        return txtContrasenaRepita;
    }

    public void setTxtContrasenaRepita(String txtContrasenaRepita) {
        this.txtContrasenaRepita = txtContrasenaRepita;
    }
     public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
