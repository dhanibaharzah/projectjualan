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
import com.mvc.dto.MstSupplierDto;
import com.mvc.service.MstKotaSvc;
import com.mvc.service.MstSupplierSvc;

@Controller
public class MstSupplierCtl {
	
	@Autowired
	private MstSupplierSvc svc;
	
	@Autowired
	private MstKotaSvc svcKota;
	
	@RequestMapping("/supplier")
	public ModelAndView supplierList(Model model) {
		List<MstSupplierDto> dtos = svc.listAll();
		model.addAttribute("MstSupplier", dtos);
		ModelAndView modelAndView = new ModelAndView("supplier-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/supplier/add")
	public ModelAndView supplierAdd(Model model) {
		MstSupplierDto dto = new MstSupplierDto();
		List<MstKotaDto> listKota = svcKota.listAll();
		model.addAttribute("listkota", listKota);
		
		model.addAttribute("MstSupplierAdd", dto);
		ModelAndView modelAndView = new ModelAndView("supplierAdd-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/supplier/add/save")
	public void supplierSave(@Valid @ModelAttribute("MstSupplierAdd") MstSupplierDto dto, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter alt = response.getWriter();
		if (result.hasErrors()) {
			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Check back form supplier');");
            alt.println("window.history.back();");
            alt.println("</script>");
		} else {
			MstSupplierDto findSupplier = svc.findOne(dto.getKodeSupplier());
			MstSupplierDto findNamaSupplier = svc.findOneByNamaSupplier(dto.getNamaSupplier());
			MstKotaDto findNamaKota = svcKota.findOne(dto.getKodeKota());
			
			if (findSupplier == null) {
				if (findNamaSupplier != null) {
					if (findNamaSupplier.getKodeKota().equals(dto.getKodeKota())) {
						alt.println("<script type=\"text/javascript\">");
			            alt.println("alert('Nama supplier " + dto.getNamaSupplier() + " dengan kota " + findNamaKota.getNamaKota() +" already exists');");
			            alt.println("window.history.back();");
			            alt.println("</script>");
					} else {
						svc.save(dto);
						
						alt.println("<script type=\"text/javascript\">");
						alt.println("alert('Save successfully');");
						alt.println("location='"+ request.getContextPath() +"/supplier';");
						alt.println("</script>");
						
					}
				} else {
					svc.save(dto);
					
					alt.println("<script type=\"text/javascript\">");
					alt.println("alert('Save successfully');");
					alt.println("location='"+ request.getContextPath() +"/supplier';");
					alt.println("</script>");
				}
				
			} else {
				alt.println("<script type=\"text/javascript\">");
	            alt.println("alert('Kode supplier "+ dto.getKodeSupplier() +" already exists');");
	            alt.println("window.history.back();");
	            alt.println("</script>");
			}
		}
	}
	
	@RequestMapping(value="/supplier/edit/{kodeSupplier}")
	public ModelAndView supplierEdit(@PathVariable("kodeSupplier") String kodeSupplier, Model model) {
		MstSupplierDto dto = svc.findOne(kodeSupplier);
		List<MstKotaDto> listKota = svcKota.listAll();
		model.addAttribute("listkota", listKota);
		model.addAttribute("MstSupplierEdit", dto);
		ModelAndView modelAndView = new ModelAndView("supplierEdit-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/supplier/edit/save")
	public void supplierUpdate(@Valid @ModelAttribute("MstSupplierEdit") MstSupplierDto dto, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter alt = response.getWriter();
		if (result.hasErrors()) {
			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Check back form supplier');");
            alt.println("window.history.back();");
            alt.println("</script>");
		} else {
			svc.save(dto);
			
			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Update successfully');");
            alt.println("location='"+ request.getContextPath() +"/supplier';");
            alt.println("</script>");
		}
	}
	
	@RequestMapping(value="/supplier/delete/{kodeSupplier}")
	public String delete(@PathVariable("kodeSupplier") String kodeSupplier) {
		svc.delete(kodeSupplier);
		return "redirect:/supplier";
	}
}
