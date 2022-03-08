package com.company;
import Constants.Constants;

import java.util.Scanner;

//import static Constants.Constants.lowerCoordinate;

public class TicTac {
    private boolean player1 = true;
    private boolean player2 = true;
    private  boolean gameOver = false ;
    private final int size ;
    Scanner sc = new Scanner(System.in);

    public TicTac(int size ){
        this.size = size;
    }

    public int play()
    {
        game obj = new game(size);
        //Constants constants = new Constants();
        System.out.println(Constants.lowerCoordinate);
        while(!gameOver)
        {
            if(player1){
                System.out.println("Player1 , enter your X and Y position");
                int x= sc.nextInt();

                //System.out.println("Player1 , enter your Y position");
                int y= sc.nextInt();
                try{
                    int res = obj.move(1, x, y);
                    if(res != 0) {
                        System.out.println("Player1 won the match");
                        return 1;
                    }
                    player1 = false;
                    player2 = true ;
                }catch(IllegalArgumentException e){
                    System.out.println(e);
                    System.out.println("Player1 , enter values again ");
                }
            }
            else{
                System.out.println("Player2 , enter your X and Y position");
                int x= sc.nextInt();
                //System.out.println("Player2 , enter your Y position");
                int y= sc.nextInt();
                try{
                    int res = obj.move(0, x, y);
                    if(res != 0) {
                        System.out.println("Player2 won the match");
                        return 2;
                    }
                    player2 = false;
                    player1 = true ;
                }catch(IllegalArgumentException e){
                    System.out.println(e);
                    System.out.println("Player2 , enter values again ");
                }
            }
        }
        return 0;
    }

    public void playedGame () {
        System.out.println("Played with spring!");
    }

}
