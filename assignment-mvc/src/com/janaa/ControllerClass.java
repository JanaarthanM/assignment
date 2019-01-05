package com.janaa;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usa-income")
public class ControllerClass {

	@Autowired
	private MongodbUtils mongodbUtils;
	
	@Autowired
	private HttpUtils httpUtils;
	
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/load")
	public String load(Model model) {
		model.addAttribute("dbdetails", new Dbdetails());
		return "load";
	}
	
	@RequestMapping("/import-data")
	public String importData(@ModelAttribute("dbdetails") Dbdetails dbdetails) {
		System.out.println("Going to import");
		System.out.println(dbdetails.getHost());
		System.out.println(dbdetails.getFile());
		System.out.println(dbdetails.getDatabase());
		mongodbUtils.setDbdetails(dbdetails);
		try {
			mongodbUtils.importData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbdetails.setStatus("Imported");
		return "load";
	}
	
	@RequestMapping("/query")
	public String getRecords(Model model) {
		model.addAttribute("formquery", new Formquery());
		return "query";
	}
	
	@RequestMapping("/query-records")
	public String queryRecords(@ModelAttribute("formquery") Formquery formquery) {
		System.out.println(formquery.getQuery());
		String response = null;
		try {
			response = httpUtils.sendGET(formquery.getQuery());
		} catch (IOException e) {
			e.printStackTrace();
		}
		formquery.setResponse(response);
		return "query";
		
	}
}
