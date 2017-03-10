package devApp.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImp implements SecurityService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bPasswordCryptEncoder;
	
	@Override
	public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		if(userDetails instanceof UserDetails){
			return ((UserDetails) userDetails).getUsername();
		}
		
		return null;
	}

    /**
     * AutoLogin method to login user after registration.
     * @param username and password of the user
     */
	@Override
	public void autoLogin(String username, String password) {
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

		// manual password encryption check
		if(this.bPasswordCryptEncoder.matches(password, userDetails.getPassword())){
			UsernamePasswordAuthenticationToken authenticationToken = 
					new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
			
			this.authenticationManager.authenticate(authenticationToken);
			
			if(authenticationToken.isAuthenticated()){
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}	
		}		
	}

}
