/**
 * Assignment 6
 * Kehsin Yu
 * 002747728
 * Section 08
 */
package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class GUI implements ActionListener {

    // label of total assignment points
    private static JLabel labelTot;

    // text field of total assignment points
    private static JTextField textTot;

    // label of earned points
    private static JLabel labelEarned;

    // text field of earned points
    private static JTextField textEarned;

    // label of percentage
    private static JLabel labelPct;

    // text field of percentage
    private static JTextField textPct;

    // button of calculate weighted grade
    private static JButton btn;

    // label of weighted grade
    private static JLabel weightedLabel;
    
    // label of calculation result
    private static JLabel resLabel;

    public void graphical() {
        JFrame frame = new JFrame ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 380);
        frame.setLayout(null);
        frame.setTitle("Weighted Grade");

        // create total assignment points
        labelTot = new JLabel("Total Assignment Points");
        labelTot.setForeground(Color.BLUE);
        labelTot.setBounds(5,5,200,50);

        textTot = new JTextField();
        textTot.setBounds(5,40,180,50);
        frame.add(labelTot);
        frame.add(textTot);

        // create earned points
        labelEarned = new JLabel("Earned Points");
        labelEarned.setForeground(Color.BLUE);
        labelEarned.setBounds(210,5,200,50);

        textEarned = new JTextField();
        textEarned.setBounds(210,40,180,50);
        frame.add(labelEarned);
        frame.add(textEarned);

        // create percentage of assignment
        labelPct = new JLabel("Percentage of Assignment (%)");
        labelPct.setForeground(Color.BLUE);
        labelPct.setBounds(5,90,250,50);

        textPct = new JTextField();
        textPct.setBounds(5,125,180,50);
        frame.add(labelPct);
        frame.add(textPct);

        // create buttons
        btn = new JButton("Click to Calculate Score");
        btn.setForeground(Color.BLUE);
        btn.setBackground(Color.RED);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setBounds(100,190,210,50);
        btn.addActionListener(new GUI());
        frame.add(btn);

        // create result of weighted grade
        weightedLabel = new JLabel("Weighted Score: ");
        weightedLabel.setForeground(Color.BLUE);
        weightedLabel.setBounds(100,240,250,50);

        resLabel = new JLabel();
        resLabel.setBounds(100,275,150,50);
        frame.add(weightedLabel);
        frame.add(resLabel);

        // show frame
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // create an object of the WeightedGrades class
        WeightedGrades wg = new WeightedGrades();

        // get input of total point
        int totalPoints = Integer.parseInt(textTot.getText());
        wg.setPointTotal(totalPoints);

        // get input of earned point
        int earnedPoints = Integer.parseInt(textEarned.getText());
        wg.setEarnedPoints(earnedPoints);

        // get input of percentage
        double percentage = Double.parseDouble(textPct.getText());
        wg.setAssignmentPercent(percentage);

        // calculate the weighted grade
        double weighted =((float)wg.getEarnedPoints()/wg.getPointTotal())*wg.getAssignmentPercent();
        wg.setTotalWeightedGrade(weighted);

        // adding the round down result
        double res = wg.getTotalWeightedGrade();
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        String roundOff = df.format(res);
        resLabel.setText(roundOff);
    }
}
