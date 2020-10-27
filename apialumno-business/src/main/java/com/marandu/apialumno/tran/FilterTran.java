package com.marandu.apialumno.tran;

import com.cicha.core.pagination.PaginateTran;
import java.util.List;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Emanuel Cabrera
 */
public class FilterTran extends PaginateTran {

    @QueryParam("jconf")
    private String jconf;
    // Atributos
    @QueryParam("projectsIds")
    private List<Long> projectsIds;
    @QueryParam("projectId")
    private Long projectId;
    @QueryParam("assignedsIds")
    private List<Long> assignedsIds;
    @QueryParam("statesIds")
    private List<Long> statesIds;
    @QueryParam("dependencie")
    private boolean dependencias;
    @QueryParam("desde")
    private String desde;
    @QueryParam("hasta")
    private String hasta;
    @QueryParam("texto")
    private String texto;
    @QueryParam("estado")
    private String estado;
    @QueryParam("name")
    private String name;
    @QueryParam("clientId")
    private Long clientId;
    @QueryParam("vinculadoId")
    private Long vinculadoId;
    @QueryParam("allProjects")
    private boolean allProjects;
    @QueryParam("allUsers")
    private boolean allUsers;

    public FilterTran() {

    }

    public String getJconf() {
        return jconf;
    }

    public void setJconf(String jconf) {
        this.jconf = jconf;
    }

    public List<Long> getProjectsIds() {
        return projectsIds;
    }

    public void setProjectsIds(List<Long> projectsIds) {
        this.projectsIds = projectsIds;
    }

    public List<Long> getAssignedsIds() {
        return assignedsIds;
    }

    public void setAssignedsIds(List<Long> assignedsIds) {
        this.assignedsIds = assignedsIds;
    }

    public boolean isDependencias() {
        return dependencias;
    }

    public void setDependencias(boolean dependencias) {
        this.dependencias = dependencias;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public List<Long> getStatesIds() {
        return statesIds;
    }

    public void setStatesIds(List<Long> statesIds) {
        this.statesIds = statesIds;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public boolean isAllProjects() {
        return allProjects;
    }

    public void setAllProjects(boolean allProjects) {
        this.allProjects = allProjects;
    }

    public boolean isAllUsers() {
        return allUsers;
    }

    public void setAllUsers(boolean allUsers) {
        this.allUsers = allUsers;
    }

    public Long getVinculadoId() {
        return vinculadoId;
    }

    public void setVinculadoId(Long vinculadoId) {
        this.vinculadoId = vinculadoId;
    }

}
