/* class Min */
package edu.teamrocket;
import java.util.List;


public class Min implements Criteria{
   Criteria criteria;
   Criteria otherCriteria;

   public Min(Criteria criteria) {
    this.criteria = criteria;
   }
   @Override
   public List<Offer> checkCriteria(Item item) {
    return null;
   }
}