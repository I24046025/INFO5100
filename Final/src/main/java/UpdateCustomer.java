package main.java;

import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.io.*;
import java.util.Scanner;

public class UpdateCustomer extends JFrame {
    private JPanel contentPane;
    private JTextField updateId;
    private JTextField name;
    private JTextField id;
    private JTextField email;
    private JTextField contact;
    private JTextField gender;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateCustomer frame = new UpdateCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UpdateCustomer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 676, 656);
        setTitle("Update Existing Customer");
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.GRAY);

        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 16));

        JLabel lblNewLabel_1_1 = new JLabel("Id");
        lblNewLabel_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 16));

        JLabel lblNewLabel_1_2 = new JLabel("Gender");
        lblNewLabel_1_2.setForeground(Color.BLACK);
        lblNewLabel_1_2.setFont(new Font("Calibri", Font.BOLD, 16));

        JLabel lblNewLabel_1_3 = new JLabel("Email");
        lblNewLabel_1_3.setForeground(Color.BLACK);
        lblNewLabel_1_3.setFont(new Font("Calibri", Font.BOLD, 16));

        JLabel lblNewLabel_1_4 = new JLabel("Phone");
        lblNewLabel_1_4.setForeground(Color.BLACK);
        lblNewLabel_1_4.setFont(new Font("Calibri", Font.BOLD, 16));

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

        JButton updateBtn = new JButton("Update");
        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(updateId.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter a customer id.");
                } else if (name.getText().isEmpty() | id.getText().isEmpty() | email.getText().isEmpty() | contact.getText().isEmpty() | gender.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill out all the text fields.");
                } else {
                    String tempFile = "temp.txt";
                    File oldFile = new File("customerList.txt");
                    File newFile = new File(tempFile);

                    String tempName = "";
                    String tempId = "";
                    String tempEmail = "";
                    String tempContact = "";
                    String tempGender = "";

                    boolean found = false;

                    try {
                        FileWriter fw = new FileWriter(tempFile, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        Scanner sc = new Scanner(new File("customerList.txt"));
                        sc.useDelimiter("[,\n]");

                        while(sc.hasNext()) {
                            tempName = sc.next();
                            tempId = sc.next();
                            tempEmail = sc.next();
                            tempContact = sc.next();
                            tempGender = sc.next();

                            if(tempId.equals(updateId.getText())) {
                                // found the deleted target
                                found = true;
                                pw.println(name.getText() + "," + id.getText() + "," + email.getText() + "," + contact.getText() + "," + gender.getText());
                            } else {
                                pw.println(tempName + "," + tempId + "," + tempEmail + "," + tempContact + "," + tempGender);
                            }
                        }
                        sc.close();
                        pw.flush();
                        pw.close();
                        oldFile.delete();
                        File dump = new File("customerList.txt");
                        newFile.renameTo(dump);

                        if(found) {
                            JOptionPane.showMessageDialog(null, "Updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Customer not found.");
                        }
                    }
                    catch(Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        });
        updateBtn.setForeground(Color.BLACK);
        updateBtn.setFont(new Font("Calibri", Font.BOLD, 14));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 647, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(127)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_1)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(ComponentPlacement.RELATED, 383, Short.MAX_VALUE)))
                                                .addGap(22))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(id, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(name, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(contact, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gender, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
                                .addGap(114))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(261)
                                .addComponent(updateBtn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(261, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                                .addGap(27)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(name, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                .addGap(27)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(id, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                .addGap(26)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                .addGap(29)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(contact, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                .addGap(27)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(gender, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(updateBtn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        updateId = new JTextField();
        updateId.setBounds(190, 100, 237, 33);
        desktopPane.add(updateId);
        updateId.setColumns(10);

        JButton btnNewButton = new JButton("Search");
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(updateId.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter a customer id.");
                } else {
                    String tempName = "";
                    String tempId = "";
                    String tempEmail = "";
                    String tempContact = "";
                    String tempGender = "";

                    boolean found = false;

                    try {
                        Scanner sc = new Scanner(new File("customerList.txt"));
                        sc.useDelimiter("[,\n]");

                        while(sc.hasNext() && !found) {

                            if(!tempId.equals(updateId.getText())) {
                                tempName = sc.next();
                                tempId = sc.next();
                                tempEmail = sc.next();
                                tempContact = sc.next();
                                tempGender = sc.next();

                                if(tempId.equals(updateId.getText())) {
                                    found = true;
                                    name.setText(tempName);
                                    id.setText(tempId);
                                    email.setText(tempEmail);
                                    contact.setText(tempContact);
                                    gender.setText(tempGender);
                                }
                            }
                        }
                        if(!found){
                            JOptionPane.showMessageDialog(null, "Customer not found.");
                        }

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
        btnNewButton.setBounds(334, 164, 149, 33);
        desktopPane.add(btnNewButton);

        JButton btnCancel = new JButton("Back to Menu");
        btnCancel.setForeground(Color.BLACK);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.show();
                dispose();
            }
        });
        btnCancel.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCancel.setBounds(143, 164, 149, 33);
        desktopPane.add(btnCancel);

        JLabel lblNewLabel = new JLabel("Search the customer \"ID\"");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        lblNewLabel.setBounds(180, 56, 283, 33);
        desktopPane.add(lblNewLabel);
        contentPane.setLayout(gl_contentPane);
    }
}