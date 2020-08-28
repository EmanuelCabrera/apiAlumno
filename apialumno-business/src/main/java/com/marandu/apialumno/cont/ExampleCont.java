package com.marandu.apialumno.cont;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.cicha.base.contenido.cont.ContenidoListCont;
import com.cicha.core.GenericContTran;
import com.cicha.core.ex.Ex;
import com.cicha.core.extras.Op;
import com.cicha.core.logicalremove.RemoveTran;
import com.cicha.methodname.MethodName;
import com.marandu.apialumno.MethodsNameApiAlumno;
import com.marandu.apialumno.entities.Example;
import com.marandu.apialumno.tran.ExampleTran;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ejb.EJB;

/**
 *
 * @author Emanuel Cabrera
 */
@Stateless
@LocalBean
public class ExampleCont extends GenericContTran<Example, ExampleTran> {

    @EJB
    ContenidoListCont contenidoListCont;

    @Override
    @MethodName(name = MethodsNameApiAlumno.EXAMPLE_ADD)
    public Example create(ExampleTran tran) throws Exception {
        assign(Op.CREATE, tran);
        validate(Op.CREATE, tran);
        Example example = tran.build(Op.CREATE);
        em.persist(example);
        return example;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.EXAMPLE_UPD)
    public Example update(ExampleTran tran) throws Exception {
        assign(Op.UPDATE, tran);
        validate(Op.UPDATE, tran);
        Example example = tran.build(Op.UPDATE);
        em.merge(example);
        return example;
    }

    @Override
    @MethodName(name = MethodsNameApiAlumno.EXAMPLE_REM)
    public Example remove(RemoveTran tran) throws Exception {
        Example example = findEx(tran.getId());
        if (!isEmpty(example.getAtachments()) && !isEmpty(example.getAtachments().getContenidos())) {
            Long contenidoId = example.getAtachments().getId();
            example.setAtachments(null);
            contenidoListCont.remove(contenidoId);
        }
        em.remove(example);
        return example;
    }

    public void assign(Op op, ExampleTran tran) throws Ex {
        // Asignaciones
        if (Op.UPDATE.equals(op)) {
            tran.setMe(findEx(tran.getId()));
        }
    }

    public void validate(Op op, ExampleTran tran) throws Exception {
        // Validaciones
        emptyEx(tran.getBody(), "Debe ingresar un comentario!!");
        valid(tran.getBody().equalsIgnoreCase(""), "Debe ingresar un comentario!!");
    }

}
