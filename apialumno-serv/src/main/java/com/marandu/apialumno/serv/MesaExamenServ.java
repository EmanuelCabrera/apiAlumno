package com.marandu.apialumno.serv;

import com.cicha.core.GenericServ;
import com.cicha.core.GetTran;
import com.cicha.core.extras.Op;
import com.cicha.core.logicalremove.RemoveTran;
import com.cicha.core.security.SecurityM;
import com.marandu.apialumno.PermissionsApiAlumno;
import com.marandu.apialumno.cont.MesaExamenCont;
import com.marandu.apialumno.entities.MesaExamen;
import com.marandu.apialumno.tran.MesaExamenTran;

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
@Path("mesa_examen")
public class MesaExamenServ extends GenericServ<MesaExamenCont> {

    @GET
    @Override
    public String get(@BeanParam GetTran tran) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        SecurityM.testPermited(PermissionsApiAlumno.MESAEXAMEN_LIST);
        return super.get(tran);
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String create(MesaExamenTran tran) throws Exception {
        MesaExamen mesaExamen = cont.create(tran);
        return genSms(mesaExamen, Op.CREATE);
    }

    @PUT
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String update(MesaExamenTran tran) throws Exception {
        MesaExamen mesaExamen = cont.update(tran);
        return genSms(mesaExamen, Op.UPDATE);
    }

    @DELETE
    @Produces({"application/json"})
    public String remove(@BeanParam RemoveTran removeTran) throws Exception {
        MesaExamen mesaExamen = cont.remove(removeTran);
        return genSms(mesaExamen, Op.DELETE);
    }

}
