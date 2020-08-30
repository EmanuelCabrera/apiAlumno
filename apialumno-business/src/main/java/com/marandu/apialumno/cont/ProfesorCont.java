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
import com.marandu.apialumno.entities.Profesor;
import com.marandu.apialumno.entities.Profesor;
import com.marandu.apialumno.tran.ProfesorTran;
import com.marandu.apialumno.tran.ProfesorTran;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ejb.EJB;

/**
 *
 * @author Emanuel Cabrera
 */
@Stateless
@LocalBean
public class ProfesorCont extends GenericContTran<Profesor, ProfesorTran> {

    @EJB
    ContactoCont contactoCont ;

    @Override
    @MethodName(name = MethodsNameApiAlumno.PROFESOR_ADD)
    public Profesor create(ProfesorTran tran) throws Exception {
        assign(Op.CREATE, tran);
        validate(Op.CREATE, tran);
        Profesor profesor = tran.build(Op.CREATE);
        em.persist(profesor);
        return profesor;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.PROFESOR_UPD)
    public Profesor update(ProfesorTran tran) throws Exception {
        assign(Op.UPDATE, tran);
        validate(Op.UPDATE, tran);
        Profesor profesor = tran.build(Op.UPDATE);
        em.merge(profesor);
        return profesor;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.PROFESOR_REM)
    public Profesor remove(RemoveTran tran) throws Exception {
        Profesor profesor = findEx(tran.getId());
        contactoCont.remove(profesor.getContacto().getId());
        em.remove(profesor);
        return profesor;
    }

    public void assign(Op op, ProfesorTran tran) throws Ex {
        // Asignaciones
        if (Op.UPDATE.equals(op)) {
            tran.setMe(findEx(tran.getId()));
        }
    }

    public void validate(Op op, ProfesorTran tran) throws Exception {
        // Validaciones
        emptyEx(tran.getApellido(), "Debe ingresar un apellido!!");
        emptyEx(tran.getNombre(), "Debe ingresar un nombre!!");
    }

}
