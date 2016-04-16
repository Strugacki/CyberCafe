package com.ug.cyberCafe.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

public abstract class UtilitiesService {
	
	
	public String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
	
	public Model authorization(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( !(auth instanceof AnonymousAuthenticationToken)){
			model.addAttribute("user",getPrincipal());
			if(auth.getAuthorities() != null){
				for(GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()){
					String role = authority.getAuthority();
					model.addAttribute("role",role);
				}
			}
		}else{
			model.addAttribute("user", null);
		}
		
		return model;
	}
	
	
	
}
