/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tampilantubes;

/**
 *
 * @author francisca isabella
 */
public class Ulasan {
    public String rate;
    public String Description;

    public Ulasan(String rate, String Description) {
        this.rate = rate;
        this.Description = Description;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getRate() {
        return rate;
    }

    public String getDescription() {
        return Description;
    }
    
    
    
}
