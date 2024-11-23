package app;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class EmployeePerformance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DatabaseConnector dbConnector = new DatabaseConnector();

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
		
		JTextPane textPaneName = new JTextPane();
		textPaneName.setBounds(111, 74, 218, 23);
		contentPane.add(textPaneName);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblName.setBounds(10, 76, 92, 18);
		contentPane.add(lblName);
		
		JLabel lblTotalAdoptions = new JLabel("Hours Worked:");
		lblTotalAdoptions.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAdoptions.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblTotalAdoptions.setBounds(10, 241, 159, 18);
		contentPane.add(lblTotalAdoptions);
		
		JLabel lblPerformanceScore = new JLabel("Adoptions Handled:");
		lblPerformanceScore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerformanceScore.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblPerformanceScore.setBounds(10, 299, 159, 18);
		contentPane.add(lblPerformanceScore);
		
		JLabel lblBonusPenalty = new JLabel("Returning Adopters:");
		lblBonusPenalty.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBonusPenalty.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblBonusPenalty.setBounds(10, 328, 159, 18);
		contentPane.add(lblBonusPenalty);
		
		JLabel lblReviewNotes = new JLabel("Notes:");
		lblReviewNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReviewNotes.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblReviewNotes.setBounds(10, 357, 159, 18);
		contentPane.add(lblReviewNotes);
		
		JLabel lblSuccesRate = new JLabel("Role");
		lblSuccesRate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSuccesRate.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSuccesRate.setBounds(10, 270, 159, 18);
		contentPane.add(lblSuccesRate);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(179, 430, 260, 62);
		contentPane.add(textArea_1);
		
		JLabel lblEmployee_1_2 = new JLabel("Status");
		lblEmployee_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_2.setBounds(203, 549, 92, 18);
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
		btnNewButton_2_1.setBounds(10, 548, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(199, 503, 100, 35);
		contentPane.add(btnApply);
	
		JLabel lblAdoptions = new JLabel();
		lblAdoptions.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdoptions.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAdoptions.setBounds(179, 241, 159, 18);
		contentPane.add(lblAdoptions);
        
		JLabel lblAdoptions_1 = new JLabel();
		lblAdoptions_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdoptions_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAdoptions_1.setBounds(179, 270, 159, 18);
		contentPane.add(lblAdoptions_1);
		 
		JLabel lblScore = new JLabel();
		lblScore.setHorizontalAlignment(SwingConstants.LEFT);
		lblScore.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblScore.setBounds(179, 299, 159, 18);
		contentPane.add(lblScore);
		
		JLabel lblBonus = new JLabel();
		lblBonus.setHorizontalAlignment(SwingConstants.LEFT);
		lblBonus.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblBonus.setBounds(179, 328, 159, 18);
		contentPane.add(lblBonus); 
		
		//Adds the Search Button
//		JButton searchBtn = new JButton("Search");
//		searchBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				List<String> list = doesEmployeeExist(textPaneName.getText());
//				String[] listData = list.toArray(new String[0]);
//        		JList<String> jlist = new JList<>(listData);
//	            jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Single selection
//	            jlist.setLayoutOrientation(JList.VERTICAL); // Display items vertically
//	            scrollPane.setViewportView(jlist);
//	            
//	            //jlist action listener for action performed
//	             jlist.addListSelectionListener(l -> {
//    					if (!l.getValueIsAdjusting()) { // To avoid handling intermediate states
//        				String selectedValue = jlist.getSelectedValue();
//				        if (selectedValue != null) {
//				        	lblAdoptions.setText(getHoursworked(selectedValue));
//				        	lblAdoptions_1.setText(getRole(selectedValue));
//				        	lblScore.setText(getTotalAdoptions(selectedValue));
//				        	lblBonus.setText(getReturnees(selectedValue));
//				        
//				        	btnApply.addActionListener(new ActionListener() {
//				    		public void actionPerformed(ActionEvent e) {
//				    		String notesText = textArea_1.getText();
//				    				
//				    		if (!notesText.isEmpty()) {
//				    		         JOptionPane.showMessageDialog(null, "Notes is empty");
//				    		         return;
//				    		}
//				    		else {
//				    		    	JOptionPane.showMessageDialog(null, updateEmployeeNotes(selectedValue, notesText));
//				    		}
//		    			}
//				        }
//				        }
//    					});
//	             }
//			});
//		searchBtn.setBounds(339, 74, 89, 23);
//		contentPane.add(searchBtn);
//		}
	}
	
	
		// add a search button beside the textbox
		// return a list of employees
	private List<String> doesEmployeeExist(String employeeName) {
		String employeeNm = employeeName.trim();
		String sqlQuery = "SELECT first_name, last_name FROM employee WHERE first_name = ?";
		 List<String> list = new ArrayList<>();
		try (Connection conn = dbConnector.getConnection()){
     	PreparedStatement pstmt = conn.prepareStatement(sqlQuery); 

    	pstmt.setString(1, employeeNm);

    	try (ResultSet rs = pstmt.executeQuery()) {
    		
    		while (rs.next()) {
    			// add the results to the listbox below the search field
    			list.add(rs.getString("first_name") + " " + rs.getString("last_name"));
    		}
            
    	}
		} catch (SQLException e) {
    	e.printStackTrace();
		}
		return list;
	}
		
	//get the hours worked of the employee
  	private String getHoursworked(String employeeName){
 		String sqlQuery = "SELECT number_of_hours_worked" 
 						+ "FROM employee e" 
 						+ "WHERE first_name = ? AND last_name = ?";
 		
		 try (Connection conn = dbConnector.getConnection()){
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery); 
				String[] nameParts = employeeName.split(" ");
				if (nameParts.length == 2) {
				    pstmt.setString(1, nameParts[0]); // First name
				    pstmt.setString(2, nameParts[1]); // Last name
				}
					
				try(ResultSet rs = pstmt.executeQuery()) {
					if(rs.next()) {
						return rs.getString("number_of_hours_worked") + "Hours";
					}
					else{
					return "0 Adoptions Handled"; }
					}
					
				}catch (SQLException e) {
		        	e.printStackTrace();
		    	}
		    	return "ERROR";
 	}
 	
  	//get the role of the employee
 	private String getRole(String employeeName){
 		String sqlQuery = "SELECT role FROM employee e WHERE first_name = ? AND last_name = ?";
		 try (Connection conn = dbConnector.getConnection()){
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery); 
				String[] nameParts = employeeName.split(" ");
				if (nameParts.length == 2) {
				    pstmt.setString(1, nameParts[0]); // First name
				    pstmt.setString(2, nameParts[1]); // Last name
				}
				try(ResultSet rs = pstmt.executeQuery()) {
					if(rs.next()) {
						return rs.getString("role");
					}
					else{
					return "0 Adoptions Handled"; }
					}
					
				}catch (SQLException e) {
		        	e.printStackTrace();
		    	}
		    	return "ERROR";
 	}
 	
 	//get total adoptions facilitated by employee
	private String getTotalAdoptions(String employeeName) {
		String sqlQuery = "SELECT COUNT(a.adoption_id) as total_adoptions"
						+ "FROM employee e"
						+ "LEFT JOIN adoption a"
						+ "ON e.employee_id = a.employee_id"
						+ "WHERE first_name = ? AND last_name = ?";
		try (Connection conn = dbConnector.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery); 
			pstmt.setString(1, employeeName);
			String[] nameParts = employeeName.split(" ");
			if (nameParts.length == 2) {
			    pstmt.setString(1, nameParts[0]); // First name
			    pstmt.setString(2, nameParts[1]); // Last name
			}
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return rs.getString("total_adoptions") + "Total Adoptions Handled";
				}
				else{
				return "0 Adoptions Handled"; }
			}
			
			
		}catch (SQLException e) {
        	e.printStackTrace();
    	}
    	return "ERROR";
	}
	
	//returns for adoptions facilitated by the employee.
	private String getReturnees (String employeeName){
		String sqlQuery = "SELECT e.employee_id, e.first_name, e.last_name, COUNT(DISTINCT a.adopter_id) AS total_returning_visits"
						   + "FROM employee e"
						   + "LEFT JOIN adoption a ON e.employee_id = a.employee_id"
						   + "WHERE first_name = ? AND last_name = ?"
						   + "GROUP BY e.employee_id, e.first_name, e.last_name"
						   + "HAVING total_returning_visitors > 1";
						   
		try (Connection conn = dbConnector.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery); 
			String[] nameParts = employeeName.split(" ");
			if (nameParts.length == 2) {
			    pstmt.setString(1, nameParts[0]); // First name
			    pstmt.setString(2, nameParts[1]); // Last name
			}
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return rs.getString("total_returning_visits") + "Returnees";
				}
				else{
				return "0 Returnees"; }
			}
			
			
		}catch (SQLException e) {
        	e.printStackTrace();
    	}
    	return "ERROR";
    	
	}
	
	//updates the employee notes
	private String updateEmployeeNotes(String employeeName, String notesText) {
	    String sqlQuery = "UPDATE employee SET notes = ? WHERE first_name = ? AND last_name = ?";

	    try (Connection conn = dbConnector.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {

	        // Set the parameters
	        pstmt.setString(1, notesText);  // Set notes
	        String[] nameParts = employeeName.split(" ");
			if (nameParts.length == 2) {
			    pstmt.setString(1, nameParts[0]); // First name
			    pstmt.setString(2, nameParts[1]); // Last name
			}

	        // Execute the update
	        int rowsUpdated = pstmt.executeUpdate();
	        if (rowsUpdated > 0) {
	            return "Notes updated successfully";
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return "Error";
	}
}
	
	

