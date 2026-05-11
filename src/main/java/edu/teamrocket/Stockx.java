package edu.teamrocket;
import java.util.List;
import java.util.ArrayList;

public class Stockx {

    public static void main(String[] args) {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        System.out.println(Stockx.draw(sneaker));

        addBids(sneaker);
        addAsks(sneaker);
        addSales(sneaker);

        displayAllOffers(sneaker);
        processBidsAndAsks(sneaker);
        processSalesBySize(sneaker);
        processBidsBySize(sneaker);
    }

    private static void addBids(Item sneaker) {
        sneaker.add(new Bid("13", 550));
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));
    }

    private static void addAsks(Item sneaker) {
        sneaker.add(new Ask("13", 288));
        sneaker.add(new Ask("6", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));
    }

    private static void addSales(Item sneaker) {
        sneaker.add(new Sale("6", 356));
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        sneaker.add(new Sale("13", 372));
    }

    private static void displayAllOffers(Item sneaker) {
        Criteria bids = new Bids();
        System.out.println("\n\t\t All BIDS");
        bids.checkCriteria(sneaker).forEach(System.out::print);

        Criteria asks = new Asks();
        System.out.println("\n\t\t All ASKS");
        asks.checkCriteria(sneaker).forEach(System.out::print);

        Criteria sales = new Sales();
        System.out.println("\n\t\t All SALES");
        sales.checkCriteria(sneaker).forEach(System.out::print);
    }

    private static void processBidsAndAsks(Item sneaker) {
        updateBidFromCriteria(sneaker, new Max(new Bids()));
        System.out.println(Stockx.draw(sneaker));

        updateAskFromCriteria(sneaker, new MinAsk());
        System.out.println(Stockx.draw(sneaker));

        updateSaleFromCriteria(sneaker, new LastSale());
        System.out.println(Stockx.draw(sneaker));
    }

    private static void updateBidFromCriteria(Item sneaker, Criteria criteria) {
        List<Offer> offers = criteria.checkCriteria(sneaker);
        sneaker.setBid((int)(offers.isEmpty() ? 0 : offers.get(0).value()));
    }

    private static void updateAskFromCriteria(Item sneaker, Criteria criteria) {
        List<Offer> offers = criteria.checkCriteria(sneaker);
        sneaker.setAsk((int)(offers.isEmpty() ? 0 : offers.get(0).value()));
    }

    private static void updateSaleFromCriteria(Item sneaker, Criteria criteria) {
        List<Offer> offers = criteria.checkCriteria(sneaker);
        sneaker.setSale((int)(offers.isEmpty() ? 0 : offers.get(0).value()));
    }

    private static void processSalesBySize(Item sneaker) {
        String size = "9.5";
        System.out.println("\n\t\t SALES 9.5 US");
        Criteria sizeFilter = new Size(size);
        Criteria sales = new Sales();
        List<Offer> sizeSales = filterOffersByCriteria(sneaker, sizeFilter, sales);
        sizeSales.forEach(System.out::print);
        
        sneaker.setSale(sizeSales.isEmpty() ? 0 : sizeSales.get(sizeSales.size() - 1).value());
        System.out.println("\n\t\t LAST SALE 9.5 US: " + sneaker.getSale());
    }

    private static void processBidsBySize(Item sneaker) {
        String size = "9.5";
        System.out.println("\n\t\t BIDS 9.5 US");
        Criteria sizeFilter = new Size(size);
        
        Criteria bids = new Bids();
        List<Offer> bidsBySize = filterOffersByCriteria(sneaker, sizeFilter, bids);
        bidsBySize.forEach(System.out::print);

        sneaker.setBid(bidsBySize.stream().mapToInt(Offer::value).max().orElse(0));
        System.out.println("\n\t\t MAX BID 9.5 US: " + sneaker.getBid());

        Criteria asks = new Asks();
        List<Offer> asksBySize = filterOffersByCriteria(sneaker, sizeFilter, asks);
        sneaker.setAsk(asksBySize.stream().mapToInt(Offer::value).min().orElse(0));
        System.out.println("\n\t\t MIN ASK 9.5 US: " + sneaker.getAsk());

        System.out.println(Stockx.draw(sneaker));
    }

    private static List<Offer> filterOffersByCriteria(Item sneaker, Criteria first, Criteria second) {
        List<Offer> firstList = first.checkCriteria(sneaker);
        List<Offer> secondList = second.checkCriteria(sneaker);
        List<Offer> result = new ArrayList<>();
        for (Offer offer : firstList) {
            if (secondList.contains(offer)) {
                result.add(offer);
            }
        }
        return result;
    }

    public static String draw(Item sneaker) {
        return "\n\n\t\t" + sneaker.getAsk() + " Buy\t" 
            + sneaker.getBid() + " Sell \n" +  
            "\t\t" + " _    _" + "\n" +
            "\t\t" + "(_\\__/(,_" + "\n" +
            "\t\t" + "| \\ `_////-._" + "\n" +
            "\t\t" + "J_/___\"=> __/`\\" + "\n" +
            "\t\t" + "|=====;__/___./" + "\n" +
            "\t\t" + "\'-\'-\'-\"\"\"\"\"\"\"`" + "\n" +
            "\t" + sneaker.toString() + "\n" +
            "\t\tlast sale: " + sneaker.getSale();
    }
}