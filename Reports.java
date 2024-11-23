package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reports extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdoptionHistory adoptionHistory = new AdoptionHistory();
				adoptionHistory.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(65, 110, 179, 62);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblSelectAReport = new JLabel("Choose a report to generate");
		lblSelectAReport.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectAReport.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblSelectAReport.setBounds(10, 66, 289, 32);
		contentPane.add(lblSelectAReport);
		
		JButton btnNewButton_1_1_3 = new JButton("Employee Adoption");
		btnNewButton_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeAdoption empAdoption = new EmployeeAdoption();
				empAdoption.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_1_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_1_1_3.setBounds(65, 184, 179, 62);
		contentPane.add(btnNewButton_1_1_3);
		
		JButton btnNewButton_1_1_3_1 = new JButton("Adoption Trends");
		btnNewButton_1_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdoptionTrends adoptTrends = new AdoptionTrends();
				adoptTrends.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_1_1_3_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1_3_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_1_1_3_1.setBounds(65, 257, 179, 62);
		contentPane.add(btnNewButton_1_1_3_1);
		
		JButton btnNewButton_1_1_3_1_1 = new JButton("Adoption Revenue");
		btnNewButton_1_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdoptionRevenue adoptRevenue = new AdoptionRevenue();
				adoptRevenue.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_1_1_3_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1_3_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_1_1_3_1_1.setBounds(65, 330, 179, 62);
		contentPane.add(btnNewButton_1_1_3_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBApp dbApp = new DBApp();
				dbApp.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(110, 413, 89, 23);
		contentPane.add(btnNewButton_2_1);
	}
}
