package br.com.guilhermemessias.devsnap.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class Filter extends OncePerRequestFilter {
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = searchToken(request);
        if (token != null) {
            String userLogin = tokenService.searchUserToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private String searchToken(HttpServletRequest request) {
        var token = request.getHeader("Authorization");
        if (token != null) {
        return token.replace("Bearer ", "");
        }
        return null;
    }
}
