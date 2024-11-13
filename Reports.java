package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Reports extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
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
	public Reports() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblReports.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblReports.setBounds(10, 11, 289, 32);
		contentPane.add(lblReports);
		
		JButton btnNewButton_1_1 = new JButton("Adoption History");
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(65, 110, 179, 62);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblSelectAReport = new JLabel("Choose a report to generate");
		lblSelectAReport.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectAReport.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblSelectAReport.setBounds(10, 66, 289, 32);
		contentPane.add(lblSelectAReport);
		
		JButton btnNewButton_1_1_3 = new JButton("Employee Adoption");
		btnNewButton_1_1_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_1_1_3.setBounds(65, 184, 179, 62);
		contentPane.add(btnNewButton_1_1_3);
		
		JButton btnNewButton_1_1_3_1 = new JButton("Adoption Trends");
		btnNewButton_1_1_3_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_1_1_3_1.setBounds(65, 257, 179, 62);
		contentPane.add(btnNewButton_1_1_3_1);
		
		JButton btnNewButton_1_1_3_1_1 = new JButton("Adoption Revenue");
		btnNewButton_1_1_3_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_1_1_3_1_1.setBounds(65, 330, 179, 62);
		contentPane.add(btnNewButton_1_1_3_1_1);
		
		JButton btnNewButton_1_1_3_1_1_1 = new JButton("Adoption Revenue");
		btnNewButton_1_1_3_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_1_1_3_1_1_1.setBounds(65, 399, 179, 62);
		contentPane.add(btnNewButton_1_1_3_1_1_1);
	}
}
