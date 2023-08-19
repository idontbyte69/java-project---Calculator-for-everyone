import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CalculatorGUI {
    String fileName = "file.txt";
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> calculatorComboBox;
    private JButton calculateButton;

    public CalculatorGUI() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 3));

        JLabel titleLabel = new JLabel("CALCULATOR FOR EVERYONE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        calculatorComboBox = new JComboBox<>();
        calculatorComboBox.addItem("Select");
        calculatorComboBox.addItem("Basic Math");
        calculatorComboBox.addItem("Formula");
        calculatorComboBox.addItem("Medical Field");
        panel.add(calculatorComboBox);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateButtonClicked();
            }
        });
        panel.add(calculateButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void calculateButtonClicked() {
        String selectedOption = (String) calculatorComboBox.getSelectedItem();
        switch (selectedOption) {
            case "Select":
                JOptionPane.showMessageDialog(frame, "Invalid option\nSelect from the given options");
                break;
            case "Basic Math":
                showBasicMathOptions();
                break;
            case "Formula":
                showFormula();
                break;
            case "Medical Field":
                showMedicalFieldOptions();
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Invalid Option");
                break;
        }
    }
    private void showBasicMathOptions() {
        Object[] options = {"Select","Addition", "Subtraction", "Multiplication", "Division", "Modulus", "Power", "Factorial"};
        String selectedOption = (String) JOptionPane.showInputDialog(frame, "Choose an option:", "Basic Math", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            switch (selectedOption) {
                case "Select":
                    JOptionPane.showMessageDialog(frame, "Invalid option\nSelect from the given options");
                    break;
                case "Addition":
                    performAddition();
                    break;
                case "Subtraction":
                    performSubtraction();
                    break;
                case "Multiplication":
                    performMultiplication();
                    break;
                case "Division":
                    performDivision();
                    break;
                case "Modulus":
                    performModulus();
                    break;
                case "Power":
                    performPower();
                    break;
                case "Factorial":
                    performFactorial();
                    break;
            }
        }
    }

    private void performAddition() {
        int n = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of elements you want to add:"));
        int total = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number " + (i + 1) + ":"));
            total += number;
        }
        JOptionPane.showMessageDialog(frame, "Sum of " + n + " numbers = " + total);
        appendToFile("file.txt", "Addition = " + Integer.toString(total));
    }

    private void performSubtraction() {
        int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the first number:"));
        int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the second number:"));
        int result = a - b;
        JOptionPane.showMessageDialog(frame, a + " - " + b + "=" + result);
        appendToFile("file.txt", "Subtraction = " + Integer.toString(result));
    }

    private void performMultiplication() {
        int n = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of elements you want to multiply:"));
        int total = 1;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number " + (i + 1) + ":"));
            total *= number;
        }
        JOptionPane.showMessageDialog(frame, "Product of " + n + " numbers = " + total);
        appendToFile("file.txt", "Multiplication = " + Integer.toString(total));
    }

    private void performDivision() {
        int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the dividend:"));
        int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the divisor:"));
        if (b != 0) {
            double result = (double) a / b;
            JOptionPane.showMessageDialog(frame, a + " / " + b + " = " + result);
            appendToFile("file.txt", "Division = " + Double.toString(result));
        } else {
            JOptionPane.showMessageDialog(frame, "Cannot divide by zero!");
            appendToFile("file.txt", "Arithmetic Exception-> Divided by Zero(0)" );
        }
    }

    private void performModulus() {
        int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the first number:"));
        int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the second number:"));
        int result = a % b;
        JOptionPane.showMessageDialog(frame, a + " % " + b + " = " + result);
        appendToFile("file.txt", "Modulus = " + Integer.toString(result));
    }

    private void performPower() {
        double base = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter the base number:"));
        double exponent = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter the exponent:"));
        double result = Math.pow(base, exponent);
        JOptionPane.showMessageDialog(frame, base + " ^ " + exponent + " = " + result);
        appendToFile("file.txt", "Power = " + Double.toString(result));

    }

    private void performFactorial() {
        int n = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter a positive integer:"));
        if (n >= 0) {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            JOptionPane.showMessageDialog(frame, n + "! = " + result);
            appendToFile("file.txt", "Factorial = " + Integer.toString(result));
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid input! Factorial is defined only for non-negative integers.");
            appendToFile("file.txt", "Invalid input! Factorial is defined only for non-negative integers.");
        }
    }

    private void showFormula() {
        Object[] options = {"Select","Area", "Volume"};
        String selectedOption = (String) JOptionPane.showInputDialog(frame, "Choose an option:", "Formula", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            switch (selectedOption) {
                case "Select":
                    JOptionPane.showMessageDialog(frame, "Invalid option\nSelect from the given options");
                    break;
                case "Area":
                    performArea();
                    break;
                case "Volume":
                    performVolume();
                    break;
            }
        }
    }
    private void performArea() {
        Object[] options = {"Select","Square", "Rectangle", "Triangle", "Circle"};
        String selectedOption = (String) JOptionPane.showInputDialog(frame, "Choose an option:", "Shapes for Area", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            switch (selectedOption) {
                case "Select":
                    JOptionPane.showMessageDialog(frame, "Invalid option\nSelect from the given options");
                    break;
                case "Square":
                    performAreaOfSquare();
                    break;
                case "Rectangle":
                    performAreaOfRectangle();
                    break;
                case "Triangle":
                    performAreaOfTriangle();
                    break;
                case "Circle":
                    performAreaOfCircle();
                    break;

            }
        }
    }
    private void performAreaOfSquare(){
        double a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the length of the Side:"));
        double result = a*a;
        JOptionPane.showMessageDialog(frame, "The area of the Square (Side * Side) = " + result);
        appendToFile("file.txt", "Area of Square = " + Double.toString(result));

    }
    private void performAreaOfRectangle(){
        double a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the Width:"));
        double b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the Length:"));
        double result = a*b;
        JOptionPane.showMessageDialog(frame, "The area of the Rectangle (Width * Length) = " + result);
        appendToFile("file.txt", "Area of Rectangle = " + Double.toString(result));
    }
private void performAreaOfTriangle(){
    double a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the Base:"));
    double b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the Height:"));
    double result = 0.5*a*b;
    JOptionPane.showMessageDialog(frame, "The area of the Triangle (0.5 * Base * Height)= " + result);
    appendToFile("file.txt", "Area of Triangle = " + Double.toString(result));
}
private void performAreaOfCircle(){
    double a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the Radius:"));
    double result = 3.1416*a*a;
    JOptionPane.showMessageDialog(frame, "PI = 3.1416\nThe area of the Triangle (PI * (Radius * Radius))= " + result);
    appendToFile("file.txt", "Area of Circle = " + Double.toString(result));

}

    private void performVolume() {
        Object[] options = {"Select","Square", "Rectangle", "Triangle", "Circle"};
        String selectedOption = (String) JOptionPane.showInputDialog(frame, "Choose an option:", "Shapes for Volume", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            switch (selectedOption) {
                case "Select":
                    JOptionPane.showMessageDialog(frame, "Invalid option\nSelect from the given options");
                    break;
                case "Square", "Rectangle", "Triangle", "Circle":
                    JOptionPane.showMessageDialog(frame, "Sorry!\nThe formula haven't added yet...");
                    break;
            }
        }
    }

    private void showMedicalFieldOptions() {
        Object[] options = {"Select","BMR", "Calorie Need"};
        String selectedOption = (String) JOptionPane.showInputDialog(frame, "Choose an option:", "Formula", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            switch (selectedOption) {
                case "Select":
                    JOptionPane.showMessageDialog(frame, "Invalid option\nSelect from the given options");
                    break;
                case "BMR":
                    showBMR();
                    break;
                case "Calorie Need":
                    showCalNeed();
                    break;
            }
        }
    }
    private void showBMR() {
        Object[] options = {"Select","BMR for Men", "BMR for Women"};
        String selectedOption = (String) JOptionPane.showInputDialog(frame, "Select your Gender:", "Formula", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            switch (selectedOption) {
                case "Select":
                    JOptionPane.showMessageDialog(frame, "Invalid option\nSelect from the given options");
                    break;
                case "BMR for Men":
                    performABMRForMen();
                    break;
                case "BMR for Women":
                    performABMRForWomen();
                    break;
            }
        }
    }
    private void performABMRForMen(){
        double a = Integer.parseInt(JOptionPane.showInputDialog(frame, "For calculating BMR you need to give some value: \nWeight(kg) = "));
        double b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Height(cm) = "));
        double c = Integer.parseInt(JOptionPane.showInputDialog(frame, "Age(year) = "));
        double result = 66.5 + (13.75 * a) + (5.003 * b) - (6.75 * c);
        JOptionPane.showMessageDialog(frame, "BMR = " + result);
        appendToFile("file.txt", "BMR counted for the Men user = " + Double.toString(result));
    }
    private void performABMRForWomen(){
        double a = Integer.parseInt(JOptionPane.showInputDialog(frame, "For calculating BMR you need to give some value: \nWeight(kg) = "));
        double b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Height(cm) = "));
        double c = Integer.parseInt(JOptionPane.showInputDialog(frame, "Age(year) = "));
        double result = 655.1 + (9.563 * a) + (1.850 * b) - (4.676 * c);
        JOptionPane.showMessageDialog(frame, "BMR = " + result);
        appendToFile("file.txt", "BMR counted for the Women user = " + Double.toString(result));
    }
    private void showCalNeed(){
        Object[] options = {"Select","Calorie need for Men", "Calorie need for Women"};
        String selectedOption = (String) JOptionPane.showInputDialog(frame, "Select your Gender:", "Formula", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            switch (selectedOption) {
                case "Select":
                    JOptionPane.showMessageDialog(frame, "Invalid option\nSelect from the given options");
                    break;
                case "Calorie need for Men":
                    performCalNeedForMen();
                    break;
                case "Calorie need for Women":
                    performCalNeedForWomen();
                    break;
            }
        }
    }
    private void performCalNeedForMen(){
        double a = Integer.parseInt(JOptionPane.showInputDialog(frame, "For calculating  you need to give some value: \nWeight(kg) = "));
        double b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Height(cm) = "));
        double c = Integer.parseInt(JOptionPane.showInputDialog(frame, "Age(year) = "));
        double result = 66.5 + (13.75 * a) + (5.003 * b) - (6.75 * c);
        Object[] options = {"Select","Light/No Exercise", "Light Exercise/Sports 1-3 Days/Week","Moderate Exercise/Sports 3-5 Days/Week","Hard exercise/Sports 6-7 Days/Week","Very Hard Exercise/Sports & Physical Job"};
        String selectedOption = (String) JOptionPane.showInputDialog(frame, "Select your suitable option:", "Activity Factor", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            switch (selectedOption) {
                case "Select":
                    JOptionPane.showMessageDialog(frame, "Invalid option\nSelect from the given options");
                    break;
                case "Light/No Exercise":
                    JOptionPane.showMessageDialog(frame, "Calorie you need: "+result*1.2);
                    appendToFile("file.txt", "Calorie need for the Men user who do Light/No = " + Double.toString(result));
                    break;
                case "Light Exercise/Sports 1-3 Days/Week":
                    JOptionPane.showMessageDialog(frame, "Calorie you need: "+result*1.375);
                    appendToFile("file.txt", "Calorie need for the Men user who do Light Exercise/Sports 1-3 Days/Week = " + Double.toString(result));
                    break;
                case "Moderate Exercise/Sports 3-5 Days/Week":
                    JOptionPane.showMessageDialog(frame, "Calorie you need: "+result*1.55);
                    appendToFile("file.txt", "Calorie need for the Men user who do Moderate Exercise/Sports 3-5 Days/Week = " + Double.toString(result));
                    break;
                case "Hard exercise/Sports 6-7 Days/Week":
                    JOptionPane.showMessageDialog(frame, "Calorie you need: "+result*1.725);
                    appendToFile("file.txt", "Calorie need for the Men user who do Hard exercise/Sports 6-7 Days/Week = " + Double.toString(result));
                    break;
                case "Very Hard Exercise/Sports & Physical Job":
                    JOptionPane.showMessageDialog(frame, "Calorie you need: "+result*1.9);
                    appendToFile("file.txt", "Calorie need for the Men user who do Very Hard Exercise/Sports & Physical Job = " + Double.toString(result));
                    break;
            }
        }
    }
    private void performCalNeedForWomen(){
        double a = Integer.parseInt(JOptionPane.showInputDialog(frame, "For calculating  you need to give some value: \nWeight(kg) = "));
        double b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Height(cm) = "));
        double c = Integer.parseInt(JOptionPane.showInputDialog(frame, "Age(year) = "));
        double result = 655.1 + (9.563 * a) + (1.850 * b) - (4.676 * c);
        Object[] options = {"Select","Light/No Exercise", "Light Exercise/Sports 1-3 Days/Week","Moderate Exercise/Sports 3-5 Days/Week","Hard exercise/Sports 6-7 Days/Week","Very Hard Exercise/Sports & Physical Job"};
        String selectedOption = (String) JOptionPane.showInputDialog(frame, "Select your suitable option:", "Activity Factor", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {
            switch (selectedOption) {
                case "Select":
                    JOptionPane.showMessageDialog(frame, "Invalid option\nSelect from the given options");
                    break;
                case "Light/No Exercise":
                    JOptionPane.showMessageDialog(frame, "Calorie you need: "+result*1.2);
                    appendToFile("file.txt", "Calorie need for the Women user who do Light/No = " + Double.toString(result));
                    break;
                case "Light Exercise/Sports 1-3 Days/Week":
                    JOptionPane.showMessageDialog(frame, "Calorie you need: "+result*1.375);
                    appendToFile("file.txt", "Calorie need for the Women user who do Light Exercise/Sports 1-3 Days/Week = " + Double.toString(result));
                    break;
                case "Moderate Exercise/Sports 3-5 Days/Week":
                    JOptionPane.showMessageDialog(frame, "Calorie you need: "+result*1.55);
                    appendToFile("file.txt", "Calorie need for the Women user who do Moderate Exercise/Sports 3-5 Days/Week = " + Double.toString(result));
                    break;
                case "Hard exercise/Sports 6-7 Days/Week":
                    JOptionPane.showMessageDialog(frame, "Calorie you need: "+result*1.725);
                    appendToFile("file.txt", "Calorie need for the Women user who do Hard exercise/Sports 6-7 Days/Week = " + Double.toString(result));
                    break;
                case "Very Hard Exercise/Sports & Physical Job":
                    JOptionPane.showMessageDialog(frame, "Calorie you need: "+result*1.9);
                    appendToFile("file.txt", "Calorie need for the Women user who do Very Hard Exercise/Sports & Physical Job = " + Double.toString(result));
                    break;
            }
        }
    }
    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
    public static void appendToFile(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(getCurrentDateTime() + " -->>  " + data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorGUI();
            }
        });
    }
}



