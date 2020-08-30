package com.marandu.apialumno.tran;

import com.cicha.base.contenido.tran.GenericContenidoTran;
import com.cicha.base.rrhh.tran.ContactoTran;
import com.cicha.core.extras.Op;
import com.marandu.apialumno.entities.Example;
import com.marandu.apialumno.entities.MesaExamen;
import com.marandu.apialumno.entities.Profesor;
import java.util.Date;


/**
 *
 * @author Emanuel Cabrera
 */
public class MesaExamenTran extends GenericContenidoTran<MesaExamen> {

    // Atributos
    private Date fecha;

    private Long presidenteId;

    private Long primerVocalId;

    private Profesor presidente;
    private Profesor primerVocal;
    

    public MesaExamenTran() {
    }

    public MesaExamen build(Op op) throws IllegalArgumentException, IllegalAccessException {
        MesaExamen res = getMe();
        res.setFecha(fecha);
        res.setPresidente(presidente);
        res.setPrimerVocal(primerVocal);
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

  

}
