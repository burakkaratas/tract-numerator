package net.karatas.altay.tracknumerator.core.servlet.filter;

import lombok.extern.slf4j.Slf4j;
import net.karatas.altay.tracknumerator.core.context.Context;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class RequestFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            Context.setTx(UUID.randomUUID().toString());
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            Context.cleanup();
        }
    }
}
