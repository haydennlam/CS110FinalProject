/*
Hayden Lam
CS110 
Assignment 10
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WarGame extends JFrame{
   //Class fields declarations
   private JFrame frame = new JFrame();
   private JButton button1 = new JButton("Flip");
   private Deck deck = new Deck(2,15);
   private Deck player2Deck = new Deck();
   private Deck player1Deck = new Deck();
   private Card p2Card = new Card();
   private Card p1Card = new Card();
   private Card p2WarCard = new Card();
   private Card p1WarCard = new Card();
 
   //Labels
   private JLabel labelPlayerTwo = new JLabel();// player 2 card
   private JLabel labelPlayerOne = new JLabel();// player 1 card
   private JLabel labelCenter = new JLabel();//text label
   private JLabel playerTwoScore = new JLabel();
   private JLabel playerOneScore = new JLabel();
      
   private JLabel labelwc1 = new JLabel();
   private JLabel labelwc2 = new JLabel();
   private JLabel labelwc3 = new JLabel();
   private JLabel labelwc4 = new JLabel();
   private JLabel label  = new JLabel();
   //ImageIcons
   private ImageIcon backCard = new ImageIcon("back.jpg");
   
   //Create instance of the WarGame   
   public static void main(String[] args){
      new WarGame();    
   }

   public WarGame(){
         //Shuffle deck
         deck.shuffle();
         //Create two piles of cards
         for(int i = 0; !deck.isEmpty() ; i++){ 
            //Creates Two piles of cards from 1 deck
            p1Card = deck.RemoveCard();
            player1Deck.AddCard(p1Card);
            
            p2Card = deck.RemoveCard();
            player2Deck.AddCard(p2Card);
             
         }
         
      //Displays amount of cards in each pile
      playerOneScore = new JLabel("Player 1 Cards: " + player1Deck.size());
      playerTwoScore = new JLabel("Player 2 Cards: " + player2Deck.size());
      
      //Initialize JFrame window
      setTitle("War Game");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      
      //Create new method labels
      JLabel playerOneBackCard = new JLabel();
      JLabel playerTwoBackCard = new JLabel();
      
   
      //Get images
      playerOneBackCard.setIcon(backCard);
      playerTwoBackCard.setIcon(backCard);
      
      //Create method panels
      JPanel panelNorth  = new JPanel();
      JPanel panelEast   = new JPanel();
      JPanel panelWest   = new JPanel();
      JPanel panelCenter = new JPanel();
      JPanel panelSouth  = new JPanel();
      
      //Create ActionListener Object
      button1.addActionListener(new ButtonListener());
      
      //Add buttons and labels to panels
      panelNorth.add(playerOneScore);
      panelNorth.add(button1);
      panelNorth.add(playerTwoScore);
      
      panelCenter.add(labelCenter);// text label
      panelEast.add(labelPlayerTwo);//player 2 card
      
      panelEast.add(playerOneBackCard);
      panelWest.add(playerTwoBackCard);
      
      panelWest.add(labelPlayerOne);//player 1 card
      
      panelSouth.add(label);
      panelSouth.add(labelwc1);
      panelSouth.add(labelwc4);
      panelSouth.add(labelwc3);
      panelSouth.add(labelwc2);
   
      //Add panels to BorderLayout Locations
      add(panelNorth,  BorderLayout.NORTH); 
      add(panelCenter, BorderLayout.CENTER);
      add(panelEast,   BorderLayout.EAST);
      add(panelWest,   BorderLayout.WEST);
      add(panelSouth,  BorderLayout.SOUTH);
      
      //set up GUI
      pack();
      setSize(750,525);//size of GUI
      setVisible(true);
   } 
   
      
//----------------------- Button ------------------------//
  
   private class ButtonListener implements ActionListener{
   
      public void actionPerformed(ActionEvent e){
      try{
         //set babel to null
         labelwc1.setIcon(null);    
         labelwc2.setIcon(null);
         labelwc3.setIcon(null);    
         labelwc4.setIcon(null);
         labelCenter.setText(null);// text label
         
         //Update Pile Size
         playerTwoScore.setText("Player 2 Cards: " + player2Deck.size());
         playerOneScore.setText("Player 1 Cards: " + player1Deck.size());
         
         //Get Card from each pile
         
         p1Card = player1Deck.RemoveCard();
         p2Card = player2Deck.RemoveCard();
         
         //shuffle piles 
         player2Deck.shuffle();
         player1Deck.shuffle();
         
         ////TESTING
         //compare to see which player have higher card then add cards to their card size
         int player2Card1 =p2Card.getRank();//player 2 card rank
         int player1Card1 =p1Card.getRank();//player 1 card rank
         
         
          //add card to whoever have the higher  war card   
         if(player1Card1 >player2Card1){
            player1Deck.AddCard(p2Card);
            player1Deck.AddCard(p1Card);            
         }
         else if (player1Card1 <player2Card1){
            player2Deck.AddCard(p2Card);
            player2Deck.AddCard(p1Card);
         }
         
         else if (player1Card1 == player2Card1){
            //Call War Method
            
            labelCenter.setText("WAR");//text label
            war(player2Deck,player1Deck,p2Card,p1Card);
            labelwc1.setIcon(backCard);    //Set down Card image
            labelwc2.setIcon(backCard);    //Set down Card image
            player1Deck.AddCard(p1Card);
            player2Deck.AddCard(p2Card);
            
            //war Cards
            ImageIcon player1WarCard = new ImageIcon(getJPG(p1WarCard));
            labelwc4.setIcon(player1WarCard);
            ImageIcon player2WarCard = new ImageIcon(getJPG(p2WarCard));
            labelwc3.setIcon(player2WarCard);
           }
         //TESTING
         
         
//-----------------------Get & Display Cards------------------------//
         //Get Card Pictures
         String getPic1 = getJPG(p2Card);
         String getPic2 = getJPG(p1Card);
         
         try{
            //Get and set Card Pic 1
            ImageIcon frontCard1 = new ImageIcon(getPic1);
            labelPlayerTwo.setIcon(frontCard1);// player 2 card
            //Get and set Card Pic 2
            ImageIcon frontCard2 = new ImageIcon(getPic2);
            labelPlayerOne.setIcon(frontCard2);//player 1    
            }//try
         
         catch(Exception eee){
            System.out.println("NO PICTURE FOUND");
         }
      }
      
      catch(Exception ee){
      
         //If player 1 wins
         if(player1Deck.size() > player2Deck.size()){
            
            labelCenter.setText("Player 1 WIN");//text label
            playerOneScore.setText(null);
            playerTwoScore.setText(null);
         }     
         else{
            //If player 2 wins
            
            labelCenter.setText("Player 2 WIN");//text label
            playerOneScore.setText(null);
            playerTwoScore.setText(null); 
         }
      }
   }
   
   }
//---------------------------WAR-------------------------------------------//   

   public void war(Deck player2Deck, Deck player1Deck, Card card1, Card card2){
         //Create new cards
         Card card3 = new Card();
         Card card4 = new Card();
         //set war card to integer value
         int player1WCard = p2WarCard.getRank();
         int player2WCard = p1WarCard.getRank();
         
         while(player1WCard==player2WCard){
            //System.out.println("War");

            card3 = player2Deck.RemoveCard();
            card4 = player1Deck.RemoveCard();
            
            p2WarCard = player2Deck.RemoveCard();
            p1WarCard = player1Deck.RemoveCard();
            
            player1WCard = p1WarCard.getRank();
            player2WCard = p2WarCard.getRank();

            //System.out.print("\np2 "+player2WCard);
            //System.out.print("\np1 "+player1WCard);            
          
         if (player1WCard > player2WCard){
               player1Deck.AddCard(card1);
               player1Deck.AddCard(card2);
               player1Deck.AddCard(card3);
               player1Deck.AddCard(card4);
               player1Deck.AddCard(p2WarCard);
               player1Deck.AddCard(p1WarCard);
               //System.out.println("testing p1>p2");   
            }
          else if (player1WCard < player2WCard){
               player2Deck.AddCard(card1);
               player2Deck.AddCard(card2);
               player2Deck.AddCard(card3);
               player2Deck.AddCard(card4);
               player2Deck.AddCard(p2WarCard);
               player2Deck.AddCard(p1WarCard);
               //System.out.println("testing p1<p2");
            }
            
           }
         }                       
     
        
//-----------------------Get Card image-------------------------//       

     public String getJPG(Card card){
        String getPic;
        // card holder value that greater than 10
        switch(card.getRank()){
        case 11:
           getPic = "jack" + card.getSuit() + ".jpg";
           break;
        case 12:
           getPic = "queen" + card.getSuit() + ".jpg";
           break;
        case 13:
           getPic = "king" + card.getSuit() + ".jpg";
           break;
        case 14:
           getPic = "ace" + card.getSuit() + ".jpg";
           break;
        default:
           getPic = card.getRank() + card.getSuit() + ".jpg";
        }
         
        return getPic;
     }
}