package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.Color;

public class Records extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DatabaseConnector dbConnector = new DatabaseConnector();
	private JScrollPane scrollPane;
	private JTable petTable;

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPetData();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		buttonGroup.add(btnNewButton);
		btnNewButton.setBounds(56, 54, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adopter");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		buttonGroup.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadAdopterData();
			}
		});
		btnNewButton_1.setBounds(149, 54, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Adoption");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadAdoptionData();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		buttonGroup.add(btnNewButton_2);
		btnNewButton_2.setBounds(249, 54, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Employee");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		buttonGroup.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadEmployeeData();
			}
		});
		btnNewButton_3.setBounds(348, 54, 89, 23);
		contentPane.add(btnNewButton_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 479, 349);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBApp dbApp = new DBApp();
				dbApp.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_2_1.setBackground(new Color(255, 255, 255));
		btnNewButton_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_2_1.setBounds(205, 527, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Add");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
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
		btnNewButton_1_2.setBackground(new Color(255, 255, 255));
		btnNewButton_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_1_2.setBounds(155, 495, 89, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Modify");
		btnNewButton_1_2_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnNewButton_1_2_1.setBounds(249, 495, 89, 23);
		contentPane.add(btnNewButton_1_2_1);
	}
	
	private void loadPetData() {
	    try {
	        ResultSet resultSet = dbConnector.fetchPetData();

	        petTable = new JTable(buildTableModel(resultSet));

	        scrollPane.setViewportView(petTable);
	        revalidate(); 

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
	    }
	}
	
	private void loadAdopterData() {
	    try {
	        ResultSet resultSet = dbConnector.fetchAdopterData();

	        petTable = new JTable(buildTableModel(resultSet));

	        scrollPane.setViewportView(petTable);
	        revalidate();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
	    }
	}
	
	private void loadAdoptionData() {
	    try {
	        ResultSet resultSet = dbConnector.fetchAdoptionData();

	        petTable = new JTable(buildTableModel(resultSet));

	        scrollPane.setViewportView(petTable);
	        revalidate();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
	    }
	}
	
	private void loadEmployeeData() {
	    try {
	        ResultSet resultSet = dbConnector.fetchEmployeeData();

	        petTable = new JTable(buildTableModel(resultSet));

	        scrollPane.setViewportView(petTable);
	        revalidate();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
	    }
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        
        int columnCount = rs.getMetaData().getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            model.addColumn(rs.getMetaData().getColumnName(column));
        }

        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            model.addRow(row);
        }
        return model;
    }
}
