package com.marandu.apialumno.cont;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.cicha.base.rrhh.cont.ContactoCont;
import com.cicha.core.GenericContTran;
import com.cicha.core.ex.Ex;
import com.cicha.core.extras.Op;
import com.cicha.core.logicalremove.RemoveTran;
import com.cicha.methodname.MethodName;
import com.marandu.apialumno.MethodsNameApiAlumno;
import com.marandu.apialumno.entities.Inscripcion;
import com.marandu.apialumno.tran.InscripcionTran;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ejb.EJB;

/**
 *
 * @author Emanuel Cabrera
 */
@Stateless
@LocalBean
public class InscripcionCont extends GenericContTran<Inscripcion, InscripcionTran> {

    @EJB
    ContactoCont contactoCont;

    @Override
    @MethodName(name = MethodsNameApiAlumno.INSCRIPCION_ADD)
    public Inscripcion create(InscripcionTran tran) throws Exception {
        assign(Op.CREATE, tran);
        validate(Op.CREATE, tran);
        Inscripcion inscripcion = tran.build(Op.CREATE);
        em.persist(inscripcion);
        return inscripcion;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.INSCRIPCION_UPD)
    public Inscripcion update(InscripcionTran tran) throws Exception {
        assign(Op.UPDATE, tran);
        validate(Op.UPDATE, tran);
        Inscripcion inscripcion = tran.build(Op.UPDATE);
        em.merge(inscripcion);
        return inscripcion;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.INSCRIPCION_REM)
    public Inscripcion remove(RemoveTran tran) throws Exception {
        Inscripcion inscripcion = findEx(tran.getId());
        em.remove(inscripcion);
        return inscripcion;
    }

    public void assign(Op op, InscripcionTran tran) throws Ex {
        // Asignaciones
        if (Op.UPDATE.equals(op)) {
            tran.setMe(findEx(tran.getId()));
        }
        if (tran.getFechaInscripcion() == null) {
            tran.setFechaInscripcion(new Date());
        }
    }

    public void validate(Op op, InscripcionTran tran) throws Exception {
        // Validaciones
        emptyEx(tran.getMesaId(), "Debe seleccionar una mesa de examen!!");
//        emptyEx(tran.getNombre(), "Debe ingresar un nombre!!");
    }

}
