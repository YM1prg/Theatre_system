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

    
    public String cancel_reservation(int classnumber, int row, int col) {
        switch (classnumber) {
            /// Each index should be labelled with x or O ///
            case 1:
            try{
                indexRowColumn();
                if (firstClass_Seats[row][col] == 'X') // Check if the seat is reserved
                {
                    firstClass_Seats[row][col] = 'O'; /// Now,Seat is empty

                    total_price -= firstclass_price; // remove the seat price from total price
                    System.out.println("Seat cancelled successfully");
                    System.out.println("+ 50 L.E");

                    return "total_price = " + total_price + " L.E";

                } 
                else {

                    throw new  Exception("No reservation found at the specified seat.");

                }}catch(Exception e){
                    System.out.print(e.getMessage());

                }break ;

            case 2:
            try{
                indexRowColumn();
                if (firstClass_Seats[row][col] == 'X') 
                {
                    firstClass_Seats[row][col] = 'O'; 

                    total_price -= firstclass_price; 
                    System.out.println("Seat cancelled successfully");
                    System.out.println("+ 15 L.E");

                    return "total_price = " + total_price + " L.E";
                } else {
                    throw new Exception( "No reservation found at the specified seat.");

                }}catch(Exception e){
                    System.out.print(e.getMessage());
                }break ;

            case 3:
            try{
                indexRowColumn();
                if (firstClass_Seats[row][col] == 'X') 
                {
                    firstClass_Seats[row][col] = 'O'; 

                    total_price -= firstclass_price; 
                    System.out.println("Seat cancelled successfully");
                    System.out.println("+ 10 L.E");

                    return "total_price = " + total_price + " L.E";
                } else {
                    throw new Exception("No reservation found at the specified seat.");

                }}catch(Exception e){
                    System.out.print(e.getMessage());
                }break ;

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
