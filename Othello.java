/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

/**
 *
 * @author kenzi
 */
import java.util.Scanner;
public class Othello {

    /**
     * @param args the command line arguments
     */
    final static int X = 1;
    final static int Y = -1;
    final static int HEIGHT = 8;
    final static int WIDTH = 8;
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        char[][] state =   {{'o','o','o','o','o','o','o','o','\n'},                   //newしない（できない）
                            {'o','o','o','o','o','o','o','o','\n'},
                            {'o','o','o','o','o','o','o','o','\n'},
                            {'o','o','o','X','Y','o','o','o','\n'},
                            {'o','o','o','Y','X','o','o','o','\n'},
                            {'o','o','o','o','o','o','o','o','\n'},
                            {'o','o','o','o','o','o','o','o','\n'},
                            {'o','o','o','o','o','o','o','o','\n'}};
        int turn = X;
        
        
            draw(state, turn);
        while(true){                                                
                                                                                System.out.println("Input");
            update(input(), turn, state);
                                                                                System.out.println("update");
            turn *= -1;                                                                    System.out.println("draw");
            draw(state, turn);
            
        }
           
    }
    
    
    public static int[] input(){
        Scanner sc = new Scanner(System.in);
        int[] input = new int[2];
        input[0] = sc.nextInt();
        input[1] = sc.nextInt();
                                                                                System.out.println("Input OK");
        return input;
    }
    public static void update(int[] input, int turn, char[][] state){
     char piece = 'o';
        if(turn == 1){
            piece = 'X';
        }else if (turn == -1){
            piece = 'Y';
        }
        state[input[0]][input[1]] = piece;
            for(int h = 0;h<HEIGHT;h++){
                for(int w = 0;w<WIDTH;w++){
                    if(state[h][w]==piece){
                        System.out.print("Find ");
                        System.out.print(h);
                        System.out.println(w);
                        int x = h-input[0];
                        int y = w-input[1];
                        turnPiece(x, y, state, turn, piece, input);
                        
                    }
                
                }    
            }                                                                              
    }
    public static void draw(char[][] state, int turn){
        char piece ='o';
        if(turn == 1){
            piece = 'X';
        }else if (turn == -1){
            piece = 'Y';
        }
        System.out.println("turn " +piece);
       System.out.println("   "+"0 1 2 3 4 5 6 7");
        for(int i = 0;i<HEIGHT;i++){
            System.out.print(i +" ");
            for(int j = 0;j<WIDTH;j++){
                System.out.print(" ");
                System.out.print(state[i][j]);
            }
            System.out.print('\n');
        }
    }
    public static void turnPiece(int x, int y, char[][] state, int turn, char piece, int[] input){
        int slope = 50;
        if (x != 0){
            slope = y/x;
        }else {
            slope = 0;
        }
        System.out.println("x ="+x);
        System.out.println("y ="+y);
        System.out.println("slope ="+slope);
        int length = (int)Math.sqrt((double)(x*x+y*y));
        System.out.println("length ="+length);
            switch(slope){
                case 1:
                    for(int i =0;i<length;i++){
                        state[input[0]+i][input[1]-i] = piece;
                    }
                    break;
                case -1:
                     for(int i =0;i<length;i++){
                        state[input[0]+i][input[1]-i] = piece;
                     }
                     break;
                case 0:
                    if(y>0 && x==0){
                        for(int i =0;i<length;i++){
                        state[input[0]][input[1]+i] = piece;
                        }
                    }else if (y<0 && x==0){
                        for(int i =0;i<length;i++){
                        state[input[0]][input[1]-i] = piece;
                    }
                    }else if (x>0 && y==0){
                        for(int i =0;i<length;i++){
                        state[input[0]+i][input[1]] = piece;
                        }
                    }else if (y<0 && x==0){
                        for(int i =0;i<length;i++){
                        state[input[0]-i][input[1]] = piece;
                        }
                    }    
                    break;
                default:
                    break;
                                
            }
    }
        
    
              
}
