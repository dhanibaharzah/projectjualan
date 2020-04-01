package com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.dto.MstCustomerDto;
import com.mvc.dto.MstKotaDto;
import com.mvc.dto.MstSupplierDto;
import com.mvc.service.MstCustomerSvc;
import com.mvc.service.MstKotaSvc;



@Controller
public class MstCustomerCtl {
	
	@Autowired
	private MstCustomerSvc svc;
	
	@Autowired
	private MstKotaSvc svcKota;
	
	@RequestMapping("/customer")
	public ModelAndView allCustomer(Model model) {
		
		List<MstCustomerDto> dtos = svc.listAll();
		model.addAttribute("listCustomer", dtos);
		ModelAndView modelAndView = new ModelAndView("customer-def", "model", model);
		
		return modelAndView;
	
	}
	
	@RequestMapping("/customer/add")
	public ModelAndView add(Model model) {
		
		MstCustomerDto dto = new MstCustomerDto();
		
		List<MstKotaDto> listKota = svcKota.listAll();
		model.addAttribute("listKota", listKota);
		model.addAttribute("dto", dto);
		
		ModelAndView modelAndView = new ModelAndView("customerAdd-def", "model", model);
		return modelAndView;
	}
	
	@RequestMapping("/customer/save")
	public String save(@Valid @ModelAttribute("dto") MstCustomerDto dto, BindingResult result) {
		
		if(result.hasErrors()){
			 return "redirect:/customer/add";
		} else {
			svc.save(dto);
			return "redirect:/customer";
		}
	}
	
	@RequestMapping(value = "customer/detail/{kodeCustomer}")
	public ModelAndView detail(@PathVariable("kodeCustomer") String kodeBarang, Model model) {
		
		MstCustomerDto MstCustomerDto = svc.findOne(kodeBarang);
		
		List<MstKotaDto> listKota = svcKota.listAll();
		model.addAttribute("listKota", listKota);
		model.addAttribute("dto", MstCustomerDto);
		
		ModelAndView modelAndView = new ModelAndView("customerEdit-def", "model", model);
		return modelAndView;
	}
	
	@RequestMapping(value = "customer/delete/{kodeCustomer}")
	public String delete(@PathVariable("kodeCustomer") String kodeCustomer, Model model) {
	
		svc.delete(kodeCustomer);
		return "redirect:/customer";
	}
	
}
