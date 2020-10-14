package com.marandu.apialumno.serv;

import com.cicha.core.GenericServ;
import com.cicha.core.GetTran;
import com.cicha.core.extras.Op;
import com.cicha.core.logicalremove.RemoveTran;
import com.cicha.core.security.SecurityM;
import com.marandu.apialumno.PermissionsApiAlumno;
import com.marandu.apialumno.cont.MateriaCursadaCont;

import com.marandu.apialumno.entities.MateriaCursada;
import com.marandu.apialumno.tran.MateriaCursadaTran;

import java.lang.reflect.InvocationTargetException;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Emanuel Cabrera
 */
@RequestScoped
@Path("materia-cursada")
public class MateriaCursadaServ extends GenericServ<MateriaCursadaCont> {

    @GET
    @Override
    public String get(@BeanParam GetTran tran) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        SecurityM.testPermited(PermissionsApiAlumno.MATERIACURSADA_LIST);
        return super.get(tran);
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String create(MateriaCursadaTran tran) throws Exception {
        MateriaCursada materiaCursada = cont.create(tran);
        return genSms(materiaCursada, Op.CREATE);
    }

    @PUT
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String update(MateriaCursadaTran tran) throws Exception {
        MateriaCursada materiaCursada = cont.update(tran);
        return genSms(materiaCursada, Op.UPDATE);
    }

    @DELETE
    @Produces({"application/json"})
    public String remove(@BeanParam RemoveTran removeTran) throws Exception {
        MateriaCursada materiaCursada = cont.remove(removeTran);
        return genSms(materiaCursada, Op.DELETE);
    }

}
