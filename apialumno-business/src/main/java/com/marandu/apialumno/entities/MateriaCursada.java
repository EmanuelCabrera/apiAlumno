package com.marandu.apialumno.entities;

import com.cicha.core.AuditableEntity;
import com.cicha.core.EntityInfo;
import com.cicha.core.Gender;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Emanuel Cabrera
 */
@Entity
@EntityInfo(gender = Gender.MALE, name = "materia cursada", namePlural = "Materias Cursadas")
public class MateriaCursada extends AuditableEntity {

    private boolean aprobada;
    private boolean vencida;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCursado;

    @OneToOne
    private Alumno alumno;

    @OneToOne
    private Materia materia;

    public MateriaCursada() {
    }

    public boolean isAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }

    public boolean isVencida() {
        return vencida;
    }

    public void setVencida(boolean vencida) {
        this.vencida = vencida;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Date getFechaCursado() {
        return fechaCursado;
    }

    public void setFechaCursado(Date fechaCursado) {
        this.fechaCursado = fechaCursado;
    }

    @Override
    public String myName() {
        return this.materia.getNombre();
    }

}
