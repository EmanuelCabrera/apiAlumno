package com.marandu.apialumno.tran;

import com.cicha.base.contenido.tran.GenericContenidoTran;
import com.cicha.core.extras.Op;
import com.marandu.apialumno.entities.Materia;
import com.marandu.apialumno.entities.Profesor;

/**
 *
 * @author Emanuel Cabrera
 */
public class MateriaTran extends GenericContenidoTran<Materia> {

    // Atributos
    private String nombre;
    private String codigo;

    private Long profesorId;
    
    private Profesor profesor;

    public MateriaTran() {
    }

    public Materia build(Op op) throws IllegalArgumentException, IllegalAccessException {
        Materia res = getMe();
        res.setNombre(nombre);
        res.setCodigo(codigo);
        res.setProfesor(profesor);

        return res;
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

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }


}
