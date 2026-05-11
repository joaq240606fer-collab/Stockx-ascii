/*Class Sneaker*/

package edu.teamrocket;

public class Sneaker implements Item {
    private String name;
    private String style;
    private int sale;
    private int ask;
    private int bid;


    public Sneaker(String name, String style) {
        this.name = name;
        this.style = style;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public int getSale() {
        return sale;
    }
    public void setSale(int sale) {
        this.sale = sale;
    }
    public int getAsk() {
        return ask;
    }
    public void setAsk(int ask) {
        this.ask = ask;
    }
    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
    }
} 