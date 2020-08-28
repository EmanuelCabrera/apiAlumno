package com.marandu.apialumno.web;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * A class extending {@link Application} and annotated with @ApplicationPath is the Java EE 6
 * "no XML" approach to activating JAX-RS.
 * 
 * <p>
 * Resources are served relative to the servlet path specified in the {@link ApplicationPath}
 * annotation.
 * </p>
 */
@javax.ws.rs.ApplicationPath("services")
public class JaxRsActivator extends Application {
   /* class body intentionally left blank */
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = super.getClasses();
        return classes;
    }
}
