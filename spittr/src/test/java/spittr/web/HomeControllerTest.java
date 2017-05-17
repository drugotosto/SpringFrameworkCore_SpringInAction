package spittr.web;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by drugo on 17/05/2017.
 */
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        assertEquals("home", controller.home());
    }
}