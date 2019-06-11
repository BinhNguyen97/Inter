package com.example.demo.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Dictionary;
import com.example.demo.service.DictionaryService;

@Controller
public class DictionaryController {
	@Autowired
	private DictionaryService DictionaryService;

	@GetMapping("/dictionary")
	public String index(Model model) {
		model.addAttribute("dictionarys", DictionaryService.findAll());
		return "list";
	}

	@GetMapping("/dictionary/create")
	public String create(Model model) {
		model.addAttribute("dictionary", new Dictionary());
		return "form";
	}

	@GetMapping("/dictionary/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("dictionary", DictionaryService.findOne(id));
		return "form";
	}

	@PostMapping("/dictionary/save")
	public String save(@Valid Dictionary dictionary, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		DictionaryService.save(dictionary);
		redirect.addFlashAttribute("success", "Saved Dictionary successfully!");
		return "redirect:/dictionary";
	}

	@GetMapping("/dictionary/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		DictionaryService.delete(id);
		redirect.addFlashAttribute("success", "Deleted Dictionary successfully!");
		return "redirect:/dictionary";
	}

	@GetMapping("/dictionary/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/dictionary";
		}

		model.addAttribute("dictionarys", DictionaryService.search(s));
		return "list";
	}
}