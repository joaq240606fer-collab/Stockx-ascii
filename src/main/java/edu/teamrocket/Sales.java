/* class Sales */

package edu.teamrocket;
import java.util.List;
import java.util.ArrayList;

public class Sales implements Criteria {
    private List<Offer> offers = new ArrayList<>();

    @Override
    public List<Offer> checkCriteria(Item item) {
        for (Offer offer : item.getOffers()) {
            if (offer instanceof Ask) {
                offers.add(offer);
            }
        }
        return offers;
    }
}