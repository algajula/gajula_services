package com.gajula.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private final static Logger admin = LogManager.getLogger(WebConfig.class);

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        //resolver.setExposeContextBeansAsAttributes(true);
        admin.info("VIEW RESOLVER:::");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        admin.info("addResourceHandlers start");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/**", "classpath:/resources/static/**",
                        "classpath:/static/");
        admin.info("addResourceHandlers end");
        registry.setOrder(1);
    }

}
