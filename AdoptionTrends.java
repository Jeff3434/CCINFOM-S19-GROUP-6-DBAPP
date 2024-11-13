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

public class AdoptionTrends extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdoptionTrends frame = new AdoptionTrends();
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
	public AdoptionTrends() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdoptionTrends = new JLabel("Adoption Trends");
		lblAdoptionTrends.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdoptionTrends.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAdoptionTrends.setBounds(10, 11, 479, 32);
		contentPane.add(lblAdoptionTrends);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 479, 349);
		contentPane.add(scrollPane);
		
		JLabel lblAdoption = new JLabel("Adoption");
		lblAdoption.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdoption.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAdoption.setBounds(60, 422, 92, 18);
		contentPane.add(lblAdoption);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(161, 420, 177, 23);
		contentPane.add(textPane_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(161, 454, 177, 23);
		contentPane.add(textPane);
		
		JLabel lblEmployee_1 = new JLabel("Month");
		lblEmployee_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblEmployee_1.setBounds(60, 456, 92, 18);
		contentPane.add(lblEmployee_1);
		
		JLabel lblEmployee_1_1 = new JLabel("Year");
		lblEmployee_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblEmployee_1_1.setBounds(60, 490, 92, 18);
		contentPane.add(lblEmployee_1_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(161, 488, 177, 23);
		contentPane.add(textPane_1);
	}

}
