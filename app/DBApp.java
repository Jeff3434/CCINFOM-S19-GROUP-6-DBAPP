package app;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class DBApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBApp frame = new DBApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DBApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pet Adoption Database");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 414, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelectATransaction = new JLabel("Choose an option");
		lblSelectATransaction.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectATransaction.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblSelectATransaction.setBounds(10, 101, 414, 32);
		contentPane.add(lblSelectATransaction);
		
		JButton btnNewButton = new JButton("Manage Records");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Records records = new Records();
				records.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton.setBounds(118, 144, 198, 52);
		btnNewButton.setBackground(Color.WHITE);
		
		contentPane.add(btnNewButton);
		
		JButton btnManage = new JButton("<html><div style='text-align: center;'>Pet Adoption<br>Application<div></html>");
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetAdoptionApplication petAdopt = new PetAdoptionApplication();
				petAdopt.setVisible(true);
				
				dispose();
			}
		});
		btnManage.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnManage.setBounds(118, 313, 198, 52);
		btnManage.setBackground(Color.WHITE);
		contentPane.add(btnManage);
		
		JLabel lblSimulateATransaction = new JLabel("Simulate an application");
		lblSimulateATransaction.setHorizontalAlignment(SwingConstants.LEFT);
		lblSimulateATransaction.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblSimulateATransaction.setBounds(10, 270, 414, 32);
		contentPane.add(lblSimulateATransaction);
		
		JButton btnpetReturnapplication = new JButton("<html><div style='text-align: center;'>Pet Return<br>Application<div></html>");
		btnpetReturnapplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetReturnApplication petReturn = new PetReturnApplication();
				petReturn.setVisible(true);
				
				dispose();
			}
		});
		btnpetReturnapplication.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnpetReturnapplication.setBounds(118, 378, 198, 52);
		btnpetReturnapplication.setBackground(Color.WHITE);
		contentPane.add(btnpetReturnapplication);
		
		JButton btnpetAdmissionapplication = new JButton("<html>\r\n<div style='text-align: center;'>\r\nEmployee Performance<br>\r\nReview\r\n<div>\r\n</html>");
		btnpetAdmissionapplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeePerformance empPerf = new EmployeePerformance();
				empPerf.setVisible(true);
				
				dispose();
			}
		});
		btnpetAdmissionapplication.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnpetAdmissionapplication.setBounds(118, 504, 198, 52);
		btnpetAdmissionapplication.setBackground(Color.WHITE);
		contentPane.add(btnpetAdmissionapplication);
		
		JButton btnpetAdmissionapplication_1 = new JButton("<html><div style='text-align: center;'>Pet Admission<br>Application<div></html>");
		btnpetAdmissionapplication_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetAdmissionApplication petAdmission = new PetAdmissionApplication();
				petAdmission.setVisible(true);
				
				dispose();
			}
		});
		btnpetAdmissionapplication_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnpetAdmissionapplication_1.setBounds(118, 441, 198, 52);
		btnpetAdmissionapplication_1.setBackground(Color.WHITE);
		contentPane.add(btnpetAdmissionapplication_1);
		
		JButton btnGenerateReports = new JButton("Generate Reports");
		btnGenerateReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reports reports = new Reports();
				reports.setVisible(true);
				
				dispose();
			}
		});
		btnGenerateReports.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnGenerateReports.setBounds(118, 207, 198, 52);
		btnGenerateReports.setBackground(Color.WHITE);
		contentPane.add(btnGenerateReports);
		
		JLabel lblShelterHappyPaws = new JLabel("<html>\r\n<div style='text-align: center;'>\r\n<b>Shelter:</b> Happy Paws Adoption Center<br>\r\n<b>Location:</b> 123 Mabini Street, Ermita, Manila, 1000\r\n</div>\r\n</html>");
		lblShelterHappyPaws.setHorizontalAlignment(SwingConstants.CENTER);
		lblShelterHappyPaws.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblShelterHappyPaws.setBounds(10, 50, 414, 40);
		contentPane.add(lblShelterHappyPaws);
	}
}
