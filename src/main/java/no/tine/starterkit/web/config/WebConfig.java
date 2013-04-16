package no.tine.starterkit.web.config;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import no.tine.common.web.interceptor.EnvironmentModeInterceptor;


@Configuration
public class WebConfig {

    private static final Logger LOG = LoggerFactory.getLogger(WebConfig.class);

    @Autowired
    private UserMappersConfig userMappers;

    @Value("${userObjectInterceptor}")
    protected String userObjectInterceptor;

    @Autowired
    private EnvironmentModeInterceptor environmentModeInterceptor;


    @Bean
    FixedLocaleResolver localeResolver() {
        return new FixedLocaleResolver(new Locale("NO"));
    }

    @Bean
    ResourceBundleViewResolver submoduleViewResolver() {
        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
        viewResolver.setBasename("views");
        viewResolver.setCache(true);
        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Bean
    InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setOrder(10);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setCache(true);
        return viewResolver;
    }


    @Bean
    DefaultAnnotationHandlerMapping interceptorMapper() {
        DefaultAnnotationHandlerMapping interceptorMapping = new DefaultAnnotationHandlerMapping();

        Object[] interceptors = new Object[2];
        interceptors[0] = userMappers.resolveUserInterceptor(userObjectInterceptor);
//        interceptors[1] = new IEOverrideCompatibilityViewInterceptor();
        interceptors[1] = environmentModeInterceptor;

        interceptorMapping.setInterceptors(interceptors);
        return interceptorMapping;

    }


}

