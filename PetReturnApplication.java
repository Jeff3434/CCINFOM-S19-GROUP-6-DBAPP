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
import javax.swing.JScrollPane;

public class PetReturnApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetReturnApplication frame = new PetReturnApplication();
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
	public PetReturnApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPetName = new JLabel("Pet Name");
		lblPetName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblPetName.setBounds(10, 89, 92, 18);
		contentPane.add(lblPetName);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(111, 87, 351, 23);
		contentPane.add(textPane_1_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(111, 121, 351, 47);
		contentPane.add(textArea_1);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblReason.setBounds(10, 118, 92, 18);
		contentPane.add(lblReason);
		
		JLabel lblSearchPet = new JLabel("Search Pet");
		lblSearchPet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearchPet.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSearchPet.setBounds(10, 181, 92, 18);
		contentPane.add(lblSearchPet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 179, 164, 102);
		contentPane.add(scrollPane);
		
		JLabel lblEmployee_1 = new JLabel("Name");
		lblEmployee_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1.setBounds(264, 181, 92, 18);
		contentPane.add(lblEmployee_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(365, 179, 97, 23);
		contentPane.add(textPane);
		
		JLabel lblEmployee_1_1 = new JLabel("Breed");
		lblEmployee_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_1.setBounds(264, 215, 92, 18);
		contentPane.add(lblEmployee_1_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(365, 213, 97, 23);
		contentPane.add(textPane_1);
		
		JLabel lblEmployee_1_1_1 = new JLabel("Species");
		lblEmployee_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_1_1.setBounds(264, 249, 92, 18);
		contentPane.add(lblEmployee_1_1_1);
		
		JTextPane textPane_1_2 = new JTextPane();
		textPane_1_2.setBounds(365, 247, 97, 23);
		contentPane.add(textPane_1_2);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(189, 292, 100, 35);
		contentPane.add(btnApply);
		
		JLabel lblPetReturnApplication = new JLabel("Pet Return Application");
		lblPetReturnApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetReturnApplication.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPetReturnApplication.setBounds(10, 11, 479, 32);
		contentPane.add(lblPetReturnApplication);
		
		JLabel lblEmployee_1_2 = new JLabel("Status");
		lblEmployee_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_2.setBounds(193, 338, 92, 18);
		contentPane.add(lblEmployee_1_2);
	}

}
