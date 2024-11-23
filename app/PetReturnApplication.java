package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Choice;

public class PetReturnApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private Choice choiceEmployee;
	private Choice choiceBreed;
	private Choice choiceSpecies;
	private Choice choiceAdopter;
	private DatabaseConnector dbConnector = new DatabaseConnector();
	
	public PetReturnApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	    
		JTextArea textAreaReason = new JTextArea();
		textAreaReason.setBounds(111, 186, 453, 47);
		contentPane.add(textAreaReason);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblReason.setBounds(10, 200, 92, 18);
		contentPane.add(lblReason);
		
		JLabel lblPetReturnApplication = new JLabel("Pet Return Application");
		lblPetReturnApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetReturnApplication.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPetReturnApplication.setBounds(10, 11, 554, 32);
		contentPane.add(lblPetReturnApplication);
		
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
		btnNewButton_2_1.setBounds(10, 417, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(452, 72, 97, 23);
		contentPane.add(textFieldName);
		
		choiceSpecies = new Choice();
		choiceSpecies.setBounds(452, 101, 97, 20);
		contentPane.add(choiceSpecies);
		choiceSpecies.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectedSpecies = choiceSpecies.getSelectedItem();
                if (selectedSpecies != null && !selectedSpecies.isEmpty()) {
                    populateBreedsChoice(selectedSpecies);
                }
            }
        });
		
		choiceBreed = new Choice();
		choiceBreed.setBounds(452, 126, 97, 20);
		contentPane.add(choiceBreed);
		
		JLabel lblEmployee_1_1_2 = new JLabel("Breed");
		lblEmployee_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_1_2.setBounds(351, 127, 92, 18);
		contentPane.add(lblEmployee_1_1_2);
		
		JLabel lblEmployee_1_1_1_1 = new JLabel("Species");
		lblEmployee_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_1_1_1.setBounds(351, 102, 92, 18);
		contentPane.add(lblEmployee_1_1_1_1);
		
		JLabel lblEmployee_1_2 = new JLabel("Name");
		lblEmployee_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_2.setBounds(351, 74, 92, 18);
		contentPane.add(lblEmployee_1_2);
		
		JScrollPane scrollPanePet = new JScrollPane();
		scrollPanePet.setBounds(111, 72, 279, 102);
		contentPane.add(scrollPanePet);
		
		choiceAdopter = new Choice();
		choiceAdopter.setBounds(111, 261, 279, 20);
		contentPane.add(choiceAdopter);
		
		JLabel lblPets = new JLabel("Search Pet");
		lblPets.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPets.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPets.setBounds(10, 114, 92, 18);
		contentPane.add(lblPets);
		
		JLabel lblPetCount_1_1 = new JLabel("<html>\r\n<div style='text-align: center;'>\r\nAdopter<br> \r\nName\r\n</div>\r\n</html>");
		lblPetCount_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPetCount_1_1.setBounds(10, 244, 92, 55);
		contentPane.add(lblPetCount_1_1);
		
		choiceEmployee = new Choice();
		choiceEmployee.setBounds(111, 324, 164, 20);
		contentPane.add(choiceEmployee);
		
		JLabel lblPetCount_1_1_1 = new JLabel("<html>\r\n<div style='text-align: center;'>\r\nHandling<br> \r\nEmployee\r\n</div>\r\n</html>");
		lblPetCount_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPetCount_1_1_1.setBounds(10, 307, 92, 55);
		contentPane.add(lblPetCount_1_1_1);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnFilter.setBackground(Color.WHITE);
		btnFilter.setBounds(456, 152, 89, 23);
		contentPane.add(btnFilter);
		btnFilter.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String breedFilter = choiceBreed.getSelectedItem();
		        String speciesFilter = choiceSpecies.getSelectedItem();
		        String nameFilter = textFieldName.getText().toLowerCase();

		        String sqlQuery = "SELECT pet_id, pet_name, breed, species, adoption_status FROM pet WHERE adoption_status = 'adopted'"; 
		        
		        if (!breedFilter.equals("All")) {  
		            sqlQuery += " AND breed = ?"; 
		        }
		        if (!speciesFilter.equals("All")) { 
		            sqlQuery += " AND species = ?"; 
		        }
		        if (!nameFilter.isEmpty()) {
		            sqlQuery += " AND LOWER(pet_name) LIKE ?"; 
		        }

		        try (Connection conn = dbConnector.getConnection()) {
		            PreparedStatement stmt = conn.prepareStatement(sqlQuery);

		            int paramIndex = 1;
		            if (!breedFilter.equals("All")) {
		                stmt.setString(paramIndex++, breedFilter);
		            }
		            if (!speciesFilter.equals("All")) {
		                stmt.setString(paramIndex++, speciesFilter);
		            }
		            if (!nameFilter.isEmpty()) {
		                stmt.setString(paramIndex++, nameFilter + "%");
		            }

		            ResultSet rs = stmt.executeQuery();

		            DefaultTableModel model = new DefaultTableModel(new String[]{"Pet ID", "Pet Name", "Breed", "Species", "Adoption Status"}, 0);

		            while (rs.next()) {
		                int petId = rs.getInt("pet_id");
		                String petName = rs.getString("pet_name");
		                String breed = rs.getString("breed");
		                String species = rs.getString("species");
		                String adoptionStatus = rs.getString("adoption_status");

		                model.addRow(new Object[]{petId, petName, breed, species, adoptionStatus});
		            }

		            JTable table = new JTable(model);
		            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		            scrollPanePet.setViewportView(table);

		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Error fetching pet data: " + ex.getMessage());
		            ex.printStackTrace();
		        }
		    }
		});
		
		JButton btnLookUp = new JButton("Look Up");
		btnLookUp.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnLookUp.setBackground(Color.WHITE);
		btnLookUp.setBounds(414, 260, 89, 23);
		contentPane.add(btnLookUp);
		btnLookUp.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JTable petTable = (JTable) scrollPanePet.getViewport().getView();
		        int selectedRow = petTable.getSelectedRow();
		        
		        if (selectedRow != -1) {
		            int petId = (int) petTable.getValueAt(selectedRow, 0);
		            
		            String query = "SELECT adopter.adopter_id, adopter.first_name, adopter.last_name "
		                         + "FROM adoption INNER JOIN adopter ON adoption.adopter_id = adopter.adopter_id "
		                         + "WHERE adoption.pet_id = ?";
		            
		            try (Connection conn = dbConnector.getConnection();
		                 PreparedStatement stmt = conn.prepareStatement(query)) {
		                stmt.setInt(1, petId); 
		                ResultSet rs = stmt.executeQuery();
		                
		                if (rs.next()) {
		                    int adopterId = rs.getInt("adopter_id");
		                    String adopterName = rs.getString("first_name") + " " + rs.getString("last_name");
		                    
		                    choiceAdopter.removeAll();
		                    choiceAdopter.add(adopterId + " - " + adopterName);
		                } else {
		                    JOptionPane.showMessageDialog(null, "No adopter found for the selected pet.");
		                }
		                
		            } catch (SQLException ex) {
		                JOptionPane.showMessageDialog(null, "Error fetching adopter data: " + ex.getMessage());
		                ex.printStackTrace();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a pet from the table.");
		        }
		    }
		});

		populateEmployeeChoice();
        populateSpeciesChoice();
        
        JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(237, 368, 100, 35);
		contentPane.add(btnApply);
		btnApply.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JTable petTable = (JTable) scrollPanePet.getViewport().getView();
		        
		        if (petTable == null) {
		            JOptionPane.showMessageDialog(null, "Search for a pet.");
		            return;
		        }
		        
		        int selectedRow = petTable.getSelectedRow();
		        
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Please select a pet from the table.");
		            return;
		        }
		        
		        int petId = (int) petTable.getValueAt(selectedRow, 0);
		        
		        if (choiceEmployee.getSelectedItem() == null) {
		            JOptionPane.showMessageDialog(null, "Please select an employee.");
		            return;
		        }
		        
		        String employeeIdStr = choiceEmployee.getSelectedItem().toString().split(" - ")[0].replace("[", "").replace("]", "");
		        int employeeId = Integer.parseInt(employeeIdStr);
		        
		        if (choiceAdopter.getSelectedItem() == null) {
		            JOptionPane.showMessageDialog(null, "Please select an adopter.");
		            return;
		        }
		        
		        String adopterIdStr = choiceAdopter.getSelectedItem().toString().split(" - ")[0].replace("[", "").replace("]", "");
		        int adopterId = Integer.parseInt(adopterIdStr);
		        
		        String reason = textAreaReason.getText();
		        if (reason.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please provide a reason for the return.");
		            return;
		        }
		        
		        java.sql.Date adoptionDate = new java.sql.Date(System.currentTimeMillis());
		        int returnFee = 1000;
		        
		        int confirmation = JOptionPane.showConfirmDialog(null, 
		            "The return fee is " + returnFee + ". Do you want to proceed?", 
		            "Confirm Adoption", 
		            JOptionPane.YES_NO_OPTION);
		        
		        if (confirmation == JOptionPane.YES_OPTION) {
		        	String insertAdoptionQuery = "INSERT INTO adoption (pet_id, adopter_id, employee_id, adoption_date, adoption_fee) "
                            + "VALUES (?, ?, ?, ?, ?)";

					try (Connection conn = dbConnector.getConnection();
					     PreparedStatement stmt = conn.prepareStatement(insertAdoptionQuery)) {
					    
					    System.out.println("Inserting adoption with pet_id: " + petId + ", adopter_id: " + adopterId +
					                       ", employee_id: " + employeeId + ", adoption_date: " + adoptionDate + ", adoption_fee: " + returnFee);
					    
					    stmt.setInt(1, petId);
					    stmt.setInt(2, adopterId);
					    stmt.setInt(3, employeeId);
					    stmt.setDate(4, adoptionDate);
					    stmt.setInt(5, returnFee);
					    
					    int rowsAffected = stmt.executeUpdate();
					    System.out.println("Rows affected: " + rowsAffected); // Check if any rows were inserted
					    
					} catch (SQLException ex) {
					    JOptionPane.showMessageDialog(null, "Error updating adoption data: " + ex.getMessage());
					    ex.printStackTrace();
					}

		            
		            String updatePetQuery = "UPDATE pet SET adoption_status = 'returned' WHERE pet_id = ?";
		            
		            try (Connection conn = dbConnector.getConnection();
		                 PreparedStatement stmt = conn.prepareStatement(updatePetQuery)) {
		                stmt.setInt(1, petId);
		                stmt.executeUpdate();
		            } catch (SQLException ex) {
		                JOptionPane.showMessageDialog(null, "Error updating pet status: " + ex.getMessage());
		                ex.printStackTrace();
		            }
		            
		            String updateAdopterQuery = "UPDATE adopter SET adopter_type = 'returnee', reason = ?, pet_count = pet_count - 1 WHERE adopter_id = ?";
		            
		            try (Connection conn = dbConnector.getConnection();
		                 PreparedStatement stmt = conn.prepareStatement(updateAdopterQuery)) {
		                stmt.setString(1, reason);
		                stmt.setInt(2, adopterId);
		                stmt.executeUpdate();
		            } catch (SQLException ex) {
		                JOptionPane.showMessageDialog(null, "Error updating adopter data: " + ex.getMessage());
		                ex.printStackTrace();
		            }
		            
		            JOptionPane.showMessageDialog(null, "Pet return processed successfully.");
		            
		        } else {
		            JOptionPane.showMessageDialog(null, "Pet return canceled.");
		        }
		    }
		});

	}
	
    private void populateSpeciesChoice() {
        String query = "SELECT DISTINCT species FROM pet"; 
        
        try (Connection conn = dbConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String species = rs.getString("species");
                choiceSpecies.add(species);  
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
    
    private void populateBreedsChoice(String species) {
		choiceBreed.removeAll();
		choiceBreed.add("All"); 
		try (Connection conn = dbConnector.getConnection()) {
			String sqlQuery = "SELECT DISTINCT breed FROM pet WHERE species = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlQuery);
			stmt.setString(1, species);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				choiceBreed.add(rs.getString("breed"));
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error fetching breeds: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		}
	}
    
    private void populateEmployeeChoice() {
        try (Connection conn = dbConnector.getConnection()) {
            String sqlQuery = "SELECT employee_id, first_name, last_name FROM employee";
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
                choiceEmployee.add(String.format("%d - %s", employeeId, fullName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching employee data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
