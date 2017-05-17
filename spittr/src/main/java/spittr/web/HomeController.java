package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
/**
 * Created by drugo on 17/05/2017.
 */

//The first thing you’ll notice about HomeController is that it’s annotated with @Controller
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

    /*
    HomeController’s only method, the home() method, is annotated with @RequestMapping.
    The value attribute specifies the request path that this method will handle,
    and the method attribute details the HTTP method that it can handle.
    In this case, whenever an HTTP GET request comes in for /, the home() method will be called.
    As you can see, the home() method doesn’t do much: it returns a String value of“home”.
    This String will be interpreted by Spring MVC as the name of the view that will be rendered.
    DispatcherServlet will ask the view resolver to resolve this logical view name into an actual view
    Given the way you configured InternalResourceViewResolver, the view name “home” will be resolved
    as a JSP at /WEB-INF/views/home.jsp
    */
    @RequestMapping(method=GET)
    public String home() {
        return "home";
    }
}