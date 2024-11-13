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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;

public class AddAdopter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdopter frame = new AddAdopter();
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
	public AddAdopter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddAdopter = new JLabel("Add Adopter");
		lblAddAdopter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAdopter.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAddAdopter.setBounds(10, 11, 479, 32);
		contentPane.add(lblAddAdopter);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(111, 54, 351, 23);
		contentPane.add(textPane_1_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblName.setBounds(10, 56, 92, 18);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Address");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge.setBounds(10, 87, 92, 18);
		contentPane.add(lblAge);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(111, 88, 351, 47);
		contentPane.add(textArea);
		
		JTextPane textPane_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1.setBounds(111, 146, 141, 23);
		contentPane.add(textPane_1_1_1_1);
		
		JLabel lblAge_1 = new JLabel("Age");
		lblAge_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1.setBounds(10, 148, 92, 18);
		contentPane.add(lblAge_1);
		
		JLabel lblAge_1_1 = new JLabel("Sex");
		lblAge_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1_1.setBounds(218, 148, 92, 18);
		contentPane.add(lblAge_1_1);
		
		JTextPane textPane_1_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1_1.setBounds(319, 146, 143, 23);
		contentPane.add(textPane_1_1_1_1_1);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("Married");
		rdbtnNo_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNo_1.setBounds(182, 178, 70, 23);
		contentPane.add(rdbtnNo_1);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");
		rdbtnSingle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnSingle.setBounds(111, 178, 69, 23);
		contentPane.add(rdbtnSingle);
		
		JLabel lblAge_1_2 = new JLabel("Status");
		lblAge_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1_2.setBounds(10, 179, 92, 18);
		contentPane.add(lblAge_1_2);
		
		JLabel lblName_1 = new JLabel("Contact");
		lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblName_1.setBounds(10, 210, 92, 18);
		contentPane.add(lblName_1);
		
		JTextPane textPane_1_1_1 = new JTextPane();
		textPane_1_1_1.setBounds(111, 208, 351, 23);
		contentPane.add(textPane_1_1_1);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblReason.setBounds(10, 239, 92, 18);
		contentPane.add(lblReason);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(111, 242, 351, 47);
		contentPane.add(textArea_1);
		
		JLabel lblPetCount = new JLabel("Income Level");
		lblPetCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPetCount.setBounds(10, 301, 92, 18);
		contentPane.add(lblPetCount);
		
		JTextPane textPane_1_1_2 = new JTextPane();
		textPane_1_1_2.setBounds(111, 299, 351, 23);
		contentPane.add(textPane_1_1_2);
		
		JLabel lblPetCount_1 = new JLabel("Pet Count");
		lblPetCount_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblPetCount_1.setBounds(10, 335, 92, 18);
		contentPane.add(lblPetCount_1);
		
		JTextPane textPane_1_1_2_1 = new JTextPane();
		textPane_1_1_2_1.setBounds(111, 333, 141, 23);
		contentPane.add(textPane_1_1_2_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(365, 398, 97, 23);
		contentPane.add(textPane_1);
		
		JLabel lblEmployee_1 = new JLabel("Name");
		lblEmployee_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1.setBounds(264, 366, 92, 18);
		contentPane.add(lblEmployee_1);
		
		JLabel lblEmployee_1_1 = new JLabel("Breed");
		lblEmployee_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_1.setBounds(264, 400, 92, 18);
		contentPane.add(lblEmployee_1_1);
		
		JLabel lblEmployee_1_1_1 = new JLabel("Species");
		lblEmployee_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_1_1.setBounds(264, 434, 92, 18);
		contentPane.add(lblEmployee_1_1_1);
		
		JTextPane textPane_1_2 = new JTextPane();
		textPane_1_2.setBounds(365, 432, 97, 23);
		contentPane.add(textPane_1_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(365, 364, 97, 23);
		contentPane.add(textPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 364, 164, 102);
		contentPane.add(scrollPane);
		
		JLabel lblPets = new JLabel("Search Pet");
		lblPets.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPets.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblPets.setBounds(10, 366, 92, 18);
		contentPane.add(lblPets);
		
		JButton btnApply = new JButton("Add");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(199, 477, 100, 35);
		contentPane.add(btnApply);
		
		JLabel lblEmployee_1_2 = new JLabel("Status");
		lblEmployee_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_2.setBounds(203, 523, 92, 18);
		contentPane.add(lblEmployee_1_2);
		
		JLabel lblAge_1_1_1 = new JLabel("Type");
		lblAge_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1_1_1.setBounds(218, 335, 92, 18);
		contentPane.add(lblAge_1_1_1);
		
		JTextPane textPane_1_1_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1_1_1.setBounds(319, 333, 143, 23);
		contentPane.add(textPane_1_1_1_1_1_1);
	}
}
