package schoolmanagement.config;

import java.io.IOException;

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

import schoolmanagement.helper.JwtUtil;
import schoolmanagement.services.CustomUserDetailsService;

@Component
public class JWTAuthenticationfilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtutil;

	@Autowired
	private CustomUserDetailsService cds;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//get jwt
		//start from bearer
		//validate
		
		
		String reqtokenheader = request.getHeader("Authorization");
		
		String userName=null;
		
		String jwttoken=null;
		//null and format
		if(reqtokenheader!=null && reqtokenheader.startsWith("Bearer"))
		{
			jwttoken=reqtokenheader.substring(7);
			
			try
			{
				
			userName=this.jwtutil.extractUsername(jwttoken);
				
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			UserDetails userdetails = this.cds.loadUserByUsername(userName);
			
			
			//not null username
			
			if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null)
			{
			
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
			     
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			
			}
			
			
			
			
		}
		
		filterChain.doFilter(request, response);

	}

	
}
