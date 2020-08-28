package com.marandu.apialumno.entities;

import com.cicha.base.contenido.entities.ContenidoList;
import com.cicha.core.AuditableEntity;
import com.cicha.core.EntityInfo;
import com.cicha.core.Gender;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Emanuel Cabrera
 */
@Entity
@EntityInfo(gender = Gender.MALE, name = "example", namePlural = "examples")
public class Example extends AuditableEntity {

    @Column(length = 5000)
    private String body;

    private boolean clientView;

    private boolean sistema;

    @OneToOne
    private ContenidoList atachments;



    public Example() {
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

    public ContenidoList getAtachments() {
        return atachments;
    }

    public void setAtachments(ContenidoList atachments) {
        this.atachments = atachments;
    }


    public boolean isSistema() {
        return sistema;
    }

    public void setSistema(boolean sistema) {
        this.sistema = sistema;
    }

    

    @Override
    public String myName() {
        return StringUtils.abbreviate(body, 10);
    }

}
