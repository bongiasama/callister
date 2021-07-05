package im.route.api.config;

import im.route.api.httpproxy.ProxyServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class SolrProxyServletConfiguration implements EnvironmentAware {

    @Value("${app.servlet_url}")
    private String servlet_url;
//    @Value("${app.target_url}")
//    private String target_url;
    @Value("${app.logging_enabled}")
    private String logging_enabled;

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), servlet_url);
        //servletRegistrationBean.addInitParameter(ProxyServlet.P_TARGET_URI, target_url);
        servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, logging_enabled);
        return servletRegistrationBean;
    }

    @Override
    public void setEnvironment(Environment environment) {
    }
}
