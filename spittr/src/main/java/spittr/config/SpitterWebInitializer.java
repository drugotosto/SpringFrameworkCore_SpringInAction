package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

/**
 * Created by drugo on 17/05/2017.
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
    getServletMappings(), identifies one or more paths that DispatcherServlet will be mapped to.
    In this case, it’s mapped to /, indicating that it will be the application’s default servlet.
    It will handle all requests coming into the application.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    /*
        The @Configuration class’s returned getRootConfigClasses() will be used
        to configure the application context created by ContextLoaderListener (server listener).
        ContextLoaderListener is expected to load the other beans in your application.
        These beans are typically the middle-tier and data-tier components that drive
        the back end of the application
    */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    /*
        The @Configuration classes returned from getServletConfigClasses()
        will define beans for DispatcherServlet’s application context.
        DispatcherServlet is expected to load beans containing web components
        such as controllers, view resolvers, and handler mappings
    */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }
}
