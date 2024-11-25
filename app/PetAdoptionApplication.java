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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Choice;
import javax.swing.JTextField;

public class PetAdoptionApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField textPaneNameFilter;
	private JScrollPane scrollPanePet;
	private final ButtonGroup buttonGroupGender = new ButtonGroup();
	private final ButtonGroup buttonGroupStatus = new ButtonGroup();
	private final ButtonGroup buttonGroupIncome = new ButtonGroup();
	private final ButtonGroup buttonGroupNewEx = new ButtonGroup();
	private Choice choiceEmployee;
	private Choice choiceBreed;
	private Choice choiceSpecies;
	private Choice choiceAdopter;
	private DatabaseConnector dbConnector = new DatabaseConnector();
	
	public PetAdoptionApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPetAdoptionApplication = new JLabel("Pet Adoption Application");
		lblPetAdoptionApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetAdoptionApplication.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPetAdoptionApplication.setBounds(10, 11, 549, 32);
		contentPane.add(lblPetAdoptionApplication);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblName.setBounds(10, 115, 92, 18);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Address");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAge.setBounds(10, 187, 92, 18);
		contentPane.add(lblAge);
		
		JLabel lblAge_1 = new JLabel("Age");
		lblAge_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAge_1.setBounds(10, 233, 92, 18);
		contentPane.add(lblAge_1);
		
		JTextField textPaneAge = new JTextField();
		textPaneAge.setBounds(111, 231, 141, 23);
		contentPane.add(textPaneAge);
		
		JLabel lblAge_1_1 = new JLabel("Sex");
		lblAge_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAge_1_1.setBounds(298, 235, 92, 18);
		contentPane.add(lblAge_1_1);
		
		JLabel lblName_1 = new JLabel("Contact");
		lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblName_1.setBounds(10, 295, 92, 18);
		contentPane.add(lblName_1);
		
		JTextField textPaneContact = new JTextField();
		textPaneContact.setBounds(111, 293, 448, 23);
		contentPane.add(textPaneContact);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblReason.setBounds(10, 341, 92, 18);
		contentPane.add(lblReason);
		
		JLabel lblPetCount = new JLabel("Income Level");
		lblPetCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPetCount.setBounds(10, 386, 92, 18);
		contentPane.add(lblPetCount);
		
		JLabel lblPetCount_1 = new JLabel("Pet Count");
		lblPetCount_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPetCount_1.setBounds(10, 420, 92, 18);
		contentPane.add(lblPetCount_1);
		
		scrollPanePet = new JScrollPane();
		scrollPanePet.setBounds(111, 508, 279, 102);
		contentPane.add(scrollPanePet);
		
		JLabel lblPets = new JLabel("Search Pet");
		lblPets.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPets.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPets.setBounds(10, 550, 92, 18);
		contentPane.add(lblPets);
		
		textPaneNameFilter = new JTextField();
		textPaneNameFilter.setBounds(452, 508, 97, 23);
		contentPane.add(textPaneNameFilter);
		
		JLabel lblEmployee_1 = new JLabel("Name");
		lblEmployee_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1.setBounds(351, 510, 92, 18);
		contentPane.add(lblEmployee_1);
		
		JLabel lblEmployee_1_1 = new JLabel("Breed");
		lblEmployee_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_1.setBounds(351, 563, 92, 18);
		contentPane.add(lblEmployee_1_1);
		
		JLabel lblEmployee_1_1_1 = new JLabel("Species");
		lblEmployee_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_1_1.setBounds(351, 538, 92, 18);
		contentPane.add(lblEmployee_1_1_1);
		
		JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setBounds(111, 173, 448, 47);
		contentPane.add(textAreaAddress);
		
		JTextArea textAreaReason = new JTextArea();
		textAreaReason.setBounds(111, 327, 448, 47);
		contentPane.add(textAreaReason);
		
		JLabel lblAge_1_2 = new JLabel("Status");
		lblAge_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAge_1_2.setBounds(10, 264, 92, 18);
		contentPane.add(lblAge_1_2);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");
		buttonGroupStatus.add(rdbtnSingle);
		rdbtnSingle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnSingle.setBounds(111, 262, 69, 23);
		contentPane.add(rdbtnSingle);
		
		JRadioButton rdbtnMarried = new JRadioButton("Married");
		buttonGroupStatus.add(rdbtnMarried);
		rdbtnMarried.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnMarried.setBounds(182, 262, 70, 23);
		contentPane.add(rdbtnMarried);
		
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
		btnBack.setBounds(10, 657, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPetCount_1_1 = new JLabel("<html>\r\n<div style='text-align: center;'>\r\nHandling<br> \r\nEmployee\r\n</div>\r\n</html>");
		lblPetCount_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPetCount_1_1.setBounds(10, 449, 92, 55);
		contentPane.add(lblPetCount_1_1);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroupGender.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnMale.setBounds(408, 233, 69, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroupGender.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnFemale.setBounds(479, 233, 70, 23);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnLow = new JRadioButton("Low");
		buttonGroupIncome.add(rdbtnLow);
		rdbtnLow.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnLow.setBounds(111, 386, 69, 23);
		contentPane.add(rdbtnLow);
		
		JRadioButton rdbtnMiddle = new JRadioButton("Middle");
		buttonGroupIncome.add(rdbtnMiddle);
		rdbtnMiddle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnMiddle.setBounds(182, 386, 70, 23);
		contentPane.add(rdbtnMiddle);
		
		JRadioButton rdbtnHigh = new JRadioButton("High");
		buttonGroupIncome.add(rdbtnHigh);
		rdbtnHigh.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnHigh.setBounds(254, 386, 70, 23);
		contentPane.add(rdbtnHigh);
		
		choiceBreed = new Choice();
		choiceBreed.setBounds(452, 562, 97, 18);
		contentPane.add(choiceBreed);
		
		choiceSpecies = new Choice();
		choiceSpecies.setBounds(452, 537, 97, 20);
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
		
		Choice choicePetCount = new Choice();
		choicePetCount.setBounds(111, 419, 97, 20);
		contentPane.add(choicePetCount);
		for (int i = 1; i <= 4; i++) {
			choicePetCount.add(String.valueOf(i)); 
        }
		
		JTextField textPaneFirstName = new JTextField();
		textPaneFirstName.setBounds(112, 113, 447, 23);
		contentPane.add(textPaneFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblLastName.setBounds(10, 145, 92, 18);
		contentPane.add(lblLastName);
		
		JTextField textPaneLastName = new JTextField();
		textPaneLastName.setBounds(111, 143, 448, 23);
		contentPane.add(textPaneLastName);
		
		choiceEmployee = new Choice();
		choiceEmployee.setBounds(111, 466, 164, 20);
		contentPane.add(choiceEmployee);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnFilter.setBackground(Color.WHITE);
		btnFilter.setBounds(456, 588, 89, 23);
		contentPane.add(btnFilter);
		btnFilter.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String breedFilter = choiceBreed.getSelectedItem();
		        String speciesFilter = choiceSpecies.getSelectedItem();
		        String nameFilter = textPaneNameFilter.getText().toLowerCase();

		        String sqlQuery = "SELECT pet_id, pet_name, breed, species, adoption_status FROM pet WHERE 1=1";

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
		
		choiceAdopter = new Choice();
		choiceAdopter.setEnabled(false);
		choiceAdopter.setBounds(145, 79, 279, 20);
		contentPane.add(choiceAdopter);

		populateEmployeeChoice();
        populateSpeciesChoice();
        populateAdopterChoice();
		
		JRadioButton rdbtnNew = new JRadioButton("New");
		buttonGroupNewEx.add(rdbtnNew);
		rdbtnNew.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNew.setBounds(208, 50, 69, 23);
		contentPane.add(rdbtnNew);
		rdbtnNew.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtnNew.isSelected()) {
		            textPaneFirstName.setEditable(true);
		            textPaneLastName.setEditable(true);
		            textAreaAddress.setEditable(true);
		            textPaneAge.setEditable(true);
		            rdbtnMale.setEnabled(true);
		            rdbtnFemale.setEnabled(true);
		            rdbtnSingle.setEnabled(true);
		            rdbtnMarried.setEnabled(true);
		            textPaneContact.setEditable(true);
		            textAreaReason.setEditable(true);
		            rdbtnLow.setEnabled(true);
		            rdbtnMiddle.setEnabled(true);
		            rdbtnHigh.setEnabled(true);
		            choicePetCount.setEnabled(true);
		            
			        choiceAdopter.setEnabled(false);
		        }
		    }
		});
		rdbtnNew.setSelected(true);
	
		JRadioButton rdbtnExisting = new JRadioButton("Existing");
		buttonGroupNewEx.add(rdbtnExisting);
		rdbtnExisting.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnExisting.setBounds(279, 50, 70, 23);
		contentPane.add(rdbtnExisting);
		rdbtnExisting.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtnExisting.isSelected()) {
		            textPaneFirstName.setText("");
		            textPaneLastName.setText("");
		            textAreaAddress.setText("");
		            textPaneAge.setText("");
		            buttonGroupGender.clearSelection();
		            buttonGroupStatus.clearSelection();
		            textPaneContact.setText("");
		            textAreaReason.setText("");

		            textPaneFirstName.setEditable(false);
		            textPaneLastName.setEditable(false);
		            textAreaAddress.setEditable(false);
		            textPaneAge.setEditable(false);
		            rdbtnMale.setEnabled(false);
		            rdbtnFemale.setEnabled(false);
		            rdbtnSingle.setEnabled(false);
		            rdbtnMarried.setEnabled(false);
		            textPaneContact.setEditable(false);
		            textAreaReason.setEditable(false);
		            rdbtnLow.setEnabled(false);
		            rdbtnMiddle.setEnabled(false);
		            rdbtnHigh.setEnabled(false);
		            choicePetCount.setEnabled(false);
		            
			        choiceAdopter.setEnabled(true);

		        }
		    }
		});
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(200, 621, 100, 35);
		contentPane.add(btnApply);
		btnApply.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Common variables
		        String firstName = "";
		        String lastName = "";
		        String address = "";
		        String ageText = "";
		        String contact = "";
		        String reason = "";
		        String sex = rdbtnMale.isSelected() ? "Male" : (rdbtnFemale.isSelected() ? "Female" : null);
		        String status = rdbtnSingle.isSelected() ? "Single" : (rdbtnMarried.isSelected() ? "Married" : null);
		        String incomeLevel = rdbtnLow.isSelected() ? "Low" : (rdbtnMiddle.isSelected() ? "Middle" : "High");
		        int employeeId = Integer.parseInt(choiceEmployee.getSelectedItem().toString().split(" - ")[0]);
		        int petCount = Integer.parseInt(choicePetCount.getSelectedItem().toString());

		        // Validate pet count
		        if (petCount == 5) {
		            JOptionPane.showMessageDialog(null, "Adopters cannot adopt if the pet count is 5.");
		            return;
		        }

		        // Validate selected pet
		        JTable petTable = (JTable) scrollPanePet.getViewport().getView();
		        if (petTable == null) {
		            JOptionPane.showMessageDialog(null, "Pet table is not initialized.");
		            return;
		        }
		        int selectedRow = petTable.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Please select a pet.");
		            return;
		        }
		        int petId = (int) petTable.getValueAt(selectedRow, 0);
		        double adoptionFee = 1500;
		        java.sql.Date adoptionDate = new java.sql.Date(System.currentTimeMillis());

		        // Check pet status
		        String checkPetStatusQuery = "SELECT adoption_status FROM pet WHERE pet_id = ?";
		        try (Connection conn = dbConnector.getConnection();
		             PreparedStatement checkStmt = conn.prepareStatement(checkPetStatusQuery)) {
		            checkStmt.setInt(1, petId);
		            ResultSet rs = checkStmt.executeQuery();

		            if (rs.next()) {
		                String adoptionStatus = rs.getString("adoption_status");
		                if (!adoptionStatus.equals("available") && !adoptionStatus.equals("returned")) {
		                    JOptionPane.showMessageDialog(null, "The selected pet is not available for adoption.");
		                    return;
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "The selected pet does not exist.");
		                return;
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error checking pet status: " + ex.getMessage());
		            return;
		        }

		        // Handle new and existing adopters
		        if (rdbtnNew.isSelected()) {
		            firstName = textPaneFirstName.getText().trim();
		            lastName = textPaneLastName.getText().trim();
		            address = textAreaAddress.getText().trim();
		            ageText = textPaneAge.getText().trim();
		            contact = textPaneContact.getText().trim();
		            reason = textAreaReason.getText().trim();

		            // Validate new adopter fields
		            if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || contact.isEmpty() || reason.isEmpty() || sex == null || status == null) {
		                JOptionPane.showMessageDialog(null, "Please fill in all fields for the new adopter.");
		                return;
		            }

		            int age = 0;
		            try {
		                age = Integer.parseInt(ageText);
		                if (age < 12 || age > 80) {
		                    JOptionPane.showMessageDialog(null, "Age must be between 12 and 80.");
		                    return;
		                }
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Please enter a valid numeric age.");
		                return;
		            }

		            // Check adopter's pet count before allowing adoption
		            String checkAdopterPetCountQuery = "SELECT pet_count FROM adopter WHERE first_name = ? AND last_name = ?";
		            try (Connection conn = dbConnector.getConnection();
		                 PreparedStatement pstmtCheckPetCount = conn.prepareStatement(checkAdopterPetCountQuery)) {
		                pstmtCheckPetCount.setString(1, firstName);
		                pstmtCheckPetCount.setString(2, lastName);
		                ResultSet adopterResultSet = pstmtCheckPetCount.executeQuery();

		                if (adopterResultSet.next()) {
		                    int currentPetCount = adopterResultSet.getInt("pet_count");
		                    if (currentPetCount >= 4) {
		                        JOptionPane.showMessageDialog(null, "This adopter cannot adopt more pets. They already have 4 or more pets.");
		                        return;
		                    }
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error checking adopter's pet count: " + ex.getMessage());
		                return;
		            }

		            // Insert new adopter and adoption
		            String insertAdopterQuery = "INSERT INTO adopter (first_name, last_name, age, sex, civil_status, address, contact_number, income_level, reason, pet_count) " +
		                                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		            String insertAdoptionQuery = "INSERT INTO adoption (pet_id, adopter_id, employee_id, adoption_date, adoption_fee) " +
		                                         "VALUES (?, ?, ?, ?, ?)";
		            String updatePetStatusQuery = "UPDATE pet SET adoption_status = 'adopted' WHERE pet_id = ?";
		            String updateAdopterPetCountQuery = "UPDATE adopter SET pet_count = pet_count + 1 WHERE adopter_id = ?";

		            try (Connection conn = dbConnector.getConnection();
		                 PreparedStatement pstmtAdopter = conn.prepareStatement(insertAdopterQuery, PreparedStatement.RETURN_GENERATED_KEYS);
		                 PreparedStatement pstmtAdoption = conn.prepareStatement(insertAdoptionQuery);
		                 PreparedStatement pstmtUpdatePet = conn.prepareStatement(updatePetStatusQuery);
		                 PreparedStatement pstmtUpdateAdopter = conn.prepareStatement(updateAdopterPetCountQuery)) {

		                pstmtAdopter.setString(1, firstName);
		                pstmtAdopter.setString(2, lastName);
		                pstmtAdopter.setInt(3, Integer.parseInt(ageText));
		                pstmtAdopter.setString(4, sex);
		                pstmtAdopter.setString(5, status);
		                pstmtAdopter.setString(6, address);
		                pstmtAdopter.setString(7, contact);
		                pstmtAdopter.setString(8, incomeLevel);
		                pstmtAdopter.setString(9, reason);
		                pstmtAdopter.setInt(10, petCount);

		                int affectedRows = pstmtAdopter.executeUpdate();
		                if (affectedRows == 0) {
		                    throw new SQLException("Inserting adopter failed, no rows affected.");
		                }

		                ResultSet generatedKeys = pstmtAdopter.getGeneratedKeys();
		                int adopterId = -1;
		                if (generatedKeys.next()) {
		                    adopterId = generatedKeys.getInt(1);
		                }

		                pstmtAdoption.setInt(1, petId);
		                pstmtAdoption.setInt(2, adopterId);
		                pstmtAdoption.setInt(3, employeeId);
		                pstmtAdoption.setDate(4, adoptionDate);
		                pstmtAdoption.setDouble(5, adoptionFee);
		                pstmtAdoption.executeUpdate();

		                pstmtUpdatePet.setInt(1, petId);
		                pstmtUpdatePet.executeUpdate();

		                pstmtUpdateAdopter.setInt(1, adopterId);
		                pstmtUpdateAdopter.executeUpdate();

		                JOptionPane.showMessageDialog(null, "Adoption and adopter records have been successfully added, the pet status updated to adopted, and pet count updated!");

		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error occurred while saving the adoption: " + ex.getMessage());
		            }

		        } else if (rdbtnExisting.isSelected()) {
		            // Handle existing adopter logic
		            String selectedEmployee = choiceEmployee.getSelectedItem().toString();
		            String[] parts = selectedEmployee.split(" - ");
		            employeeId = Integer.parseInt(parts[0]);

		            String selectedAdopter = choiceAdopter.getSelectedItem().toString();
		            String[] adopterParts = selectedAdopter.split(" - ");
		            int adopterId = Integer.parseInt(adopterParts[0]);

		            // Check adopter's pet count before allowing adoption
		            String checkExistingAdopterPetCountQuery = "SELECT pet_count FROM adopter WHERE adopter_id = ?";
		            try (Connection conn = dbConnector.getConnection();
		                 PreparedStatement pstmtCheckAdopterPetCount = conn.prepareStatement(checkExistingAdopterPetCountQuery)) {
		                pstmtCheckAdopterPetCount.setInt(1, adopterId);
		                ResultSet adopterResultSet = pstmtCheckAdopterPetCount.executeQuery();

		                if (adopterResultSet.next()) {
		                    int currentPetCount = adopterResultSet.getInt("pet_count");
		                    if (currentPetCount >= 4) {
		                        JOptionPane.showMessageDialog(null, "This adopter cannot adopt more pets. They already have 4 or more pets.");
		                        return;
		                    }
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error checking adopter's pet count: " + ex.getMessage());
		                return;
		            }
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
    
    private void populateAdopterChoice() {
	    try (Connection conn = dbConnector.getConnection()) {
	        String sqlQuery = "SELECT adopter_id, first_name, last_name FROM adopter";
	        PreparedStatement stmt = conn.prepareStatement(sqlQuery);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int adopterId = rs.getInt("adopter_id");
	            String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
	            choiceAdopter.add(String.format("%d - %s", adopterId, fullName));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error fetching adopter data.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
