package edu.wccnet.pmartus.pizza.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "pizza")
/*@JsonIgnoreProperties({ "pizzaOrder" })*/
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "size")
    private String size;
    @Column(name = "topping")
    private String topping;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private PizzaOrder pizzaOrder;


    public Pizza(String size, String topping) {
        this.size = size;
        this.topping = topping;
    }

    public Pizza(int id, String size, String topping, PizzaOrder pizzaOrder) {
        this.id = id;
        this.size = size;
        this.topping = topping;
        this.pizzaOrder = pizzaOrder;
    }

    public Pizza() {
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public PizzaOrder getPizzaOrder() {
        return pizzaOrder;
    }

    public void setPizzaOrder(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }
}
