package com.marandu.apialumno.web;
 
import com.cicha.base.InitBase;
import com.cicha.core.VertxUtil;
import com.cicha.core.config.SistemConfig;
import com.marandu.apialumno.InitApiAlumno;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author marandu
 */
@WebListener
public class Init implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            SistemConfig.DEFAULT.setConnectionName("apialumno");
            SistemConfig.DEFAULT.setSystemName("ApiAlumno");
            InitBase.initfirst(sce);
            VertxUtil.run(v -> InitApiAlumno.init(v));  
        } catch (Exception ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        VertxUtil.close();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
