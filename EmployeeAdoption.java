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

    public EmployeeAdoption() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 515, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblEmployeeAdoption = new JLabel("Employee Adoption");
        lblEmployeeAdoption.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmployeeAdoption.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblEmployeeAdoption.setBounds(10, 11, 479, 32);
        contentPane.add(lblEmployeeAdoption);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 54, 479, 349);
        contentPane.add(scrollPane);
        
        JLabel lblEmployee = new JLabel("Employee");
        lblEmployee.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblEmployee.setBounds(60, 430, 92, 18);
        contentPane.add(lblEmployee);
        
        JTextPane textPaneEmployee = new JTextPane();
        textPaneEmployee.setBounds(161, 428, 177, 23);
        contentPane.add(textPaneEmployee);
        
        JTextPane textPaneBreed = new JTextPane();
        textPaneBreed.setBounds(161, 462, 177, 23);
        contentPane.add(textPaneBreed);
        
        JTextPane textPaneSpecies = new JTextPane();
        textPaneSpecies.setBounds(161, 496, 177, 23);
        contentPane.add(textPaneSpecies);
        
        JLabel lblBreed = new JLabel("Breed");
        lblBreed.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBreed.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblBreed.setBounds(60, 464, 92, 18);
        contentPane.add(lblBreed);
        
        JLabel lblSpecies = new JLabel("Species");
        lblSpecies.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSpecies.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblSpecies.setBounds(60, 498, 92, 18);
        contentPane.add(lblSpecies);
        
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
                String employeeName = textPaneEmployee.getText().trim();
                String breed = textPaneBreed.getText().trim();
                String species = textPaneSpecies.getText().trim();
                
                if (employeeName.isEmpty() || breed.isEmpty() || species.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                } else {
                    try {
                        ResultSet resultSet = dbConnector.fetchEmployeeAdoptionData(employeeName, breed, species);

                        employeeAdoptionTable = new JTable(buildTableModel(resultSet));
                        scrollPane.setViewportView(employeeAdoptionTable);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error fetching employee adoption data: " + ex.getMessage());
                    }
                }
            }
        });
        btnLoadHistory.setBounds(357, 462, 120, 23);
        contentPane.add(btnLoadHistory);
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
