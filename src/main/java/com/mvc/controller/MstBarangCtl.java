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

import com.mvc.dto.MstBarangDto;
import com.mvc.dto.MstCustomerDto;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.dto.MstProvinsiDto;
import com.mvc.dto.MstSupplierDto;
import com.mvc.service.MstBarangSvc;
import com.mvc.service.MstKotaSvc;
import com.mvc.service.MstSupplierSvc;



@Controller
public class MstBarangCtl {
	
	@Autowired
	private MstBarangSvc svc;
	
	@Autowired
	private MstSupplierSvc svcSupplier;
	
	@RequestMapping("/barang")
	public ModelAndView allBarang(Model model) {
		
		List<MstBarangDto> dtos = svc.listAll();
		model.addAttribute("listBarang", dtos);
		ModelAndView modelAndView = new ModelAndView("barang-def", "model", model);
		
		return modelAndView;
	
	}
	
	@RequestMapping("/barang/add")
	public ModelAndView add(Model model) {
		
		MstBarangDto dto = new MstBarangDto();
		List<MstSupplierDto> listSupplier = svcSupplier.listAll();
		model.addAttribute("listSupplier", listSupplier);
		model.addAttribute("dto", dto);
		
		ModelAndView modelAndView = new ModelAndView("barangAdd-def", "model", model);
		return modelAndView;
	}
//	
//	@RequestMapping("/barang/edit/{}")
//	public String add(Model model) {
//		
//		MstBarangDto dto = new MstBarangDto();
//		model.addAttribute("dto", dto);
//		return "barangadd";
//	}
//	
	
	@RequestMapping("/barang/save")
	public String save(@Valid @ModelAttribute("dto") MstBarangDto dto, BindingResult result) {
		
		if(result.hasErrors()){
			 return "redirect:/barang/add";
		} else {
			svc.save(dto);
			return "redirect:/barang";
		}
	}
	
	@RequestMapping(value = "barang/detail/{kodeBarang}")
	public ModelAndView detail(@PathVariable("kodeBarang") String kodeBarang, Model model) {
		
		MstBarangDto MstBarangDto = svc.findOne(kodeBarang);

		List<MstSupplierDto> listSupplier = svcSupplier.listAll();
		model.addAttribute("listSupplier", listSupplier);
		model.addAttribute("dto", MstBarangDto);
		
		ModelAndView modelAndView = new ModelAndView("barangEdit-def", "model", model);
		return modelAndView;
	}
	
	@RequestMapping(value = "barang/delete/{kodeBarang}")
	public String delete(@PathVariable("kodeBarang") String kodeBarang, Model model) {
	
		svc.delete(kodeBarang);
		return "redirect:/barang";
	}
	
}

