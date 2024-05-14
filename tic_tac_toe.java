import java.util.*;
import java.io.*;

public class tic_tac_toe
{
    static final int size=3;
    static int check_it=0;
    static int ulti_count=0,turn_count=0, win=0;
    
    public static void main(String[]args) throws IOException{

        Scanner sc=new Scanner(System.in);
        System.out.println("Ready to play ticTacToe? (Y/N): ");
        String s=sc.nextLine();
        String s2="Y";
        if(s.equalsIgnoreCase(s2))
        {
        int r=size,c=size;
        System.out.println("The empty coulmns are as follows: \n");
        for(int r1=0;r1<r;r1++)
        {
            for(int c1=0;c1<c;c1++)
            {
                System.out.print(" | "+"["+r1+"]"+"["+c1+"]");
                System.out.print(" | ");
            }
            System.out.println(""); 
            System.out.println( "------------------------------------");
        }

        char arr[][]=new char[size][size];
        for(int r1=0;r1<r;r1++) //assigning temp values
        {
            for(int c1=0;c1<c;c1++)
            {
                arr[r1][c1]=' ';
            }
        }

        boolean gameEnds=false;
        while(gameEnds==false)
        {
            int count=0,count2=0;
            int row=0,col=0,row2=0,col2=0; //had to initialize with 0 or else letsplay() will not get valuse of row2 and col2 if turn_count=1.

            if (win==0)
            {
                do{
                    System.out.println("\nEnter (X) i.e. Player 1's turn: ");
                    System.out.println("Enter the row and column accordingly: ");
                    System.out.println("Row: ");
                    row=sc.nextInt();
                    System.out.println("Column: "); 
                    col=sc.nextInt();

                    if(row>2 || col>2)
                    {
                        System.out.println("\nENTER VALID LOCATION (row<size and col<size) !!");
                    }
                    else if(arr[row][col]==' ')
                    {
                        count=1;
                    }
                    else
                    {
                        // so count1  will stay 0
                        System.out.println("\nTHE LOCATION HAS ALREADY BEEN USED, enter an empty LOCATION !!");
                    }  
                }while(count==0);

                if(turn_count==0)
                {
                    do{
                        System.out.println("\nEnter (O) i.e. Player 2's turn: ");
                        System.out.println("Enter the row and column accordingly: ");
                        System.out.println("Row: ");
                        row2=sc.nextInt();
                        System.out.println("Column: "); 
                        col2=sc.nextInt();

                        if(row2>2 || col2>2)
                        {
                            System.out.println("\nENTER VALID LOCATION (row<size and col<size) !!");
                        }
                        else if(arr[row2][col2]==' ')
                        {
                            count2=1;
                        }
                        else
                        {
                            // so count2 will stay 0
                            System.out.println("\nTHE LOCATION HAS ALREADY BEEN USED, enter an empty LOCATION !!");
                        }  
                    }while(count2==0);
                }
        }       
                letsplay(row, col, row2, col2, arr); //does the placings in accordance to the turns

                if(check(r,c,arr) == true || check_win(r,c,arr) == true)
                {
                    if(check_it==0)
                    {
                        System.out.println("\n\n --- DRAW --- ");
                    }
                    System.out.println("\n\n ------ THANK YOU FOR PLAYING TIC-TAC-TOE, hope you enjoyed !! (Made with love <3 Jishu)------ \n\n");
                    gameEnds=true; //game stops
                }    
        
    }
    
    }}



    static boolean check(int r, int c,char[][] arr) //checks if all the boxes are filled
    {
        int c2=0;
        for(int r1=0;r1<r;r1++) //checking if all the values are filled
            {
                for(int c1=0;c1<c;c1++)
                {
                    if(arr[r1][c1]!=' ')
                    { c2++;}
                }
            }
            if(c2==9)
            {
                return true;
            }
            else{
                return false;
            }
    }


    static void letsplay(int row,int col,int row2,int col2, char[][] arr)
    {
        for(int i=0;i<size;i++)
            {
                for(int j=0;j<size;j++)
                {
                    if(i==row && j==col)
                    {
                        arr[i][j]='X';
                        System.out.print(" | "+arr[i][j]+" | ");
                    }
                    else if(i==row2 && j==col2 && turn_count==0)
                    {
                        arr[i][j]='O';
                        System.out.print(" | "+arr[i][j]+" | ");
                    }
                    else
                    {
                        System.out.print(" | "+arr[i][j]+" | ");
                    }
                }
                System.out.println(""); 
                System.out.println( "---------------------");
            }
            ulti_count++;
            if(ulti_count == 8) //ulti_count is 8 coz after that the turn is 9th and is the last turn.
            {
                turn_count =1;
            }
    }

    static boolean check_win(int r,int c,char[][] arr)
    {  
        boolean row=false,column=false,diagonal=false;
        for(int i=0;i<r;i++)
        {
            int a=0,b=0;
            for(int j=0;j<c;j++)
            {
                if(arr[i][j]=='X')
                {
                    a++;
                }
                if(arr[i][j]=='O')
                {
                    b++;
                }
            }
            if(a==size)
            {
                System.out.println("\n\n Player 1 WON (Row-wise) !!");
                row=true; check_it++;
                return true;
            }
            else if(b==size)
            {
                System.out.println("\n\n Player 2 WON (Row-wise) !!");
                row=true; check_it++;
                return true;
            }
        }
        if(row==false) //for column win proceed now
        {
            for(int i=0;i<c;i++)
            {
                int a=0,b=0;
                for(int j=0;j<r;j++)
                {
                    if(arr[j][i]=='X')
                    {
                        a++;
                    }
                    if(arr[j][i]=='O')
                    {
                        b++;
                    }
                }
                if(a==size)
                {
                    System.out.println("\n\n Player 1 WON (Column-wise) !!");
                    column=true; check_it++;
                    return true;
                }
                else if(b==size)
                {
                    System.out.println("\n\n Player 2 WON (Column-wise) !!");
                    column=true; check_it++;
                    return true;
                }
            }
        }
        if(column==false && row==false) //for diagonal win proceed now
        {
            int a=0,b=0;
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    if(i==j)
                    {
                        if(arr[i][j]=='X')
                        {
                            a++;
                        }
                        
                        else if(arr[i][j]=='O')
                        {
                            b++;
                        }
                        
                    }
                }
            }
            if(a==size || (arr[1][1]=='X' && arr[2][0]=='X' && arr[0][2]=='X'))
                {
                    System.out.println("\n\n Player 1 WON (Diagonal-wise) !!");
                    diagonal=true; check_it++;
                    return true;
                }
            else if(b==size || (arr[1][1]=='O' && arr[2][0]=='O' && arr[0][2]=='O'))
                {
                    System.out.println("\n\n Player 2 WON (Diagonal-wise) !!");
                    diagonal=true; check_it++;
                    return true;
                }                       
        }     
        return false;
    }
}

