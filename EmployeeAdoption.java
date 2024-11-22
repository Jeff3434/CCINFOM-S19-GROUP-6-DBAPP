package app;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EmployeeAdoption extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DatabaseConnector dbConnector = new DatabaseConnector();
    
    private JTable employeeAdoptionTable;
    private JTable employeeTable; // New JTable for employee list

    public EmployeeAdoption() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 840, 605);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblEmployeeAdoption = new JLabel("Employee Adoption");
        lblEmployeeAdoption.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmployeeAdoption.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblEmployeeAdoption.setBounds(10, 11, 804, 32);
        contentPane.add(lblEmployeeAdoption);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 54, 804, 349);
        contentPane.add(scrollPane);
        
        JLabel lblEmployee = new JLabel("Employee");
        lblEmployee.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblEmployee.setBounds(76, 414, 92, 18);
        contentPane.add(lblEmployee);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reports reports = new Reports();
                reports.setVisible(true);
                dispose();
            }
        });
        btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(10, 527, 89, 23);
        contentPane.add(btnBack);
        
        JButton btnLoadHistory = new JButton("Load History");
        btnLoadHistory.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnLoadHistory.setBackground(new Color(255, 255, 255));
        btnLoadHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row index from the employeeTable
                int selectedRow = employeeTable.getSelectedRow();
                
                // Check if a row is selected
                if (selectedRow != -1) {
                    // Retrieve employee information from the selected row
                    int employeeId = (int) employeeTable.getValueAt(selectedRow, 0);  // Assuming the first column is employee_id
                    String firstName = (String) employeeTable.getValueAt(selectedRow, 1);  // Assuming the second column is first_name
                    String lastName = (String) employeeTable.getValueAt(selectedRow, 2);  // Assuming the third column is last_name
                    
                    // Combine the first and last name as the employeeName
                    String employeeName = firstName + " " + lastName;
                    
                    try {
                        // Fetch employee adoption data using employeeName
                        ResultSet resultSet = dbConnector.fetchEmployeeAdoptionData(employeeId);

                        // Display the adoption data in the employeeAdoptionTable
                        employeeAdoptionTable = new JTable(buildTableModel(resultSet));
                        scrollPane.setViewportView(employeeAdoptionTable);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error fetching employee adoption data: " + ex.getMessage());
                    }
                } else {
                    // If no employee is selected, show an error message
                    JOptionPane.showMessageDialog(null, "Please select an employee from the list.");
                }
            }
        });
        btnLoadHistory.setBounds(352, 527, 120, 23);
        contentPane.add(btnLoadHistory);
        
        JScrollPane scrollPaneEmployee = new JScrollPane();
        scrollPaneEmployee.setBounds(76, 432, 177, 89);
        contentPane.add(scrollPaneEmployee);
        
        // Populate the employee list
        populateEmployeeList(scrollPaneEmployee);
    }

    // Method to populate the employee list in the scroll pane
    private void populateEmployeeList(JScrollPane scrollPaneEmployee) {
        try {
            ResultSet rs = dbConnector.fetchEmployeeList(); // Create this method in your DatabaseConnector class
            employeeTable = new JTable(buildTableModel(rs));
            employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPaneEmployee.setViewportView(employeeTable);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching employee data: " + ex.getMessage());
        }
    }

    // Method to build the table model from the ResultSet
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
