package main.java;

import java.io.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Customer extends JFrame {

    private JPanel contentPane;
    private JTextField name;
    private JTextField id;
    private JTextField gender;
    private JTextField email;
    private JTextField contact;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Customer frame = new Customer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Customer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 620);
        setTitle("Add Customer");
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel customerDetails = new JLabel("Customer Details");
        customerDetails.setForeground(Color.BLACK);
        customerDetails.setFont(new Font("Calibri", Font.BOLD, 22));

        JLabel customerName = new JLabel("Customer Name");
        customerName.setForeground(Color.BLACK);
        customerName.setFont(new Font("Calibri", Font.BOLD, 14));

        JLabel customerId = new JLabel("Customer Id");
        customerId.setForeground(Color.BLACK);
        customerId.setFont(new Font("Calibri", Font.BOLD, 14));

        JLabel customerGender = new JLabel("Customer Gender");
        customerGender.setForeground(Color.BLACK);
        customerGender.setFont(new Font("Calibri", Font.BOLD, 14));

        JLabel emailAddress = new JLabel("Email Address");
        emailAddress.setForeground(Color.BLACK);
        emailAddress.setFont(new Font("Calibri", Font.BOLD, 14));

        JLabel contactNumber = new JLabel("Contact Number");
        contactNumber.setForeground(Color.BLACK);
        contactNumber.setFont(new Font("Calibri", Font.BOLD, 14));

        name = new JTextField();
        name.setColumns(10);

        id = new JTextField();
        id.setColumns(10);

        email = new JTextField();
        email.setColumns(10);

        contact = new JTextField();
        contact.setColumns(10);

        gender = new JTextField();
        gender.setColumns(10);

        JButton submit = new JButton("Submit");
        submit.setForeground(Color.BLACK);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(name.getText().isEmpty() | id.getText().isEmpty() | email.getText().isEmpty() | contact.getText().isEmpty() | gender.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill out all the text fields.");
                } else {
                    File file = new File("customerList.txt");

                    try {
                        if (file.createNewFile()) {
                            // file does not exist and has been created.
                            FileWriter fw = new FileWriter("customerList.txt", true);
                            // add file headers
                            fw.write("Name,Id,Email,Phone,Gender" + System.getProperty("line.separator"));
                            fw.close();
                        }
                        // file already exists
                        FileWriter fw = new FileWriter("customerList.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);
                        StringBuilder sb = new StringBuilder();

                        sb.append(name.getText() + "," + id.getText() + "," + email.getText() + "," + contact.getText() + "," + gender.getText());
                        pw.println(sb);
                        pw.flush();
                        pw.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        submit.setFont(new Font("Calibri", Font.BOLD, 14));


        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.GRAY);

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

        JDesktopPane desktopPane_1 = new JDesktopPane();
        desktopPane_1.setBackground(Color.GRAY);

        JDesktopPane desktopPane_2 = new JDesktopPane();
        desktopPane_2.setBackground(Color.GRAY);

        JDesktopPane desktopPane_3 = new JDesktopPane();
        desktopPane_3.setBackground(Color.GRAY);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(desktopPane_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(43)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(customerId)
                                                        .addComponent(customerName, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                                        .addComponent(customerGender)
                                                        .addComponent(emailAddress)
                                                        .addComponent(contactNumber))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(contact, 242, 242, 242)
                                                        .addComponent(gender, 247, 247, 247)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                .addComponent(email)
                                                                .addComponent(name)
                                                                .addComponent(id, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                                                .addGap(34))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                                .addComponent(customerDetails)
                                                .addGap(137))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(119)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(submit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                                                .addGap(128)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(desktopPane_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                .addGap(18))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                .addGap(11)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(customerDetails)
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(customerName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(name, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                                .addGap(28)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(id, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(customerId))
                                                .addGap(41)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(emailAddress))
                                                .addGap(37)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(contactNumber)
                                                        .addComponent(contact, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                                .addGap(41)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(gender, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(customerGender))
                                                .addGap(43)
                                                .addComponent(submit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(desktopPane_2, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(desktopPane_3, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                .addGap(13)
                                .addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(6))
        );
        contentPane.setLayout(gl_contentPane);
    }
}