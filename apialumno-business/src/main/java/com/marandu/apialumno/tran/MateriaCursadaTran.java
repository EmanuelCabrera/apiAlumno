package com.marandu.apialumno.tran;

import com.cicha.base.contenido.tran.GenericContenidoTran;
import com.cicha.core.extras.Op;
import com.marandu.apialumno.entities.Alumno;
import com.marandu.apialumno.entities.Materia;
import com.marandu.apialumno.entities.MateriaCursada;
import com.marandu.apialumno.entities.MesaExamen;
import java.util.Date;

/**
 *
 * @author Emanuel Cabrera
 */
public class MateriaCursadaTran extends GenericContenidoTran<MateriaCursada> {

    // Atributos
    private boolean aprobada;
    private boolean vencida;

    private Date fechaCursado;
    private Long alumnoId;
    private Long materiaId;

    private Alumno alumno;

    private Materia materia;

    public MateriaCursadaTran() {
    }

    public MateriaCursada build(Op op) throws IllegalArgumentException, IllegalAccessException {
        MateriaCursada res = getMe();
        res.setFechaCursado(fechaCursado);
        res.setAprobada(aprobada);
        res.setVencida(vencida);
        res.setAlumno(alumno);
        res.setMateria(materia);
        return res;
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

    public Date getFechaCursado() {
        return fechaCursado;
    }

    public void setFechaCursado(Date fechaCursado) {
        this.fechaCursado = fechaCursado;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
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

}
