package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class EmployeePerformance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DatabaseConnector dbConnector = new DatabaseConnector();

	public EmployeePerformance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeReview = new JLabel("Employee Performance Review");
		lblEmployeeReview.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeReview.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblEmployeeReview.setBounds(10, 22, 479, 32);
		contentPane.add(lblEmployeeReview);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 108, 296, 111);
		contentPane.add(scrollPane);
		
		JTextField textFieldName = new JTextField();
		textFieldName.setBounds(111, 74, 296, 23);
		contentPane.add(textFieldName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblName.setBounds(10, 76, 92, 18);
		contentPane.add(lblName);
		
		JLabel lblHoursWorked = new JLabel("Hours Worked");
		lblHoursWorked.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoursWorked.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblHoursWorked.setBounds(10, 270, 159, 18);
		contentPane.add(lblHoursWorked);
		
		JLabel lblHours = new JLabel(" ");
		lblHours.setHorizontalAlignment(SwingConstants.LEFT);
		lblHours.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblHours.setBounds(179, 270, 286, 18);
		contentPane.add(lblHours);		
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRole.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblRole.setBounds(10, 241, 159, 18);
		contentPane.add(lblRole);
		
		JLabel lblRoleVar = new JLabel(" ");
		lblRoleVar.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoleVar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblRoleVar.setBounds(179, 241, 286, 18);
		contentPane.add(lblRoleVar);
		
		JLabel lblAdoptionsHandled = new JLabel("Adoptions Handled");
		lblAdoptionsHandled.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdoptionsHandled.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAdoptionsHandled.setBounds(10, 299, 159, 18);
		contentPane.add(lblAdoptionsHandled);
		
		JLabel lblTotalAdopt = new JLabel(" ");
		lblTotalAdopt.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalAdopt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblTotalAdopt.setBounds(179, 299, 286, 18);
		contentPane.add(lblTotalAdopt);
		
		JLabel lblSuccessRate = new JLabel("Success Rate");
		lblSuccessRate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSuccessRate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSuccessRate.setBounds(10, 328, 159, 18);
		contentPane.add(lblSuccessRate);
		
		JLabel lblRate = new JLabel(" ");
		lblRate.setHorizontalAlignment(SwingConstants.LEFT);
		lblRate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblRate.setBounds(179, 328, 286, 18);
		contentPane.add(lblRate);
		
		JLabel lblReviewNotes = new JLabel("Notes");
		lblReviewNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReviewNotes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblReviewNotes.setBounds(10, 411, 159, 18);
		contentPane.add(lblReviewNotes);
		
		JTextArea textAreaNotes = new JTextArea();
		textAreaNotes.setBounds(180, 357, 285, 129);
		contentPane.add(textAreaNotes); 
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBApp dbApp = new DBApp();
				dbApp.setVisible(true);
				
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(10, 548, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(199, 514, 100, 35);
		contentPane.add(btnApply);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnSearch.setBounds(417, 74, 67, 23);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        List<String> list = doesEmployeeExist(textFieldName.getText());
		        String[] listData = list.toArray(new String[0]);
		        JList<String> jlist = new JList<>(listData);
		        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        jlist.setLayoutOrientation(JList.VERTICAL);
		        scrollPane.setViewportView(jlist);

		        jlist.addListSelectionListener(l -> {
		            if (!l.getValueIsAdjusting()) {
		                String selectedValue = jlist.getSelectedValue();
		                if (selectedValue != null) {
		                    String[] parts = selectedValue.split(" - ", 2);
		                    if (parts.length == 2) {
		                        String employeeId = parts[0]; 
		                        String fullName = parts[1];  

		                        lblRoleVar.setText(getRole(fullName));
		                        lblHours.setText(getHoursworked(fullName));
		                        lblTotalAdopt.setText(getTotalAdoptions(fullName));
		                        lblRate.setText(getRate(fullName));

		                        btnApply.addActionListener(new ActionListener() {
		                            public void actionPerformed(ActionEvent e) {
		                                String notesText = textAreaNotes.getText();

		                                if (notesText.isEmpty()) {
		                                    JOptionPane.showMessageDialog(null, "Notes is empty.");
		                                    return;
		                                } else {
		                                    JOptionPane.showMessageDialog(null, updateEmployeeNotes(fullName, notesText));
		                                }
		                            }
		                        });
		                    }
		                }
		            }
		        });
		    }
		});
	}
	
	private List<String> doesEmployeeExist(String employeeName) {
	    String employeeNm = employeeName.trim() + "%";
	    String sqlQuery = "SELECT employee_id, first_name, last_name FROM employee WHERE first_name LIKE ?";
	    List<String> list = new ArrayList<>();
	    try (Connection conn = dbConnector.getConnection()) {
	        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
	        pstmt.setString(1, employeeNm);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                int employeeId = rs.getInt("employee_id");
	                String firstName = rs.getString("first_name");
	                String lastName = rs.getString("last_name");
	                list.add(employeeId + " - " + firstName + " " + lastName);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	
	private String getHoursworked(String employeeName){
 		String sqlQuery = "SELECT number_of_hours_worked " 
 						+ "FROM employee " 
 						+ "WHERE first_name = ? AND last_name = ?";
 		
		 try (Connection conn = dbConnector.getConnection()){
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery); 
				String[] nameParts = employeeName.split(" ");
				if (nameParts.length == 2) {
				    pstmt.setString(1, nameParts[0]); 
				    pstmt.setString(2, nameParts[1]); 
				}
					
				try(ResultSet rs = pstmt.executeQuery()) {
					if(rs.next()) {
						return rs.getString("number_of_hours_worked") + " Hours";
					}
					else{
					return "0 Hours Worked"; }
					}
					
				}catch (SQLException e) {
		        	e.printStackTrace();
		    	}
		    	return "ERROR";
 	}
	
	private String getRole(String employeeName){
 		String sqlQuery = "SELECT employee_role FROM employee e WHERE first_name = ? AND last_name = ?";
		 try (Connection conn = dbConnector.getConnection()){
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery); 
				employeeName.replaceFirst("^\\d+\\s*-\\s*", "");
				String[] nameParts = employeeName.split(" ");
				if (nameParts.length == 2) {
				    pstmt.setString(1, nameParts[0]); 
				    pstmt.setString(2, nameParts[1]); 
				}
				try(ResultSet rs = pstmt.executeQuery()) {
					if(rs.next()) {
						return rs.getString("employee_role");
					}
					else{
					return "0 Adoptions Handled"; }
					}
					
				}catch (SQLException e) {
		        	e.printStackTrace();
		    	}
		    	return "ERROR";
 	}
	
	private String getTotalAdoptions(String employeeName) {
	    String sqlQuery = "SELECT COUNT(a.adoption_id) AS total_adoptions " +
	                      "FROM employee e " +
	                      "LEFT JOIN adoption a ON e.employee_id = a.employee_id " +
	                      "WHERE e.first_name = ? AND e.last_name = ?";

	    try (Connection conn = dbConnector.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {

	        String[] nameParts = employeeName.split(" ");
	        if (nameParts.length == 2) {
	            pstmt.setString(1, nameParts[0]); 
	            pstmt.setString(2, nameParts[1]); 
	        } 

	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getString("total_adoptions");
	            } else {
	                return "0";
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return "ERROR";
	}

	private String getRate(String employeeName) {
	    String sqlQuery1 = "SELECT COUNT(DISTINCT a.adopter_id) AS total_returning_visits " +
	                       "FROM employee e " +
	                       "LEFT JOIN adoption a ON e.employee_id = a.employee_id " +
	                       "WHERE e.first_name = ? AND e.last_name = ? " +
	                       "GROUP BY e.employee_id " +
	                       "HAVING COUNT(DISTINCT a.adopter_id) > 1";

	    String sqlQuery2 = "SELECT COUNT(adopter_id) AS total_adoptions FROM adoption";

	    try (Connection conn = dbConnector.getConnection()) {
	        PreparedStatement pstmt1 = conn.prepareStatement(sqlQuery1);
	        PreparedStatement pstmt2 = conn.prepareStatement(sqlQuery2);

	        String[] nameParts = employeeName.split(" ");
	        if (nameParts.length == 2) {
	            pstmt1.setString(1, nameParts[0]);
	            pstmt1.setString(2, nameParts[1]);
	        }

	        int returnees = 0;
	        int totalAdoptions = 0;

	        try (ResultSet rs1 = pstmt1.executeQuery()) {
	            if (rs1.next()) {
	                returnees = rs1.getInt("total_returning_visits");
	            }
	        }

	        try (ResultSet rs2 = pstmt2.executeQuery()) {
	            if (rs2.next()) {
	                totalAdoptions = rs2.getInt("total_adoptions");
	            }
	        }

	        if (totalAdoptions > 0) {
	            double percent = ((double) returnees / totalAdoptions) * 100;
	            return String.format("%.2f%%", percent);
	        } else {
	            return "0%";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return "ERROR";
	}

	
	private String updateEmployeeNotes(String employeeName, String notesText) {
	    String sqlQuery = "UPDATE employee SET notes = ? WHERE first_name = ? AND last_name = ?";

	    try (Connection conn = dbConnector.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sqlQuery)) {

	        pstmt.setString(1, notesText);
	        String[] nameParts = employeeName.replaceFirst("^\\d+\\s*-\\s*", "").split(" ");
	        if (nameParts.length == 2) {
	            pstmt.setString(2, nameParts[0]);
	            pstmt.setString(3, nameParts[1]);
	        }

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
