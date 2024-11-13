package app;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdoptionHistory extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DatabaseConnector dbConnector = new DatabaseConnector();
    private JTable adoptionTable;

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
        
        JLabel lblYear = new JLabel("Year");
        lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
        lblYear.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblYear.setBounds(60, 437, 92, 18);
        contentPane.add(lblYear);
        
        JTextPane textPaneYear = new JTextPane();
        textPaneYear.setBounds(161, 435, 177, 23);
        contentPane.add(textPaneYear);
        
        JLabel lblMonth = new JLabel("Month");
        lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMonth.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblMonth.setBounds(60, 471, 92, 18);
        contentPane.add(lblMonth);
        
        JTextPane textPaneMonth = new JTextPane();
        textPaneMonth.setBounds(161, 469, 177, 23);
        contentPane.add(textPaneMonth);
        
        // Back Button
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
        btnLoadHistory.setBackground(new Color(255, 255, 255));
        btnLoadHistory.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnLoadHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String yearText = textPaneYear.getText();
                String monthText = textPaneMonth.getText();
                
                try {
                    int year = Integer.parseInt(yearText);
                    int month = Integer.parseInt(monthText);

                    if (month < 1 || month > 12) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid month (1-12).");
                    } else {
                        ResultSet resultSet = dbConnector.fetchAdoptionHistory(year, month);

                        adoptionTable = new JTable(buildTableModel(resultSet));
                        scrollPane.setViewportView(adoptionTable);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values for year and month.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error fetching adoption history: " + ex.getMessage());
                }
            }
        });
        btnLoadHistory.setBounds(189, 506, 120, 23);
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
