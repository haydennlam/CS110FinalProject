/*
Hayden Lam
CS110 
Assignment 10
*/
import java.util.ArrayList;
import java.util.Random;



public class Deck{
   
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
   
   
   public int size() 
   {
      return deck.size();
   }
   
  
   public boolean isEmpty() 
   {
      return deck.size() == 0;
   }
 
   public Card RemoveCard()
   {
          card = deck.remove(deck.size()-1);
          return card;
   }
   

   public void AddCard(Card card){
      deck.add(0,card);
   }
   

   public ArrayList<Card> getDeck(){
      return deck;
   }
   

   public void shuffle(){
      for(int i = 0; i < 1000; i++){      
         int randNum = rand.nextInt(deck.size());
         temp = deck.remove(deck.size()-1);
         deck.add(randNum,temp);        
      }
   }  
}