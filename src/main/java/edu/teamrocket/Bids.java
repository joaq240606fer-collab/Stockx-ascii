/*class bids*/
package edu.teamrocket;
import java.util.List;
import java.util.ArrayList;

public class Bids implements Criteria {
    private List<Offer> offers = new ArrayList<>();

    @Override
    public List<Offer> checkCriteria(Item item) {
        for (Offer offer : item.getOffers()) {
            if (offer instanceof Bid) {
                offers.add(offer);
            }
        }
        return offers;
    }
}