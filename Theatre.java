class Theatres {
    //// First let's create the three classes we  have ////
    private final int[][] firstClass_Seats; /// first class size
    private final int firstclass_price ;    /// first class price

    private final int[][] secondClass_Seats; /// second class size
    private final int secondclass_price ;    /// second class price

    private final int[][] thirdClass_Seats; /// third class size
    private final int thirdclass_price ;    /// third class price

    public int total_price = 0; /// total price of reserved seats

    // Constructor 
    public Theatres(int[][] frstClass_Seats , int frstclass_price, int[][] scndClass_Seats,
                     int scndclass_price, int[][] thrdClass_Seats, int thrdclass_price) {

        firstClass_Seats = new int [4][5] ;
        firstclass_price = 50;

        secondClass_Seats = new int[8][5] ;
        secondclass_price = 15;

        thirdClass_Seats = new int[10][5] ;
        thirdclass_price = 10;

    }

    //// Intiate Getters for each class ////
    
    public int[][] getFirstClass_Seats() {
        return firstClass_Seats;
    }
    public int getFirstclass_price() {
        return firstclass_price;
    }

    public int[][] getSecondClass_Seats() {
        return secondClass_Seats;
    }
    public int getSecondclass_price() {
        return secondclass_price;
    }

    public int[][] getThirdClass_Seats() {
        return thirdClass_Seats;
    }
    public int getThirdclass_price() {
        return thirdclass_price;
    }

    public String cancel_reservation(int classnumber, int row, int col) {
        switch (classnumber) {
            /// Each index should be labelled with 1 or 0 ///
            case 1:
                if (firstClass_Seats[row][col] == 1) // Check if the seat is reserved
                {
                    firstClass_Seats[row][col] = 0; /// Now,Seat is empty

                    total_price -= firstclass_price; // remove the seat price from total price
                    System.out.println("Seat cancelled successfully");
                    System.out.println("+ 50 L.E");

                    return "total_price = " + total_price + " L.E";

                } else {

                    return "No reservation found at the specified seat.";

                }

            case 2:
                if (firstClass_Seats[row][col] == 1) 
                {
                    firstClass_Seats[row][col] = 0; 

                    total_price -= firstclass_price; 
                    System.out.println("Seat cancelled successfully");
                    System.out.println("+ 15 L.E");

                    return "total_price = " + total_price + " L.E";
                } else {
                    return "No reservation found at the specified seat.";

                }

            case 3:
                if (firstClass_Seats[row][col] == 1) 
                {
                    firstClass_Seats[row][col] = 0; 

                    total_price -= firstclass_price; 
                    System.out.println("Seat cancelled successfully");
                    System.out.println("+ 10 L.E");

                    return "total_price = " + total_price + " L.E";
                } else {
                    return "No reservation found at the specified seat.";

                }

        }
        
        return " Invalid choices !! ";
    }

    ///// Function Exit ////
    public void Exit(){
        System.exit(1);  // parameter should be of  int type
    }
}

//// This main classs is for testing and might be removed later ////
public class Theatre {
    public static void main(String[] args) {
       

        int[][] firstClassSeats = new int[4][5];
        int firstClassPrice = 50;
        int[][] secondClassSeats = new int[8][5];
        int secondClassPrice = 15;
        int[][] thirdClassSeats = new int[10][5];
        int thirdClassPrice = 10;

        Theatres theatres = new Theatres(firstClassSeats, firstClassPrice, secondClassSeats, secondClassPrice, thirdClassSeats, thirdClassPrice);
        
        String result = theatres.cancel_reservation(1, 2, 3); // Cancel reservation for class 1 at row 2, column 3
        System.out.println(result);

        theatres.Exit();
    }
}
