package app;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdoptionTrends extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable adoptionTrendsTable;
    private DatabaseConnector dbConnector = new DatabaseConnector(); 

    public AdoptionTrends() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 840, 605);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAdoptionTrends = new JLabel("Adoption Trends");
        lblAdoptionTrends.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdoptionTrends.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblAdoptionTrends.setBounds(10, 11, 804, 32);
        contentPane.add(lblAdoptionTrends);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 54, 804, 349);
        contentPane.add(scrollPane);

        JTextField textPaneMonth = new JTextField();
        textPaneMonth.setBounds(324, 469, 177, 23);
        contentPane.add(textPaneMonth);

        JLabel lblMonth = new JLabel("Month");
        lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMonth.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblMonth.setBounds(223, 471, 92, 18);
        contentPane.add(lblMonth);

        JLabel lblYear = new JLabel("Year");
        lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
        lblYear.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblYear.setBounds(223, 437, 92, 18);
        contentPane.add(lblYear);

        JTextField textPaneYear = new JTextField();
        textPaneYear.setBounds(324, 435, 177, 23);
        contentPane.add(textPaneYear);

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

        JButton btnLoadTrends = new JButton("Load Trends");
        btnLoadTrends.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String monthStr = textPaneMonth.getText().trim();
                String yearStr = textPaneYear.getText().trim();

                if (monthStr.isEmpty() || yearStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both month and year.");
                } else {
                    try {
                        int month = Integer.parseInt(monthStr);
                        int year = Integer.parseInt(yearStr);
                        ResultSet resultSet = dbConnector.fetchAdoptionTrends(year, month);

                        adoptionTrendsTable = new JTable(buildTableModel(resultSet));
                        scrollPane.setViewportView(adoptionTrendsTable);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error fetching adoption trends: " + ex.getMessage());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter valid numeric values for month and year.");
                    }
                }
            }
        });
        btnLoadTrends.setBounds(352, 506, 120, 23);
        contentPane.add(btnLoadTrends);
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
