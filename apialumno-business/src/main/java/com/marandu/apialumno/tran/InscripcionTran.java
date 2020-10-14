package com.marandu.apialumno.tran;

import com.cicha.base.contenido.tran.GenericContenidoTran;
import com.cicha.core.GenericTran;
import com.cicha.core.extras.Op;
import com.marandu.apialumno.entities.Alumno;
import com.marandu.apialumno.entities.Inscripcion;
import com.marandu.apialumno.entities.MesaExamen;
import java.util.Date;

/**
 *
 * @author Emanuel Cabrera
 */
public class InscripcionTran extends GenericTran<Inscripcion> {

    // Atributos
    private String codigo;
    private boolean baja;
    private Date fechaInscripcion;

    private Long alumnoId;
    private Long mesaId;

    private Alumno alumno;

    private MesaExamen mesa;

    public InscripcionTran() {
    }

    public Inscripcion build(Op op) throws IllegalArgumentException, IllegalAccessException {
        Inscripcion res = getMe();
        res.setCodigo(codigo);
        res.setBaja(baja);
        res.setFechaInscripcion(fechaInscripcion);
        res.setAlumno(alumno);
        res.setMesa(mesa);

        return res;
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

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
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

}
