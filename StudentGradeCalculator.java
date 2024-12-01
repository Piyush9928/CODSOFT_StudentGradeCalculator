import java.awt.event.ActionEvent;
import javax.swing.*;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Student Grade Calculator");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels and text fields for input
        JLabel[] subjectLabels = new JLabel[5];
        JTextField[] subjectFields = new JTextField[5];
        
        for (int i = 0; i < 5; i++) {
            subjectLabels[i] = new JLabel("Subject " + (i + 1) + " Marks:");
            subjectLabels[i].setBounds(20, 20 + (i * 40), 150, 30);
            frame.add(subjectLabels[i]);

            subjectFields[i] = new JTextField();
            subjectFields[i].setBounds(180, 20 + (i * 40), 150, 30);
            frame.add(subjectFields[i]);
        }

        // Button to calculate the grade
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(140, 240, 120, 40);
        frame.add(calculateButton);

        // Label to display the result
        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(20, 300, 350, 50);
        frame.add(resultLabel);

        // Action listener for the calculate button
        calculateButton.addActionListener((ActionEvent e) -> {
            try {
                int totalMarks = 0;
                for (JTextField field : subjectFields) {
                    int marks = Integer.parseInt(field.getText());
                    if (marks < 0 || marks > 100) {
                        throw new NumberFormatException();
                    }
                    totalMarks += marks;
                }
                
                // Calculate average percentage
                int numberOfSubjects = subjectFields.length;
                double averagePercentage = (double) totalMarks / numberOfSubjects;
                
                // Determine grade
                String grade;
                if (averagePercentage >= 90) {
                    grade = "A";
                } else if (averagePercentage >= 80) {
                    grade = "B";
                } else if (averagePercentage >= 70) {
                    grade = "C";
                } else if (averagePercentage >= 60) {
                    grade = "D";
                } else {
                    grade = "F";
                }
                
                // Display the result
                resultLabel.setText("<html>Total Marks: " + totalMarks + "<br>" +
                        "Average Percentage: " + String.format("%.2f", averagePercentage) + "%<br>" +
                                "Grade: " + grade + "</html>");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid marks (0-100) for all subjects.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
