package minihandel;

import java.time.LocalDate;
import java.util.*;

/**
 * Models a Customer with Orders.
 */
public class Customer {
    private String name;
    private String birthday;
    private List<Order> orders = new ArrayList<Order>();
    
    /**
     * Create a new Customer.
     * @param name the name.
     * @param birthday birthday of the customer.
     */
    public Customer(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public List<Order> getOrders() {
        return new ArrayList<Order>(orders);
    }
    
    public void addOrder(Order order) {
        orders.add(order);
    }
    
    public void removeOrder(Order order) {
        orders.remove(order);
    }
    
}
