package spittr.web;

import org.junit.Test;
import spittr.domain.Spitter;
import spittr.data.SpitterRepository;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.*;

/**
 * Created by drugo on 19/05/2017.
 */
public class SpitterControllerTest {
    /*
    shouldProcessRegistration() performs a POST request against /spitter/register.
    As part of that POST request, user information is passed as parameters
    on the request to simulate a form being submitted.
    When handling a POST request, it’s usually a good idea to send a redirect after the
    POST has completed processing so that a browser refresh won’t accidentally submit the form a second time.
    This test expects that the request will end in a redirect to /spitter/jbauer,
    the URL path of the new user’s profile page.
    Finally, the test verifies that the mocked SpitterRepository was actually used to
    save the data coming in on the form.
    */
    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));
        verify(mockRepository, atLeastOnce()).save(unsaved);
    }
}
