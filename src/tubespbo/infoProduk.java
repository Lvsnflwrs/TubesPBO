/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubespbo;

/**
 *
 * @author Sean Himawan Arianto
 */
public class infoProduk {
    private String namaProduk;
    private int hargaProduk;
    public infoProduk(String namaProduk, int hargaProduk){
        this.namaProduk=namaProduk;
        this.hargaProduk=hargaProduk;
    }
    public String getNamaProduk(){
        return namaProduk;
    }
    public int getHargaProduk(){
        return hargaProduk;
    }
}
