package net.karatas.altay.tracknumerator.core.config;

import net.karatas.altay.tracknumerator.core.aspect.AppLogger;
import net.karatas.altay.tracknumerator.core.secure.CORSFilter;
import net.karatas.altay.tracknumerator.core.servlet.filter.RequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class AppConfig {

    @Bean
    public RequestFilter requestFilter() {
        return new RequestFilter();
    }

    @Bean
    public AppLogger appLogger() {
        return new AppLogger();
    }

    @Bean
    public CORSFilter corsFilter() {
        return new CORSFilter();
    }

}
