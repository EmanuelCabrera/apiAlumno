package com.marandu.apialumno.tran;

import com.cicha.base.contenido.tran.GenericContenidoTran;
import com.cicha.core.extras.Op;
import com.marandu.apialumno.entities.Example;


/**
 *
 * @author Emanuel Cabrera
 */
public class ExampleTran extends GenericContenidoTran<Example> {

    // Atributos
    private String body;
    private boolean clientView;
    private boolean notify;
    private boolean notifyOperator;
    private boolean sistema;
    private Long userId;
    private Long ticketId;


    public ExampleTran() {
    }

    public Example build(Op op) throws IllegalArgumentException, IllegalAccessException {
        Example res = getMe();
        res.setBody(body);
        res.setSistema(sistema);
        res.setClientView(clientView);
        return res;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isClientView() {
        return clientView;
    }

    public void setClientView(boolean clientView) {
        this.clientView = clientView;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }



    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public boolean isSistema() {
        return sistema;
    }

    public void setSistema(boolean sistema) {
        this.sistema = sistema;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    public boolean isNotifyOperator() {
        return notifyOperator;
    }

    public void setNotifyOperator(boolean notifyOperator) {
        this.notifyOperator = notifyOperator;
    }

}
