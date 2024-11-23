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
    private JTable employeeTable;

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
        lblEmployee.setBounds(239, 414, 92, 18);
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
                int selectedRow = employeeTable.getSelectedRow();
                
                if (selectedRow != -1) {
                    int employeeId = (int) employeeTable.getValueAt(selectedRow, 0);  
                    String firstName = (String) employeeTable.getValueAt(selectedRow, 1);  
                    String lastName = (String) employeeTable.getValueAt(selectedRow, 2);  
                    
                    String employeeName = firstName + " " + lastName;
                    
                    try {
                        ResultSet resultSet = dbConnector.fetchEmployeeAdoptionData(employeeId);

                        employeeAdoptionTable = new JTable(buildTableModel(resultSet));
                        scrollPane.setViewportView(employeeAdoptionTable);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error fetching employee adoption data: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an employee from the list.");
                }
            }
        });
        btnLoadHistory.setBounds(352, 532, 120, 23);
        contentPane.add(btnLoadHistory);
        
        JScrollPane scrollPaneEmployee = new JScrollPane();
        scrollPaneEmployee.setBounds(239, 437, 347, 89);
        contentPane.add(scrollPaneEmployee);
        
        populateEmployeeList(scrollPaneEmployee);
    }

    private void populateEmployeeList(JScrollPane scrollPaneEmployee) {
        try {
            ResultSet rs = dbConnector.fetchEmployeeList();
            employeeTable = new JTable(buildTableModel(rs));
            employeeTable.setLocation(248, 0);
            employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPaneEmployee.setViewportView(employeeTable);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching employee data: " + ex.getMessage());
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