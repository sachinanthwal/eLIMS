package com.lims.controller;

import com.lims.model.AuthenticationRequest;
import com.lims.util.JwtUtil;
import com.lims.model.AuthenticationResponse;
import com.lims.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
													   HttpServletRequest request) throws Exception
	{
		HttpSession session = request.getSession();
		String errorMessage = null;
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			errorMessage = "Invalid UserName and Password";
			return ResponseEntity.ok(new AuthenticationResponse(null, errorMessage));
		}

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		session.setAttribute("userName", authenticationRequest.getUsername());
		session.setAttribute("userRole", authenticationRequest.getUserRole());
		session.setAttribute("token",jwt);
		return ResponseEntity.ok(new AuthenticationResponse(jwt, errorMessage));
	}

}

