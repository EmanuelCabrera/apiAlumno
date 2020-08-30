package com.marandu.apialumno.serv;

import com.cicha.core.GenericServ;
import com.cicha.core.GetTran;
import com.cicha.core.extras.Op;
import com.cicha.core.logicalremove.RemoveTran;
import com.cicha.core.security.SecurityM;
import com.marandu.apialumno.PermissionsApiAlumno;
import com.marandu.apialumno.entities.Materia;
import com.marandu.apialumno.tran.MateriaTran;
import com.marandu.apimateria.cont.MateriaCont;

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
@Path("materia")
public class MateriaServ extends GenericServ<MateriaCont> {

    @GET
    @Override
    public String get(@BeanParam GetTran tran) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        SecurityM.testPermited(PermissionsApiAlumno.MATERIA_LIST);
        return super.get(tran);
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String create(MateriaTran tran) throws Exception {
        Materia materia = cont.create(tran);
        return genSms(materia, Op.CREATE);
    }

    @PUT
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String update(MateriaTran tran) throws Exception {
        Materia materia = cont.update(tran);
        return genSms(materia, Op.UPDATE);
    }

    @DELETE
    @Produces({"application/json"})
    public String remove(@BeanParam RemoveTran removeTran) throws Exception {
        Materia materia = cont.remove(removeTran);
        return genSms(materia, Op.DELETE);
    }

}
