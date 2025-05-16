package Theatre_system;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.Scanner;

public class Theatre {
    Scanner input = new Scanner(System.in);
    private final static int FirstClassCost = 50;//
    private final static int SecondClassCost = 15;// The fixed cost for each class
    private final static int ThirdClassCost = 10;//

    private final static int FirstClassSeats = 20;//
    private final static int SecondClassSeats = 40;// The fixed seat for each class
    private final static int ThirdClassSeats = 50; //

    // Make the button arrays accessible to TheatreGUIEditor
    public JButton[][] FirstClass2dArr = new JButton[4][5];
    public JButton[][] SecondClass2dArr = new JButton[8][5]; //
    public JButton[][] ThirdClass2dArr = new JButton[10][5];

    int  Row = 0, Column = 0, countForOffer=0;
    double FinalPayment=0,discount=0.8;

    public void InitializeFirstClass2dArr() { // initialize all the class values with O
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 5; column++) {
                FirstClass2dArr[row][column] = new JButton();
                FirstClass2dArr[row][column].setName("O");
                FirstClass2dArr[row][column].setText("O");
            }
        }
    }

    public void InitializeSecondClass2dArr() { // initialize all the class values with O
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 5; column++) {
                SecondClass2dArr[row][column] = new JButton();
                SecondClass2dArr[row][column].setName("O");
                SecondClass2dArr[row][column].setText("O");
            }
        }
    }

    public void InitializeThirdClass2dArr() { // initialize all the class values with O
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 5; column++) {
                ThirdClass2dArr[row][column] = new JButton();
                ThirdClass2dArr[row][column].setName("O");
                ThirdClass2dArr[row][column].setText("O");
            }
        }
    }

    public void indexRowColumn(int UserInputID) { // the users enters the ID and it translate it into Row and Columns
        int storage, counts = -1;
        storage = UserInputID;
        if (storage % 5 == 0) {
            Row = (storage / 5) - 1;
            Column = 4;
        } else {
            Column = (storage % 5) - 1;
//            while (storage > 0) {
//                storage -= 5;
//                counts++;
//            }
//            Row = counts;
            Row= storage/5;
        }
    }

    public void Reservation(int userInputID, String UserInputClass) throws Exception {
        switch (UserInputClass) {
            case "First Class":
                indexRowColumn(userInputID); // gets the row column
                if (FirstClass2dArr[Row][Column].getText().equals("O")) { // check if its empty
                    FirstClass2dArr[Row][Column].setText("X"); // fill it with X to make it resereved
                    FirstClass2dArr[Row][Column].setName("X"); // also update name for consistency
                    FinalPayment += FirstClassCost;
                    countForOffer++;
                } else {
                    throw new Exception("Error: this seat is already taken!"); // if the users enters ID already taken
                }
                break;
            case "Second Class":
                indexRowColumn(userInputID);
                if (SecondClass2dArr[Row][Column].getText().equals("O")) {
                    SecondClass2dArr[Row][Column].setText("X");
                    SecondClass2dArr[Row][Column].setName("X");
                    FinalPayment += SecondClassCost;
                } else {
                    throw new Exception("Error: this seat is already taken!"); // if the users enters ID already taken
                }
                break;
            case "Third Class":
                indexRowColumn(userInputID);
                if (ThirdClass2dArr[Row][Column].getText().equals("O")) {
                    ThirdClass2dArr[Row][Column].setText("X");
                    ThirdClass2dArr[Row][Column].setName("X");
                    FinalPayment += ThirdClassCost;

                } else {
                    throw new Exception("Error: this seat is already taken!\n"); // if the users enters ID already taken

                }
                break;
        }
    }

    public void CancelReservation(int userInputID, String UserInputClass) throws Exception {
        switch (UserInputClass) {
            /// Each index should be labelled with x or O ///
            case "First Class":
                indexRowColumn(userInputID);
                if (FirstClass2dArr[Row][Column].getText().equals("X")) // Check if the seat is reserved
                {
                    FirstClass2dArr[Row][Column].setText("O"); /// Now,Seat is empty
                    FirstClass2dArr[Row][Column].setName("O"); // also update name for consistency
                    FinalPayment -= FirstClassCost; // remove the seat price from total price
                    countForOffer--;

                } else {
                    throw new Exception("Error: no reservation found at the specified seat."); // if the users enters ID
                                                                                               // already taken

                }
                break;
            case "Second Class":
                indexRowColumn(userInputID);
                if (SecondClass2dArr[Row][Column].getText().equals("X")) {
                    SecondClass2dArr[Row][Column].setText("O");
                    SecondClass2dArr[Row][Column].setName("O");
                    FinalPayment -= SecondClassCost;

                } else {
                    throw new Exception("Error: no reservation found at the specified seat."); // if the users enters ID
                                                                                               // already taken

                }
                break;
            case "Third Class":
                indexRowColumn(userInputID);
                if (ThirdClass2dArr[Row][Column].getText().equals("X")) {
                    ThirdClass2dArr[Row][Column].setText("O");
                    ThirdClass2dArr[Row][Column].setName("O");
                    FinalPayment -= ThirdClassCost;
                } else {
                    throw new Exception("Error: no reservation found at the specified seat."); // if the users enters ID
                                                                                               // already taken
                }
                break;
        }
    }

    public void ResetTheatreReservation() { // it returns all the classes to its original form
        InitializeFirstClass2dArr();
        InitializeSecondClass2dArr();
        InitializeThirdClass2dArr();
        countForOffer=0;
        FinalPayment = 0; // resets the payment too
    }

    /// // Function Exit ////
    public void Exit() {
        System.exit(1); // parameter should be of int type
    }

    // These string representation methods are kept for backwards compatibility
    // but are no longer needed in the visual button representation
    public String arrayOneToString() {
        StringBuilder matrixToString = new StringBuilder();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 5; column++) {
                matrixToString.append(FirstClass2dArr[row][column].getName()).append("|");
            }
            matrixToString.append("\n");
        }
        return matrixToString.toString();
    }

    public String arrayTwoToString() {
        StringBuilder matrixToString = new StringBuilder();
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 5; column++) {
                matrixToString.append(SecondClass2dArr[row][column].getName()).append("|");
            }
            matrixToString.append("\n");
        }
        return matrixToString.toString();
    }

    public String arrayThreeToString() {
        StringBuilder matrixToString = new StringBuilder();
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 5; column++) {
                matrixToString.append(ThirdClass2dArr[row][column].getName()).append("|");
            }
            matrixToString.append("\n");
        }
        return matrixToString.toString();
    }

    public String toStringHelperFunction(String className) {
        return switch (className) {
            case "First Class" -> arrayOneToString();
            case "Second Class" -> arrayTwoToString();
            case "Third Class" -> arrayThreeToString();
            default -> "";
        };
    }

    public double OfferFeature(){
        return discount;
    }
}
