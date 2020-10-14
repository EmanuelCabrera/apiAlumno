package com.marandu.apimateria.cont;

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
import com.marandu.apialumno.cont.ProfesorCont;
import com.marandu.apialumno.entities.Materia;
import com.marandu.apialumno.tran.MateriaTran;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ejb.EJB;

/**
 *
 * @author Emanuel Cabrera
 */
@Stateless
@LocalBean
public class MateriaCont extends GenericContTran<Materia, MateriaTran> {

    @EJB
    private ProfesorCont profesorCont;

    @Override
    @MethodName(name = MethodsNameApiAlumno.MATERIA_ADD)
    public Materia create(MateriaTran tran) throws Exception {
        assign(Op.CREATE, tran);
        validate(Op.CREATE, tran);
        Materia materia = tran.build(Op.CREATE);

        em.persist(materia);
        return materia;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.MATERIA_UPD)
    public Materia update(MateriaTran tran) throws Exception {
        assign(Op.UPDATE, tran);
        validate(Op.UPDATE, tran);
        Materia materia = tran.build(Op.UPDATE);

        em.merge(materia);
        return materia;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.MATERIA_REM)
    public Materia remove(RemoveTran tran) throws Exception {
        Materia materia = findEx(tran.getId());
        em.remove(materia);
        return materia;
    }

    public void assign(Op op, MateriaTran tran) throws Ex {
        // Asignaciones
        if (Op.UPDATE.equals(op)) {
            tran.setMe(findEx(tran.getId()));
        }
        tran.setProfesor(profesorCont.find(tran.getProfesorId()));
    }

    public void validate(Op op, MateriaTran tran) throws Exception {
        // Validaciones
        emptyEx(tran.getNombre(), "Debe ingresar un nombre!!");

    }

}
