/* class And Criteria*/
package edu.teamrocket;
import java.util.List;


public class AndCriteria implements Criteria{
   private Criteria criteria;
   private Criteria otherCriteria;

   public AndCriteria() {
    this.criteria = criteria;
    this.otherCriteria = otherCriteria;
   }
   @Override
   public List<Offer> checkCriteria(Item item) {
    return null;
   }
}