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

import com.mvc.dto.MstProvinsiDto;
import com.mvc.service.MstProvinsiSvc;

@Controller
public class MstProvinsiCtl {

	@Autowired
	private MstProvinsiSvc svc;
	
	@RequestMapping("/provinsi")
	public ModelAndView provinsiList(Model model) {
		List<MstProvinsiDto> dtos = svc.listAll();
		model.addAttribute("MstProvinsi", dtos);
		ModelAndView modelAndView = new ModelAndView("provinsi-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/provinsi/add")
	public ModelAndView provinsiAdd(Model model) {
		MstProvinsiDto dto = new MstProvinsiDto();
		model.addAttribute("MstProvinsiAdd", dto);
		ModelAndView modelAndView = new ModelAndView("provinsiAdd-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/provinsi/add/save")
	public void provinsiSave(@Valid @ModelAttribute("MstProvinsiAdd") MstProvinsiDto dto, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter alt = response.getWriter();
		if (result.hasErrors()) {
			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Check back form provinsi');");
            alt.println("window.history.back();");
            alt.println("</script>");
		} else {
			MstProvinsiDto findProvinsi = svc.findOne(dto.getKodeProvinsi());
			MstProvinsiDto findNamaProvinsi = svc.findOneByNamaProvinsi(dto.getNamaProvinsi());
			
			if(findProvinsi == null) {
				
				if (findNamaProvinsi == null) {
					svc.save(dto);
					
					alt.println("<script type=\"text/javascript\">");
					alt.println("alert('Save successfully');");
					alt.println("location='"+ request.getContextPath() +"/provinsi';");
					alt.println("</script>");
				} else {
					alt.println("<script type=\"text/javascript\">");
					alt.println("alert('Provinsi "+ dto.getNamaProvinsi() +" already exists');");
					alt.println("window.history.back();");
					alt.println("</script>");
				}
				
			} else {
				if (findNamaProvinsi != null) {
					alt.println("<script type=\"text/javascript\">");
					alt.println("alert('Provinsi " + dto.getKodeProvinsi() + " - "+ dto.getNamaProvinsi() +" already exists');");
					alt.println("window.history.back();");
					alt.println("</script>");
				} else {
					alt.println("<script type=\"text/javascript\">");
		            alt.println("alert('Kode provinsi "+ dto.getKodeProvinsi() +" already exists');");
		            alt.println("window.history.back();");
		            alt.println("</script>");
				}
			}
		}
	}
	
	@RequestMapping(value="/provinsi/edit/{kodeProvinsi}")
	public ModelAndView provinsiEdit(@PathVariable("kodeProvinsi") String kodeProvinsi, Model model) {
		MstProvinsiDto dto = svc.findOne(kodeProvinsi);
		model.addAttribute("MstProvinsiEdit", dto);
		ModelAndView modelAndView = new ModelAndView("provinsiEdit-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/provinsi/edit/save")
	public void provinsiUpdate(@Valid @ModelAttribute("MstProvinsiEdit") MstProvinsiDto dto, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter alt = response.getWriter();
		
		if (result.hasErrors()) {
			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Check back form provinsi');");
            alt.println("window.history.back();");
            alt.println("</script>");
		} else {
			MstProvinsiDto findNamaProvinsi = svc.findOneByNamaProvinsi(dto.getNamaProvinsi());
			
			if (findNamaProvinsi == null) {
				svc.save(dto);
				
				alt.println("<script type=\"text/javascript\">");
				alt.println("alert('Update successfully');");
				alt.println("location='"+ request.getContextPath() +"/provinsi';");
				alt.println("</script>");
			} else {
				alt.println("<script type=\"text/javascript\">");
				alt.println("alert('Provinsi "+ dto.getNamaProvinsi() +" already exists');");
				alt.println("window.history.back();");
				alt.println("</script>");
			}
		}
	}
	
	@RequestMapping(value="/provinsi/delete/{kodeProvinsi}")
	public String delete(@PathVariable("kodeProvinsi") String kodeProvinsi) {
		svc.delete(kodeProvinsi);
		return "redirect:/provinsi";
	}
}
