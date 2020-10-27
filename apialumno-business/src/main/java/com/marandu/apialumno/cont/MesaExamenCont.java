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
import com.marandu.apimateria.cont.MateriaCont;

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
    @EJB
    private MateriaCont materiaCont;

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
        tran.setPrimerVocal(profesorCont.find(tran.getPrimerVocalId()));
        tran.setMateria(materiaCont.findEx(tran.getMateriaId()));
    }

    public void validate(Op op, MesaExamenTran tran) throws Exception {
        // Validaciones
        emptyEx(tran.getFecha(), "Debe ingresar una fecha para la mesa!!");

    }

//    public ResultPaginated getTikectsByFilter(FilterTran filterTran) throws Ex, ParseException {
//        User user = (User) SessionManager.getUser();
//        valid((filterTran.getAssignedsIds().isEmpty()
//                && filterTran.getProjectsIds().isEmpty()
//                && filterTran.getStatesIds().isEmpty()
//                && filterTran.getDesde() == null
//                && filterTran.getHasta() == null
//                && filterTran.getTexto() == null), String.format("Ingrese un valor para filtrar"));
//        Set<Project> projects = new HashSet<>(projectCont.find(filterTran.getProjectsIds()));
//        Set<User> assigneds = new HashSet<>(userCont.find(filterTran.getAssignedsIds()));
//        Set<TicketState> states = new HashSet<>(ticketStateCont.find(filterTran.getStatesIds()));
//
//        List<Predicate> filters = new LinkedList();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Ticket> consulta = cb.createQuery(Ticket.class);
//        Root<Ticket> tickets = consulta.from(Ticket.class);
//
//        if (!projects.isEmpty()) {
//            filters.add(tickets.get("project").in(projects));
//        }
//        if (filterTran.isDependencias()) {
//            for (Iterator<Project> iterator = projects.iterator(); iterator.hasNext();) {
//                Project next = iterator.next();
//                projects.addAll(next.getDependencies());
//            }
//        }
//
//        if (!assigneds.isEmpty()) {
//            filters.add(tickets.get("assigned").in(assigneds));
//        }
//
//        if (filterTran.getDesde() != null && filterTran.getHasta() != null) {
//            Path<Date> updatedAtPath = tickets.get("updatedAt");
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
//            Date desde = formatter.parse(filterTran.getDesde());
//            Date hasta = formatter.parse(filterTran.getHasta());
//            filters.add(cb.between(updatedAtPath, desde, hasta));
//        }
//
//        if (!states.isEmpty()) {
//            filters.add(tickets.get("state").in(states));
//        }
//
//        if (filterTran.getTexto() != null) {
//            try {
//                Long valueOf = Long.valueOf(filterTran.getTexto());
//                filters.add(cb.or(cb.like(cb.upper(tickets.get("subject")), "%" + filterTran.getTexto().toUpperCase() + "%"), cb.equal(tickets.get("id"), valueOf)));
//            } catch (Exception e) {
//                filters.add(cb.like(cb.upper(tickets.get("subject")), "%" + filterTran.getTexto().toUpperCase() + "%"));
//            }
//        }
//
//        //restricciones
//        List<Predicate> restrictions = new LinkedList();
////        if (!user.isPermission(PermissionsCflow.VIEW_ALL)) {
////            if (user != null) {
////
////                //Obtiene los tickets donde soy colaborador
////                List<Ticket> byCollaborators = getByCollaborators();
////                restrictions.add(cb.equal(tickets.get("assigned"), user));
////                restrictions.add(cb.equal(tickets.get("author"), user));
////                if (!findProjectsByRol.isEmpty()) {
////                    restrictions.add(cb.and(
////                            tickets.get("project").in(findProjectsByRol),
////                            cb.isFalse(tickets.get("confidentiality"))
////                    ));
////                }
////                if (!byCollaborators.isEmpty()) {
////                    restrictions.add(
////                            cb.or(
////                                    tickets.in(byCollaborators)));
////                }
////            }
////        }
//        Predicate where = null;
//        if (!filters.isEmpty()) {
//            where = cb.and(filters.stream().toArray(Predicate[]::new));
//        }
//        if (!restrictions.isEmpty()) {
//            where = appendPredicate(where, true, cb, cb.or(restrictions.stream().toArray(Predicate[]::new)));
//        }
//
//        if (user != null) {
//            consulta.select(tickets).where(where).orderBy(cb.desc(tickets.get("updatedAt")));
//            return this.paginate(consulta, filterTran);
//        } else {
//            ResultPaginated resultPaginated = new ResultPaginated();
//            resultPaginated.setList(new LinkedList());
//            resultPaginated.setPages(0);
//            long count = 0;
//            resultPaginated.setCount(count);
//            return resultPaginated;
//        }
//    }
//
//    private Predicate appendPredicate(Predicate pWhere, boolean and, CriteriaBuilder cb, Predicate pNew) {
//        if (pWhere == null) {
//            return pNew;
//        } else {
//            if (and) {
//                return cb.and(pWhere, pNew);
//            } else {
//                return cb.or(pWhere, pNew);
//            }
//        }
//    }

}
