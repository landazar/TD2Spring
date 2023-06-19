package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String affichageNomProduit(@RequestParam(value =  "nom", required = false, defaultValue = "nom") String nom)
	{
		return "Produit";
	}
	
	@GetMapping("prix")
	public String affichagePrixProduit(@RequestParam(value =  "prix", required = true, defaultValue = "00.0") double prix)
	{
		return "Produit";
	}
	
	@GetMapping("calcul")
	public String calcul(@RequestParam(value =  "prix", required = true, defaultValue = "00.0") double prix, @RequestParam(value =  "nom", required = false, defaultValue = "nom") String nom, Model m)
	{
		double prixTTC = prix + 0.2 * prix;
		m.addAttribute("prixTTC", prixTTC);
		
		return "Produit";
	}
	
	
}
