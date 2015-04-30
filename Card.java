/*
Hayden Lam
CS110 
Assignment 10
*/


public class Card{
   //varible declaraion
   private int rank;
   private String suit;
   
   // set rank suit to nulll
   public Card(){
      rank = 0;
      suit = null;   
   }
   //set rank,suit
   public Card(int rank,String suit){
      this.rank = rank;
      this.suit = suit;
   }
   
   /**set rank to integer value
   @param setRank
   */
   public void setRank(int rank){
      this.rank = rank;
   }
   /**set suit to integer value
   @param setSuit
   */
   public void setSuit( String suit){
      this.suit = suit;
   }
   /**return rank
   @param getRank
   */
   public int getRank(){
      return rank;
   }
    /**return suit
   @param getSuit
   */
   public String getSuit(){
      return suit;
   }
   /**return string
   @param toString
   */
   public String toString(Card card){
      String string = card.getRank() + " of " + card.getSuit();
      System.out.println(string);
      return string;
   }
}