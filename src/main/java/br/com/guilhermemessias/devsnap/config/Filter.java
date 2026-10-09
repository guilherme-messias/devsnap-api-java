package br.com.guilhermemessias.devsnap.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class Filter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = searchToken(request);
    }

    private String searchToken(HttpServletRequest request) {
        var token = request.getHeader("Authorization");
        if (token == null) {
            throw new RuntimeException("Token not found");
        }
        return token.replace("Bearer ", "");
    }
}
