/* class Max */
package edu.teamrocket;
import java.util.List;
import java.util.ArrayList;

public class Max implements Criteria {
    private final Criteria criteria;

    public Max(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> offers = criteria.checkCriteria(item);
        if (offers == null || offers.isEmpty()) {
            return new ArrayList<>();
        }

        Offer maxOffer = offers.get(0);
        for (Offer offer : offers) {
            if (offer.value() > maxOffer.value()) {
                maxOffer = offer;
            }
        }
        List<Offer> result = new ArrayList<>();
        result.add(maxOffer);
        return result;
    }
}