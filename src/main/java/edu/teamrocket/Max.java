/* class Max */
package edu.teamrocket;
import java.util.List;


public class Max implements Criteria{
   Criteria criteria;
   Criteria otherCriteria;

   public Max(Criteria criteria) {
    this.criteria = criteria;
   }
   @Override
   public List<Offer> checkCriteria(Item item) {
    return null;
   }
}