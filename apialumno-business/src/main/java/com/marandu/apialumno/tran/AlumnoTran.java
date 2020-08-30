package com.marandu.apialumno.tran;

import com.cicha.base.contenido.tran.GenericContenidoTran;
import com.cicha.base.rrhh.tran.ContactoTran;
import com.cicha.core.extras.Op;
import com.marandu.apialumno.entities.Alumno;
import com.marandu.apialumno.entities.Example;
import com.marandu.apialumno.entities.MateriaCursada;
import java.util.List;

/**
 *
 * @author Emanuel Cabrera
 */
public class AlumnoTran extends GenericContenidoTran<Alumno> {

    // Atributos
    private String nombre;
    private String apellido;
    private String matricula;

    private ContactoTran contacto;

    private List<Long> materiasCursadasIds;

    private transient List<MateriaCursada> materiaCursadas;

    public AlumnoTran() {
    }

    public Alumno build(Op op) throws IllegalArgumentException, IllegalAccessException {
        Alumno res = getMe();
        res.setNombre(nombre);
        res.setApellido(apellido);
        res.setMatricula(matricula);

        res.setMateriasCursadas(materiaCursadas);

        return res;
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

    public ContactoTran getContacto() {
        return contacto;
    }

    public void setContacto(ContactoTran contacto) {
        this.contacto = contacto;
    }

    public List<Long> getMateriasCursadasIds() {
        return materiasCursadasIds;
    }

    public void setMateriasCursadasIds(List<Long> materiasCursadasIds) {
        this.materiasCursadasIds = materiasCursadasIds;
    }

    public List<MateriaCursada> getMateriaCursadas() {
        return materiaCursadas;
    }

    public void setMateriaCursadas(List<MateriaCursada> materiaCursadas) {
        this.materiaCursadas = materiaCursadas;
    }

}
