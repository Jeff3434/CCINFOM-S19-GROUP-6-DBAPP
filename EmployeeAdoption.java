package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class EmployeeAdoption extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeAdoption frame = new EmployeeAdoption();
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
	public EmployeeAdoption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeAdoption = new JLabel("Employee Adoption");
		lblEmployeeAdoption.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeAdoption.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblEmployeeAdoption.setBounds(10, 11, 479, 32);
		contentPane.add(lblEmployeeAdoption);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 479, 349);
		contentPane.add(scrollPane);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblEmployee.setBounds(60, 430, 92, 18);
		contentPane.add(lblEmployee);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(161, 462, 177, 23);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(161, 496, 177, 23);
		contentPane.add(textPane_1);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(161, 428, 177, 23);
		contentPane.add(textPane_1_1);
		
		JLabel lblEmployee_1 = new JLabel("Breed");
		lblEmployee_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblEmployee_1.setBounds(60, 464, 92, 18);
		contentPane.add(lblEmployee_1);
		
		JLabel lblEmployee_1_1 = new JLabel("Species");
		lblEmployee_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblEmployee_1_1.setBounds(60, 498, 92, 18);
		contentPane.add(lblEmployee_1_1);
	}

}
