package com.erank.controller;

import java.net.URI;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.erank.model.AuthProvider;
import com.erank.model.User;
import com.erank.payload.ApiResponse;
import com.erank.payload.AuthResponse;
import com.erank.payload.LoginRequest;
import com.erank.payload.SignUpRequest;
import com.erank.repo.UserRepository;
import com.erank.security.TokenProvider;
import com.erank.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.erank.exception.BadRequestException;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class AuthController {  
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	 @Autowired
	    private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticationUser(@Valid @RequestBody LoginRequest loginRequest) {
		 
		Authentication authentication = authenticationManager.authenticate(new 
				UsernamePasswordAuthenticationToken(
						
						loginRequest.getEmail(),
						loginRequest.getPassword()
						)
				);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = tokenProvider.createToken(authentication);
		
		return ResponseEntity.ok(new AuthResponse(token));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?>registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if(userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new BadRequestException("Email address already in use.");
		}
		
		//Creating User's account
		User user= new User();
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(signUpRequest.getPassword());
		user.setProvider(AuthProvider.local);
		user.setPhNum(signUpRequest.getPhNum());
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User result = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(result.getId()).toUri();
		
		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered Successfully@"));
	}
	
	 @PostMapping("/user/add")
	    public User addUser(@RequestBody User user) {
	    	return userService.saveUser(user);
	    }
	    
	    @GetMapping("/userInfo")
	    public User getUserInfo(HttpServletRequest request){
	    	
	    	String jwt = getJwtFromRequest(request);
	    	
	    	Long userId = tokenProvider.getUserIdFromToken(jwt);
	    	
	    	
	    	 return userService.getUserById(userId);
	    }
	    
	    @PutMapping("/updateUser")
	    public User Update(@RequestBody User user){
	    	return userService.userUpdate(user);
	    }
	    
	    private String getJwtFromRequest(HttpServletRequest request) {
	        String bearerToken = request.getHeader("Authorization");
	        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
	            return bearerToken.substring(7, bearerToken.length());
	        }
	        return null;
	    }
}
