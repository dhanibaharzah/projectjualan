package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.dto.MstKaryawanDto;
import com.mvc.service.MstKaryawanSvc;

@Controller
public class MstKaryawanCtl {

	@Autowired
	MstKaryawanSvc svc;
	
	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if ((session.getAttribute("kodeKaryawan") == null) || (session.getAttribute("kodeKaryawan") == "")) {
			MstKaryawanDto dto = new MstKaryawanDto();
			model.addAttribute("MstKaryawanDto", dto);
			
			return "login";
		} else {
			response.sendRedirect(request.getContextPath() +"/dashboard");
			
			return null;
		}
	}
	
	@RequestMapping("/login/check-login")
	public void checkLogin(@ModelAttribute("MstKaryawanDto") MstKaryawanDto dto, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter alt = response.getWriter();
		MstKaryawanDto findUser = svc.findOneByUsername(dto.getUsername());
		if(findUser != null){
			if(dto.getPassword().equals(findUser.getPassword())){
				session.setAttribute("kodeKaryawan", findUser.getKodeKaryawan());
				session.setAttribute("namaKaryawan", findUser.getNamaKaryawan());
				
				response.sendRedirect(request.getContextPath() +"/dashboard");
			}else{
				alt.println("<script type=\"text/javascript\">");
	            alt.println("alert('Invalid Password');");
	            alt.println("location='"+ request.getContextPath() +"/login';");
	            alt.println("</script>");
			}
		} else {
			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Invalid Username or Password');");
            alt.println("location='"+ request.getContextPath() +"/login';");
            alt.println("</script>");
		}
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() +"/login");
	}
	
	@RequestMapping("/karyawan")
	public ModelAndView karyawanList(Model model) {
		List<MstKaryawanDto> dtos = svc.listAll();
		model.addAttribute("MstKaryawanDto", dtos);
		ModelAndView modelAndView = new ModelAndView("karyawan-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/karyawan/add")
	public ModelAndView karyawanAdd(Model model) {
		MstKaryawanDto dtos = new MstKaryawanDto();
		model.addAttribute("MstKaryawanDto", dtos);
		ModelAndView modelAndView = new ModelAndView("karyawanAdd-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/karyawan/add/save")
	public void save(@Valid @ModelAttribute("MstKaryawanDto") MstKaryawanDto dto, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter alt = response.getWriter();
		if (result.hasErrors()) {
			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Check back form karyawan');");
            alt.println("window.history.back();");
            alt.println("</script>");
		} else {
			MstKaryawanDto findKaryawan = svc.findOne(dto.getKodeKaryawan());
			
			if(findKaryawan == null){
				svc.save(dto);

				alt.println("<script type=\"text/javascript\">");
	            alt.println("alert('Save successfully');");
	            alt.println("location='"+ request.getContextPath() +"/karyawan';");
	            alt.println("</script>");
			} else {
				alt.println("<script type=\"text/javascript\">");
	            alt.println("alert('Kode karyawan "+ dto.getKodeKaryawan() +" already exists');");
	            alt.println("window.history.back();");
	            alt.println("</script>");
			}
		}
	}
	
	@RequestMapping("/karyawan/edit/{kodeKaryawan}")
	public ModelAndView detail(@PathVariable("kodeKaryawan") String kodeKaryawan, Model model) {
		MstKaryawanDto dto = svc.findOne(kodeKaryawan);
		model.addAttribute("MstKaryawanDto", dto);
		ModelAndView modelAndView = new ModelAndView("karyawanEdit-def", "model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/karyawan/edit/save")
	public void update(@Valid @ModelAttribute("MstKaryawanDto") MstKaryawanDto dto, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter alt = response.getWriter();
		if (result.hasErrors()) {
			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Check back form karyawan');");
            alt.println("window.history.back();");
            alt.println("</script>");
		} else {
			svc.save(dto);

			alt.println("<script type=\"text/javascript\">");
            alt.println("alert('Update successfully');");
            alt.println("location='"+ request.getContextPath() +"/karyawan';");
            alt.println("</script>");
		}
	}
	
	@RequestMapping("/karyawan/delete/{code}")
	public String delete(@PathVariable("code") String code) {
		svc.delete(code);
		return "redirect:/karyawan";
	}
	
}