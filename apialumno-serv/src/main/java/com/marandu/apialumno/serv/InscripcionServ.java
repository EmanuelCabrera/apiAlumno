package com.marandu.apialumno.serv;

import com.cicha.core.GenericServ;
import com.cicha.core.GetTran;
import com.cicha.core.extras.Op;
import com.cicha.core.logicalremove.RemoveTran;
import com.cicha.core.security.SecurityM;
import com.marandu.apialumno.PermissionsApiAlumno;
import com.marandu.apialumno.cont.InscripcionCont;
import com.marandu.apialumno.entities.Inscripcion;
import com.marandu.apialumno.tran.InscripcionTran;

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
@Path("inscripcion")
public class InscripcionServ extends GenericServ<InscripcionCont> {

    @GET
    @Override
    public String get(@BeanParam GetTran tran) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        SecurityM.testPermited(PermissionsApiAlumno.INSCRIPCION_LIST);
        return super.get(tran);
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String create(InscripcionTran tran) throws Exception {
        Inscripcion inscripcion = cont.create(tran);
        return genSms(inscripcion, Op.CREATE);
    }

    @PUT
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String update(InscripcionTran tran) throws Exception {
        Inscripcion inscripcion = cont.update(tran);
        return genSms(inscripcion, Op.UPDATE);
    }

    @DELETE
    @Produces({"application/json"})
    public String remove(@BeanParam RemoveTran removeTran) throws Exception {
        Inscripcion inscripcion = cont.remove(removeTran);
        return genSms(inscripcion, Op.DELETE);
    }

}
