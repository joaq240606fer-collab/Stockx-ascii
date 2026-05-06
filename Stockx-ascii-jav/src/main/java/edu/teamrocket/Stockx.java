package edu.teamrocket;

import java.util.List;

public class Stockx {

    public static void main(String[] args) {
        Item sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
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
        Criteria maxBid = new MaxBid();
        List<Offer> maximum = maxBid.checkCriteria(sneaker);
        sneaker.setBid(maximum.isEmpty() ? 0 : maximum.get(0).value());
        System.out.println(Stockx.draw(sneaker));

        Criteria minAsk = new MinAsk();
        List<Offer> minimum = minAsk.checkCriteria(sneaker);
        sneaker.setAsk(minimum.isEmpty() ? 0 : minimum.get(0).value());
        System.out.println(Stockx.draw(sneaker));

        Criteria lastSale = new LastSale();
        List<Offer> actualSale = lastSale.checkCriteria(sneaker);
        sneaker.setSale(actualSale.isEmpty() ? 0 : actualSale.get(0).value());
        System.out.println(Stockx.draw(sneaker));
    }

    private static void processSalesBySize(Item sneaker) {
        String size = "9.5";
        System.out.println("\n\t\t SALES 9.5 US");
        Criteria sizeFilter = new Size(size);
        Criteria sales = new Sales();
        Criteria andSizeSales = new AndCriteria(sizeFilter, sales);
        andSizeSales.checkCriteria(sneaker).forEach(System.out::print);

        List<Offer> sizeSales = andSizeSales.checkCriteria(sneaker);
        sneaker.setSale(sizeSales.isEmpty() ? 0 : sizeSales.get(sizeSales.size() - 1).value());
        System.out.println("\n\t\t LAST SALE 9.5 US: " + sneaker.getSale());
    }

    private static void processBidsBySize(Item sneaker) {
        String size = "9.5";
        System.out.println("\n\t\t BIDS 9.5 US");
        Criteria sizeFilter = new Size(size);
        Criteria bids = new Bids();
        Criteria andSizeBids = new AndCriteria(sizeFilter, bids);
        andSizeBids.checkCriteria(sneaker).forEach(System.out::print);

        Criteria sizeMaxBid = new Max(sizeFilter, bids);
        List<Offer> sizeBid = sizeMaxBid.checkCriteria(sneaker);
        sneaker.setBid(sizeBid.isEmpty() ? 0 : sizeBid.get(0).value());
        System.out.println("\n\t\t MAX BID 9.5 US: " + sneaker.getBid());

        Criteria asks = new Asks();
        Criteria sizeMinAsk = new Min(sizeFilter, asks);
        List<Offer> sizeAsk = sizeMinAsk.checkCriteria(sneaker);
        sneaker.setAsk(sizeAsk.isEmpty() ? 0 : sizeAsk.get(0).value());
        System.out.println("\n\t\t MIN ASK 9.5 US: " + sneaker.getAsk());

        System.out.println(Stockx.draw(sneaker));
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