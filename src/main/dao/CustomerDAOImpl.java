package main.dao;

import main.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = this.sessionFactory.getCurrentSession();

		// create a query ... and sort by last name
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer: if customer.id is a new one the insert() calls else calls update() method
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// get current hibernate session
		Session currentSession = this.sessionFactory.getCurrentSession();

		// retrieve/read Customer by Primary key: id from the currentSession
		Customer customer = currentSession.get(Customer.class, id);

		// return Customer object
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// get current hibernate session
		Session currentSession = this.sessionFactory.getCurrentSession();

		// delete object with primary key
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);

		query.executeUpdate();
	}
}
