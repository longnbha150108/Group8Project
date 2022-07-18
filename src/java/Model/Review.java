/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author trana
 */
public class Review {
    boolean favor;
    int Rate;

    public Review(boolean favor, int Rate) {
        this.favor = favor;
        this.Rate = Rate;
    }

    public Review() {
    }

    public boolean isFavor() {
        return favor;
    }

    public void setFavor(boolean favor) {
        this.favor = favor;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int Rate) {
        this.Rate = Rate;
    }
    
}
