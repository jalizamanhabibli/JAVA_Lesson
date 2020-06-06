package com.company;

import com.company.dto.ResponseDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration;
import org.springframework.security.oauth2.client.test.OAuth2ContextSetup;
import org.springframework.security.oauth2.client.test.RestTemplateHolder;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 01/06/2020
 * Time: 18:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ResumeRestApiApplication.class,webEnvironment = WebEnvironment.DEFINED_PORT)
@OAuth2ContextConfiguration(MyDetails.class)
public class UserRestControllerIT implements RestTemplateHolder {
    @LocalServerPort
    private int port;

    public int getPort() {
        return port;
    }

//    @Autowired
//    private TestRestTemplate testRestTemplate;

    @Rule
    public OAuth2ContextSetup contextSetup = OAuth2ContextSetup.standard(this);

    RestOperations restTemplate;

    @Test
    public void testGetUsers() throws Exception {
        String url = "http://localhost:" + port + "/users";
        ResponseDto entity = this.restTemplate.getForObject(url, ResponseDto.class);
        System.out.println(entity);

    }

    @Override
    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate=restTemplate;
    }

    @Override
    public RestOperations getRestTemplate() {
        return restTemplate;
    }
}
class MyDetails extends ResourceOwnerPasswordResourceDetails{
    public MyDetails(Object obj) {
        UserRestControllerIT test=(UserRestControllerIT) obj;
        setAccessTokenUri("http://localhost:" + test.getPort() + "/oauth/token");
        setClientId("alma");
        setClientSecret("alma");
        List<String> scope = Arrays.asList("read","write");
        setScope(scope);
        setUsername("elizaman196@gmail.com");
        setPassword("12345");
        setClientAuthenticationScheme(AuthenticationScheme.header);
    }
}
