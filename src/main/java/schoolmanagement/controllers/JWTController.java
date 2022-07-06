package schoolmanagement.controllers;

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

import schoolmanagement.helper.JwtUtil;
import schoolmanagement.models.JWTRequest;
import schoolmanagement.models.JWTResponse;
import schoolmanagement.services.CustomUserDetailsService;

@RestController
public class JWTController {

	
	@Autowired
	private AuthenticationManager auth;
	
	
	
	@Autowired
	private CustomUserDetailsService cds;
	
	
	@Autowired
	private JwtUtil jwtutil;
	
	@RequestMapping(value = "/token",method = RequestMethod.POST)
	public ResponseEntity<?>generatetoken(@RequestBody JWTRequest jwtrequest) throws Exception
	{
		
		System.out.println(jwtrequest);
		
		
		try
		{
			this.auth.authenticate(new UsernamePasswordAuthenticationToken(jwtrequest.getUserName(), jwtrequest.getPassword()));
			
		}
		
		catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credentials");
			
		}
		
		
		//fine code
		
		UserDetails userdetails = this.cds.loadUserByUsername(jwtrequest.getUserName());
		
		String token = this.jwtutil.generateToken(userdetails);
		
		//convert token to json
		
		return ResponseEntity.ok(new JWTResponse(token));
		
		
		
	}
}
