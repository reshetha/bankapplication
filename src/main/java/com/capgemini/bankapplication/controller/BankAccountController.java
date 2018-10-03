package com.capgemini.bankapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.bankapplication.entities.BankAccount;
import com.capgemini.bankapplication.entities.Customer;
import com.capgemini.bankapplication.service.BankAccountService;

@Controller
public class BankAccountController {

	@Autowired
	private BankAccountService bankaccountService;
	
	@RequestMapping("/k")
	public String sayHello() {
		return "index";
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getHeaderPage()
	{
		return "header";
	}
	
	@RequestMapping(value ="/balance", method=RequestMethod.GET)
	public String getBalancePage(HttpSession session, HttpServletRequest request,Model model) {
		session= request.getSession();
		Customer customer=(Customer) session.getAttribute("customer");
		double balance= bankaccountService.getBalance(customer.getAccount().getAccountId());
	  model.addAttribute("balance",balance);
		return "balance";
	}
	@RequestMapping(value="/fundTransferPage",method=RequestMethod.GET)
	public String getFundTransferPage() {
		return "transfer";
	}
	@RequestMapping(value="/transfer",method=RequestMethod.POST)
    public String fundTransfer(HttpSession session,HttpServletRequest request,Model model,@RequestParam long fromAccount,@RequestParam long toAccount,@RequestParam double amount) {
		Customer customer=(Customer) session.getAttribute("customer");
		bankaccountService.fundTransfer(fromAccount, toAccount, amount);
		session.setAttribute("customer", customer);
		request.setAttribute("success", true);
	    return "success";
		
	}




/*	@RequestMapping(value = "/edit4", method = RequestMethod.POST)
	public String updateCustomer(Model model, @RequestParam String custName, @RequestParam String address,
			@RequestParam String email, HttpSession session, HttpServletRequest request) {
		Customer customer = (Customer) session.getAttribute("customer");
		session = request.getSession();
		customer.setCustomerName(custName);
		customer.setAddress(address);
		customer.setEmail(email);
		customerService.updateProfile(customer);
		session.setAttribute("customer", customer);
		return "edit";
	}
	*/
	
	


//	@RequestMapping(value ="/login.do", method = RequestMethod.POST)
//	
//	public String login(@ModelAttribute Customer customer,HttpServletRequest request) throws Exception {
//		customer = customerService.authenticate(customer);
//		if(customer!=null)
//		{
//		HttpSession session =request.getSession();
//		session.setAttribute("Customer",customer);
//		session.setMaxInactiveInterval(60);
//		return "loginpage";
//		}
//	return "home";
//		
//	}
////	@RequestMapping("/")
////	public String login() {
////		return "login";
////	}
//
//	

//	@RequestMapping(value = "/getBalancePage", method = RequestMethod.GET)
//	public String getBalancePage(@PathVariable int accountId) throws PayeeAccountNotFoundException {
//		bankAccountService.getBalance(accountId);
//	return "getBalance";
//}
}
//	@RequestMapping(value = "/fundTransferPage", method = RequestMethod.GET)
//	public String fundTransferPage(@PathVariable int accountId, Model model) {
//		return "fundTransfer";
//	}
//
//	@RequestMapping(value = "/moneyTransfer", method = RequestMethod.POST)
//	public String fundTransfer(@PathVariable long fromAcc, long toAcc, double amount)
//			throws Exception {
//		bankAccountService.fundTransfer(fromAcc, toAcc, amount);
//		return "fundTransferSuccess";
//	}
//	
///*	@RequestMapping("/")
//	public String home() {
//		return "login";
//	}*/
//	
//	
//	 /*@RequestMapping(value = "/getBalancePage", method = RequestMethod.GET)
//	   public String authenticatePage(Model model) {
//		   model.addAttribute("bankAccount", new BankAccount());
//		   return "login";
//	   }*/
//	   
//	   @RequestMapping(value = "/loginPage" ,method = RequestMethod.POST)
//	   public String authenticate(@ModelAttribute Customer customer) throws Exception {
//	       customerService.authenticate(customer);
//	       return "home";
//	   }
//	   
//	   @RequestMapping(value = "/editProfilePage", method = RequestMethod.GET)
//	   public String editProfilePage(@ModelAttribute Customer customer) {
//	        return "updateProfileForm";
//	   }
//	   
//	  @RequestMapping(value = "/updateProfilePage",method = RequestMethod.POST)
//	  public String updateProfilePage(@ModelAttribute Customer customer) throws SQLException {
//		  customerService.updateProfile(customer);
//		  return "customerDetails";
//	  }
//	  
//	  @RequestMapping(value = "/editPasswordPage", method = RequestMethod.GET)
//	   public String editPasswordPage(@ModelAttribute Customer customer) {
//	        return "updatePasswordForm";
//	   }
//	   
//	  @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
//	  public String updatePassword(@PathVariable Customer customer, String oldPassword, String newPassword) throws SQLException {
//		  customerService.updatePassword( customer,oldPassword,newPassword);
//		  return "passwordChangedSuccessfully";
//	  }
//	  
//	  @RequestMapping(value = "/logout", method = RequestMethod.GET)
//	   public String logout(Model model) {
//		   return "login";
//	   }
//	  
//	  
//}