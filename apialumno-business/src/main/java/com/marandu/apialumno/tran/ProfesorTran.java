package com.marandu.apialumno.tran;

import com.cicha.base.rrhh.tran.ContactoTran;
import com.cicha.core.GenericTran;
import com.cicha.core.extras.Op;
import com.marandu.apialumno.entities.Profesor;


/**
 *
 * @author Emanuel Cabrera
 */
public class ProfesorTran extends GenericTran<Profesor> {

    // Atributos
    private String nombre;
    private String apellido;

    
    private ContactoTran contacto;



    public ProfesorTran() {
    }

    public Profesor build(Op op) throws IllegalArgumentException, IllegalAccessException {
        Profesor res = getMe();
        res.setNombre(nombre);
        res.setApellido(apellido);
        
        return res;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ContactoTran getContacto() {
        return contacto;
    }

    public void setContacto(ContactoTran contacto) {
        this.contacto = contacto;
    }

  

}
