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
@EntityInfo(gender = Gender.MALE, name = "mesa examen", namePlural = "Mesas de Examenes")
public class MesaExamen extends AuditableEntity {

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @OneToOne
    private Materia materia;

    @OneToOne
    private Profesor presidente;

    @OneToOne
    private Profesor primerVocal;

    public MesaExamen() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Profesor getPresidente() {
        return presidente;
    }

    public void setPresidente(Profesor presidente) {
        this.presidente = presidente;
    }

    public Profesor getPrimerVocal() {
        return primerVocal;
    }

    public void setPrimerVocal(Profesor primerVocal) {
        this.primerVocal = primerVocal;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String myName() {
        return this.getId().toString();
    }

}
