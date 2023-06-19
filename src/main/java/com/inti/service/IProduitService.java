package com.inti.service;

import java.util.List;


import com.inti.model.Produit;

public interface IProduitService {
	
	public List<Produit> getproduits();
	public void saveProduit(Produit p);
	public Produit getProduit(int id);
	public void deleteProduit(int id);
	public void updateProduit(Produit p);
	

}
