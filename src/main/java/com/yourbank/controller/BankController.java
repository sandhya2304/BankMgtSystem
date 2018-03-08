package com.yourbank.controller;

import static org.mockito.Matchers.intThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yourbank.model.Account;
import com.yourbank.model.Operate;
import com.yourbank.service.BankServiceI;

@Controller
public class BankController
{
	@Autowired
	private BankServiceI bankServiceI;
	
	@RequestMapping(value="/operations")
	public String index()
	{
		return "account";
	}
	
	
	@RequestMapping(value="/consultAccount")
	public String ConsultAcccount(Model model,String codeAccount,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size
			)
	{
		model.addAttribute("codeAccount",codeAccount);
		try
		{
			Account account=bankServiceI.consultAccount(codeAccount);
			Page<Operate> pageOperation=bankServiceI.listOperations(codeAccount,page,size);
			model.addAttribute("listOperations",pageOperation.getContent());
			int[] pages=new int[pageOperation.getTotalPages()];
			model.addAttribute("pages",pages);
			
			model.addAttribute("account",account);
		}catch(Exception e)
		{
			model.addAttribute("exception",e);
		}
		
		return "account";
	}
	
	@RequestMapping(value="/saveOperation",method=RequestMethod.POST)
	public String saveOperations(Model model,String typeOperation,String codeAccount,double amount,String codeAccount2)
	{
		try {
			if(typeOperation.equals("pay"))
			{
				bankServiceI.pay(codeAccount, amount);
			}
			
			else if(typeOperation.equals("with"))
			{
				bankServiceI.remove(codeAccount, amount);
			}
			if(typeOperation.equals("transfer"))
			{
				bankServiceI.transfer(codeAccount, codeAccount2, amount);
			}
		} catch (Exception e) {
			model.addAttribute("exception",e);
			return "redirect:/consultAccount?codeAccount="+codeAccount+"&error="+e.getMessage();
		}
		
		
		return "redirect:/consultAccount?codeAccount="+codeAccount;
		
	}
	
	

}
