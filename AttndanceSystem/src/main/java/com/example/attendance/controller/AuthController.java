package com.example.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendance.model.AuthRequest;
import com.example.attendance.model.AuthResponse;
import com.example.attendance.service.JwtService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	public AuthResponse authenticate(@RequestBody AuthRequest request) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

		if (passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
			String token = jwtService.generateToken(userDetails.getUsername());

			return new AuthResponse(token);
		}

		throw new RuntimeException("Invalid username or password");
	}
}
