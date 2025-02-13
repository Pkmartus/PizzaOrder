package edu.wccnet.pmartus.pizza.dao;

import edu.wccnet.pmartus.pizza.entity.PizzaOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PizzaOrder> getOrders(int custId) {
        Session session = sessionFactory.getCurrentSession();
        Query<PizzaOrder> query = session.createQuery("from PizzaOrder where customer.id = "
                + custId + " order by id", PizzaOrder.class);
        return query.getResultList();
    }

    @Override
    public void saveOrder(PizzaOrder order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from PizzaOrder where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public PizzaOrder getOrder(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(PizzaOrder.class, orderId);
    }

    @Override
    public List<PizzaOrder> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from PizzaOrder");
        return query.getResultList();
    }
}
