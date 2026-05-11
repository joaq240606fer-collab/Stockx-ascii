package edu.teamrocket;
import java.util.List;
import java.util.ArrayList;

public class Size implements Criteria {
    
    String size = "Size";
    List<Offer> offers = new ArrayList<>();

    public Size(String size) {
        this.size = size;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        for (Offer offer : item.getOffers()) {
            if (offer instanceof Size) {
                offers.add(offer);
            }
        }
        return offers;
    }
}