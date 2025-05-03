package Theatre_system;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        theatre theatre1 = new theatre();
        theatre1.InitializeFirstClass2dArr(); // initialize the classes with O
        theatre1.InitializeSecondClass2dArr();//  //         //  //      //
        theatre1.InitializeThirdClass2dArr();//   //         //  //      //

        // simple Comandline to exam the functions
        while(true){
            System.out.print("1. Reserve: \n 2. CancleReserve: \n 3. ResetRerservation: \n 4. Final: \n 5. Exit: \n");
            int numbers = input.nextInt();
            switch(numbers){
                case 1:
                    theatre1.Reservation();
                    break;
                case 2:
                    theatre1.CancelReservation();
                    break;
                case 3:
                    theatre1.ResetTheatreReservation();
                    break;
                case 4:
                    System.out.println("cash: "+theatre1.FinalPayment);
                    break;
                case 5:
                    theatre1.Exit();
                    break;
            }
        }
    }
}