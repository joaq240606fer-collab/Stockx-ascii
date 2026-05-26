package edu.teamrocket;
import java.util.List;
import java.util.ArrayList;

public class LastSale implements Criteria {
    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> offers = new ArrayList<>();
        Offer lastSale = null;
        for (Offer offer : item.getOffers()) {
            if (offer instanceof Sale) {
                lastSale = offer;
            }
        }
        if (lastSale != null) {
            offers.add(lastSale);
        }
        return offers;
    }
}