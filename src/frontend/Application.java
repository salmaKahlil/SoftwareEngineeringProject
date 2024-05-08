package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import io.grpc.ManagedChannel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import software.project.ComputeEngineClient;

public class Application extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTextArea numbersTextArea;
    private JTextField fileNameTextField;
    private JTextField delimiterTextField;
    private static String delimiter;
    private static String outputFileName;
    private static String inputFilePath;

    public Application() {
        setTitle("File Input/Output GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Welcome panel
        JPanel welcomePanel = new JPanel(new GridLayout(3, 1));
        JLabel welcomeLabel = new JLabel("Welcome! Please choose an option:");
        JButton uploadFileButton = new JButton("Upload a File");
        JButton typeNumbersButton = new JButton("Type Numbers");
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(uploadFileButton);
        welcomePanel.add(typeNumbersButton);

        // Panel to upload file
        JPanel uploadFilePanel = new JPanel(new GridLayout(3, 1));
        JButton browseButton = new JButton("Browse");
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // Show file path in a dialog
                    JOptionPane.showMessageDialog(null, "Selected File: " + fileChooser.getSelectedFile().getAbsolutePath());
                    inputFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                }
            }
        });
        JButton uploadButton = new JButton("Upload");
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "enterFileNamePanel");
            }
        });
        uploadFilePanel.add(new JLabel("Upload a File"));
        uploadFilePanel.add(browseButton);
        uploadFilePanel.add(uploadButton);

        // Panel to type numbers
        JPanel typeNumbersPanel = new JPanel(new BorderLayout());
        numbersTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(numbersTextArea);
        JButton submitNumbersButton = new JButton("Submit");
        submitNumbersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "enterFileNamePanel");
            }
        });
        typeNumbersPanel.add(new JLabel("Type Numbers (comma-separated):"), BorderLayout.NORTH);
        typeNumbersPanel.add(scrollPane, BorderLayout.CENTER);
        typeNumbersPanel.add(submitNumbersButton, BorderLayout.SOUTH);

        // Panel to enter file name
        JPanel enterFileNamePanel = new JPanel(new BorderLayout());
        fileNameTextField = new JTextField(20);
        JButton submitFileNameButton = new JButton("Submit");
        submitFileNameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "enterDelimiterPanel");
            }
        });
        enterFileNamePanel.add(new JLabel("Enter File Name:"), BorderLayout.NORTH);
        enterFileNamePanel.add(fileNameTextField, BorderLayout.CENTER);
        enterFileNamePanel.add(submitFileNameButton, BorderLayout.SOUTH);

        // Panel to enter delimiter
        JPanel enterDelimiterPanel = new JPanel(new BorderLayout());
        delimiterTextField = new JTextField(20);
        JButton submitDelimiterButton = new JButton("Submit");
        submitDelimiterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delimiter = delimiterTextField.getText();
                outputFileName = fileNameTextField.getText();
            }
        });
        enterDelimiterPanel.add(new JLabel("Enter Delimiter (Optional):"), BorderLayout.NORTH);
        enterDelimiterPanel.add(delimiterTextField, BorderLayout.CENTER);
        enterDelimiterPanel.add(submitDelimiterButton, BorderLayout.SOUTH);

        cardPanel.add(welcomePanel, "welcomePanel");
        cardPanel.add(uploadFilePanel, "uploadFilePanel");
        cardPanel.add(typeNumbersPanel, "typeNumbersPanel");
        cardPanel.add(enterFileNamePanel, "enterFileNamePanel");
        cardPanel.add(enterDelimiterPanel, "enterDelimiterPanel");

        add(cardPanel);

        uploadFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "uploadFilePanel");
            }
        });

        typeNumbersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "typeNumbersPanel");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        String target = "localhost:50052";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            ComputeEngineClient client = new ComputeEngineClient(channel); // Boilerplate TODO: update to this class name
            client.compute(inputFilePath,outputFileName);
        } finally {
            try {
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Application();
            }
        });
    }
}
