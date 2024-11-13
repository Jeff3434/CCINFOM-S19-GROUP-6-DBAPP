package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class AddEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddAdopter = new JLabel("Add Employee");
		lblAddAdopter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAdopter.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAddAdopter.setBounds(10, 11, 479, 32);
		contentPane.add(lblAddAdopter);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblName.setBounds(10, 56, 92, 18);
		contentPane.add(lblName);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(111, 54, 351, 23);
		contentPane.add(textPane_1_1);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRole.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblRole.setBounds(10, 87, 92, 18);
		contentPane.add(lblRole);
		
		JTextPane textPane_1_1_1 = new JTextPane();
		textPane_1_1_1.setBounds(111, 85, 351, 23);
		contentPane.add(textPane_1_1_1);
		
		JLabel lblExperience = new JLabel("Years Worked");
		lblExperience.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExperience.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblExperience.setBounds(10, 118, 92, 18);
		contentPane.add(lblExperience);
		
		JTextPane textPane_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1.setBounds(111, 116, 102, 23);
		contentPane.add(textPane_1_1_1_1);
		
		JLabel lblHoursWorked = new JLabel("Hours Worked");
		lblHoursWorked.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoursWorked.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblHoursWorked.setBounds(249, 115, 102, 18);
		contentPane.add(lblHoursWorked);
		
		JTextPane textPane_1_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1_1.setBounds(360, 113, 102, 23);
		contentPane.add(textPane_1_1_1_1_1);
		
		JTextPane textPane_1_1_1_2 = new JTextPane();
		textPane_1_1_1_2.setBounds(111, 147, 351, 23);
		contentPane.add(textPane_1_1_1_2);
		
		JLabel lblDateWorked = new JLabel("Date Worked");
		lblDateWorked.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateWorked.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDateWorked.setBounds(10, 149, 92, 18);
		contentPane.add(lblDateWorked);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotes.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblNotes.setBounds(10, 212, 92, 18);
		contentPane.add(lblNotes);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(111, 213, 351, 66);
		contentPane.add(textArea);
		
		JButton btnApply = new JButton("Add");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(199, 290, 100, 35);
		contentPane.add(btnApply);
		
		JLabel lblEmployee_1_2 = new JLabel("Status");
		lblEmployee_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_2.setBounds(203, 336, 92, 18);
		contentPane.add(lblEmployee_1_2);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalary.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSalary.setBounds(10, 183, 92, 18);
		contentPane.add(lblSalary);
		
		JTextPane textPane_1_1_1_3 = new JTextPane();
		textPane_1_1_1_3.setBounds(111, 181, 351, 23);
		contentPane.add(textPane_1_1_1_3);
	}

}
