package com.interview.activity.config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.interview.activity.helper.JwtUtil;
import com.interview.activity.jwtmodel.JwtResponse;
import com.interview.activity.service.CustomUserDetailsService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomUserDetailsService customuserdetailsservice;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// get jwt
		//// Bearer
		// validate

		//
         
           String name = request.getParameter("username");
		String requestTokenHeader = request.getHeader("Authorization");
		String username=null;
		String jwtToken = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);

			try {
				username = this.jwtutil.extractUsername(jwtToken);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

  
		// securtity
		
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userdetails = this.customuserdetailsservice.loadUserByUsername(name);
			if (jwtutil.validateToken(jwtToken, userdetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userdetails, null, userdetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}

		}
		
		
		filterChain.doFilter(request, response);
	}
	
	

}
