package frontend;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
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
        inputFilePath = filePath;
        outputFileName = JOptionPane.showInputDialog(null, "Enter output file name:");
        System.out.println(outputFileName);
        if (outputFileName == null || outputFileName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Output file name is required!");
            return;
        }
        showDelimiterDialog();

    }

    private void processInputNumbers(String input) {

        outputFileName = JOptionPane.showInputDialog(null, "Enter output file name:");

        if (outputFileName == null || outputFileName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Output file name is required!");
            return;
        }
        showDelimiterDialog();

    }


    private String showDelimiterDialog() {

        delimiter = JOptionPane.showInputDialog(null, "Enter delimiter (leave blank for none):");
        System.out.println(delimiter);
        if (delimiter == null) {
            delimiter = ";";
        }
        showComputeButton();
        return delimiter;

    }
    private void showComputeButton() {
        computeButton = new JButton("Compute");
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComputeEngine.ComputeResponse result = startComputing();
                System.out.println(result);


                JOptionPane.showMessageDialog(null, "The computation has been a " + result);
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
            ComputeEngine.ComputeResponse result = client.compute(inputFilePath, outputFileName, delimiter);
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
