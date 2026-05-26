/*class MinAsk */
package edu.teamrocket;
import java.util.List;
import java.util.ArrayList;

public class MinAsk implements Criteria {
    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> offers = new ArrayList<>();
        Offer minOffer = null;
        for (Offer offer : item.getOffers()) {
            if (offer instanceof Ask) {
                if (minOffer == null || offer.value() < minOffer.value()) {
                    minOffer = offer;
                }
            }
        }
        if (minOffer != null) {
            offers.add(minOffer);
        }
        return offers;
    }
}
