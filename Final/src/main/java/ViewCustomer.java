package main.java;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ViewCustomer extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewCustomer frame = new ViewCustomer();
                frame.setVisible(true);
            }
        });
    }


    public ViewCustomer() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,700,550);
        setTitle("View Customer");
        getContentPane().setLayout(null);

        // Label Result
        final JLabel lblResult = new JLabel("Customer Details", JLabel.CENTER);
        lblResult.setFont(new Font("Calibri", Font.BOLD, 20));
        lblResult.setBounds(230, 30, 200, 30);
        getContentPane().add(lblResult);

        // Table
        JTable table = new JTable();
        getContentPane().add(table);

        // Table Model
        final DefaultTableModel model = (DefaultTableModel)table.getModel();

        // ScrollPane
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(80, 70, 500, 300);
        getContentPane().add(scroll);

        try{
            FileReader fr = new FileReader("customerList.txt");
            BufferedReader br = new BufferedReader(fr);

            // get the first line aka the columns name from the file, set columns name to the jTable Model
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(",");

            model.setColumnIdentifiers(columnsName);

            // get line from txt file
            Object[] tableLines = br.lines().toArray();

            // extract ata from lines, set data to jTable model
            for (int i = 0; i < tableLines.length ; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        JButton btnNewButton = new JButton("Back to Menu");
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.show();
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
        btnNewButton.setBounds(250, 400, 167, 37);
        getContentPane().add(btnNewButton);
    }
}

