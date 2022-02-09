package com.company;
import java.util.Scanner;

public class TicTac {
    private boolean player1 = true;
    private boolean player2 = true;
    private  boolean gameOver = false ;
    private final int size ;
    Scanner sc = new Scanner(System.in);

    TicTac(){
        System.out.println("Enter size of board : ");
        size = sc.nextInt();
    }

    public void play()
    {
        game obj = new game(size);
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
                        gameOver = true ;
                        break ;
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
                        gameOver = true ;
                        break ;
                    }
                    player2 = false;
                    player1 = true ;
                }catch(IllegalArgumentException e){
                    System.out.println(e);
                    System.out.println("Player2 , enter values again ");
                }
            }
        }
    }
}
