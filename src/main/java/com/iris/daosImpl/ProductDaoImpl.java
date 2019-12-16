package com.iris.daosImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.ProductDao;

import com.iris.models.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean addProduct(Product pObj) {
		try {
		Session session=sessionFactory.getCurrentSession();
		session.save(pObj);
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product pObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.delete(pObj);
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean updateProduct(Product pObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(pObj);
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public Product getProductById(int pid) {
		try {
		Session session=sessionFactory.getCurrentSession();
		Product pro=session.get(Product.class, pid);
		return pro;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from com.iris.models.Product");
			return query.list();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		
		return null;
	}

	@Override
	public Product validateProduct(int productId, String productName) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Product pObj=session.get(Product.class, productId);
			
			if(pObj!=null) {
			if(pObj.getProductName().equals(productName)) {
				return pObj;
			}
		}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
