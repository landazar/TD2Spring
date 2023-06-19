package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.service.IProduitService;

@Controller
@RequestMapping("produit")
public class ProduitController {
	
	@Autowired
	IProduitService ips;

	@GetMapping("affichage")
	public String affichageNomProduit(@RequestParam(value =  "nom", required = false, defaultValue = "nom pas défini") String nom)
	{
		
		
		return "nomProduit";
	}
}
