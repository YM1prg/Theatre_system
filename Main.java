package Theatre_system;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

class TheatreGUIEditor extends JFrame{
    private CardLayout cardLayout = new CardLayout();
    private final String[] seatClasses = {"First Class","Second Class","Third Class"};

    private JPanel contentPane = new JPanel(cardLayout);
    private JPanel mainMenu = new JPanel(new GridLayout(5,1));
    private JPanel registerCard = new JPanel(new BorderLayout());
    private JPanel cancelCard = new JPanel(new BorderLayout());
    private JPanel buttonWrappers = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel backButtonWrappers = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel matrixWrapper = new JPanel(new GridBagLayout());
    private JPanel theatreSelectorWrapper = new JPanel(new GridBagLayout());
    private JPanel buttonWrappers2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel backButtonWrappers2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel matrixWrapper2 = new JPanel(new GridBagLayout());
    private JPanel theatreSelectorWrapper2 = new JPanel(new GridBagLayout());
    private JTextArea matrixRepresentation = new JTextArea();
    private JTextArea matrixRepresentation2 = new JTextArea();
    private JTextField userSeatInput = new JTextField(7);
    private JTextField userSeatInput2 = new JTextField(7);


    private JButton regBT = new JButton("Register Seat");
    private JButton cancelBT = new JButton("Cancel Seat");
    private JButton resetBT = new JButton("Reset All Seats");
    private JButton exitBT = new JButton("Exit");
    private JButton finalizeBT = new JButton("Finalize");
    private JButton confirmBT = new JButton("Confirm");
    private JButton backToMainMenu = new JButton("Back");
    private JButton confirmBT2 = new JButton("Confirm");
    private JButton backToMainMenu2 = new JButton("Back");
    private JButton finalizeBT2 = new JButton("Finalize");

    private JLabel jl1 = new JLabel("Theatre Auditorium");
    private JLabel jl2 = new JLabel("Enter Seat to Register: ");
    private JLabel jl3 = new JLabel("Enter Seat to Cancel: ");
    private JComboBox<String> theatreClass = new JComboBox(seatClasses);
    private JComboBox<String> theatreClass2 = new JComboBox(seatClasses);

    private Theatre mainTheatre = new Theatre();

    public void updateMatrixRepresentation(){
        String currentClass = (String) theatreClass.getSelectedItem();
        matrixRepresentation.setText(mainTheatre.toStringHelperFunction(currentClass));
        String currentClass2 = (String) theatreClass2.getSelectedItem();
        matrixRepresentation2.setText(mainTheatre.toStringHelperFunction(currentClass2));
        matrixRepresentation.updateUI();
        matrixRepresentation2.updateUI();
    }
    public TheatreGUIEditor(){
        mainTheatre.InitializeFirstClass2dArr();  // initialize the classes with 'O'
        mainTheatre.InitializeSecondClass2dArr();
        mainTheatre.InitializeThirdClass2dArr();
        matrixRepresentation.setEditable(false);
        matrixRepresentation.setFont(new Font("Arial",Font.PLAIN,30));
        matrixRepresentation.setBorder(new EtchedBorder());
        matrixRepresentation2.setEditable(false);
        matrixRepresentation2.setFont(new Font("Arial",Font.PLAIN,30));
        matrixRepresentation2.setBorder(new EtchedBorder());
        mainMenu.setBackground(Color.BLACK);
        this.add(contentPane);

        contentPane.add(mainMenu,"Menu");
        contentPane.add(registerCard,"Register");
        contentPane.add(cancelCard,"Cancel");

        jl1.setHorizontalAlignment(JLabel.CENTER);
        jl1.setForeground(Color.WHITE);
        jl1.setFont(new Font("Arial",Font.BOLD,25));

        buttonWrappers.add(jl2);
        buttonWrappers.add(userSeatInput);
        buttonWrappers.add(confirmBT);
        backButtonWrappers.add(backToMainMenu);
        backButtonWrappers.add(finalizeBT);
        theatreSelectorWrapper.add(theatreClass);

        buttonWrappers2.add(jl3);
        buttonWrappers2.add(userSeatInput2);
        buttonWrappers2.add(confirmBT2);
        backButtonWrappers2.add(backToMainMenu2);
        backButtonWrappers2.add(finalizeBT2);
        theatreSelectorWrapper2.add(theatreClass2);

        matrixWrapper.add(matrixRepresentation);
        matrixWrapper2.add(matrixRepresentation2);

        registerCard.add(backButtonWrappers,BorderLayout.NORTH);
        registerCard.add(theatreSelectorWrapper,BorderLayout.WEST);
        registerCard.add(buttonWrappers,BorderLayout.SOUTH);
        registerCard.add(matrixWrapper,BorderLayout.CENTER);
        registerCard.add(new JPanel(), BorderLayout.EAST);

        cancelCard.add(backButtonWrappers2,BorderLayout.NORTH);
        cancelCard.add(theatreSelectorWrapper2,BorderLayout.WEST);
        cancelCard.add(buttonWrappers2,BorderLayout.SOUTH);
        cancelCard.add(matrixWrapper2,BorderLayout.CENTER);
        cancelCard.add(new JPanel(), BorderLayout.EAST);

        mainMenu.add(jl1);
        mainMenu.add(regBT);
        mainMenu.add(cancelBT);
        mainMenu.add(resetBT);
        mainMenu.add(exitBT);

        cardLayout.show(contentPane,"Menu");
        this.setVisible(true);
        this.setSize(800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        theatreClass.addActionListener(e-> {
            updateMatrixRepresentation();
        });
        theatreClass2.addActionListener(e-> {
            updateMatrixRepresentation();
        });
        confirmBT.addActionListener(e->{
            try {
                mainTheatre.Reservation(Integer.parseInt(userSeatInput.getText()) , (String) theatreClass.getSelectedItem());
                updateMatrixRepresentation();
            }
            catch(NumberFormatException | IndexOutOfBoundsException n){
                JOptionPane.showMessageDialog(registerCard, "Please enter a valid seat number!");
            }
            catch(Exception mm){
                JOptionPane.showMessageDialog(registerCard, "Seat already reserved!");
            }
        });
        confirmBT2.addActionListener(e->{
            try {
                mainTheatre.CancelReservation(Integer.parseInt(userSeatInput2.getText()) , (String) theatreClass2.getSelectedItem());
                updateMatrixRepresentation();
            }
            catch(NumberFormatException | IndexOutOfBoundsException n){
                JOptionPane.showMessageDialog(registerCard, "Please enter a valid seat number!");
            }
            catch(Exception mm){
                JOptionPane.showMessageDialog(registerCard, mm.getMessage());
            }
        });

        resetBT.addActionListener(
                e -> mainTheatre.ResetTheatreReservation()
        );
        exitBT.addActionListener(
                e -> mainTheatre.Exit()
        );
        finalizeBT.addActionListener(e -> {
            JOptionPane.showMessageDialog(registerCard,"Your total is $" + mainTheatre.FinalPayment);
        });
        finalizeBT2.addActionListener(e -> {
            JOptionPane.showMessageDialog(cancelCard,"Your total is $" + mainTheatre.FinalPayment);
        });
        regBT.addActionListener(e -> {
            cardLayout.show(contentPane,"Register");
            updateMatrixRepresentation();
        });
        backToMainMenu.addActionListener(e ->{
            cardLayout.show(contentPane,"Menu");
        });
        backToMainMenu2.addActionListener(e ->{
            cardLayout.show(contentPane,"Menu");
        });
        cancelBT.addActionListener(e->{
            cardLayout.show(contentPane,"Cancel");
            updateMatrixRepresentation();
        });
    }
}
public class Main {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        Theatre theatre1 = new Theatre();
//        theatre1.InitializeFirstClass2dArr(); // initialize the classes with O
//        theatre1.InitializeSecondClass2dArr();//  //         //  //      //
//        theatre1.InitializeThirdClass2dArr();//   //         //  //      //

        // simple Comandline to exam the functions
//        while(true){
//            System.out.print("1. Reserve: \n 2. CancleReserve: \n 3. ResetRerservation: \n 4. Final: \n 5. Exit: \n");
//            int numbers = input.nextInt();
//            switch(numbers){
//                case 1:
//                    theatre1.Reservation();
//                    break;
//                case 2:
//                    theatre1.CancelReservation();
//                    break;
//                case 3:
//                    theatre1.ResetTheatreReservation();
//                    break;
//                case 4:
//                    System.out.println("cash: "+theatre1.FinalPayment);
//                    break;
//                case 5:
//                    theatre1.Exit();
//                    break;
        TheatreGUIEditor gui = new TheatreGUIEditor();

    }
}