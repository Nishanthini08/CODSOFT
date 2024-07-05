/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculatorGUI extends JFrame {
    private JTextField physicsField, chemistryField, mathsField, englishField, computerScienceField;
    private JLabel totalMarksLabel, percentageLabel, gradeLabel;

    public GradeCalculatorGUI() {
        setTitle("Student Grade Calculator");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("ABC School, chennai");
        titleLabel.setBounds(100, 10, 200, 20);
        add(titleLabel);

        // Physics
        JLabel physicsLabel = new JLabel("Physics:");
        physicsLabel.setBounds(50, 50, 100, 20);
        add(physicsLabel);
        physicsField = new JTextField();
        physicsField.setBounds(150, 50, 200, 20);
        add(physicsField);

        // Chemistry
        JLabel chemistryLabel = new JLabel("Chemistry:");
        chemistryLabel.setBounds(50, 80, 100, 20);
        add(chemistryLabel);
        chemistryField = new JTextField();
        chemistryField.setBounds(150, 80, 200, 20);
        add(chemistryField);

        // Maths
        JLabel mathsLabel = new JLabel("Maths:");
        mathsLabel.setBounds(50, 110, 100, 20);
        add(mathsLabel);
        mathsField = new JTextField();
        mathsField.setBounds(150, 110, 200, 20);
        add(mathsField);

        // English
        JLabel englishLabel = new JLabel("English:");
        englishLabel.setBounds(50, 140, 100, 20);
        add(englishLabel);
        englishField = new JTextField();
        englishField.setBounds(150, 140, 200, 20);
        add(englishField);

        // Computer Science
        JLabel computerScienceLabel = new JLabel("Computer Science:");
        computerScienceLabel.setBounds(50, 170, 120, 20);
        add(computerScienceLabel);
        computerScienceField = new JTextField();
        computerScienceField.setBounds(180, 170, 170, 20);
        add(computerScienceField);

        // Total Marks
        totalMarksLabel = new JLabel("Total Marks: ");
        totalMarksLabel.setBounds(50, 260, 200, 20);
        add(totalMarksLabel);

        // Percentage
        percentageLabel = new JLabel("Percentage: ");
        percentageLabel.setBounds(50, 290, 200, 20);
        add(percentageLabel);

        // Grade
        gradeLabel = new JLabel("Grade: ");
        gradeLabel.setBounds(50, 320, 200, 20);
        add(gradeLabel);

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 210, 100, 30);
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int physics = Integer.parseInt(physicsField.getText());
                int chemistry = Integer.parseInt(chemistryField.getText());
                int maths = Integer.parseInt(mathsField.getText());
                int english = Integer.parseInt(englishField.getText());
                int computerScience = Integer.parseInt(computerScienceField.getText());

                int totalMarks = physics + chemistry + maths + english + computerScience;
                double percentage = totalMarks / 5.0;

                String grade;
                if (percentage > 90) {
                    grade = "A";
                } else if (percentage > 85) {
                    grade = "B";
                } else if (percentage > 80) {
                    grade = "C";
                } else if (percentage > 70) {
                    grade = "D";
                } else if (percentage > 60) {
                    grade = "E";
                } else {
                    grade = "Poor";
                }

                totalMarksLabel.setText("Total Marks: " + totalMarks);
                percentageLabel.setText("Percentage: " + String.format("%.2f", percentage) + "%");
                gradeLabel.setText("Grade: " + grade);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new GradeCalculatorGUI();
    }
}
