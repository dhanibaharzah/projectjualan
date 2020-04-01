package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvc.dto.MstBarangDto;
import com.mvc.service.MstBarangSvc;

public class tes {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		MstBarangSvc svc = ctx.getBean(MstBarangSvc.class);
		List<MstBarangDto> dtos = svc.listAll();
		for(MstBarangDto d : dtos){
			System.out.println(d.getNamaBarang());
		}
	}
}
