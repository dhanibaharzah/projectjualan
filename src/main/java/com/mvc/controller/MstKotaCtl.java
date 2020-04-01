package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.dto.MstKotaDto;
import com.mvc.dto.MstProvinsiDto;
import com.mvc.service.MstKotaSvc;
import com.mvc.service.MstProvinsiSvc;

@Controller
public class MstKotaCtl {
	
	@Autowired
	private MstKotaSvc svc;
	
	@Autowired
	private MstProvinsiSvc svcProv;
	
	@RequestMapping("/kota")
	public ModelAndView kotaList(Model model) {
		List<MstKotaDto> dtos = svc.listAll();
		model.addAttribute("MstKota", dtos);
		ModelAndView modelAndView = new ModelAndView("kota-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/kota/add")
	public ModelAndView kotaAdd(Model model) {
		MstKotaDto dto = new MstKotaDto();
		List<MstProvinsiDto> listProvinsi = svcProv.listAll();
		model.addAttribute("listprovinsi", listProvinsi);
		
		model.addAttribute("MstKotaAdd", dto);
		ModelAndView modelAndView = new ModelAndView("kotaAdd-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/kota/add/save")
	public void kotaSave(@Valid @ModelAttribute("MstKotaAdd") MstKotaDto dto, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter alt = response.getWriter();
		if (result.hasErrors()) {
			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Check back form kota');");
            alt.println("window.history.back();");
            alt.println("</script>");
		} else {
			MstKotaDto findKota = svc.findOne(dto.getKodeKota());
			MstKotaDto findNamaKota = svc.findOneByNamaKota(dto.getNamaKota());
			
			if(findKota == null) {
				
				if(findNamaKota == null) {
					svc.save(dto);
					
					alt.println("<script type=\"text/javascript\">");
					alt.println("alert('Save successfully');");
					alt.println("location='"+ request.getContextPath() +"/kota';");
					alt.println("</script>");
				} else {
					alt.println("<script type=\"text/javascript\">");
					alt.println("alert('Kota "+ dto.getNamaKota() +" already exists');");
					alt.println("window.history.back();");
					alt.println("</script>");
				}
				
			} else {
				if(findNamaKota != null) {
					alt.println("<script type=\"text/javascript\">");
					alt.println("alert('Kota " + dto.getKodeKota() + " - "+ dto.getNamaKota() +" already exists');");
					alt.println("window.history.back();");
					alt.println("</script>");
				} else {
					alt.println("<script type=\"text/javascript\">");
		            alt.println("alert('Kode kota "+ dto.getKodeKota() +" already exists');");
		            alt.println("window.history.back();");
		            alt.println("</script>");
				}
			}
		}
	}
	
	@RequestMapping(value="/kota/edit/{kodeKota}")
	public ModelAndView kotaEdit(@PathVariable("kodeKota") String kodeKota, Model model) {
		MstKotaDto dto = svc.findOne(kodeKota);
		
		List<MstProvinsiDto> listProvinsi = svcProv.listAll();
		model.addAttribute("listprovinsi", listProvinsi);
		
		model.addAttribute("MstKotaEdit", dto);
		ModelAndView modelAndView = new ModelAndView("kotaEdit-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/kota/edit/save")
	public void kotaUpdate(@Valid @ModelAttribute("MstKotaEdit") MstKotaDto dto, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter alt = response.getWriter();
		if (result.hasErrors()) {
			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Check back form kota');");
            alt.println("window.history.back();");
            alt.println("</script>");
		} else {
			MstKotaDto findNamaKota = svc.findOneByNamaKota(dto.getNamaKota());
			
			if(findNamaKota == null) {
				svc.save(dto);
				
				alt.println("<script type=\"text/javascript\">");
				alt.println("alert('Update successfully');");
				alt.println("location='"+ request.getContextPath() +"/kota';");
				alt.println("</script>");
			} else {
				alt.println("<script type=\"text/javascript\">");
				alt.println("alert('Kota "+ dto.getNamaKota() +" already exists');");
				alt.println("window.history.back();");
				alt.println("</script>");
			}
		}
	}
	
	@RequestMapping(value="/kota/delete/{kodeKota}")
	public String delete(@PathVariable("kodeKota") String kodeKota) {
		svc.delete(kodeKota);
		return "redirect:/kota";
	}
}