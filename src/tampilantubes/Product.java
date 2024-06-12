/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tampilantubes;
import java.util.Random;

/**
 *
 * @author francisca isabella
 */
public class Product {
    private String name;
    private int id;
    private double subtotal;
    private double tax;
    private double discount;
    
    public Product (String name, double subtotal,double tax,double discount) {
        this.name = name;
        Random rand= new Random();
        this.id = rand.nextInt(50) + 1;
        this.subtotal = subtotal;
        this.tax = tax;
        this.discount = discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getDiscount() {
        return discount;
    }
    
    public double calculateTotal() {
        double total = subtotal + (subtotal * tax) - (subtotal * discount);
        return total;
    }
    
    
        
}

