/* class And Criteria */
package edu.teamrocket;
import java.util.List;
import java.util.ArrayList;

public class AndCriteria implements Criteria {
    private final Criteria criteria;
    private final Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> firstList = criteria.checkCriteria(item);
        List<Offer> secondList = otherCriteria.checkCriteria(item);
        if (firstList == null || secondList == null) {
            return new ArrayList<>();
        }
        List<Offer> result = new ArrayList<>();
        for (Offer offer : firstList) {
            if (secondList.contains(offer)) {
                result.add(offer);
            }
        }
        return result;
    }
}