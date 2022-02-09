package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class game {
    private int size ;
    //private ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
    int [][] board ;
    //Scanner sc = new Scanner(System.in);
     game(int n){
         board = new int[n][n];
         for(int i=0 ; i<n ; i++){
             for (int j= 0; j< n; j++) {
                board[i][j] = -1;
             }
         }
         size = n ;
     }

    /**
     * Makes a move on the board and return winner , if the move is winning move.
     *
     * @param player is either boolean 0 or 1
     * @param row
     * @param col
     * @return +1 if player1 wins, -1 for player2 , 0 otherwise
     * @throws IllegalArgumentException if move is invalid .
     */

    public int move(int player, int row, int col)
    {
       // int player = p==true ? 1 : 0;
        System.out.println(player);
        if (row < 0 || col < 0 || row >= size || col >= size){
            throw new IllegalArgumentException("Move out of board");
        } else if ( board[row][col] != -1) {
            throw  new IllegalArgumentException("Grid is occupied");
        } else if (player != 0 && player != 1) {
            throw  new IllegalArgumentException("Not a valid player");
        } else {
            board[row][col] = player;
            boolean win1 = true , win2= true;

            // check fixing row and col
            for (int i = 0 ; i<size; i++){
                if (board[row][i] != player) {
                    win1 = false ;
                }

                if(board[i][col] != player) {
                    win2 = false ;
                }
            }

            if(win1 || win2) return player == 1 ? 1 : -1;

            boolean win3= false , win4= false ;

            // chk for both diagonal
            if(row == col) {
                boolean winD1= true ;
                for (int i=0 ; i<size ; i++) {
                    if(board[i][i] != player) {
                        winD1 = false ;
                        break;
                    }
                }
                if(winD1) {
                    win3 = true ;
                }
            }
            if(row+ col == size) {
                boolean winD2= true ;
                for (int i=0 ; i<size ; i++) {
                    if (board[i][size-i-1] != player) {
                        winD2 = false ;
                        break;
                    }
                }
                if(winD2) {
                    win4 = true ;
                }
            }

            if (win3 || win4 ) {
                return player == 1 ? 1 : -1;
            }

            return 0 ;
        }
    }




































    /* boolean isValid(int x, int y){
         if(board.get(x).get(y) != 0) return false ;

         if(x>= size || y >= size || x<0 || y< 0) return false ;
         return  true;

     }
     boolean checkBoard(int x, int y, boolean player){
         int gridValue= player ? 1 : 0;
         if(gridValue==0) gridValue=1;
         else gridValue=2;

         //same row

         for(int j=0 ; j<= y; j++)
         {


         }
         return true ;
     }
     boolean isTie(){
         return true ;
     }

     public void play()
     {
         while(!gameover)
         {
             if(isTie()){
                 System.out.println("Game Tie!");
                 gameover = true;
                 return ;

             }
             if(player1){
                 System.out.println("Player1 , enter your X position");
                 int x= sc.nextInt();
                 System.out.println("Player1 , enter your Y position");
                 int y= sc.nextInt();
                 if(isValid(x,y)){
                     board.get(x).set(y,1);
                     player1 = !player1;
                     gameover = checkBoard(x, y, player1);
                 }
             }
             else{
                 System.out.println("Player2 , enter your X position");
                 int x= sc.nextInt();
                 System.out.println("Player2 , enter your Y position");
                 int y= sc.nextInt();
                 if(isValid(x,y)){
                     board.get(x).set(y,2);
                     player2 = !player2;
                     gameover = checkBoard(x, y, player2);
                 }

             }
         }




     }*/



}
