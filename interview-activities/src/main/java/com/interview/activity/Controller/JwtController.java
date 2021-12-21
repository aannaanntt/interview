package com.interview.activity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.interview.activity.helper.JwtUtil;
import com.interview.activity.jwtmodel.JwtRequest;
import com.interview.activity.jwtmodel.JwtResponse;

import com.interview.activity.service.CustomUserDetailsService;

@RestController
public class JwtController {
	@Autowired
	private CustomUserDetailsService customerdetailsservice;
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private AuthenticationManager authenticationmanager;

	@RequestMapping(value = "/tokens", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtrequest) throws Exception {
		System.out.println(jwtrequest.toString());
		try {
			this.authenticationmanager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtrequest.getUsername(), jwtrequest.getPassword()));

		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Creds");
		}

		UserDetails userdetails = this.customerdetailsservice.loadUserByUsername(jwtrequest.getUsername());

		String token = this.jwtutil.generateToken(userdetails);

		System.out.println("JWT TOKEN" + " " + token);

		return ResponseEntity.ok(new JwtResponse(token));

	}

}
