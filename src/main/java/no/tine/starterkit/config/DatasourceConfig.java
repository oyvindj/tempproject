package no.tine.starterkit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class DatasourceConfig {

    @Bean(name = "dataSourceNMHDB2P")
    JndiObjectFactoryBean dataSourceNMHDB2P() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("java:comp/env/jdbc/nmhdb2p");
        return jndiObjectFactoryBean;
    }

}