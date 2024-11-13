package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Records extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Records frame = new Records();
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
	public Records() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecords = new JLabel("Records");
		lblRecords.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecords.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRecords.setBounds(10, 11, 479, 32);
		contentPane.add(lblRecords);
		
		JButton btnNewButton = new JButton("Pet");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		buttonGroup.add(btnNewButton);
		btnNewButton.setBounds(56, 54, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adopter");
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		buttonGroup.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(155, 54, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Adoption");
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		buttonGroup.add(btnNewButton_2);
		btnNewButton_2.setBounds(255, 54, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Employee");
		btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		buttonGroup.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(354, 54, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 479, 349);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_2_1.setBounds(205, 527, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Add");
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_1_1.setBounds(56, 494, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("Filter: ");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 460, 46, 18);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(56, 460, 177, 23);
		contentPane.add(textPane);
		
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_1_2.setBounds(155, 495, 89, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Modify");
		btnNewButton_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_1_2_1.setBounds(255, 495, 89, 23);
		contentPane.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Modify");
		btnNewButton_1_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_1_2_1_1.setBounds(354, 495, 89, 23);
		contentPane.add(btnNewButton_1_2_1_1);
	}
}
