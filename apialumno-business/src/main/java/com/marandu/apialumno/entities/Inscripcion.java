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
@EntityInfo(gender = Gender.MALE, name = "inscripcion", namePlural = "Inscripciones")
public class Inscripcion extends AuditableEntity {

    private String codigo;
    private boolean baja;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInscripcion;

    @OneToOne
    private Alumno alumno;

    @OneToOne
    private MesaExamen mesa;

    public Inscripcion() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public MesaExamen getMesa() {
        return mesa;
    }

    public void setMesa(MesaExamen mesa) {
        this.mesa = mesa;
    }

    @Override
    public String myName() {
        return codigo;
    }

}
