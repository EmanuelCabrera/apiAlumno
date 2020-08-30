package com.marandu.apialumno.cont;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.cicha.base.contenido.cont.ContenidoListCont;
import com.cicha.base.rrhh.cont.ContactoCont;
import com.cicha.core.GenericContTran;
import com.cicha.core.ex.Ex;
import com.cicha.core.extras.Op;
import com.cicha.core.logicalremove.RemoveTran;
import com.cicha.methodname.MethodName;
import com.marandu.apialumno.MethodsNameApiAlumno;
import com.marandu.apialumno.entities.Alumno;
import com.marandu.apialumno.entities.Alumno;
import com.marandu.apialumno.tran.AlumnoTran;
import com.marandu.apialumno.tran.AlumnoTran;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ejb.EJB;

/**
 *
 * @author Emanuel Cabrera
 */
@Stateless
@LocalBean
public class AlumnoCont extends GenericContTran<Alumno, AlumnoTran> {

    @EJB
    ContactoCont contactoCont;

    @Override
    @MethodName(name = MethodsNameApiAlumno.ALUMNO_ADD)
    public Alumno create(AlumnoTran tran) throws Exception {
        assign(Op.CREATE, tran);
        validate(Op.CREATE, tran);
        Alumno alumno = tran.build(Op.CREATE);
        alumno.setContacto(contactoCont.save(tran.getContacto()));
        em.persist(alumno);
        return alumno;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.ALUMNO_UPD)
    public Alumno update(AlumnoTran tran) throws Exception {
        assign(Op.UPDATE, tran);
        validate(Op.UPDATE, tran);
        Alumno alumno = tran.build(Op.UPDATE);
        alumno.setContacto(contactoCont.save(tran.getContacto()));

        em.merge(alumno);
        return alumno;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.ALUMNO_REM)
    public Alumno remove(RemoveTran tran) throws Exception {
        Alumno alumno = findEx(tran.getId());
        contactoCont.remove(alumno.getContacto().getId());
        em.remove(alumno);
        return alumno;
    }

    public void assign(Op op, AlumnoTran tran) throws Ex {
        // Asignaciones
        if (Op.UPDATE.equals(op)) {
            tran.setMe(findEx(tran.getId()));
        }
    }

    public void validate(Op op, AlumnoTran tran) throws Exception {
        // Validaciones
        emptyEx(tran.getNombre(), "Debe ingresar un nombre!!");
        emptyEx(tran.getApellido(), "Debe ingresar un apellido!!");
        emptyEx(tran.getMatricula(), "Debe ingresar una matricula!!");
        
    }

}
