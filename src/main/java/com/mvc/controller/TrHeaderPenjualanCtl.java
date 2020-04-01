package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.dto.MstCustomerDto;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.dto.TrHeaderPenjualanDto;
import com.mvc.service.MstCustomerSvc;
import com.mvc.service.MstKaryawanSvc;
import com.mvc.service.TrHeaderPenjualanSvc;

@Controller
public class TrHeaderPenjualanCtl {
	
	@Autowired
	private TrHeaderPenjualanSvc svc;
	
	@Autowired
	private MstCustomerSvc svcCust;
	
	@Autowired
	private MstKaryawanSvc svcKar;
	
	@RequestMapping("/penjualan")
	public ModelAndView headerPenjualanList(Model model) {
		List<TrHeaderPenjualanDto> dtos = svc.listAll();
		model.addAttribute("TrPenjualan", dtos);
		ModelAndView modelAndView = new ModelAndView("penjualan-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/penjualan/add")
	public ModelAndView headerPenjualanAdd(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String namaKaryawan = (String) session.getAttribute("namaKaryawan");
		TrHeaderPenjualanDto dto = new TrHeaderPenjualanDto();
		dto.setNamaKaryawan(namaKaryawan);
		
		List<MstCustomerDto> listCust = svcCust.listAll();
		model.addAttribute("listcust", listCust);
		
		model.addAttribute("TrPenjualanAdd", dto);
		ModelAndView modelAndView = new ModelAndView("penjualanAdd-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/penjualan/save")
	public void headerPenjualanSave(@Valid @ModelAttribute("TrHeaderPenjualanAdd") TrHeaderPenjualanDto dto, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (result.hasErrors()) {
			response.sendRedirect(request.getContextPath() +"/penjualan/add");
		} else {
			svc.save(dto);
			response.sendRedirect(request.getContextPath() +"/penjualan");
		}
	}
	
	@RequestMapping(value="/penjualan/edit/{noNota}")
	public ModelAndView headerPenjualanEdit(@PathVariable("noNota") String noNota, Model model) {
		TrHeaderPenjualanDto dto = svc.findOne(noNota);
		List<MstCustomerDto> listCust = svcCust.listAll();
		model.addAttribute("listcust", listCust);
		
		List<MstKaryawanDto> listKar = svcKar.listAll();
		model.addAttribute("listkar", listKar);
		
		model.addAttribute("TrHeaderPenjualanEdit", dto);
		ModelAndView modelAndView = new ModelAndView("penjualanEdit-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/penjualan/delete/{noNota}")
	public String delete(@PathVariable("noNota") String noNota) {
		svc.delete(noNota);
		return "redirect:/penjualan";
	}
}
