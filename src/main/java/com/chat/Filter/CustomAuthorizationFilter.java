package com.chat.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
public class CustomAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		/*
		String origin = "http://localhost:3000";
		response.addHeader("Access-Control-Allow-Origin", origin);
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Headers",
	            "content-type, x-gwt-module-base, x-gwt-permutation, clientid, longpush");
	    */
		if(request.getServletPath().equals("/login")) {
			filterChain.doFilter(request, response);
		} else {
			String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
			if(authorizationHeader != null) {
				try {
					
				String token = authorizationHeader;
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decoderJWT = verifier.verify(token);
				
				String username = decoderJWT.getSubject();
				
				String[] roles = decoderJWT.getClaim("roles").asArray(String.class);
				
				Collection<GrantedAuthority> authorities = new ArrayList<>();
				
				Stream<String> stream = Stream.of(roles);
				stream.forEach(role -> {
					authorities.add(new SimpleGrantedAuthority(role));
				});
				
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				
				filterChain.doFilter(request, response);
				
				} catch(Exception exception) {
					
					response.setHeader("error", exception.getMessage());
					response.sendError(HttpStatus.FORBIDDEN.value());
				}
				
			}
			else {
				filterChain.doFilter(request, response);
			}
		}
	}

}
