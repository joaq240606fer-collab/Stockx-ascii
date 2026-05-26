package edu.teamrocket;
import java.util.List;
import java.util.ArrayList;

public class Size implements Criteria {
    private final String size;

    public Size(String size) {
        this.size = size;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> offers = new ArrayList<>();
        for (Offer offer : item.getOffers()) {
            if (size.equals(offer.size())) {
                offers.add(offer);
            }
        }
        return offers;
    }
}