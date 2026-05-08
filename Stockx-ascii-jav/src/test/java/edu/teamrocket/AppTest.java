package edu.teamrocket;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


 /* test de ceracion zapatillas */
@test 
    piublic void bidMaximaTalla() {
    Item sneaker = new sneaker("9.5", "zapatilla_prueba");
    sneaker.add(new Bid("13", 550));
    sneaker.add(new Bid("6", 200));
    sneaker.add(new Bid("9.5", 479));

    criteria sizeFilter = new size("9,5")
    criteria Bids = new Bids();
    criteria MaxBid = new MaxBid(sizeFilter , bids)

    List<Offer> result = MaxBid.checkCriteria(result)

    }