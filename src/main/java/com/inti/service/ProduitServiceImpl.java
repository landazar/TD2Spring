package com.inti.service;

import java.util.List;

import org.hibernate.Session;
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
	public List<Produit> getproduits() {
		List<Produit> listeP = null;
		
		session.beginTransaction();
		try {
			
			listeP = session.createNativeQuery("select * from Produit", Produit.class).list();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return listeP;
	}

	@Override
	public void saveProduit(Produit p) {
		
		session.beginTransaction();
		try {
			
			session.save(p);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	@Override
	public Produit getProduit(int id) {
		
		Produit p1 = null;
		
		session.beginTransaction();
		try {
			
			p1 = session.load(Produit.class, id);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return p1;
	}

	@Override
	public void deleteProduit(int id) {
		
		session.beginTransaction();
		try {
			
			Produit p1 = session.load(Produit.class, id);
            session.delete(p1);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
