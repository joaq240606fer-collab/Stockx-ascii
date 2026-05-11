/* bids class */
package edu.teamrocket;

public class Bid implements Offer {
    private String size;
    private int bid;
    public Bid(String size, int bid) {
        this.size = size;
        this.bid = bid;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
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
        return bid;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}