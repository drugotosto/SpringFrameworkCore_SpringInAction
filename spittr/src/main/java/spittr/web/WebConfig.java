package spittr.web;

/**
 * Created by drugo on 17/05/2017.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
/*      spitter.web package will be scanned for components.
        The controllers you write will be annotated with @Controller,
        which will make them candidates for component-scanning.
*/
@ComponentScan("spittr.web")
public class WebConfig  extends WebMvcConfigurerAdapter {

    /*
    You add a ViewResolver bean. It’s configured to look for JSP files by wrapping view names
    with a specific prefix and suffix (for example, a view name of "home" will be resolved
    as "/WEB-INF/views/home.jsp").
    */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        /*
        But if those JSP files are using JSTL tags for formatting or messages, then you may want to configure
        InternalResourceViewResolver to resolve a JstlView instead.
        This will ensure that JSTL’s formatting and message tags will get the Locale and message sources configured in Spring.
        */
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        return resolver;
    }

    /*
    Finally, this new WebConfig class extends WebMvcConfigurerAdapter and overrides
    its configureDefaultServletHandling() method. By calling enable() on the given
    DefaultServletHandlerConfigurer, you’re asking DispatcherServlet to forward
    requests for static resources to the servlet container’s default servlet and not to try to
    handle them itself.
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
