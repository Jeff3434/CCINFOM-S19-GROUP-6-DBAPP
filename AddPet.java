package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;

public class AddPet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPet frame = new AddPet();
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
	public AddPet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddPet = new JLabel("Add Pet");
		lblAddPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddPet.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAddPet.setBounds(10, 11, 479, 32);
		contentPane.add(lblAddPet);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblName.setBounds(10, 56, 92, 18);
		contentPane.add(lblName);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(111, 54, 351, 23);
		contentPane.add(textPane_1_1);
		
		JTextPane textPane_1_1_1 = new JTextPane();
		textPane_1_1_1.setBounds(111, 85, 351, 23);
		contentPane.add(textPane_1_1_1);
		
		JLabel lblBreed = new JLabel("Breed");
		lblBreed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreed.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblBreed.setBounds(10, 87, 92, 18);
		contentPane.add(lblBreed);
		
		JTextPane textPane_1_1_2 = new JTextPane();
		textPane_1_1_2.setBounds(111, 119, 351, 23);
		contentPane.add(textPane_1_1_2);
		
		JLabel lblSpecies = new JLabel("Species");
		lblSpecies.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpecies.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSpecies.setBounds(10, 121, 92, 18);
		contentPane.add(lblSpecies);
		
		JLabel lblAge_1 = new JLabel("Age");
		lblAge_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1.setBounds(10, 155, 92, 18);
		contentPane.add(lblAge_1);
		
		JTextPane textPane_1_1_1_1_2 = new JTextPane();
		textPane_1_1_1_1_2.setBounds(111, 153, 141, 23);
		contentPane.add(textPane_1_1_1_1_2);
		
		JLabel lblAge_1_1 = new JLabel("Sex");
		lblAge_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1_1.setBounds(218, 155, 92, 18);
		contentPane.add(lblAge_1_1);
		
		JTextPane textPane_1_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1_1.setBounds(319, 153, 143, 23);
		contentPane.add(textPane_1_1_1_1_1);
		
		JLabel lblAge_1_2 = new JLabel("Color");
		lblAge_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1_2.setBounds(10, 186, 92, 18);
		contentPane.add(lblAge_1_2);
		
		JTextPane textPane_1_1_1_1_2_1 = new JTextPane();
		textPane_1_1_1_1_2_1.setBounds(111, 184, 141, 23);
		contentPane.add(textPane_1_1_1_1_2_1);
		
		JLabel lblVaccination = new JLabel("Vaccinated?");
		lblVaccination.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVaccination.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblVaccination.setBounds(10, 214, 92, 18);
		contentPane.add(lblVaccination);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		rdbtnNewRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(111, 213, 52, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNo.setBounds(174, 213, 52, 23);
		contentPane.add(rdbtnNo);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Yes");
		rdbtnNewRadioButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(316, 213, 52, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNo_1.setBounds(376, 213, 52, 23);
		contentPane.add(rdbtnNo_1);
		
		JLabel lblVaccination_1 = new JLabel("Spayed/Neutered?");
		lblVaccination_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVaccination_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblVaccination_1.setBounds(293, 184, 150, 18);
		contentPane.add(lblVaccination_1);
		
		JLabel lblTrainingLevel = new JLabel("Training Level");
		lblTrainingLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrainingLevel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTrainingLevel.setBounds(10, 245, 92, 18);
		contentPane.add(lblTrainingLevel);
		
		JTextPane textPane_1_1_1_1_3 = new JTextPane();
		textPane_1_1_1_1_3.setBounds(111, 243, 351, 23);
		contentPane.add(textPane_1_1_1_1_3);
		
		JTextPane textPane_1_1_1_1_3_1 = new JTextPane();
		textPane_1_1_1_1_3_1.setBounds(111, 274, 351, 23);
		contentPane.add(textPane_1_1_1_1_3_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDate.setBounds(10, 276, 92, 18);
		contentPane.add(lblDate);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(199, 314, 100, 35);
		contentPane.add(btnAdd);
		
		JLabel lblEmployee_1_2 = new JLabel("Status");
		lblEmployee_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_2.setBounds(203, 360, 92, 18);
		contentPane.add(lblEmployee_1_2);
	}

}
