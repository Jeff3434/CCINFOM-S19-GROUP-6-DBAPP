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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PetAdmissionApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public PetAdmissionApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPetAdmissionApplication = new JLabel("Pet Admission Application");
		lblPetAdmissionApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetAdmissionApplication.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPetAdmissionApplication.setBounds(10, 11, 479, 32);
		contentPane.add(lblPetAdmissionApplication);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblName.setBounds(10, 76, 92, 18);
		contentPane.add(lblName);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(111, 74, 351, 23);
		contentPane.add(textPane_1_1);
		
		JLabel lblBreed = new JLabel("Breed");
		lblBreed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreed.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblBreed.setBounds(10, 107, 92, 18);
		contentPane.add(lblBreed);
		
		JTextPane textPane_1_1_1 = new JTextPane();
		textPane_1_1_1.setBounds(111, 105, 351, 23);
		contentPane.add(textPane_1_1_1);
		
		JLabel lblSpecies = new JLabel("Species");
		lblSpecies.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpecies.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSpecies.setBounds(10, 138, 92, 18);
		contentPane.add(lblSpecies);
		
		JTextPane textPane_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1.setBounds(111, 136, 351, 23);
		contentPane.add(textPane_1_1_1_1);
		
		JTextPane textPane_1_1_1_1_1 = new JTextPane();
		textPane_1_1_1_1_1.setBounds(319, 167, 143, 23);
		contentPane.add(textPane_1_1_1_1_1);
		
		JLabel lblAge_1_1 = new JLabel("Sex");
		lblAge_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1_1.setBounds(218, 169, 92, 18);
		contentPane.add(lblAge_1_1);
		
		JTextPane textPane_1_1_1_1_2 = new JTextPane();
		textPane_1_1_1_1_2.setBounds(111, 167, 141, 23);
		contentPane.add(textPane_1_1_1_1_2);
		
		JLabel lblAge_1 = new JLabel("Age");
		lblAge_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1.setBounds(10, 169, 92, 18);
		contentPane.add(lblAge_1);
		
		JLabel lblAge_1_2 = new JLabel("Color");
		lblAge_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1_2.setBounds(10, 200, 92, 18);
		contentPane.add(lblAge_1_2);
		
		JTextPane textPane_1_1_1_1_2_1 = new JTextPane();
		textPane_1_1_1_1_2_1.setBounds(111, 198, 141, 23);
		contentPane.add(textPane_1_1_1_1_2_1);
		
		JLabel lblVaccination = new JLabel("Vaccinated?");
		lblVaccination.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVaccination.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblVaccination.setBounds(10, 231, 92, 18);
		contentPane.add(lblVaccination);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		rdbtnNewRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(111, 230, 52, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(174, 230, 52, 23);
		contentPane.add(rdbtnNo);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Yes");
		rdbtnNewRadioButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(316, 230, 52, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNo_1.setBounds(376, 230, 52, 23);
		contentPane.add(rdbtnNo_1);
		
		JLabel lblVaccination_1 = new JLabel("Spayed/Neutered?");
		lblVaccination_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVaccination_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblVaccination_1.setBounds(293, 201, 150, 18);
		contentPane.add(lblVaccination_1);
		
		JLabel lblTrainingLevel = new JLabel("Training Level");
		lblTrainingLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrainingLevel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTrainingLevel.setBounds(10, 262, 92, 18);
		contentPane.add(lblTrainingLevel);
		
		JTextPane textPane_1_1_1_1_3 = new JTextPane();
		textPane_1_1_1_1_3.setBounds(111, 260, 351, 23);
		contentPane.add(textPane_1_1_1_1_3);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDate.setBounds(10, 293, 92, 18);
		contentPane.add(lblDate);
		
		JTextPane textPane_1_1_1_1_3_1 = new JTextPane();
		textPane_1_1_1_1_3_1.setBounds(111, 291, 351, 23);
		contentPane.add(textPane_1_1_1_1_3_1);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(199, 331, 100, 35);
		contentPane.add(btnApply);
		
		JLabel lblEmployee_1_2 = new JLabel("Status");
		lblEmployee_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_2.setBounds(203, 377, 92, 18);
		contentPane.add(lblEmployee_1_2);
		
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
		btnNewButton_2_1.setBounds(10, 527, 89, 23);
		contentPane.add(btnNewButton_2_1);
	}
}
