package se.iuh.btl.controller;

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
@RequestMapping(value={"/chocolate","/"})
public class ChocolateController {

	private ChocolateService chocolateService;
	
	@Autowired(required = true)
	public void setChocolateService(ChocolateService chocolateService) {
		this.chocolateService = chocolateService;
	}

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping(value = {"/listchocolates"})
	public String listChocolates(Model model) {
		List<Chocolate> chocolates = chocolateService.getChocoLates();
		model.addAttribute("chocolates", chocolates);
		return "list-chocolates";
	}

	@GetMapping("/showChocolateForm")
	public String showFormForAdd(Model model) {
		Chocolate chocolate = new Chocolate();
		model.addAttribute("chocolate", chocolate);
		return "chocolate-form";
	}

	@PostMapping("/saveChocolate")
	public String saveChocolate(@ModelAttribute("chocolate") Chocolate chocolate, @RequestParam(value = "file") MultipartFile file) {
		String image = chocolateService.saveImage(file);
		chocolate.setImage(image);
		chocolateService.saveChocoLate(chocolate);
		return "redirect:/listChocolates";
	}

	@GetMapping("/updateChocolateForm/{id}")
	public String showFormForUpdate(@PathVariable("id") int id, Model model) {
		Chocolate chocolate = chocolateService.getChocoLate(id);
		model.addAttribute("chocolate", chocolate);
		return "chocolate-form";
	}

	@GetMapping("/deleteChocolate/{id}")
	public String deleteChocolate(@PathVariable("id") int id) {
		chocolateService.deleteChocoLate(id);
		return "redirect:/chocolate/listChocolates";
	}
}
