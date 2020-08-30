package com.marandu.apialumno.entities;

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
@EntityInfo(gender = Gender.MALE, name = "materia", namePlural = "materias")
public class Materia extends AuditableEntity {

    private String nombre;
    private String codigo;
    
    
    @OneToOne
    private Profesor profesor;




    public Materia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }


    @Override
    public String myName() {
        return nombre;
    }

}
