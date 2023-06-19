package com.inti.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Produit;
import com.inti.util.HibernateUtil;

@Service
public class ProduitServiceImpl implements IProduitService {
	
	private Session session;
	
	public ProduitServiceImpl()
	{
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public void afficherNomProduit() {
		
		session.beginTransaction();
		try {
			
			Produit p = session.get(Produit.class, id);
            
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
