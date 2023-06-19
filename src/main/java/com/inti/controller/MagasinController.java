package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Magasin;
import com.inti.service.IMagasinService;


@Controller
@RequestMapping("magasin")
public class MagasinController {
	
		
		@Autowired
		IMagasinService ims;

		
		
		@GetMapping("saveMagasin")
		public String formMagasin()
		{
			return "formMagasin";
		}
		
		@PostMapping("saveMagasin")
		public String saveMagasin(@ModelAttribute("magasin") Magasin m)
		{
			
			ims.saveMagasin(m);
			
			return "formMagasin";
		}
		
		@GetMapping("listeMagasin")
		public String getMagasins(Model m)
		{

			m.addAttribute("listeM", ims.getMagasins());
			
			return "listeMagasin";
		}
		
		@GetMapping("supprimerMagasin")
		public String supprimerMagasin(@RequestParam("id") int id)
		{
			ims.deleteMagasin(id);
			
			return "redirect:listeMagasin";
		}
		
		
		
		@GetMapping("afficherMagasin")
		public String afficherMagasin(@RequestParam("id") int id, Model m)
		{
			
			m.addAttribute("magasin", ims.getMagasin(id));
			return "afficherMagasin";
		}

}
