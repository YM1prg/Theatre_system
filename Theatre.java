package Theatre_system;

import java.util.Scanner;
public class theatre {
    Scanner input = new Scanner(System.in);
    private final static int FirstClassCost=50;
    private final static int SecondClassCost=15;
    private final static int ThirdClassCost=10;

    private final static int FirstClassSeats=20;
    private final static int SecondClassSeats=40;
    private final static int ThirdClassSeats=50;

    private Character[][] FirstClass2dArr=new Character[4][5];
    private Character[][] SecondClass2dArr=new Character[8][5];
    private Character[][] ThirdClass2dArr=new Character[10][5];

    int FinalPayment=0,Row=0,Column=0,UserInputClass=0,UserInputID=0;

    public Character[][] getFirstClass2dArr() {
        return FirstClass2dArr;
    }
    public Character[][] getSecondClass2dArr() {
        return SecondClass2dArr;
    }
    public Character[][] getThirdClass2dArr() {
        return ThirdClass2dArr;
    }
    public void InitializeFirstClass2dArr() {
        for(int row=0;row<4;row++){
            for(int column=0;column<5;column++){
                FirstClass2dArr[row][column]='O';
            }
        }
    }
    public void InitializeSecondClass2dArr() {
        for(int row=0;row<8;row++){
            for(int column=0;column<5;column++){
                SecondClass2dArr[row][column]='O';
            }
        }
    }
    public void InitializeThirdClass2dArr() {
        for(int row=0;row<10;row++){
            for(int column=0;column<5;column++){
                ThirdClass2dArr[row][column]='O';
            }
        }
    }
    // for testing
    public void print1(){
        for(int row=0;row<4;row++){
            for(int column=0;column<5;column++){
                System.out.print(FirstClass2dArr[row][column]+"\t");
            }
            System.out.println();
        }
    }
    // for testing
    public void print2(){
        for(int row=0;row<8;row++){
            for(int column=0;column<5;column++){
                System.out.print(SecondClass2dArr[row][column]+"\t");
            }
            System.out.println();
        }
    }
    // for testing
    public void print3(){
        for(int row=0;row<10;row++){
            for(int column=0;column<5;column++){
                System.out.print(ThirdClass2dArr[row][column]+"\t");
            }
            System.out.println();
        }
    }
    public void indexRowColumn(){
        int storage=0, counts=-1;
        System.out.print("Enter the ID: ");
        UserInputID=input.nextInt();
        storage=UserInputID;
        if(storage%5==0){
            Row=(storage/5)-1;
            Column=4;
        }else{
            Column=(storage%5)-1;
            while(storage>0){
                storage-=5;
                counts++;
            }
            Row=counts;
        }
    }
    public void Reservation(){
        System.out.print("Enter First Class: ");
        UserInputClass=input.nextInt();
        switch(UserInputClass){
            case 1:
                try{
                    indexRowColumn();
                    if(FirstClass2dArr[Row][Column]=='O'){
                        FirstClass2dArr[Row][Column]='X';
                        FinalPayment+=FirstClassCost;
                    }
                    else{
                        throw new Exception("Error: this seat is already taken!");
                    }
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }
                break;
            case 2:
                try{
                    indexRowColumn();
                    if(SecondClass2dArr[Row][Column]=='O'){
                        SecondClass2dArr[Row][Column]='X';
                        FinalPayment+=SecondClassCost;
                    }
                    else{
                        throw new Exception("Error: this seat is already taken!");
                    }
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }

                break;
            case 3:
                try{
                    indexRowColumn();
                    if(ThirdClass2dArr[Row][Column]=='O'){
                        ThirdClass2dArr[Row][Column]='X';
                        FinalPayment+=ThirdClassCost;
                    }
                    else{
                        throw new Exception("Error: this seat is already taken!");
                    }
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }
                break;
        }
    }


}
