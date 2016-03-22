package com.ug.cyberCafe.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.ug.cyberCafe.domain.Address;
import com.ug.cyberCafe.domain.User;
import com.ug.cyberCafe.service.AddressService;
import com.ug.cyberCafe.service.RoleService;
import com.ug.cyberCafe.service.UserService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	final static Logger LOGGER = Logger.getLogger(EmployeeController.class);

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
	
	@RequestMapping(value = "list")
	public String list(Model model){
		userService.authorization(model);
		List<User> Employees = userService.getUsersByRole("ROLE_EMPLOYEE");
		LOGGER.info(Employees.size());
		model.addAttribute("employees",Employees);
		return "employee/listEmployee";
	}
	
	@RequestMapping(value = "deactive", method = RequestMethod.GET)
	public String deactivate(@RequestParam("id")String idUser,Model model){
		userService.deactivateUserAccount(Long.parseLong(idUser),false);
		return "redirect:/employee/list";
	}
	
	@RequestMapping(value = "active", method = RequestMethod.GET)
	public String activate(@RequestParam("id")String idUser,Model model){
		userService.deactivateUserAccount(Long.parseLong(idUser),true);
		return "redirect:/employee/list";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String getEmployeeProfilUpdateForm(@RequestParam("id") String idCustomer, Model model) throws IOException{
			userService.authorization(model);
			User userProfil = userService.getUserById(Long.parseLong(idCustomer));
			Address userAddress = addressService.getAddressById(userProfil.getAddress().getIdAddress());
			if(userProfil.getAvatar() != null){
	        	byte[] encodeBase64 = Base64.encode(userProfil.getAvatar());
	       	 	String base64Encoded = new String(encodeBase64, "UTF-8");
	       	 	model.addAttribute("userImage", base64Encoded );
		    }
            model.addAttribute("userProfil",userProfil);
            model.addAttribute("userAddress",userAddress);
            model.addAttribute("edit",true);
    	return "/employee/updateEmployee";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String processEmployeeProfilUpdateForm(@Valid @ModelAttribute("userProfil") User userProfil, BindingResult resultUser,@RequestParam("id") String idUser, @Valid @ModelAttribute("userAddress") Address userAddress, BindingResult resultAddress, Model model) throws IOException{
			userService.authorization(model);
            userProfil.setIdUser(Long.parseLong(idUser));
            LOGGER.info(userProfil.getIdUser());
            LOGGER.info(userProfil.getFirstName());
            LOGGER.info(userProfil.getLastName());
            LOGGER.info(idUser);
			if(resultUser.hasErrors() || resultAddress.hasErrors()){
				model.addAttribute("warn","Nie udało się wykonać aktualizacji, spróbuj ponownie!");
				LOGGER.info(resultUser.toString());
				LOGGER.info(userAddress.toString());
				return "/employee/updateEmployee";
			}else{
				addressService.updateAddress(userAddress);
				userService.updateUser(userProfil);
				return "redirect:/employee/list";
			}
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String getAddNewUserForm(Model model){
		userService.authorization(model);
		User newUser = new User();
		Address newAddress = new Address();
		model.addAttribute("newUser", newUser);
		model.addAttribute("newAddress",newAddress);
		return "/employee/addEmployee";
	}
	
	/**
	 * @throws IOException 
	 * @throws HibernateException 
	 * @throws SQLException 
	 * @throws SerialException 
	 * 
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String processAddNewUserForm(@Valid @ModelAttribute("newUser") User newUser, BindingResult resultUser,@Valid @ModelAttribute("newAddress") Address newAddress, BindingResult resultAddress, Model model) throws HibernateException, IOException, SerialException, SQLException{
		userService.authorization(model);
		if(resultUser.hasErrors() || resultUser.hasErrors()){
			model.addAttribute("warn","Nie udało się dodać pracownika, spróbuj ponownie!");
			return "/customer/addCustomer";
		}else{
			newUser.setRole(roleService.getRoleByName("ROLE_EMPLOYEE"));
			addressService.addAddress(newAddress);
			newUser.setAddress(newAddress);
			userService.addUser(newUser);
			return "redirect:/employee/list" ;
		}
	}
		
	
	
}
