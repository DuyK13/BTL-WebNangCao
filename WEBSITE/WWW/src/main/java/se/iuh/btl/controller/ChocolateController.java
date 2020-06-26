package se.iuh.btl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import se.iuh.btl.entities.Chocolate;
import se.iuh.btl.service.chocolateservice.ChocolateService;

@Controller
@RequestMapping(value = {"/chocolate", "/"})
public class ChocolateController {

	private ChocolateService chocolateService;
	
	@Autowired(required = true)
	public void setChocolateService(ChocolateService chocolateService) {
		this.chocolateService = chocolateService;
	}

	@GetMapping(value = {"/listchocolates", "/"})
	public String listChocolates(Model model) {
		List<Chocolate> chocolates = chocolateService.getChocoLates();
		model.addAttribute("chocolates", chocolates);
		return "list-chocolates";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model) {
		Chocolate chocolate = new Chocolate();
		model.addAttribute("chocolate", chocolate);
		return "chocolate-form";
	}

	@PostMapping("/saveChocolate")
	public String saveCustomer(@ModelAttribute("chocolate") Chocolate chocolate, @RequestParam(value = "files") MultipartFile[] files) {
		List<String> listImage = new ArrayList<>();
		System.out.println(files.toString());
		for(MultipartFile file : files) {
			String filename = chocolateService.saveImage(file);
			listImage.add(filename);
		}
		chocolate.setListImage(listImage);
		chocolateService.saveChocoLate(chocolate);
		return "redirect:/chocolate/listChocolates";
	}

	@GetMapping("/updateForm/{id}")
	public String showFormForUpdate(@PathVariable("id") int id, Model model) {
		Chocolate chocolate = chocolateService.getChocoLate(id);
		model.addAttribute("chocolate", chocolate);
		return "chocolate-form";
	}

	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		chocolateService.deleteChocoLate(id);
		return "redirect:/chocolate/listChocolates";
	}
}
