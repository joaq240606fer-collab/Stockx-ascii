/* class And Criteria*/
package edu.teamrocket;
import java.util.List;


public class AndCriteria implements Criteria{
   private Criteria criteria;
   private Criteria otherCriteria;

   public AndCriteria(Criteria criteria) {
    this.criteria = criteria;
   }
   @Override
   public List<Offer> checkCriteria(Item item) {
    return null;
   }
}