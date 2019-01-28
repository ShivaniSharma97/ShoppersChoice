package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateAddress(UserDetail user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDetail getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
