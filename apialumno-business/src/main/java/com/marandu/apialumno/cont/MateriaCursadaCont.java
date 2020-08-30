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
import com.marandu.apialumno.entities.MateriaCursada;
import com.marandu.apialumno.entities.Profesor;
import com.marandu.apialumno.tran.MateriaCursadaTran;
import com.marandu.apialumno.tran.ProfesorTran;
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
public class MateriaCursadaCont extends GenericContTran<MateriaCursada, MateriaCursadaTran> {

    @EJB
    ContactoCont contactoCont;

    @Override
    @MethodName(name = MethodsNameApiAlumno.MATERIACURSADA_ADD)
    public MateriaCursada create(MateriaCursadaTran tran) throws Exception {
        assign(Op.CREATE, tran);
        validate(Op.CREATE, tran);
        MateriaCursada materiaCursada = tran.build(Op.CREATE);
        em.persist(materiaCursada);
        return materiaCursada;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.MATERIACURSADA_UPD)
    public MateriaCursada update(MateriaCursadaTran tran) throws Exception {
        assign(Op.UPDATE, tran);
        validate(Op.UPDATE, tran);
        MateriaCursada materiaCursada = tran.build(Op.UPDATE);
        em.merge(materiaCursada);
        return materiaCursada;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.MATERIACURSADA_REM)
    public MateriaCursada remove(RemoveTran tran) throws Exception {
        MateriaCursada materiaCursada = findEx(tran.getId());
        em.remove(materiaCursada);
        return materiaCursada;
    }

    public void assign(Op op, MateriaCursadaTran tran) throws Ex {
        // Asignaciones
        if (Op.UPDATE.equals(op)) {
            tran.setMe(findEx(tran.getId()));
        }
        if (tran.getFechaCursado() == null) {
            tran.setFechaCursado(new Date());
        }
    }

    public void validate(Op op, MateriaCursadaTran tran) throws Exception {
        // Validaciones
//        emptyEx(tran.get, "Debe ingresar un apellido!!");
//        emptyEx(tran.getNombre(), "Debe ingresar un nombre!!");
    }

}
