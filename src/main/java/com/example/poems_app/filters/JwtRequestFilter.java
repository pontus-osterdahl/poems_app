package com.example.poems_app.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.poems_app.services.ApplictionUserDetailsService;
import com.example.poems_app.util.JwtUtil;

//@Component
public class JwtRequestFilter {//extends OncePerRequestFilter {
/**
	@Autowired
	private ApplictionUserDetailsService userDetailsService ;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		
		
		final String authorizationHeader = request.getHeader("Authorization");
		
		String username = null;
		
		String token = null;
		
		if (
			authorizationHeader != null && authorizationHeader.startsWith("Bearer")
				) {
			token = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(token);
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
		
		
		    if (jwtUtil.validateToken(token, userDetails)) {
		    	UsernamePasswordAuthenticationToken upw = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
		    	upw.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		    	SecurityContextHolder.getContext().setAuthentication(upw);
		    }
		
		
		}
		filterChain.doFilter(request, response);
		
		
	}
	
	*/
}
