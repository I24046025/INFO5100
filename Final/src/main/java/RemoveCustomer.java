package main.java;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.io.*;
import java.util.Scanner;

public class RemoveCustomer extends JFrame {
    private JPanel contentPane;
    private JTextField deleteId;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RemoveCustomer frame = new RemoveCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RemoveCustomer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 477, 526);
        setTitle("Remove Existing Customer");
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.LIGHT_GRAY);

        JDesktopPane desktopPane_1 = new JDesktopPane();
        desktopPane_1.setBackground(Color.LIGHT_GRAY);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(desktopPane_1, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                .addContainerGap())
        );

        deleteId = new JTextField();
        deleteId.setBounds(111, 40, 206, 29);
        desktopPane_1.add(deleteId);
        deleteId.setColumns(10);

        JButton deleteData = new JButton("Delete");
        deleteData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(deleteId.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter a customer id.");
                } else {

                    String tempFile = "temp.txt";
                    File oldFile = new File("customerList.txt");
                    File newFile = new File(tempFile);

                    String name = "";
                    String id = "";
                    String email = "";
                    String contact = "";
                    String gender = "";

                    boolean found = false;

                    try{
                        FileWriter fw = new FileWriter(tempFile, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        Scanner sc = new Scanner(new File("customerList.txt"));
                        sc.useDelimiter("[,\n]");

                        while(sc.hasNext()) {
                            name = sc.next();
                            id = sc.next();
                            email = sc.next();
                            contact = sc.next();
                            gender = sc.next();

                            if(!id.equals(deleteId.getText())) {
                                pw.println(name + "," + id + "," + email + "," + contact + "," + gender);
                            } else {
                                // found the deleted target
                                found = true;
                            }
                        }
                        sc.close();
                        pw.flush();
                        pw.close();
                        oldFile.delete();
                        File dump = new File("customerList.txt");
                        newFile.renameTo(dump);

                        if(found) {
                            JOptionPane.showMessageDialog(null, "Deleted successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Customer not found.");
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        deleteData.setForeground(Color.BLACK);
        deleteData.setBounds(130, 111, 167, 37);
        desktopPane_1.add(deleteData);
        deleteData.setFont(new Font("Calibri", Font.BOLD, 14));

        JButton btnNewButton_1 = new JButton("Back to Menu");
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Menu menu = new Menu();
                menu.show();
                dispose();

            }
        });
        btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 14));
        btnNewButton_1.setBounds(130, 171, 167, 37);
        desktopPane_1.add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("Please enter the \"ID\" of the customer");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(10, 90, 408, 25);
        desktopPane.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        contentPane.setLayout(gl_contentPane);
    }
}
