package com.marandu.apialumno.entities;

import com.cicha.base.rrhh.entities.Contacto;
import com.cicha.core.AuditableEntity;
import com.cicha.core.EntityInfo;
import com.cicha.core.Gender;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Emanuel Cabrera
 */
@Entity
@EntityInfo(gender = Gender.MALE, name = "profesor", namePlural = "profesores")
public class Profesor extends AuditableEntity {

    private String nombre;
    private String apellido;

    @OneToOne
    private Contacto contacto;

    public Profesor() {
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

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public String myName() {
        return nombre;
    }

}
