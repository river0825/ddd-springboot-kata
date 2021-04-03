package solid.humank.dddspringbootkata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import solid.humank.dddspringbootkata.webapi.TutorialController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// This is 鳳先, Hello World
// 到此一遊
// DaMuSe歸位

@SpringBootTest
@AutoConfigureMockMvc
class DddSpringbootKataApplicationTests {

    @Autowired
    private TutorialController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void should_get_correct_json() throws Exception {
        String uri = "/api/tutorials";

        String expected = "[{\"id\":1,\"title\":\"test1\",\"published\":true,\"description\":\"kimtest\"},{\"id\":2,\"title\":\"test2\",\"published\":true,\"description\":\"fongtest\"},{\"id\":3,\"title\":\"test3\",\"published\":true,\"description\":\"arthurtest\"},{\"id\":4,\"title\":\"test4\",\"published\":true,\"description\":\"rivertest\"}]";

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get(uri));
        String content = result.andReturn().getResponse().getContentAsString();
        assertEquals(expected,content);
    }

}

