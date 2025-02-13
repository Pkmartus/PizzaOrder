package edu.wccnet.pmartus.pizza.dao;

import edu.wccnet.pmartus.pizza.entity.Pizza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaDAOImpl implements PizzaDao{
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Pizza> getPizzas(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Pizza> query = session.createQuery("from Pizza where pizzaOrder.id = "
                +orderId+ " order by id");
        return query.getResultList();
    }

    @Override
    public void deletePizza(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Pizza where pizzaOrder.id = :id");
        query.setParameter("id", orderId);
        query.executeUpdate();
    }

    @Override
    public void savePizza(Pizza pizza) {
        Session session = sessionFactory.getCurrentSession();
        session.save(pizza);
    }
}
