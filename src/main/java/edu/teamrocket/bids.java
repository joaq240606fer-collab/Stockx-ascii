/*class bids*/
package edu.teamrocket;


public class Bids implements criteria {
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