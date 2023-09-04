package com.marketingapp7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp7.entity.Lead;
import com.marketingapp7.service.LeadService;
import com.marketingapp7.util.EmailService;


@Controller
public class LeadController {
	
	@Autowired
	private LeadService LeadService;
	
	@Autowired
	private EmailService emailService;
	
	
	//http://localhost:8080/view
	@RequestMapping("/view")
	public String viewpage() {
		return "create_lead"; //page name
		//request dispatcher
	}
	
	
	
	//http://localhost:8080/saveLead
	@RequestMapping("/saveLead")
	public String saveOneLead(Lead lead, Model model) {
		LeadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(), "Welcome!", "test");
		model.addAttribute("msg", "Lead is saved!!");
		return "create_lead";

		}
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String getAllLeads(Model model)  {
		List<Lead> leads= LeadService.getLeads();
		model.addAttribute("leads", leads);
		System.out.println(leads);
		return"list_lead";
	}
	
	//http://localhost:8080/delete
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id, Model model) {
		LeadService.deleteLead(id);
		List<Lead> leads= LeadService.getLeads();
		model.addAttribute("leads", leads);
		System.out.println(leads);
		return"list_lead";
	}
	
	@RequestMapping("/update")
	public String getLeadById(@RequestParam("id") long id, Model model) {
		Lead leads=LeadService.getLeadById(id);
		model.addAttribute("lead", leads);
		return "update_lead";
		
	}
	
		@RequestMapping("/updateLead")
		public String updateOneLead(Lead lead, Model model) {
			LeadService.saveLead(lead);
			List<Lead> leads= LeadService.getLeads();
			model.addAttribute("leads", leads);
			System.out.println(leads);
			return"list_lead";
			
		}
	

}
