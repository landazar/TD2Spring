package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Produit;
import com.inti.service.IProduitService;



@Controller
@RequestMapping("produit")
public class ProduitController {
	
	@Autowired
	IProduitService ips;

	@GetMapping("affichage")
	public String affichageNomProduit(@RequestParam(value =  "nom", required = false, defaultValue = "Iphone 14") String nom, Model m)
	{
		m.addAttribute("nom", nom);
		return "Produit";
	}
	
	@GetMapping("prix")
	public String affichagePrixProduit(@RequestParam(value =  "prix", required = true, defaultValue = "00.0") double prix, Model m)
	{
		m.addAttribute("prix", prix);
		return "Produit";
	}
	
	@GetMapping("calcul")
	public String calcul(@RequestParam(value =  "prix", required = true, defaultValue = "00.0") double prix, @RequestParam(value =  "nom", required = false, defaultValue = "Iphone 14") String nom, Model m)
	{
		m.addAttribute("nom", nom);
		m.addAttribute("prix", prix);
		double prixTTC = prix + 0.2 * prix;
		m.addAttribute("prixTTC", prixTTC);
		
		return "Produit";
	}
	
	@GetMapping("saveProduit")
	public String formProduit()
	{
		return "formProduit";
	}
	
	@PostMapping("saveProduit")
	public String saveProduit(@ModelAttribute("produit") Produit p)
	{
		
		ips.saveProduit(p);
		
		return "formProduit";
	}
	
	@GetMapping("listeProduit")
	public String getProduits(Model m)
	{

		m.addAttribute("listeP", ips.getproduits());
		
		return "listeProduit";
	}
	
	@GetMapping("supprimerProduit")
	public String supprimerProduit(@RequestParam("id") int id)
	{
		ips.deleteProduit(id);;
		
		return "redirect:listeProduit";
	}
	
	
	
	@GetMapping("afficherProduit")
	public String afficherProduit(@RequestParam("id") int id, Model m)
	{
		
		m.addAttribute("produit", ips.getProduit(id));
		return "afficherProduit";
	}
}
