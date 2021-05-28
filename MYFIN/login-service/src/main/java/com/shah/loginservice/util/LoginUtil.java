package com.shah.loginservice.util;
import com.shah.loginservice.VO.LoginInputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoginUtil{

    @Value("{url.registration-base-url}")
    private String registrationBaseUrl;

    @Value("{url.credentials-authenticate-base-url}")
    private String credentialsAuthenticateBaseUrl;

    @Autowired
    RestTemplate restTemplate;

    public Long getUserIdFromUsername(String username){
        return restTemplate.getForObject(registrationBaseUrl+username, Long.class);
    }

    public boolean authenticateUser(LoginInputVO loginInputVO) {
        ResponseEntity<Boolean> responseEntity =
                restTemplate.postForEntity(credentialsAuthenticateBaseUrl, loginInputVO, Boolean.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }
}
