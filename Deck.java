/*
Hayden Lam
CS110 
Assignment 10
*/
import java.util.ArrayList;
import java.util.Random;



public class Deck{
   //varible declaratin and creat array list
   private Card card = new Card();
   private Card temp = new Card();
   private ArrayList<Card> deck = new ArrayList<Card>();
   private ArrayList<Card> pile1 = new ArrayList<Card>();
   private ArrayList<Card> pile2 = new ArrayList<Card>();
   private Random rand = new Random();;
   
   
   public Deck(){
   }
   
   
   public Deck(int low,int high){
      for(int i = low;i < high;i++)
         deck.add(new Card(i, "c"));
      for(int i = low;i < high;i++)
         deck.add(new Card(i, "d"));
      for(int i = low;i < high;i++)
         deck.add(new Card(i, "h"));
      for(int i = low;i < high;i++)
         deck.add(new Card(i, "s"));   
      }
   
   /**return deck size
   @param size
   */
   public int size() 
   {
      return deck.size();
   }
   
  /**
  check deck size is empty
  @param isEmpty
  */
   public boolean isEmpty() 
   {
      return deck.size() == 0;
   }
 /**
 @param RemoveCard
 */
   public Card RemoveCard()
   {
          card = deck.remove(deck.size()-1);
          return card;
   }
   /**
 @param AddCard
 */

   public void AddCard(Card card){
      deck.add(0,card);
   }
   /**
   return deck
 @param getDeck
 */

   public ArrayList<Card> getDeck(){
      return deck;
   }
   
   /**
   shuffle the deck
   */
   public void shuffle(){
      for(int i = 0; i < 1000; i++){      
         int randNum = rand.nextInt(deck.size());
         temp = deck.remove(deck.size()-1);
         deck.add(randNum,temp);        
      }
   }  
}