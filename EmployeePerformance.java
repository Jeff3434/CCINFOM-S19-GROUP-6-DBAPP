package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;

public class EmployeePerformance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePerformance frame = new EmployeePerformance();
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
	public EmployeePerformance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeReview = new JLabel("Employee Performance Review");
		lblEmployeeReview.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeReview.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblEmployeeReview.setBounds(10, 11, 479, 32);
		contentPane.add(lblEmployeeReview);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 108, 315, 111);
		contentPane.add(scrollPane);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(111, 74, 296, 23);
		contentPane.add(textPane_1_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblName.setBounds(10, 76, 92, 18);
		contentPane.add(lblName);
		
		JLabel lblTotalAdoptions = new JLabel("Adoptions Handled:");
		lblTotalAdoptions.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAdoptions.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblTotalAdoptions.setBounds(10, 241, 159, 18);
		contentPane.add(lblTotalAdoptions);
		
		JLabel lblPerformanceScore = new JLabel("Performance Score:");
		lblPerformanceScore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerformanceScore.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblPerformanceScore.setBounds(10, 299, 159, 18);
		contentPane.add(lblPerformanceScore);
		
		JLabel lblBonusPenalty = new JLabel("Bonus:");
		lblBonusPenalty.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBonusPenalty.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblBonusPenalty.setBounds(10, 328, 159, 18);
		contentPane.add(lblBonusPenalty);
		
		JLabel lblReviewNotes = new JLabel("Notes:");
		lblReviewNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReviewNotes.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblReviewNotes.setBounds(10, 357, 159, 18);
		contentPane.add(lblReviewNotes);
		
		JLabel lblAdoptions = new JLabel("Adoptions");
		lblAdoptions.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdoptions.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAdoptions.setBounds(179, 241, 159, 18);
		contentPane.add(lblAdoptions);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setHorizontalAlignment(SwingConstants.LEFT);
		lblScore.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblScore.setBounds(179, 299, 159, 18);
		contentPane.add(lblScore);
		
		JLabel lblBonus = new JLabel("Bonus");
		lblBonus.setHorizontalAlignment(SwingConstants.LEFT);
		lblBonus.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblBonus.setBounds(179, 328, 159, 18);
		contentPane.add(lblBonus);
		
		JLabel lblSuccesRate = new JLabel("Succes Rate");
		lblSuccesRate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSuccesRate.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSuccesRate.setBounds(10, 270, 159, 18);
		contentPane.add(lblSuccesRate);
		
		JLabel lblAdoptions_1 = new JLabel("Adoptions");
		lblAdoptions_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdoptions_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAdoptions_1.setBounds(179, 270, 159, 18);
		contentPane.add(lblAdoptions_1);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(199, 503, 100, 35);
		contentPane.add(btnApply);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(180, 357, 260, 62);
		contentPane.add(textArea);
		
		JLabel lblThissReviewNotes = new JLabel("Review Notes:");
		lblThissReviewNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThissReviewNotes.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblThissReviewNotes.setBounds(10, 430, 159, 18);
		contentPane.add(lblThissReviewNotes);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(179, 430, 260, 62);
		contentPane.add(textArea_1);
		
		JLabel lblEmployee_1_2 = new JLabel("Status");
		lblEmployee_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_2.setBounds(203, 549, 92, 18);
		contentPane.add(lblEmployee_1_2);
	}

}
