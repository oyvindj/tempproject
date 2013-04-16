package no.tine.starterkit.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import no.tine.common.user.UserService;
import no.tine.common.user.WebUserFactory;
import no.tine.common.web.interceptor.UserObjectFileConfigurableInterceptor;
import no.tine.common.web.interceptor.UserObjectHeaderInterceptor;
import no.tine.common.web.interceptor.UserObjectInterceptor;
import no.tine.common.web.interceptor.UserObjectStickyFileConfigurableInterceptor;

@Configuration
public class UserMappersConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${defaultMockUser}")
    protected String defaultMockUser;


    @Autowired
    private UserService userService;

    @Autowired
    private WebUserFactory userFactory;

    //henter brukerverdier fra header verdier i request
    @Bean
    UserObjectHeaderInterceptor userObjectHeaderInterceptor() {

        UserObjectHeaderInterceptor headerInterceptor = new UserObjectHeaderInterceptor();
        headerInterceptor.setUserFactory(userFactory);
        headerInterceptor.setUserService(userService);
        return headerInterceptor;
    }

    @Bean
    UserObjectFileConfigurableInterceptor userObjectFromFileInterceptor() {
        UserObjectFileConfigurableInterceptor userInterceptor = new UserObjectFileConfigurableInterceptor();

        userInterceptor.setUserFactory(userFactory);
        userInterceptor.setUserService(userService);
        userInterceptor.setDefaultUser(defaultMockUser);

        return userInterceptor;
    }


    @Bean
    public UserObjectStickyFileConfigurableInterceptor stickyUserObjectFromFileInterceptor() {
        UserObjectStickyFileConfigurableInterceptor userInterceptor = new UserObjectStickyFileConfigurableInterceptor();

        userInterceptor.setUserFactory(userFactory);
        userInterceptor.setUserService(userService);
        userInterceptor.setDefaultUser(defaultMockUser);

        return userInterceptor;
    }

    protected UserObjectInterceptor resolveUserInterceptor(String name) {
        return (UserObjectInterceptor) applicationContext.getBean(name);
    }

}