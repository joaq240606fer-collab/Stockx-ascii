/* sale class */

package edu.teamrocket;

public class Sale implements Offer {
    private String size;
    private int sale;
    public Sale(String size, int sale) {
        this.size = size;
        this.sale = sale;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public int getSale() {
        return sale;
    }
    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public int compareTo(Offer offer) {
        return 0;
    }

    @Override
    public String Size() {
        return size;
    }

    @Override
    public int Value() {
        return sale;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}