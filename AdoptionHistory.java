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

public class AdoptionHistory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdoptionHistory frame = new AdoptionHistory();
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
	public AdoptionHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdoptionHistory = new JLabel("Adoption History");
		lblAdoptionHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdoptionHistory.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAdoptionHistory.setBounds(10, 11, 479, 32);
		contentPane.add(lblAdoptionHistory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 479, 349);
		contentPane.add(scrollPane);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblMonth.setBounds(60, 437, 92, 18);
		contentPane.add(lblMonth);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(161, 435, 177, 23);
		contentPane.add(textPane_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(161, 469, 177, 23);
		contentPane.add(textPane);
		
		JLabel lblEmployee_1 = new JLabel("Year");
		lblEmployee_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblEmployee_1.setBounds(60, 471, 92, 18);
		contentPane.add(lblEmployee_1);
	}

}
