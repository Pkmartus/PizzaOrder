package edu.wccnet.pmartus.pizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizza_order")
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pizzaOrder", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pizza> pizzas = new ArrayList<>();

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "id=" + id + "Customer " + customer +
                ", pizzas=" + pizzas +
                '}';
    }

    public PizzaOrder() {
    }

    public PizzaOrder(Customer customer, List<Pizza> pizzas) {
        this.customer = customer;
        this.pizzas = pizzas;
    }

    public PizzaOrder(int id, Customer customer, List<Pizza> pizzas) {
        this.id = id;
        this.customer = customer;
        this.pizzas = pizzas;
    }

    public void addPizza(Pizza newPizza) {
        newPizza.setPizzaOrder(this);
        pizzas.add(newPizza);
    }
    public void removePizza(int index) {
        pizzas.remove(index);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
