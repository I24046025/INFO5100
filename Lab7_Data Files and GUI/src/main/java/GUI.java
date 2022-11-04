package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI extends JFrame implements ActionListener {

    // file name for reading
    private String readFileName;

    // user input file name for writing
    private JTextField writeFileName;

    // text areas for reading and writing file
    private JTextArea readArea, writeArea;

    // create a scroll pane
    private JScrollPane readScrollPane, writeScrollPane;

    // label of reading file name
    private JLabel labelReadFile, labelReadFileName;

    // label of writing file name
    private JLabel labelWriteFile;

    // button of read and write from file
    private JButton btnRead, btnWrite;

    // read the file and save the contents in data variable
    private List<String> data = null;

    public GUI(String readFileName){
        this.readFileName = readFileName;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(870, 400);
        this.setTitle("Data Files and GUI");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // create text areas
        readArea = new JTextArea();
        readArea.setBounds(10, 160, 400, 200);
        readScrollPane = new JScrollPane(readArea);
        readScrollPane.setBounds(10, 160, 400, 200);
        this.add(readScrollPane);

        writeArea = new JTextArea();
        writeArea.setBounds(450, 160, 400, 200);
        writeScrollPane = new JScrollPane(writeArea);
        writeScrollPane.setBounds(450, 160, 400, 200);
        this.add(writeScrollPane);

        // create reading file labels
        labelReadFile = new JLabel("Reading File Name");
        labelReadFile.setForeground(Color.BLUE);
        labelReadFile.setBounds(10, 5, 200, 50);
        this.add(labelReadFile);

        labelReadFileName = new JLabel("annual.csv");
        labelReadFileName.setForeground(Color.BLUE);
        labelReadFileName.setBounds(25, 25, 200, 50);
        this.add(labelReadFileName);

        // create writing file labels
        labelWriteFile = new JLabel("Writing File Name");
        labelWriteFile.setForeground(Color.BLUE);
        labelWriteFile.setBounds(450, 5, 200, 50);
        this.add(labelWriteFile);

        writeFileName = new JTextField("output.csv");
        writeFileName.setForeground(Color.BLUE);
        writeFileName.setBounds(450, 40, 190, 40);
        this.add(writeFileName);

        // create buttons
        btnRead = new JButton("Click to Read From File");
        btnRead.setForeground(Color.BLUE);
        btnRead.setBackground(Color.RED);
        btnRead.setOpaque(true);
        btnRead.setBorderPainted(false);
        btnRead.setBounds(10, 80, 190, 50);
        btnRead.addActionListener(this);
        this.add(btnRead);

        btnWrite = new JButton("Click to Write to File");
        btnWrite.setForeground(Color.BLUE);
        btnWrite.setBackground(Color.RED);
        btnWrite.setOpaque(true);
        btnWrite.setBorderPainted(false);
        btnWrite.setBounds(450, 80, 190, 50);
        btnWrite.addActionListener(this);
        this.add(btnWrite);

        // show the frame
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // set the csv file name to be read
        FlatFile flatFile = new FlatFile();
        flatFile.setReadFileName(readFileName);

        // read the csv file
        String readFileName = flatFile.getReadFileName();

        StringBuilder stringBuilder = new StringBuilder();

        // if read file button is triggered, else write file button is triggered...
        if (e.getSource() == btnRead){
            data = flatFile.readFile(readFileName);

            // print the first five rows and headers of reading file
            int i = 0;
            for (String s : data) {
                if (i > 5){
                    break;
                }
                stringBuilder.append(s + "\n");
                i += 1;
            }
            readArea.setText(String.valueOf(stringBuilder));
        } else if (e.getSource() == btnWrite){
            flatFile.setOutputFileName(writeFileName.getText());
            flatFile.writeFile(flatFile.getOutputFileName(), data);

            if (data != null){

                // print the first five rows and headers of writing file
                for (int row = 0; row < 6; row++) {
                    // write only the first three fields
                    String[] values = data.get(row).split(",");

                    // clear stringBuilder
                    for(int j = 0; j < 3; j++) {
                        stringBuilder.append(values[j]);
                        if( j != 2) { // the last one value doesn't need a comma
                            stringBuilder.append(",");
                        }
                    }
                    stringBuilder.append("\n");
                }
                writeArea.setText(String.valueOf(stringBuilder));
            }
        }

        // clear stringBuilder
        stringBuilder.setLength(0);
    }
}