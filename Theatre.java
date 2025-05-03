package Theatre_system;

import java.util.Scanner;
public class theatre {
    Scanner input = new Scanner(System.in);
    private final static int FirstClassCost=50;//
    private final static int SecondClassCost=15;//     The fixed cost for each class
    private final static int ThirdClassCost=10;//

    private final static int FirstClassSeats=20;//
    private final static int SecondClassSeats=40;//     The fixed seat for each class
    private final static int ThirdClassSeats=50; //

    private Character[][] FirstClass2dArr=new Character[4][5]; //
    private Character[][] SecondClass2dArr=new Character[8][5]; //  The fixed size of the 2D arrays classes
    private Character[][] ThirdClass2dArr=new Character[10][5]; //

    int FinalPayment=0,Row=0,Column=0,UserInputClass=0,UserInputID=0;


    public void InitializeFirstClass2dArr() {   //  initialize all the class values with O
        for(int row=0;row<4;row++){
            for(int column=0;column<5;column++){
                FirstClass2dArr[row][column]='O';
            }
        }
    }

    public void InitializeSecondClass2dArr() {  //  initialize all the class values with O
        for(int row=0;row<8;row++){
            for(int column=0;column<5;column++){
                SecondClass2dArr[row][column]='O';
            }
        }
    }

    public void InitializeThirdClass2dArr() {  //  initialize all the class values with O
        for(int row=0;row<10;row++){
            for(int column=0;column<5;column++){
                ThirdClass2dArr[row][column]='O';
            }
        }
    }



    // for testing
    public void print1(){
        System.out.println();
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


    public void indexRowColumn(){   // the users enters the ID and it translate it into Row and Columns
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
    public void TakeClassInput(){    // taking user class input
        System.out.print("Enter First Class: ");
        UserInputClass=input.nextInt();
    }

    public void Reservation(){
        TakeClassInput();
        switch(UserInputClass){
            case 1:
                try{
                    indexRowColumn(); // gets the row column
                    if(FirstClass2dArr[Row][Column]=='O'){   // check if its empty
                        FirstClass2dArr[Row][Column]='X'; // fill it with X to make it resereved
                        FinalPayment+=FirstClassCost;
                    }
                    else{
                        throw new Exception("Error: this seat is already taken!"); // if the users enters ID already taken
                    }
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }
                print1();
                break;
            case 2:
                try{
                    indexRowColumn();
                    if(SecondClass2dArr[Row][Column]=='O'){
                        SecondClass2dArr[Row][Column]='X';
                        FinalPayment+=SecondClassCost;
                    }
                    else{
                        throw new Exception("Error: this seat is already taken!"); // if the users enters ID already taken
                    }
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }
                print2();
                break;
            case 3:
                try{
                    indexRowColumn();
                    if(ThirdClass2dArr[Row][Column]=='O'){
                        ThirdClass2dArr[Row][Column]='X';
                        FinalPayment+=ThirdClassCost;
                    }
                    else{
                        throw new Exception("Error: this seat is already taken!\n"); // if the users enters ID already taken

                    }
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }
                print3();
                break;
        }
    }

    public void CancelReservation() {
        TakeClassInput();
        switch (UserInputClass) {
            /// Each index should be labelled with x or O ///
            case 1:
                try{
                    indexRowColumn();
                    if (FirstClass2dArr[Row][Column] == 'X') // Check if the seat is reserved
                    {
                        FirstClass2dArr[Row][Column] = 'O'; /// Now,Seat is empty
                        FinalPayment -= FirstClassCost; // remove the seat price from total price

                    }
                    else {
                        throw new Exception("Error: no reservation found at the specified seat."); // if the users enters ID already taken

                    }
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }
                print1();
                break ;
            case 2:
                try{
                    indexRowColumn();
                    if (SecondClass2dArr[Row][Column] == 'X')
                    {
                            SecondClass2dArr[Row][Column] = 'O';
                            FinalPayment -= SecondClassCost;
                    } else {
                        throw new Exception( "Error: no reservation found at the specified seat."); // if the users enters ID already taken

                    }
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }
                print2();
                break ;
            case 3:
                try{
                    indexRowColumn();
                        if (ThirdClass2dArr[Row][Column] == 'X')
                    {
                        ThirdClass2dArr[Row][Column] = 'O';
                        FinalPayment -= ThirdClassCost;


                    } else {
                        throw new Exception("Error: no reservation found at the specified seat."); // if the users enters ID already taken
                    }
                }catch(Exception e){
                    System.out.print(e.getMessage());
                }
                print3();
                break ;
        }

    }

    public void ResetTheatreReservation(){ // it returns all the classes to its original form
        InitializeFirstClass2dArr();
        InitializeSecondClass2dArr();
        InitializeThirdClass2dArr();
        print1();
        System.out.println("------------------------------------------------------");
        print2();
        System.out.println("------------------------------------------------------");
        print3();
        System.out.println("-----------------------------------------------------");
        FinalPayment=0; // resets the payment too
    }

    ///// Function Exit ////
    public void Exit(){
        System.exit(1);  // parameter should be of  int type
    }
}



