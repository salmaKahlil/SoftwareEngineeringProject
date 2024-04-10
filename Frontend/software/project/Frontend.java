import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Frontend extends JFrame {
    private JButton startButton;
    private String[] options = {"Upload File", "Type Numbers"};
    
    public Frontend() {
        setTitle("Number Computation");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showOptionDialog();
            }
        });
        
        add(startButton, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private void showOptionDialog() {
        JComboBox<String> optionBox = new JComboBox<>(options);
        int result = JOptionPane.showConfirmDialog(null, optionBox, "Choose an option", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            String selectedOption = (String) optionBox.getSelectedItem();
            if (selectedOption.equals(options[0])) {
                showUploadFileDialog();
            } else { 
                showTypeNumbersDialog();
            }
        }
    }
    
    private void showUploadFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            processInputFile(selectedFile.getAbsolutePath());
        }
    }
    
    private void showTypeNumbersDialog() {
        JTextArea inputTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(inputTextArea);
        int result = JOptionPane.showConfirmDialog(null, scrollPane, "Enter numbers (separate by line)", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            String input = inputTextArea.getText();
            processInputNumbers(input);
        }
    }
    
    private void processInputFile(String filePath) {
        String outputFilePath = JOptionPane.showInputDialog(null, "Enter output file name:");
        if (outputFilePath == null || outputFilePath.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Output file name is required!");
            return;
        }
        String delimiter = showDelimiterDialog();
        //computeFromFile(filePath, outputFilePath, delimiter);
    }
    
    private void processInputNumbers(String input) {
        String outputFilePath = JOptionPane.showInputDialog(null, "Enter output file name:");
        if (outputFilePath == null || outputFilePath.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Output file name is required!");
            return;
        }
        String delimiter = showDelimiterDialog();
        //computeFromNumbers(input, outputFilePath, delimiter);
    }
    
    private String showDelimiterDialog() {
        String delimiter = JOptionPane.showInputDialog(null, "Enter delimiter (leave blank for none):");
        if (delimiter == null) {
            delimiter = ";"; 
        }
        return delimiter;

    }
    
                /*******************************TO BE FURTHER EDITED*********************************/

    // private void computeFromFile(String inputFilePath, String outputFilePath, String delimiter) {
    //     // ArrayList<Integer> numbers = new ArrayList<>();
        
    //     // try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
    //     //     String line;
    //     //     while ((line = reader.readLine()) != null) {
    //     //         try {
    //     //             int number = Integer.parseInt(line.trim());
    //     //             numbers.add(number);
    //     //         } catch (NumberFormatException ex) {
    //     //             JOptionPane.showMessageDialog(null, "Invalid input in file: " + line);
    //     //             return;
    //     //         }
    //     //     }
    //     // } catch (IOException ex) {
    //     //     JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage());
    //     //     return;
    //     }

        
    //     try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
    //     //     for (int num : numbers) {
    //     //         writer.write(Integer.toString(num));
    //     //         writer.newLine();
    //     //     }
    //     //     JOptionPane.showMessageDialog(null, "Computation completed. Sum: " + sum);
    //     // } catch (IOException ex) {
    //     //     JOptionPane.showMessageDialog(null, "Error writing output file: " + ex.getMessage());
    //     //     return;
    //     // }
    // }
    
    // private void computeFromNumbers(String input, String outputFilePath, String delimiter) {
    //     // ArrayList<Integer> numbers = new ArrayList<>();
    //     // String[] lines = input.split("\\n");
        
    //     // for (String line : lines) {
    //     //     try {
    //     //         int number = Integer.parseInt(line.trim());
    //     //         numbers.add(number);
    //     //     } catch (NumberFormatException ex) {
    //     //         JOptionPane.showMessageDialog(null, "Invalid input: " + line);
    //     //         return;
    //     //     }
    //     }
        

        
    // //     try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
    // //         writer.write(Integer.toString(sum));
    // //         JOptionPane.showMessageDialog(null, "Computation completed.");
    // //     } catch (IOException ex) {
    // //         JOptionPane.showMessageDialog(null, "Error writing output file: " + ex.getMessage());
    // //         return;
    // //     }
    // // }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frontend();
            }
        });
    }
}

