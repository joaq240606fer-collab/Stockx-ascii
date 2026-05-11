/* Item interface */
package edu.teamrocket;
import java.util.List;
 
public interface Item {
    int getBid();
    int getAsk();
    int getSale();
    void setBid(int bid);
    void setAsk(int ask);
    void setSale(int sale);
    void add(Offer offer);
    List<Offer> getOffers();
}


