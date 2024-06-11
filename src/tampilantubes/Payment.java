/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tampilantubes;

/**
 *
 * @author francisca isabella
 */
public class Payment extends Product{
    private boolean isPaid;
    private String paymentMethod;

    
    public Payment(String name, double subtotal, double tax, double discount) {
        super(name, subtotal, tax, discount);
        this.isPaid = false;
        this.paymentMethod = "Belum Dipilih";
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public void setPaymentMethod(String method) {
        this.paymentMethod = method;
    }
    
    public void payNow() {
        if (!paymentMethod.equals("Belum Dipilih")) {
            this.isPaid = true;
            System.out.println("Pembayaran berhasil menggunakan metode: " + paymentMethod);
        } else {
            System.out.println("Silakan pilih metode pembayaran terlebih dahulu.");
        }
    }

    public boolean isPaid() {
        return isPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public double getTotal(){
        return calculateTotal();
    }
}
