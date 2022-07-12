package bebeShare.web;

//import bebeShare.config.auth.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(controllers = HelloConntroller.class,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)
@MockBean(JpaMetamodelMappingContext.class)
class HelloConntrollerTest {

    @Autowired
    private MockMvc mvc;



    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @WithMockUser(roles = "USER")
    @Test
    void helloDto가리턴된당() throws Exception {

        mvc.perform(
                get("/hello/dto")
                        .param("name","hello")
                        .param("amount", String.valueOf(1000))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("hello")))
                .andExpect(jsonPath("$.amount", is(1000)));
    }
}