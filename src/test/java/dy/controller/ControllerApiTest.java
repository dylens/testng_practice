package dy.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//@WebAppConfiguration
//@ContextConfiguration(locations = "classpath:application.yaml")
@SpringBootTest
public class ControllerApiTest {

//    @Autowired
//    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeTest
    public void start() {
        // 这种方式需要依赖集成Web环境
        // mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        // 此种方式并不会集成真正的web环境，而是通过相应的Mock API进行模拟测试，无须启动服务器
        mockMvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
    }

    @Test
    public void testHelloController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/dye"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello dye"));
    }


}
