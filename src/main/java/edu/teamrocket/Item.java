/* Item interface */
package edu.teamrocket;
import java.util.List;
 
public interface Item {
    int getBid();
    int getAsk();
    int getSale();
    int setBid(int bid);
    int setAsk(int ask);
    int setSale(int sale);
    void add(Offer offer);
    List<Offer> getOffers();
}


