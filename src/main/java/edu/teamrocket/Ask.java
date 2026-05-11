/* ask class */
package edu.teamrocket;

public class Ask implements Offer {
    private String size;
    private int ask;
    public Ask(String size, int ask) {
        this.size = size;
        this.ask = ask;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public int getAsk() {
        return ask;
    }
    public void setAsk(int ask) {
        this.ask = ask;
    }

    @Override
    public int value() {
        return ask;
    }

    @Override
    public String size() {
        return size;
    }

    @Override
    public int compareTo(Offer offer) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}