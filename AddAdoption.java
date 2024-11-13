package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;

public class AddAdoption extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdoption frame = new AddAdoption();
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
	public AddAdoption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddAdoption = new JLabel("Add Adoption");
		lblAddAdoption.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAdoption.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAddAdoption.setBounds(10, 11, 479, 32);
		contentPane.add(lblAddAdoption);
		
		JLabel lblPetId = new JLabel("Pet ID");
		lblPetId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetId.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblPetId.setBounds(10, 56, 92, 18);
		contentPane.add(lblPetId);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(111, 54, 127, 23);
		contentPane.add(textPane_1_1);
		
		JTextPane textPane_1_1_1 = new JTextPane();
		textPane_1_1_1.setBounds(111, 164, 127, 23);
		contentPane.add(textPane_1_1_1);
		
		JLabel lblAdopterId = new JLabel("Adopter ID");
		lblAdopterId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdopterId.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAdopterId.setBounds(10, 166, 92, 18);
		contentPane.add(lblAdopterId);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblDate.setBounds(10, 386, 92, 18);
		contentPane.add(lblDate);
		
		JTextPane textPane_1_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1_1.setBounds(111, 384, 351, 23);
		contentPane.add(textPane_1_1_1_1_1);
		
		JTextPane textPane_1_1_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1_1_1.setBounds(111, 418, 351, 23);
		contentPane.add(textPane_1_1_1_1_1_1);
		
		JLabel lblAdoptionFee = new JLabel("Fee");
		lblAdoptionFee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdoptionFee.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAdoptionFee.setBounds(10, 420, 92, 18);
		contentPane.add(lblAdoptionFee);
		
		JButton btnApply = new JButton("Add");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(199, 452, 100, 35);
		contentPane.add(btnApply);
		
		JLabel lblEmployee_1_2 = new JLabel("Status");
		lblEmployee_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_2.setBounds(203, 498, 92, 18);
		contentPane.add(lblEmployee_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 54, 201, 99);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(261, 164, 201, 99);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(261, 274, 201, 99);
		contentPane.add(scrollPane_1_1);
		
		JTextPane textPane_1_1_1_2 = new JTextPane();
		textPane_1_1_1_2.setBounds(111, 274, 127, 23);
		contentPane.add(textPane_1_1_1_2);
		
		JLabel lblEmpId = new JLabel("Emp. ID");
		lblEmpId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpId.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblEmpId.setBounds(10, 276, 92, 18);
		contentPane.add(lblEmpId);
	}

}
