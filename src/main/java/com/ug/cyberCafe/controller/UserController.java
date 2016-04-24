package com.ug.cyberCafe.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.ug.cyberCafe.service.AddressService;
import com.ug.cyberCafe.service.RoleService;
import com.ug.cyberCafe.service.UserService;
import com.ug.cyberCafe.domain.Address;
import com.ug.cyberCafe.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	final static Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AddressService addressService;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	
	/**
	 * Controller method rendering login page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model){
		userService.authorization(model);
		return "/user/login";
	}
	
	/**
	 * Controller method redirecting to logout page
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request,response,auth);
		}
		return "redirect:/user/login?logout";
	}
	
	/**
	 * Controller method rendering user profile page
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile(Model model) throws IOException{
		userService.authorization(model);
        User currentUser = userService.getUserByUsername(userService.getPrincipal());
        Address currentAddress = addressService.getAddressById(currentUser.getAddress().getIdAddress());
        if(currentUser.getAvatar() != null){
        	byte[] encodeBase64 = Base64.encode(currentUser.getAvatar());
       	 	String base64Encoded = new String(encodeBase64, "UTF-8");
       	 	model.addAttribute("userImage", base64Encoded );
        }
        model.addAttribute("currentUser",currentUser);
        model.addAttribute("currentAddress",currentAddress);
	
        return "/user/profile";
	}
	
	/**
	 * Get user update form controller method
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "profile/edit", method = RequestMethod.GET)
	public String getUserProfilUpdateForm(Model model) throws IOException{
		userService.authorization(model);
		User userProfil = userService.getUserByUsername(userService.getPrincipal());
		Address userAddress = addressService.getAddressById(userProfil.getAddress().getIdAddress());
        model.addAttribute("userProfil",userProfil);
        model.addAttribute("userAddress",userAddress);
        model.addAttribute("edit",true);
        return "/user/profile";
	}
	
	/**
	 * Process user update form controller method
	 * @param userProfil
	 * @param resultUser
	 * @param userAddress
	 * @param resultAddress
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "profile/edit", method = RequestMethod.POST)
	public String processUserProfilUpdateForm(@Valid @ModelAttribute("userProfil") User userProfil, BindingResult resultUser,@Valid @ModelAttribute("userAddress") Address userAddress, BindingResult resultAddress, Model model) throws IOException{
		userService.authorization(model);
		if(resultUser.hasErrors() || resultAddress.hasErrors()){
			model.addAttribute("warn","Nie udało się wykonać aktualizacji, spróbuj ponownie!");
			LOGGER.info("Result user: "+resultUser.toString() + " user address: " + userAddress.toString());
			return "/user/profile";
		}else{
			addressService.updateAddress(userAddress);
			userService.updateUser(userProfil);
			return "redirect:/user/profile";
		}
	}
	
	/**
	 * Get user add form controller method
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String getAddNewUserForm(Model model){
		userService.authorization(model);
		User newUser = User.builder().build();
		Address newAddress = Address.builder().build();
		newUser.setActive(true);
		model.addAttribute("newUser", newUser);
		model.addAttribute("newAddress",newAddress);
		return "/user/registration";
	}
	
	/**
	 * Process user add form controller method
	 * @throws IOException 
	 * @throws HibernateException 
	 * @throws SQLException 
	 * @throws SerialException 
	 * 
	 */
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String processAddNewUserForm(@Valid @ModelAttribute("newUser") User newUser, BindingResult resultUser,@Valid @ModelAttribute("newAddress") Address newAddress, BindingResult resultAddress, Model model) throws HibernateException, IOException, SerialException, SQLException{
		userService.authorization(model);
		if(resultUser.hasErrors() || resultUser.hasErrors()){
			model.addAttribute("warn","Nie udało się wykonać rejestracji, spróbuj ponownie!");
			LOGGER.info("Result user: "+resultUser.toString() + " user address: " + newAddress.toString());
			return "/user/registration";
		}else{
			newUser.setRole(roleService.getRoleByName("ROLE_USER"));
			addressService.addAddress(newAddress);
			newUser.setAddress(newAddress);
			userService.addUser(newUser);
			return "redirect:/user/profil" ;
		}
	}
	
	/**
	 * Check nickname controller method
	 * using AJAX
	 * @param nickname
	 * @return
	 */
	@RequestMapping(value = "checkNickname", method = RequestMethod.GET)
	public @ResponseBody String checkNickname(@RequestParam("nickname") String nickname){
		String response = "not";
		boolean result;
		result = userService.checkUniqueNickname(nickname);
		if(result){
			response = "yes";
		}else{
			response = "not";
		}
		return response;
	}
	
	/**
	 * Check login controller method
	 * using AJAX
	 * @param login
	 * @return
	 */
	@RequestMapping(value = "checkLogin", method = RequestMethod.GET)
	public @ResponseBody String checkLogin(@RequestParam("login") String login){
		String response = "not";
		boolean result;
		result = userService.checkUniqueLogin(login);
		if(result){
			response = "yes";
		}else{
			response = "not";
		}
		return response;
	}
	
}
	
