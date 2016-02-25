package com.ug.cyberCafe.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.ug.cyberCafe.service.RoleService;
import com.ug.cyberCafe.service.UserService;
import com.ug.cyberCafe.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model){
		Authorization(model);
		return "/user/login";
	}
	
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request,response,auth);
		}
		return "redirect:/user/login?logout";
	}
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile(Model model) throws IOException{
            User currentUser = userService.getUserByUsername(getPrincipal());
            Authorization(model);
            if(currentUser.getAvatar() != null){
            	byte[] encodeBase64 = Base64.encode(currentUser.getAvatar());
           	 	String base64Encoded = new String(encodeBase64, "UTF-8");
           	 	model.addAttribute("userImage", base64Encoded );
            }
            System.out.println(currentUser.getAvatar());
            model.addAttribute("currentUser",currentUser);
    	
    	return "/user/profile";
	}
	
	@RequestMapping(value = "profile/edit", method = RequestMethod.GET)
	public String getUserProfilUpdateForm(Model model) throws IOException{
			Authorization(model);
			User userProfil = userService.getUserByUsername(getPrincipal());
            model.addAttribute("userProfil",userProfil);
            model.addAttribute("edit",true);
    	return "/user/profile";
	}
	
	@RequestMapping(value = "profile/edit", method = RequestMethod.POST)
	public String processUserProfilUpdateForm(@Valid @ModelAttribute("userProfil") User userProfil,BindingResult result, Model model) throws IOException{
            Authorization(model);
			if(result.hasErrors()){
				model.addAttribute("warn","Nie udało się wykonać aktualizacji, spróbuj ponownie!");
				return "/user/profile";
			}else{
				userService.updateUser(userProfil);
				return "redirect:/user/profile";
			}
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String getAddNewUserForm(Model model){
		User newUser = new User();
		newUser.setActive(true);
		model.addAttribute("newUser", newUser);
		Authorization(model);
		return "/user/registration";
	}
	
	/**
	 * @throws IOException 
	 * @throws HibernateException 
	 * @throws SQLException 
	 * @throws SerialException 
	 * 
	 */
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String processAddNewUserForm(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model) throws HibernateException, IOException, SerialException, SQLException{
		if(result.hasErrors()){
			model.addAttribute("warn","Nie udało się wykonać rejestracji, spróbuj ponownie!");
			System.out.println(result.toString());
			return "/user/registration";
		}else{
			newUser.setRole(roleService.getRoleByName("ROLE_USER"));
			newUser.setAddresses(null);
			System.out.println(newUser.getAvatar());
			userService.addUser(newUser);
			return "redirect:/" ;
		}
	}
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
	
	private Model Authorization(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( !(auth instanceof AnonymousAuthenticationToken)){
			model.addAttribute("user",getPrincipal());
			if(auth.getAuthorities() != null){
				for(GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()){
					String role = authority.getAuthority();
					System.out.println(role);
					model.addAttribute("role",role);
				}
			}
		}else{
			model.addAttribute("user", null);
		}
		
		return model;
	}
	
}
	
