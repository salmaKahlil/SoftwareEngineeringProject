package frontend;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

import compute_engine.ComputeEngine;
import io.grpc.ManagedChannel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import software.project.ComputeEngineClient;
import software.project.ComputeMessage;

public class Application extends JFrame {

    private static String delimiter;
    private static String outputFileName;
    private static String inputFilePath;
    private static String digit;
    private static ComputeEngine.ComputeResponse result;

    private JButton startButton;
    private String[] options = {"Upload File", "Type Numbers"};
    private JButton computeButton;


    public Application() {
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
            inputFilePath = selectedFile.getAbsolutePath();
            showDigitDialog();
        }

    }

    private void showTypeNumbersDialog() {
        JTextArea inputTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(inputTextArea);
        int result = JOptionPane.showConfirmDialog(null, scrollPane, "Enter numbers (separate by line)", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String input = inputTextArea.getText();
            String[] lines = input.split("\\n");
            inputFilePath = "./src/software/project/test.txt";
            for (String line : lines) {
                try {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFilePath, true))) {
                        writer.write(line);
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input: " + line);
                    return;
                }
            }

            showDigitDialog();
        }
    }



    private void processDigitInput() {

        outputFileName = JOptionPane.showInputDialog(null, "Enter output file name:");

        if (outputFileName == null || outputFileName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Output file name is required!");
            return;
        }
        showDelimiterDialog();

    }


    private void showDelimiterDialog() {

        delimiter = JOptionPane.showInputDialog(null, "Enter delimiter (leave blank for none):");
        System.out.println(delimiter);
        if (delimiter == null) {
            delimiter = ";";
        }
        showComputeButton();

    }
    private void showDigitDialog() {

        digit = JOptionPane.showInputDialog(null, "Enter The Digit of Interest: ");

        if (digit == null || digit.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A digit is required!");
            return;
        }else if(Integer.valueOf(digit) > 9 || Integer.valueOf(digit) < 1) {
            JOptionPane.showMessageDialog(null, "Digit must be between 1 and 9 ");
            return;
        }
        processDigitInput();

    }

    private void showComputeButton() {
        computeButton = new JButton("Compute");
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComputeEngine.ComputeResponse result = startComputing();
                System.out.println(result);


                JOptionPane.showMessageDialog(null, "The computation has been a SUCCESS");
                System.exit(0);
            }



        });

        add(computeButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    private ComputeEngine.ComputeResponse startComputing() {
        String target = "localhost:50052";

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();

        try {
            ComputeEngineClient client = new ComputeEngineClient(channel);
            ComputeEngine.ComputeResponse result = client.compute(inputFilePath, outputFileName, delimiter, Integer.valueOf(digit));
        } finally {
            try {
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Application();
            }
        });



    }
}
