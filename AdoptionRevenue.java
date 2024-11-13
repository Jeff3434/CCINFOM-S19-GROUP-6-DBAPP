package app;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdoptionRevenue extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable revenueTable;
    private DatabaseConnector dbConnector = new DatabaseConnector();

    public AdoptionRevenue() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 515, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAdoptionRevenue = new JLabel("Adoption Revenue");
        lblAdoptionRevenue.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdoptionRevenue.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblAdoptionRevenue.setBounds(10, 11, 479, 32);
        contentPane.add(lblAdoptionRevenue);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 54, 479, 349);
        contentPane.add(scrollPane);

        JLabel lblMonth = new JLabel("Month");
        lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMonth.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblMonth.setBounds(60, 437, 92, 18);
        contentPane.add(lblMonth);

        JTextPane textPaneMonth = new JTextPane();
        textPaneMonth.setBounds(161, 435, 177, 23);
        contentPane.add(textPaneMonth);

        JTextPane textPaneYear = new JTextPane();
        textPaneYear.setBounds(161, 469, 177, 23);
        contentPane.add(textPaneYear);

        JLabel lblYear = new JLabel("Year");
        lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
        lblYear.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblYear.setBounds(60, 471, 92, 18);
        contentPane.add(lblYear);

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

        JButton btnLoadRevenue = new JButton("Load Revenue");
        btnLoadRevenue.setBackground(new Color(255, 255, 255));
        btnLoadRevenue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String monthStr = textPaneMonth.getText().trim();
                String yearStr = textPaneYear.getText().trim();

                if (monthStr.isEmpty() || yearStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both month and year.");
                } else {
                    try {
                        int month = Integer.parseInt(monthStr);
                        int year = Integer.parseInt(yearStr);
                        ResultSet resultSet = dbConnector.fetchAdoptionRevenue(year, month);

                        revenueTable = new JTable(buildTableModel(resultSet));
                        scrollPane.setViewportView(revenueTable);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error fetching adoption revenue data: " + ex.getMessage());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter valid numeric values for month and year.");
                    }
                }
            }
        });
        btnLoadRevenue.setBounds(189, 503, 120, 23);
        contentPane.add(btnLoadRevenue);
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
