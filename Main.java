package Theatre_system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class TheatreGUIEditor extends JFrame {
    // Modern color scheme
    private static final Color PRIMARY_COLOR = new Color(41, 128, 185); // Blue
    private static final Color SECONDARY_COLOR = new Color(52, 73, 94); // Dark blue-gray
    private static final Color BG_COLOR = SECONDARY_COLOR; // Light gray
    private static final Color TEXT_COLOR = Color.WHITE; // Dark blue-gray

    private CardLayout cardLayout = new CardLayout();
    private final String[] seatClasses = { "First Class", "Second Class", "Third Class" };

    private JPanel contentPane = new JPanel(cardLayout);
    private JPanel mainMenu = new JPanel(new GridLayout(5, 1, 10, 20));
    private JPanel registerCard = new JPanel(new BorderLayout(10, 10));
    private JPanel cancelCard = new JPanel(new BorderLayout(10, 10));

    // Replace text area with actual seat panels
    private JPanel firstClassSeatsPanel = new JPanel(new GridLayout(4, 5, 8, 8));
    private JPanel secondClassSeatsPanel = new JPanel(new GridLayout(8, 5, 8, 8));
    private JPanel thirdClassSeatsPanel = new JPanel(new GridLayout(10, 5, 8, 8));

    // Create panels to hold the seats based on class
    private JPanel[] seatPanels = new JPanel[3];
    private CardLayout seatsPanelLayout = new CardLayout();
    private JPanel seatsContainer = new JPanel(seatsPanelLayout);

    // Similar setup for cancel view
    private JPanel firstClassSeatsPanel2 = new JPanel(new GridLayout(4, 5, 8, 8));
    private JPanel secondClassSeatsPanel2 = new JPanel(new GridLayout(8, 5, 8, 8));
    private JPanel thirdClassSeatsPanel2 = new JPanel(new GridLayout(10, 5, 8, 8));
    private JPanel[] seatPanels2 = new JPanel[3];
    private CardLayout seatsPanelLayout2 = new CardLayout();
    private JPanel seatsContainer2 = new JPanel(seatsPanelLayout2);

    private JPanel buttonWrappers = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
    private JPanel backButtonWrappers = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
    private JPanel theatreSelectorWrapper = new JPanel(new GridBagLayout());
    private JPanel buttonWrappers2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
    private JPanel backButtonWrappers2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
    private JPanel theatreSelectorWrapper2 = new JPanel(new GridBagLayout());
    private JTextField userSeatInput = new JTextField(7);
    private JTextField userSeatInput2 = new JTextField(7);

    private JButton regBT = createStyledButton("Reserve a Seat");
    private JButton cancelBT = createStyledButton("Cancel Reservation");
    private JButton resetBT = createStyledButton("Reset All Seats");
    private JButton exitBT = createStyledButton("Exit");
    private JButton finalizeBT = createStyledButton("Show Total");
    private JButton confirmBT = createStyledButton("Confirm");
    private JButton backToMainMenu = createStyledButton("Back");
    private JButton confirmBT2 = createStyledButton("Confirm");
    private JButton backToMainMenu2 = createStyledButton("Back");
    private JButton finalizeBT2 = createStyledButton("Show Total");

    private JLabel jl1 = new JLabel("Theatre Booking System");
    private JLabel jl2 = new JLabel("Selected Seat: ");
    private JLabel jl3 = new JLabel("Selected Seat: ");
    private JLabel selectedSeatLabel = new JLabel("None");
    private JLabel selectedSeatLabel2 = new JLabel("None");
    private JComboBox<String> theatreClass = createStyledComboBox(seatClasses);
    private JComboBox<String> theatreClass2 = createStyledComboBox(seatClasses);

    private Theatre mainTheatre = new Theatre();
    private int selectedSeatId = -1;
    private int selectedSeatId2 = -1;

    // Helper method to create styled buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 25));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    // Helper method to create styled combo boxes
    private JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBackground(PRIMARY_COLOR);
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        return comboBox;
    }

    public void updateSeatButtons() {
        // Update seat buttons in registration view
        updateClassSeatButtons(firstClassSeatsPanel, mainTheatre.FirstClass2dArr, "First Class", 0);
        updateClassSeatButtons(secondClassSeatsPanel, mainTheatre.SecondClass2dArr, "Second Class", 0);
        updateClassSeatButtons(thirdClassSeatsPanel, mainTheatre.ThirdClass2dArr, "Third Class", 0);

        // Update seat buttons in cancellation view
        updateClassSeatButtons(firstClassSeatsPanel2, mainTheatre.FirstClass2dArr, "First Class", 1);
        updateClassSeatButtons(secondClassSeatsPanel2, mainTheatre.SecondClass2dArr, "Second Class", 1);
        updateClassSeatButtons(thirdClassSeatsPanel2, mainTheatre.ThirdClass2dArr, "Third Class", 1);
    }

    private void updateClassSeatButtons(JPanel panel, JButton[][] buttonsArray, String classType, int mode) {
        panel.removeAll();
        int rows = buttonsArray.length;
        int cols = buttonsArray[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                JButton seatButton = new JButton();
                final int seatId = row * 5 + col + 1;
                seatButton.setText(Integer.toString(seatId));
                seatButton.setText("O");
                seatButton.setFont(new Font("Arial", Font.BOLD, 20));
                seatButton.setFocusPainted(true);
                seatButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                seatButton.setBorder(BorderFactory.createRaisedBevelBorder());

                if (buttonsArray[row][col].getText().equals("X")) {
                    seatButton.setBackground(SECONDARY_COLOR);
                    seatButton.setForeground(Color.WHITE);
                    seatButton.setText("X");
                } else {
                    seatButton.setBackground(PRIMARY_COLOR);
                    seatButton.setForeground(Color.WHITE);
                    seatButton.setText("O");
                }

                if (mode == 0) { // Register mode
                    seatButton.addActionListener(e -> {
                        selectedSeatId = seatId;
                        userSeatInput.setText(Integer.toString(selectedSeatId));
                        selectedSeatLabel.setText(Integer.toString(selectedSeatId));
                    });
                } else { // Cancel mode
                    seatButton.addActionListener(e -> {
                        selectedSeatId2 = seatId;
                        userSeatInput2.setText(Integer.toString(selectedSeatId2));
                        selectedSeatLabel2.setText(Integer.toString(selectedSeatId2));
                    });
                }
                panel.setBackground(SECONDARY_COLOR);
                panel.add(seatButton);
            }
        }
        panel.revalidate();
        panel.repaint();
    }

    public void showClassSeats(String classType) {
        if (classType.equals("First Class")) {
            seatsPanelLayout.show(seatsContainer, "First Class");
        } else if (classType.equals("Second Class")) {
            seatsPanelLayout.show(seatsContainer, "Second Class");
        } else {
            seatsPanelLayout.show(seatsContainer, "Third Class");
        }
    }

    public void showClassSeats2(String classType) {
        if (classType.equals("First Class")) {
            seatsPanelLayout2.show(seatsContainer2, "First Class");
        } else if (classType.equals("Second Class")) {
            seatsPanelLayout2.show(seatsContainer2, "Second Class");
        } else {
            seatsPanelLayout2.show(seatsContainer2, "Third Class");
        }
    }

    public TheatreGUIEditor() {
        mainTheatre.InitializeFirstClass2dArr(); // initialize the classes with 'O'
        mainTheatre.InitializeSecondClass2dArr();
        mainTheatre.InitializeThirdClass2dArr();

        // Set the app look and feel to be more modern

        // Setup seat panels
        seatPanels[0] = firstClassSeatsPanel;
        seatPanels[1] = secondClassSeatsPanel;
        seatPanels[2] = thirdClassSeatsPanel;

        seatPanels2[0] = firstClassSeatsPanel2;
        seatPanels2[1] = secondClassSeatsPanel2;
        seatPanels2[2] = thirdClassSeatsPanel2;

        // Add seat panels to containers with CardLayout
        seatsContainer.add(firstClassSeatsPanel, "First Class");
        seatsContainer.add(secondClassSeatsPanel, "Second Class");
        seatsContainer.add(thirdClassSeatsPanel, "Third Class");

        seatsContainer2.add(firstClassSeatsPanel2, "First Class");
        seatsContainer2.add(secondClassSeatsPanel2, "Second Class");
        seatsContainer2.add(thirdClassSeatsPanel2, "Third Class");

        // Set background colors for panels
        mainMenu.setBackground(SECONDARY_COLOR);
        contentPane.setBackground(BG_COLOR);
        registerCard.setBackground(BG_COLOR);
        cancelCard.setBackground(BG_COLOR);
        buttonWrappers.setBackground(BG_COLOR);
        buttonWrappers2.setBackground(BG_COLOR);
        backButtonWrappers.setBackground(BG_COLOR);
        backButtonWrappers2.setBackground(BG_COLOR);
        theatreSelectorWrapper.setBackground(BG_COLOR);
        theatreSelectorWrapper2.setBackground(BG_COLOR);
        seatsContainer.setBackground(BG_COLOR);
        seatsContainer2.setBackground(BG_COLOR);

        // Add padding to panels
        mainMenu.setBorder(new EmptyBorder(20, 20, 20, 20));
        registerCard.setBorder(new EmptyBorder(10, 10, 10, 10));
        cancelCard.setBorder(new EmptyBorder(10, 10, 10, 10));
        seatsContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
        seatsContainer2.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Initial update of seat buttons
        updateSeatButtons();

        this.add(contentPane);

        contentPane.add(mainMenu, "Menu");
        contentPane.add(registerCard, "Register");
        contentPane.add(cancelCard, "Cancel");

        // Style the header label
        jl1.setHorizontalAlignment(JLabel.CENTER);
        jl1.setForeground(Color.WHITE);
        jl1.setFont(new Font("Arial", Font.BOLD, 28));

        // Style the smaller labels
        jl2.setForeground(TEXT_COLOR);
        jl2.setFont(new Font("Arial", Font.BOLD, 14));
        jl3.setForeground(TEXT_COLOR);
        jl3.setFont(new Font("Arial", Font.BOLD, 14));
        selectedSeatLabel.setForeground(TEXT_COLOR);
        selectedSeatLabel.setFont(new Font("Arial", Font.BOLD, 14));
        selectedSeatLabel2.setForeground(TEXT_COLOR);
        selectedSeatLabel2.setFont(new Font("Arial", Font.BOLD, 14));

        buttonWrappers.add(jl2);
        buttonWrappers.add(selectedSeatLabel);
        buttonWrappers.add(confirmBT);
        backButtonWrappers.add(backToMainMenu);
        backButtonWrappers.add(finalizeBT);
        theatreSelectorWrapper.add(theatreClass);

        buttonWrappers2.add(jl3);
        buttonWrappers2.add(selectedSeatLabel2);
        buttonWrappers2.add(confirmBT2);
        backButtonWrappers2.add(backToMainMenu2);
        backButtonWrappers2.add(finalizeBT2);
        theatreSelectorWrapper2.add(theatreClass2);

        registerCard.add(backButtonWrappers, BorderLayout.NORTH);
        registerCard.add(theatreSelectorWrapper, BorderLayout.WEST);
        registerCard.add(buttonWrappers, BorderLayout.SOUTH);
        registerCard.add(seatsContainer, BorderLayout.CENTER);

        cancelCard.add(backButtonWrappers2, BorderLayout.NORTH);
        cancelCard.add(theatreSelectorWrapper2, BorderLayout.WEST);
        cancelCard.add(buttonWrappers2, BorderLayout.SOUTH);
        cancelCard.add(seatsContainer2, BorderLayout.CENTER);

        mainMenu.add(jl1);
        mainMenu.add(regBT);
        mainMenu.add(cancelBT);
        mainMenu.add(resetBT);
        mainMenu.add(exitBT);

        cardLayout.show(contentPane, "Menu");
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        theatreClass.addActionListener(e -> {
            String selectedClass = (String) theatreClass.getSelectedItem();
            showClassSeats(selectedClass);
        });

        theatreClass2.addActionListener(e -> {
            String selectedClass = (String) theatreClass2.getSelectedItem();
            showClassSeats2(selectedClass);
        });

        confirmBT.addActionListener(e -> {
            try {
                if (selectedSeatId == -1) {
                    showStyledMessage("Please select a seat first!");
                    return;
                }
                mainTheatre.Reservation(selectedSeatId, (String) theatreClass.getSelectedItem());
                updateSeatButtons();
                selectedSeatId = -1;
                selectedSeatLabel.setText("None");
            } catch (NumberFormatException | IndexOutOfBoundsException n) {
                showStyledMessage("Please enter a valid seat number!");
            } catch (Exception mm) {
                showStyledMessage("Seat already reserved!");
            }
        });

        confirmBT2.addActionListener(e -> {
            try {
                if (selectedSeatId2 == -1) {
                    showStyledMessage("Please select a seat first!");
                    return;
                }
                mainTheatre.CancelReservation(selectedSeatId2, (String) theatreClass2.getSelectedItem());
                updateSeatButtons();
                selectedSeatId2 = -1;
                selectedSeatLabel2.setText("None");
            } catch (NumberFormatException | IndexOutOfBoundsException n) {
                showStyledMessage("Please enter a valid seat number!");
            } catch (Exception mm) {
                showStyledMessage(mm.getMessage());
            }
        });

        resetBT.addActionListener(e -> {
            mainTheatre.ResetTheatreReservation();
            updateSeatButtons();
        });

        exitBT.addActionListener(e -> mainTheatre.Exit());

        finalizeBT.addActionListener(e -> {
            showStyledMessage("Your total is $" + mainTheatre.FinalPayment);
        });

        finalizeBT2.addActionListener(e -> {
            showStyledMessage("Your total is $" + mainTheatre.FinalPayment);
        });

        regBT.addActionListener(e -> {
            cardLayout.show(contentPane, "Register");
            showClassSeats((String) theatreClass.getSelectedItem());
        });

        backToMainMenu.addActionListener(e -> {
            cardLayout.show(contentPane, "Menu");
        });

        backToMainMenu2.addActionListener(e -> {
            cardLayout.show(contentPane, "Menu");
        });

        cancelBT.addActionListener(e -> {
            cardLayout.show(contentPane, "Cancel");
            showClassSeats2((String) theatreClass2.getSelectedItem());
        });
    }

    // Custom styled message dialog
    private void showStyledMessage(String message) {
        JOptionPane pane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog("Theatre System");
        dialog.setVisible(true);
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TheatreGUIEditor gui = new TheatreGUIEditor();
        });
    }
}
