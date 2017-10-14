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
    final static int X = 1;                                                             //ターンは１トー１で表現。
    final static int Y = -1;                                                            //コマはXとYで表現。混乱の元なので。オブジェクト化を考えている。
    final static int HEIGHT = 8;
    final static int WIDTH = 8;
    final static int SAME = 50;                                                         //マジックナンバー、意味はない。ないほうが良い。
                                                                                        //コマの検出時、コマを置く座標も検出するため、意図しない処理をしないために使用。
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int turn = X;
        char[][] state =   {{'o','o','o','o','o','o','o','o','\n'},                     //newしない（できない）やり方知らない。調べるべき。
                            {'o','o','o','o','o','o','o','o','\n'},
                            {'o','o','o','o','o','o','o','o','\n'},
                            {'o','o','o','X','Y','o','o','o','\n'},
                            {'o','o','o','Y','X','o','o','o','\n'},
                            {'o','o','o','o','o','o','o','o','\n'},
                            {'o','o','o','o','o','o','o','o','\n'},
                            {'o','o','o','o','o','o','o','o','\n'}};
        
        
        
        draw(state, turn);
        while(true){                                                                    //メインループ、無限ループ、終了条件を作るべき
            int[]  x = input();                                                         //inputのみ形が違うので変えたいが、範囲の広い変数を増やしたくない。
            update(x, turn, state); 
            turn *= -1;                                                                 //ターンは１とー１で表現。＊＝－１で交代する    
            draw(state, turn);           
        }
           
    }
    
    public static int[] input(){
        Scanner sc = new Scanner(System.in);
        int[] input = new int[2];
        do {
            System.out.println("Input \"Row Space column.\" >");
            input[0] = sc.nextInt();
            input[1] = sc.nextInt();
        } while(input[0] < 0 || input[0] > 7 || input[1] < 0 || input[1] > 7);  //do while を追加（E.Tより）
        
        System.out.println("Input finished");
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

                        System.out.print("Find "+piece);                            //デバッグ用
                        System.out.print("("+h);
                        System.out.println(","+w+")");
                        int x = h-input[0];
                        int y = w-input[1];

                        turnPiece(x, y, state, turn, piece, input);                 //長くなったので分割。コードが乱雑になった。
                        
                    }
                
                }    
            } 
            System.out.println("update finished");                                                                      
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
        //System.out.println("Input \"Row Space column.\" >"); inputめそっどにいれてもいい？
        
         
    }
    public static void turnPiece(int x, int y, char[][] state, int turn, char piece, int[] input){
        int slope = SAME;
        if (x != 0){
            slope = y/x;
        }else {
            slope = 0;
        }
        if (x==0 && y==0){
            slope = SAME;
        }

        int length = (int)Math.sqrt((double)(x*x+y*y));
        System.out.println("x ="+x);                                                //デバッグ用
        System.out.println("y ="+y);
        System.out.println("slope ="+slope);
        System.out.println("length ="+length);


            switch(slope){                                                          //盤上でコマを置く座標と同じ種類のコマの座標から直線をみちびく。
                case 1:                                                             //その傾きから処理を分類。
                    if (x>0 && y>0){                                                
                        for(int i =1;i<length;i++){
                        state[input[0]+i][input[1]+i] = piece;
                        }
                    }else if (x<0 && y<0){
                        for(int i =1;i<length;i++){
                        state[input[0]-i][input[1]-i] = piece;
                        }
                    }
                    break;
                case -1:
                    if (x<0 && y>0){
                        for(int i =1;i<length;i++){
                        state[input[0]-i][input[1]+i] = piece;
                        }
                    }else if (x>0 && y<0){
                        for(int i =1;i<length;i++){
                        state[input[0]+i][input[1]-i] = piece;
                        }
                    }
                     break;
                case 0:
                    if(y>0 && x==0){
                        for(int i =1;i<length;i++){
                        state[input[0]][input[1]+i] = piece;
                        }
                    }else if (y<0 && x==0){
                        for(int i =1;i<length;i++){
                        state[input[0]][input[1]-i] = piece;
                    }
                    }else if (x>0 && y==0){
                        for(int i =1;i<length;i++){
                        state[input[0]+i][input[1]] = piece;
                        }
                    }else if (x<0 && y==0){
                        for(int i =1;i<length;i++){
                        state[input[0]-i][input[1]] = piece;
                        }
                    }    
                    break;
                case SAME:
                    break;
                default:
                    break;
                                
            }
    }
        
    
              
}
    

