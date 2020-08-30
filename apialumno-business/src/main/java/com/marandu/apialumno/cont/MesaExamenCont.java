package com.marandu.apialumno.cont;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.cicha.core.GenericContTran;
import com.cicha.core.ex.Ex;
import com.cicha.core.extras.Op;
import com.cicha.core.logicalremove.RemoveTran;
import com.cicha.methodname.MethodName;
import com.marandu.apialumno.MethodsNameApiAlumno;
import com.marandu.apialumno.cont.ProfesorCont;
import com.marandu.apialumno.entities.MesaExamen;
import com.marandu.apialumno.tran.MesaExamenTran;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ejb.EJB;

/**
 *
 * @author Emanuel Cabrera
 */
@Stateless
@LocalBean
public class MesaExamenCont extends GenericContTran<MesaExamen, MesaExamenTran> {

    @EJB
    private ProfesorCont profesorCont;

    @Override
    @MethodName(name = MethodsNameApiAlumno.MESAEXAMEN_ADD)
    public MesaExamen create(MesaExamenTran tran) throws Exception {
        assign(Op.CREATE, tran);
        validate(Op.CREATE, tran);
        MesaExamen mesaExamen = tran.build(Op.CREATE);

        em.persist(mesaExamen);
        return mesaExamen;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.MESAEXAMEN_UPD)
    public MesaExamen update(MesaExamenTran tran) throws Exception {
        assign(Op.UPDATE, tran);
        validate(Op.UPDATE, tran);
        MesaExamen mesaExamen = tran.build(Op.UPDATE);

        em.merge(mesaExamen);
        return mesaExamen;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.MESAEXAMEN_REM)
    public MesaExamen remove(RemoveTran tran) throws Exception {
        MesaExamen mesaExamen = findEx(tran.getId());
        em.remove(mesaExamen);
        return mesaExamen;
    }

    public void assign(Op op, MesaExamenTran tran) throws Ex {
        // Asignaciones
        if (Op.UPDATE.equals(op)) {
            tran.setMe(findEx(tran.getId()));
        }
        tran.setPresidente(profesorCont.findEx(tran.getPresidenteId()));
        tran.setPrimerVocal(profesorCont.findEx(tran.getPrimerVocalId()));
    }

    public void validate(Op op, MesaExamenTran tran) throws Exception {
        // Validaciones
        emptyEx(tran.getFecha(), "Debe ingresar una fecha para la mesa!!");

    }

}
