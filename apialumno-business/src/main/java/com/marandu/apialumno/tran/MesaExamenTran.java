package com.marandu.apialumno.tran;

import com.cicha.core.GenericTran;
import com.cicha.core.extras.Op;
import com.marandu.apialumno.entities.Materia;
import com.marandu.apialumno.entities.MesaExamen;
import com.marandu.apialumno.entities.Profesor;
import java.util.Date;

/**
 *
 * @author Emanuel Cabrera
 */
public class MesaExamenTran extends GenericTran<MesaExamen> {

    // Atributos
    private Date fecha;

    private Long materiaId;
    private Long presidenteId;

    private Long primerVocalId;

    private Materia materia;
    private Profesor presidente;
    private Profesor primerVocal;

    public MesaExamenTran() {
    }

    public MesaExamen build(Op op) throws IllegalArgumentException, IllegalAccessException {
        MesaExamen res = getMe();
        res.setFecha(fecha);
        res.setPresidente(presidente);
        res.setPrimerVocal(primerVocal);
        res.setMateria(materia);
        return res;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getPresidenteId() {
        return presidenteId;
    }

    public void setPresidenteId(Long presidenteId) {
        this.presidenteId = presidenteId;
    }

    public Long getPrimerVocalId() {
        return primerVocalId;
    }

    public void setPrimerVocalId(Long primerVocalId) {
        this.primerVocalId = primerVocalId;
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

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
