package com.hyundai.pjt.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hyundai.pjt.security.service.MemberContext;


public class CustomAuthenticationProvider implements AuthenticationProvider {

   @Autowired
   private UserDetailsService userDetailsService;
   
   @Autowired
   private PasswordEncoder passwordEncoder;

   @Override
   public Authentication authenticate(Authentication authentication) throws AuthenticationException {
      String username = authentication.getName();
      String password = (String) authentication.getCredentials();
      MemberContext memberContext = (MemberContext) userDetailsService.loadUserByUsername(username);

      if (!passwordEncoder.matches(password, memberContext.getMember().getMpassword())) {
         throw new BadCredentialsException("BadCredentialsException");
      }
      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            memberContext.getMember(), null, memberContext.getAuthorities());

      return authenticationToken;
   }

   @Override
   public boolean supports(Class<?> authentication) {
      return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
   }

}