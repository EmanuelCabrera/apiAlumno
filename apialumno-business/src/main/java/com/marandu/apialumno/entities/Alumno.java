package com.marandu.apialumno.entities;

import com.cicha.base.contenido.entities.ContenidoList;
import com.cicha.base.rrhh.entities.Contacto;
import com.cicha.core.AuditableEntity;
import com.cicha.core.EntityInfo;
import com.cicha.core.Gender;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Emanuel Cabrera
 */
@Entity
@EntityInfo(gender = Gender.MALE, name = "alumno", namePlural = "alumnos")
public class Alumno extends AuditableEntity {

    private String nombre;
    private String apellido;
    private String matricula;
    @OneToOne
    private Contacto contacto;
    @ManyToOne
    private List<MateriaCursada> materiasCursadas;




    public Alumno() {
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<MateriaCursada> getMateriasCursadas() {
        return materiasCursadas;
    }

    public void setMateriasCursadas(List<MateriaCursada> materiasCursadas) {
        this.materiasCursadas = materiasCursadas;
    }

    

    

    @Override
    public String myName() {
        return nombre;
    }

}
