package com.inti.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.inti.model.Magasin;
import com.inti.util.HibernateUtil;

@Service
public class MagasinService implements IMagasinService{
	
	private Session session;
	
	public MagasinService()
	{
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public List<Magasin> getMagasins() {
		List<Magasin> listeM = null;
		
		session.beginTransaction();
		try {
			
			listeM = session.createNativeQuery("select * from Magasin", Magasin.class).list();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return listeM;
	}

	@Override
	public void saveMagasin(Magasin m) {
		session.beginTransaction();
		try {
			
			session.save(m);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	@Override
	public Magasin getMagasin(int id) {
		Magasin m1 = null;
		
		session.beginTransaction();
		try {
			
			m1 = session.load(Magasin.class, id);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return m1;
	}

	@Override
	public void deleteMagasin(int id) {
		session.beginTransaction();
		try {
			
			Magasin m1 = session.load(Magasin.class, id);
            session.delete(m1);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
