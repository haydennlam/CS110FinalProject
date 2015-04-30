/*
Hayden Lam
CS110 
Assignment 10
*/


public class Card{

   private int rank;
   private String suit;
   

   public Card(){
      rank = 0;
      suit = null;   
   }

   public Card(int rank,String suit){
      this.rank = rank;
      this.suit = suit;
   }
   

   public void setRank(int rank){
      this.rank = rank;
   }

   public void setSuit( String suit){
      this.suit = suit;
   }

   public int getRank(){
      return rank;
   }

   public String getSuit(){
      return suit;
   }

   public String toString(Card card){
      String string = card.getRank() + " of " + card.getSuit();
      System.out.println(string);
      return string;
   }
}