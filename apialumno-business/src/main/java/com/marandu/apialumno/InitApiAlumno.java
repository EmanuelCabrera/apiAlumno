/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marandu.apialumno;

import com.cicha.base.InitBase;
import com.cicha.base.InitData;
import com.cicha.base.security.cont.RolCont;
import com.cicha.base.security.cont.UserCont;
import com.cicha.base.security.entities.PermissionAction;
import com.cicha.base.security.entities.PermissionGroup;
import com.cicha.base.security.entities.PermissionList;
import com.cicha.base.security.entities.PermissionObj;
import com.cicha.base.security.entities.User;
import com.cicha.core.CoreGlobal;
import com.cicha.core.ex.Ex;
import com.cicha.core.session.SessionManager;
import com.cicha.core.extras.RequestContext;
import com.marandu.apialumno.entities.Example;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

/**
 *
 * @author Emanuel.Cabrea
 */
public class InitApiAlumno {

    private static boolean initialized = false;
    private static Logger logger = LoggerFactory.getLogger(InitApiAlumno.class.getName());

    public static void init(Vertx vertx) {
        try {
            InitBase.init(vertx);

            InitApiAlumno.initPermissionApiAlumno();
            InitSecurityApiAlumno.init();
            InitData.init(vertx);
            initData(vertx);
            InitBase.initSecurityDefault();
        } catch (Exception e) {
            logger.error("Error en unit Administracion", e);
        }
    }

    public static void initData(Vertx vertx) {
        try {
            RequestContext.initialize();
            UserCont uCont = CoreGlobal.injectEJB(UserCont.class);
            User root = uCont.findUserRoot();
            User admin = uCont.findUserAdmin();
            /////////////////////////////////////////////////////////////////////
            ///Simulando inicio de session una vez que tengo todos los datos obligatorios cargados
            /////////////////////////////////////////////////////////////////////
            SessionManager.generateSession(root);

            // Inicializacion de datos
            RolCont rolCont = CoreGlobal.injectEJB(RolCont.class);

        } catch (Exception e) {
            logger.error("Inicializando datos Administracion", e);
        }

    }

    public static void initPermissionApiAlumno() throws Ex {

        PermissionGroup grupo_examples = PermissionGroup
                .build(PermissionsApiAlumno.Groups.EXAMPLES, "Gestión de ejemplos")
                .addPermiso(PermissionObj.build(MethodsNameApiAlumno.EXAMPLE_ADD, Example.class, PermissionAction.ADD))
                .addPermiso(PermissionObj.build(MethodsNameApiAlumno.EXAMPLE_UPD, Example.class, PermissionAction.UPD))
                .addPermiso(PermissionObj.build(MethodsNameApiAlumno.EXAMPLE_REM, Example.class, PermissionAction.REM))
                .addPermiso(PermissionObj.build(PermissionsApiAlumno.EXAMPLE_LIST, Example.class, PermissionAction.LIST));

        PermissionList.add(grupo_examples);
    }

}
