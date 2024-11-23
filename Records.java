package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;

public class Records extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable petTable;
	private DatabaseConnector dbConnector = new DatabaseConnector();
	private final ButtonGroup buttonRecords = new ButtonGroup();

	public Records() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecords = new JLabel("Records");
		lblRecords.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecords.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRecords.setBounds(10, 11, 764, 32);
		contentPane.add(lblRecords);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 764, 395);
		contentPane.add(scrollPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBApp dbApp = new DBApp();
				dbApp.setVisible(true);
				
				dispose();
			}
		});
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnBack.setBounds(10, 527, 89, 23);
		contentPane.add(btnBack);
		
		JRadioButton rdbtnPet = new JRadioButton("Pet");
		rdbtnPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPetData();
			}
		});
		buttonRecords.add(rdbtnPet);
		rdbtnPet.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnPet.setBounds(135, 50, 109, 23);
		contentPane.add(rdbtnPet);
		
		JRadioButton rdbtnAdopter = new JRadioButton("Adopter");
		rdbtnAdopter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadAdopterData();
			}
		});
		buttonRecords.add(rdbtnAdopter);
		rdbtnAdopter.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAdopter.setBounds(275, 50, 109, 23);
		contentPane.add(rdbtnAdopter);
		
		JRadioButton rdbtnAdoption = new JRadioButton("Adoption");
		rdbtnAdoption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadAdoptionData();
			}
		});
		buttonRecords.add(rdbtnAdoption);
		rdbtnAdoption.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAdoption.setBounds(415, 50, 109, 23);
		contentPane.add(rdbtnAdoption);
		
		JRadioButton rdbtnEmployee = new JRadioButton("Employee");
		rdbtnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadEmployeeData();
			}
		});
		buttonRecords.add(rdbtnEmployee);
		rdbtnEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnEmployee.setBounds(555, 50, 109, 23);
		contentPane.add(rdbtnEmployee);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnDelete.setBounds(348, 495, 89, 23);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = petTable.getSelectedRow();
		        
		        if (selectedRow != -1) {
		            if (rdbtnPet.isSelected()) {
		                int petId = (int) petTable.getValueAt(selectedRow, 0); 
		                deletePetFromDatabase(petId);
		                loadPetData();
		            } else if (rdbtnAdopter.isSelected()) {
		                int adopterId = (int) petTable.getValueAt(selectedRow, 0); 
		                deleteAdopterFromDatabase(adopterId);
		                loadAdopterData();
		            } else if (rdbtnAdoption.isSelected()) {
		                int adoptionId = (int) petTable.getValueAt(selectedRow, 0); 
		                deleteAdoptionFromDatabase(adoptionId);
		                loadAdoptionData();
		            } else if (rdbtnEmployee.isSelected()) {
		                int employeeId = (int) petTable.getValueAt(selectedRow, 0); 
		                deleteEmployeeFromDatabase(employeeId);
		                loadEmployeeData();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a record to delete.");
		        }
		    }
		});

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnAdd.setBounds(248, 494, 89, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtnPet.isSelected()) {
		            addPetData();
		            loadPetData();
		        } else if (rdbtnAdopter.isSelected()) {
		            addAdopterData();
		            loadAdopterData();
		        } else if (rdbtnAdoption.isSelected()) {
		            addAdoptionData();
		            loadAdoptionData();
		        } else if (rdbtnEmployee.isSelected()) {
		            addEmployeeData();
		            loadEmployeeData();
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a valid record type.");
		        }
		    }
		});
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBackground(new Color(255, 255, 255));
		btnModify.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnModify.setBounds(448, 495, 89, 23);
		contentPane.add(btnModify);
		btnModify.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = petTable.getSelectedRow();
		        
		        if (selectedRow != -1) {
		            if (rdbtnPet.isSelected()) {
		                int petId = (int) petTable.getValueAt(selectedRow, 0); 
		                modifyPetData(petId);
		                loadPetData();
		            } else if (rdbtnAdopter.isSelected()) {
		                int adopterId = (int) petTable.getValueAt(selectedRow, 0); 
		                modifyAdopterData(adopterId);
		                loadAdopterData();
		            } else if (rdbtnAdoption.isSelected()) {
		                int adoptionId = (int) petTable.getValueAt(selectedRow, 0); 
		                modifyAdoptionData(adoptionId);
		                loadAdoptionData();
		            } else if (rdbtnEmployee.isSelected()) {
		                int employeeId = (int) petTable.getValueAt(selectedRow, 0);
		                modifyEmployeeData(employeeId);
		                loadEmployeeData();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a record to modify.");
		        }
		    }
		});
	}
	
	private void loadPetData() {
	    try {
	        ResultSet resultSet = dbConnector.fetchPetData();

	        petTable = new JTable(buildTableModel(resultSet));

	        scrollPane.setViewportView(petTable);
	        revalidate(); 

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
	    }
	}
	
	private void loadAdopterData() {
	    try {
	        ResultSet resultSet = dbConnector.fetchAdopterData();

	        petTable = new JTable(buildTableModel(resultSet));

	        scrollPane.setViewportView(petTable);
	        revalidate();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
	    }
	}
	
	private void loadAdoptionData() {
	    try {
	        ResultSet resultSet = dbConnector.fetchAdoptionData();

	        petTable = new JTable(buildTableModel(resultSet));

	        scrollPane.setViewportView(petTable);
	        revalidate();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
	    }
	}

	private void loadEmployeeData() {
	    try {
	        ResultSet resultSet = dbConnector.fetchEmployeeData();

	        petTable = new JTable(buildTableModel(resultSet));

	        scrollPane.setViewportView(petTable);
	        revalidate();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
	    }
	}
	
	private void addPetData() {
	    JTextField petNameField = new JTextField();
	    JTextField breedField = new JTextField();
	    JTextField speciesField = new JTextField();
	    JTextField colorField = new JTextField();
	    JTextField ageField = new JTextField();
	    JTextField sexField = new JTextField();
	    JTextField arrivalDateField = new JTextField();
	    JTextField vaccinationStatusField = new JTextField();
	    JTextField spayedNeuteredField = new JTextField();
	    JTextField trainingLevelField = new JTextField();
	    JTextField adoptionStatusField = new JTextField();

	    Object[] message = {
	        "Pet Name:", petNameField,
	        "Breed:", breedField,
	        "Species (dog, cat, bird):", speciesField,
	        "Color:", colorField,
	        "Age (<=20):", ageField,
	        "Sex (male/female):", sexField,
	        "Arrival Date (yyyy-mm-dd):", arrivalDateField,
	        "Vaccination Status (yes/no):", vaccinationStatusField,
	        "Spayed/Neutered (yes/no):", spayedNeuteredField,
	        "Training Level (basic/intermediate/advanced/none):", trainingLevelField,
	        "Adoption Status (available/adopted/returned):", adoptionStatusField
	    };

	    while (true) {
	        int option = JOptionPane.showConfirmDialog(null, message, "Add Pet", JOptionPane.OK_CANCEL_OPTION);
	        if (option == JOptionPane.CANCEL_OPTION) return;

	        String petName = petNameField.getText().trim();
	        String breed = breedField.getText().trim();
	        String species = speciesField.getText().trim().toLowerCase();
	        String color = colorField.getText().trim();
	        String ageText = ageField.getText().trim();
	        String sex = sexField.getText().trim().toLowerCase();
	        String arrivalDate = arrivalDateField.getText().trim();
	        String vaccinationStatus = vaccinationStatusField.getText().trim().toLowerCase();
	        String spayedNeutered = spayedNeuteredField.getText().trim().toLowerCase();
	        String trainingLevel = trainingLevelField.getText().trim().toLowerCase();
	        String adoptionStatus = adoptionStatusField.getText().trim().toLowerCase();

	        if (petName.isEmpty() || breed.isEmpty() || species.isEmpty() || color.isEmpty() || 
	            ageText.isEmpty() || sex.isEmpty() || arrivalDate.isEmpty() || 
	            vaccinationStatus.isEmpty() || spayedNeutered.isEmpty() || 
	            trainingLevel.isEmpty() || adoptionStatus.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	            continue;
	        }

	        int age;
	        try {
	            age = Integer.parseInt(ageText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Age must be a valid number.");
	            continue;
	        }

	        if (species.equals("dog") || species.equals("cat") || species.equals("bird")) {
	            if (age <= 20 && age > 0) {
	                if (sex.equals("male") || sex.equals("female")) {
	                    if (isValidDate(arrivalDate)) {
		                    if (vaccinationStatus.equals("yes") || vaccinationStatus.equals("no")) {
		                        if (spayedNeutered.equals("yes") || spayedNeutered.equals("no")) {
		                            if (adoptionStatus.equals("available") || adoptionStatus.equals("adopted") || adoptionStatus.equals("returned")) {
		                                addPetToDatabase(petName, breed, species, color, age, sex, arrivalDate, vaccinationStatus, spayedNeutered, trainingLevel, adoptionStatus);
		                                break; 
		                            } else {
		                                JOptionPane.showMessageDialog(null, "Invalid Adoption Status.");
		                            }
		                        } else {
		                            JOptionPane.showMessageDialog(null, "Spayed/Neutered must be 'yes' or 'no'.");
		                        }
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Vaccination Status must be 'yes' or 'no'.");
		                    }
	                    } else {
	                    	JOptionPane.showMessageDialog(null, "Adoption Date must be in the format YYYY-MM-DD.");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Sex must be 'male' or 'female'.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Age must be between 1 and 20.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Species must be 'dog', 'cat', or 'bird'.");
	        }
	    }
	}

	private void addPetToDatabase(String petName, String breed, String species, String color, int age, String sex, String arrivalDate, String vaccinationStatus, String spayedNeutered, String trainingLevel, String adoptionStatus) {
	    String sql = "INSERT INTO pet (pet_name, breed, species, color, age, sex, arrival_date, vaccination_status, spayed_neutered, training_level, adoption_status) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = dbConnector.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, petName);
	        stmt.setString(2, breed);
	        stmt.setString(3, species);
	        stmt.setString(4, color);
	        stmt.setInt(5, age);
	        stmt.setString(6, sex);
	        stmt.setString(7, arrivalDate);
	        stmt.setString(8, vaccinationStatus);
	        stmt.setString(9, spayedNeutered);
	        stmt.setString(10, trainingLevel);
	        stmt.setString(11, adoptionStatus);

	        stmt.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Pet added successfully!");

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error adding pet: " + ex.getMessage());
	    }
	}

	private void addAdopterData() {
	    JTextField firstNameField = new JTextField();
	    JTextField lastNameField = new JTextField();
	    JTextField ageField = new JTextField();
	    JTextField sexField = new JTextField();
	    JTextField petCountField = new JTextField();
	    JTextField addressField = new JTextField();
	    JTextField incomeLevelField = new JTextField();
	    JTextField contactNumberField = new JTextField();
	    JTextField civilStatusField = new JTextField();
	    JTextArea reasonField = new JTextArea();

	    Object[] message = {
	        "First Name:", firstNameField,
	        "Last Name:", lastNameField,
	        "Age (16-80):", ageField,
	        "Sex (male/female):", sexField,
	        "Pet Count (<=5):", petCountField,
	        "Address:", addressField,
	        "Income Level (low/middle/high):", incomeLevelField,
	        "Contact Number:", contactNumberField,
	        "Civil Status (single/married):", civilStatusField,
	        "Reason for Adoption:", reasonField
	    };

	    while (true) {
	        int option = JOptionPane.showConfirmDialog(null, message, "Add Adopter", JOptionPane.OK_CANCEL_OPTION);
	        if (option == JOptionPane.CANCEL_OPTION) return;

	        String firstName = firstNameField.getText().trim();
	        String lastName = lastNameField.getText().trim();
	        String ageText = ageField.getText().trim();
	        String sex = sexField.getText().trim().toLowerCase();
	        String petCountText = petCountField.getText().trim();
	        String address = addressField.getText().trim();
	        String incomeLevel = incomeLevelField.getText().trim().toLowerCase();
	        String contactNumber = contactNumberField.getText().trim();
	        String civilStatus = civilStatusField.getText().trim().toLowerCase();
	        String reason = reasonField.getText().trim();

	        if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || sex.isEmpty() || 
	            petCountText.isEmpty() || address.isEmpty() || incomeLevel.isEmpty() || 
	            contactNumber.isEmpty() || civilStatus.isEmpty() || reason.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	            continue;
	        }

	        int age;
	        int petCount;
	        try {
	            age = Integer.parseInt(ageText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Age must be a valid number.");
	            continue;
	        }
	        
	        try {
	            petCount = Integer.parseInt(petCountText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Pet Count must be a valid number.");
	            continue;
	        }

	        if (age >= 16 && age <= 80) {
	            if (sex.equals("male") || sex.equals("female")) {
	                if (petCount >= 0 && petCount <= 5) {
	                    if (incomeLevel.equals("low") || incomeLevel.equals("middle") || incomeLevel.equals("high")) {
	                        if (civilStatus.equals("single") || civilStatus.equals("married")) {
	                            addAdopterToDatabase(firstName, lastName, age, sex, petCount, address, incomeLevel, contactNumber, civilStatus, reason);
	                            break;
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Civil Status must be 'single' or 'married'.");
	                        }
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Income Level must be 'low', 'middle', or 'high'.");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Pet Count must be between 0 and 5.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Sex must be 'male' or 'female'.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Age must be between 16 and 80.");
	        }
	    }
	}

	private void addAdopterToDatabase(String firstName, String lastName, int age, String sex, int petCount, String address, String incomeLevel, String contactNumber, String civilStatus, String reason) {
	    String sql = "INSERT INTO adopter (first_name, last_name, age, sex, pet_count, address, income_level, contact_number, civil_status, reason, adopter_type) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = dbConnector.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, firstName);
	        stmt.setString(2, lastName);
	        stmt.setInt(3, age);
	        stmt.setString(4, sex);
	        stmt.setInt(5, petCount);
	        stmt.setString(6, address);
	        stmt.setString(7, incomeLevel);
	        stmt.setString(8, contactNumber);
	        stmt.setString(9, civilStatus);
	        stmt.setString(10, reason);
	        stmt.setString(11, "adopter");

	        stmt.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Adopter added successfully!");

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error adding adopter: " + ex.getMessage());
	    }
	}

	private void addAdoptionData() {
	    JTextField petIdField = new JTextField();
	    JTextField adopterIdField = new JTextField();
	    JTextField employeeIdField = new JTextField();
	    JTextField adoptionDateField = new JTextField();
	    JTextField adoptionFeeField = new JTextField();

	    Object[] message = {
	        "Pet ID:", petIdField,
	        "Adopter ID:", adopterIdField,
	        "Employee ID:", employeeIdField,
	        "Adoption Date (YYYY-MM-DD):", adoptionDateField,
	        "Adoption Fee (100 to 2500):", adoptionFeeField
	    };

	    while (true) {
	        int option = JOptionPane.showConfirmDialog(null, message, "Add Adoption", JOptionPane.OK_CANCEL_OPTION);
	        if (option == JOptionPane.CANCEL_OPTION) return;

	        String petIdText = petIdField.getText().trim();
	        String adopterIdText = adopterIdField.getText().trim();
	        String employeeIdText = employeeIdField.getText().trim();
	        String adoptionDate = adoptionDateField.getText().trim();
	        String adoptionFeeText = adoptionFeeField.getText().trim();

	        if (petIdText.isEmpty() || adopterIdText.isEmpty() || employeeIdText.isEmpty() || 
	            adoptionDate.isEmpty() || adoptionFeeText.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	            continue;
	        }

	        int petId;
	        int adopterId;
	        int employeeId;
	        double adoptionFee;

	        try {
	            petId = Integer.parseInt(petIdText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Pet ID must be a valid number.");
	            continue;
	        }

	        try {
	            adopterId = Integer.parseInt(adopterIdText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Adopter ID must be a valid number.");
	            continue;
	        }

	        try {
	            employeeId = Integer.parseInt(employeeIdText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Employee ID must be a valid number.");
	            continue;
	        }

	        try {
	            adoptionFee = Double.parseDouble(adoptionFeeText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Adoption Fee must be a valid number.");
	            continue;
	        }

	        if (isPetIdValid(petId)) {
	            if (isAdopterIdValid(adopterId)) {
	                if (isEmployeeIdValid(employeeId)) {
	                    if (isValidDate(adoptionDate)) {
	                        if (adoptionFee >= 100 && adoptionFee <= 2500) {
	                            addAdoptionToDatabase(petId, adopterId, employeeId, adoptionDate, adoptionFee);
	                            break;
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Adoption Fee must be between 100 and 2500.");
	                        }
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Adoption Date must be in the format YYYY-MM-DD.");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Invalid Employee ID.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Adopter has too many pets or Invalid Adopter ID.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Invalid Pet ID or Pet is not available or returned.");
	        }
	    }
	}

	private boolean isPetIdValid(int petId) {
	    String sql = "SELECT adoption_status FROM pet WHERE pet_id = ?";
	    try (Connection conn = dbConnector.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, petId);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            String adoptionStatus = rs.getString("adoption_status");
	            return adoptionStatus.equals("available") || adoptionStatus.equals("returned");
	        }
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error validating Pet ID: " + ex.getMessage());
	    }
	    return false;
	}

	private boolean isAdopterIdValid(int adopterId) {
	    String sql = "SELECT pet_count FROM adopter WHERE adopter_id = ?";
	    try (Connection conn = dbConnector.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, adopterId);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            int petCount = rs.getInt("pet_count");
	            return petCount < 5; 
	        }
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error validating Adopter ID: " + ex.getMessage());
	    }
	    return false;
	}

	private boolean isEmployeeIdValid(int employeeId) {
	    String sql = "SELECT employee_id FROM employee WHERE employee_id = ?";
	    try (Connection conn = dbConnector.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, employeeId);
	        ResultSet rs = stmt.executeQuery();
	        return rs.next(); 
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error validating Employee ID: " + ex.getMessage());
	    }
	    return false;
	}

	private boolean isValidDate(String date) {
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        sdf.setLenient(false);
	        sdf.parse(date); 
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}

	private void addAdoptionToDatabase(int petId, int adopterId, int employeeId, String adoptionDate, double adoptionFee) {
	    String updatePetStatusSql = "UPDATE pet SET adoption_status = 'adopted' WHERE pet_id = ?";
	    String insertAdoptionSql = "INSERT INTO adoption (pet_id, adopter_id, employee_id, adoption_date, adoption_fee) " +
	                               "VALUES (?, ?, ?, ?, ?)";

	    try (Connection conn = dbConnector.getConnection();
	         PreparedStatement updatePetStmt = conn.prepareStatement(updatePetStatusSql);
	         PreparedStatement insertAdoptionStmt = conn.prepareStatement(insertAdoptionSql)) {

	        updatePetStmt.setInt(1, petId);
	        updatePetStmt.executeUpdate();

	        insertAdoptionStmt.setInt(1, petId);
	        insertAdoptionStmt.setInt(2, adopterId);
	        insertAdoptionStmt.setInt(3, employeeId);
	        insertAdoptionStmt.setString(4, adoptionDate);
	        insertAdoptionStmt.setDouble(5, adoptionFee);
	        insertAdoptionStmt.executeUpdate();

	        String updateAdopterPetCountSql = "UPDATE adopter SET pet_count = pet_count + 1 WHERE adopter_id = ?";
	        try (PreparedStatement updateAdopterStmt = conn.prepareStatement(updateAdopterPetCountSql)) {
	            updateAdopterStmt.setInt(1, adopterId);
	            updateAdopterStmt.executeUpdate();
	        }

	        JOptionPane.showMessageDialog(null, "Adoption added successfully!");
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error adding adoption: " + ex.getMessage());
	    }
	}

	private void addEmployeeData() {
	    JTextField firstNameField = new JTextField();
	    JTextField lastNameField = new JTextField();
	    JTextField ageField = new JTextField();
	    JTextField sexField = new JTextField();
	    JTextField employeeRoleField = new JTextField();
	    JTextField yearsOfExperienceField = new JTextField();
	    JTextField salaryField = new JTextField();
	    JTextField hoursWorkedField = new JTextField();
	    JTextField dateWorkedField = new JTextField();
	    JTextArea notesField = new JTextArea();

	    Object[] message = {
	        "First Name:", firstNameField,
	        "Last Name:", lastNameField,
	        "Age (16 to 80):", ageField,
	        "Sex (male/female):", sexField,
	        "Employee Role:", employeeRoleField,
	        "Years of Experience:", yearsOfExperienceField,
	        "Salary (10000-100000):", salaryField,
	        "Number of Hours Worked:", hoursWorkedField,
	        "Date Worked (YYYY-MM-DD):", dateWorkedField,
	        "Notes:", notesField
	    };

	    while (true) {
	        int option = JOptionPane.showConfirmDialog(null, message, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
	        if (option == JOptionPane.CANCEL_OPTION) return;

	        String firstName = firstNameField.getText().trim();
	        String lastName = lastNameField.getText().trim();
	        String ageText = ageField.getText().trim();
	        String sex = sexField.getText().trim().toLowerCase();
	        String employeeRole = employeeRoleField.getText().trim();
	        String yearsOfExperienceText = yearsOfExperienceField.getText().trim();
	        String salaryText = salaryField.getText().trim();
	        String hoursWorkedText = hoursWorkedField.getText().trim();
	        String dateWorked = dateWorkedField.getText().trim();
	        String notes = notesField.getText().trim();

	        if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || sex.isEmpty() || 
	            employeeRole.isEmpty() || yearsOfExperienceText.isEmpty() || salaryText.isEmpty() || 
	            hoursWorkedText.isEmpty() || dateWorked.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	            continue;
	        }

	        int age;
	        int yearsOfExperience;
	        double salary;
	        int hoursWorked;

	        try {
	            age = Integer.parseInt(ageText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Age must be a valid number.");
	            continue;
	        }

	        try {
	            yearsOfExperience = Integer.parseInt(yearsOfExperienceText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Years of Experience must be a valid number.");
	            continue;
	        }

	        try {
	            salary = Double.parseDouble(salaryText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Salary must be a valid number.");
	            continue;
	        }

	        try {
	            hoursWorked = Integer.parseInt(hoursWorkedText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Number of Hours Worked must be a valid number.");
	            continue;
	        }

	        if (age >= 16 && age <= 80) {
	            if (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")) {
	                if (yearsOfExperience > 0) {
	                    if (salary >= 10000 && salary <= 100000) {
	                        if (hoursWorked > 0) {
	                            if (isValidDate(dateWorked)) {
	                                addEmployeeToDatabase(firstName, lastName, age, sex, employeeRole, yearsOfExperience, salary, hoursWorked, dateWorked, notes);
	                                break;
	                            } else {
	                                JOptionPane.showMessageDialog(null, "Date Worked must be in the format YYYY-MM-DD.");
	                            }
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Number of Hours Worked must be greater than 0.");
	                        }
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Salary must be between 10,000 and 100,000.");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Years of Experience must be greater than 0.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Sex must be 'male' or 'female'.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Age must be between 16 and 80.");
	        }
	    }
	}
	
	private void addEmployeeToDatabase(String firstName, String lastName, int age, String sex, String employeeRole,
	                                   int yearsOfExperience, double salary, int hoursWorked, String dateWorked, String notes) {
	    String sql = "INSERT INTO employee (first_name, last_name, sex, age, employee_role, years_of_experience, salary, " +
	                 "number_of_hours_worked, date_worked, notes) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = dbConnector.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, firstName);
	        stmt.setString(2, lastName);
	        stmt.setString(3, sex);
	        stmt.setInt(4, age);
	        stmt.setString(5, employeeRole);
	        stmt.setInt(6, yearsOfExperience);
	        stmt.setDouble(7, salary);
	        stmt.setInt(8, hoursWorked);
	        stmt.setString(9, dateWorked);
	        stmt.setString(10, notes);

	        stmt.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Employee added successfully!");

	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error adding employee: " + ex.getMessage());
	    }
	}
	
	public void deletePetFromDatabase(int petId) {
	    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this pet?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
	    if (option == JOptionPane.YES_OPTION) {
	        String query = "DELETE FROM pet WHERE pet_id = ?";
	        try (PreparedStatement stmt = dbConnector.getConnection().prepareStatement(query)) {
	            stmt.setInt(1, petId);
	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Pet deleted successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error deleting pet: " + e.getMessage());
	        }
	    }
	}

	public void deleteAdopterFromDatabase(int adopterId) {
	    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this adopter?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
	    if (option == JOptionPane.YES_OPTION) {
	        String query = "DELETE FROM adopter WHERE adopter_id = ?";
	        try (PreparedStatement stmt = dbConnector.getConnection().prepareStatement(query)) {
	            stmt.setInt(1, adopterId);
	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Adopter deleted successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error deleting adopter: " + e.getMessage());
	        }
	    }
	}

	public void deleteAdoptionFromDatabase(int adoptionId) {
	    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this adoption?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
	    if (option == JOptionPane.YES_OPTION) {
	        String query = "DELETE FROM adoption WHERE adoption_id = ?";
	        try (PreparedStatement stmt = dbConnector.getConnection().prepareStatement(query)) {
	            stmt.setInt(1, adoptionId);
	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Adoption deleted successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error deleting adoption: " + e.getMessage());
	        }
	    }
	}

	public void deleteEmployeeFromDatabase(int employeeId) {
	    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
	    if (option == JOptionPane.YES_OPTION) {
	        String query = "DELETE FROM employee WHERE employee_id = ?";
	        try (PreparedStatement stmt = dbConnector.getConnection().prepareStatement(query)) {
	            stmt.setInt(1, employeeId);
	            stmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Employee deleted successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error deleting employee: " + e.getMessage());
	        }
	    }
	}
	
	private void modifyPetData(int petId) {
	    String query = "SELECT * FROM pet WHERE pet_id = ?";
	    try (PreparedStatement stmt = dbConnector.getConnection().prepareStatement(query)) {
	        stmt.setInt(1, petId);
	        ResultSet resultSet = stmt.executeQuery();

	        if (resultSet.next()) {
	            JTextField petNameField = new JTextField(resultSet.getString("pet_name"));
	            JTextField petBreedField = new JTextField(resultSet.getString("breed"));
	            JTextField petSpeciesField = new JTextField(resultSet.getString("species"));
	            JTextField petColorField = new JTextField(resultSet.getString("color"));
	            JTextField petAgeField = new JTextField(String.valueOf(resultSet.getInt("age")));
	            JTextField petVaccinationStatusField = new JTextField(resultSet.getString("vaccination_status"));
	            JTextField petSpayedNeuteredField = new JTextField(resultSet.getString("spayed_neutered"));
	            JTextField petTrainingLevelField = new JTextField(resultSet.getString("training_level"));
	            JTextField petAdoptionStatusField = new JTextField(resultSet.getString("adoption_status"));

	            Object[] message = {
	                "Pet Name:", petNameField,
	                "Breed:", petBreedField,
	                "Species (dog, cat, bird):", petSpeciesField,
	                "Color:", petColorField,
	                "Age (max 20):", petAgeField,
	                "Vaccination Status (yes/no):", petVaccinationStatusField,
	                "Spayed/Neutered (yes/no):", petSpayedNeuteredField,
	                "Training Level (basic, intermediate, advanced, none):", petTrainingLevelField,
	                "Adoption Status (available, adopted, returned):", petAdoptionStatusField
	            };

	            while (true) {
	                int option = JOptionPane.showConfirmDialog(null, message, "Modify Pet", JOptionPane.OK_CANCEL_OPTION);
	                if (option == JOptionPane.CANCEL_OPTION) {
	                    return; 
	                }

	                String newSpecies = petSpeciesField.getText().trim().toLowerCase();
	                String newAgeText = petAgeField.getText().trim();
	                String newVaccinationStatus = petVaccinationStatusField.getText().trim().toLowerCase();
	                String newSpayedNeutered = petSpayedNeuteredField.getText().trim().toLowerCase();
	                String newTrainingLevel = petTrainingLevelField.getText().trim().toLowerCase();
	                String newAdoptionStatus = petAdoptionStatusField.getText().trim().toLowerCase();

	                if (petNameField.getText().trim().isEmpty() || petBreedField.getText().trim().isEmpty() ||
	                    petSpeciesField.getText().trim().isEmpty() || petColorField.getText().trim().isEmpty() ||
	                    newAgeText.isEmpty() || petVaccinationStatusField.getText().trim().isEmpty() ||
	                    petSpayedNeuteredField.getText().trim().isEmpty() || petTrainingLevelField.getText().trim().isEmpty() ||
	                    petAdoptionStatusField.getText().trim().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	                    continue;
	                }

	                int newAge = -1;
	                boolean valid = true;
	                String errorMessage = "Please fix the following errors:\n";

	                try {
	                    newAge = Integer.parseInt(newAgeText);
	                } catch (NumberFormatException e) {
	                    errorMessage += "- Age must be a valid number.\n";
	                    valid = false;
	                }

	                if (!newSpecies.equals("dog") && !newSpecies.equals("cat") && !newSpecies.equals("bird")) {
	                    errorMessage += "- Species must be dog, cat, or bird.\n";
	                    valid = false;
	                }
	                if (newAge < 0 || newAge > 20) {
	                    errorMessage += "- Age must be between 0 and 20.\n";
	                    valid = false;
	                }
	                if (!newVaccinationStatus.equals("yes") && !newVaccinationStatus.equals("no")) {
	                    errorMessage += "- Vaccination status must be 'yes' or 'no'.\n";
	                    valid = false;
	                }
	                if (!newSpayedNeutered.equals("yes") && !newSpayedNeutered.equals("no")) {
	                    errorMessage += "- Spayed/Neutered status must be 'yes' or 'no'.\n";
	                    valid = false;
	                }
	                if (!newTrainingLevel.equals("basic") && !newTrainingLevel.equals("intermediate") && !newTrainingLevel.equals("advanced") && !newTrainingLevel.equals("none")) {
	                    errorMessage += "- Training level must be 'basic', 'intermediate', 'advanced', or 'none'.\n";
	                    valid = false;
	                }
	                if (!newAdoptionStatus.equals("available") && !newAdoptionStatus.equals("adopted") && !newAdoptionStatus.equals("returned")) {
	                    errorMessage += "- Adoption status must be 'available', 'adopted', or 'returned'.\n";
	                    valid = false;
	                }

	                if (valid) {
	                    String updateQuery = "UPDATE pet SET pet_name = ?, breed = ?, species = ?, color = ?, age = ?, vaccination_status = ?, spayed_neutered = ?, " +
	                            "training_level = ?, adoption_status = ? WHERE pet_id = ?";
	                    try (PreparedStatement updateStmt = dbConnector.getConnection().prepareStatement(updateQuery)) {
	                        updateStmt.setString(1, petNameField.getText());
	                        updateStmt.setString(2, petBreedField.getText());
	                        updateStmt.setString(3, newSpecies);
	                        updateStmt.setString(4, petColorField.getText());
	                        updateStmt.setInt(5, newAge);
	                        updateStmt.setString(6, newVaccinationStatus);
	                        updateStmt.setString(7, newSpayedNeutered);
	                        updateStmt.setString(8, newTrainingLevel);
	                        updateStmt.setString(9, newAdoptionStatus);
	                        updateStmt.setInt(10, petId);  
	                        updateStmt.executeUpdate();
	                        JOptionPane.showMessageDialog(null, "Pet details updated successfully!");
	                        loadPetData();
	                        break; 
	                    } catch (SQLException ex) {
	                        ex.printStackTrace();
	                        JOptionPane.showMessageDialog(null, "Error updating pet: " + ex.getMessage());
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, errorMessage, "Invalid Input", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error fetching pet data: " + ex.getMessage());
	    }
	}

	private void modifyAdopterData(int adopterId) {
	    String query = "SELECT * FROM adopter WHERE adopter_id = ?";
	    try (PreparedStatement stmt = dbConnector.getConnection().prepareStatement(query)) {
	        stmt.setInt(1, adopterId);
	        ResultSet resultSet = stmt.executeQuery();

	        if (resultSet.next()) {
	            JTextField adopterTypeField = new JTextField(resultSet.getString("adopter_type"));
	            JTextField firstNameField = new JTextField(resultSet.getString("first_name"));
	            JTextField lastNameField = new JTextField(resultSet.getString("last_name"));
	            JTextField ageField = new JTextField(String.valueOf(resultSet.getInt("age")));
	            JTextField sexField = new JTextField(resultSet.getString("sex"));
	            JTextField petCountField = new JTextField(String.valueOf(resultSet.getInt("pet_count")));
	            JTextField addressField = new JTextField(resultSet.getString("address"));
	            JTextField incomeLevelField = new JTextField(resultSet.getString("income_level"));
	            JTextField contactNumberField = new JTextField(resultSet.getString("contact_number"));
	            JTextField civilStatusField = new JTextField(resultSet.getString("civil_status"));
	            JTextArea reasonField = new JTextArea(resultSet.getString("reason"));

	            Object[] message = {
	                "Adopter Type (adopter, rescuer, returnee):", adopterTypeField,
	                "First Name:", firstNameField,
	                "Last Name:", lastNameField,
	                "Age:", ageField,
	                "Sex (male, female):", sexField,
	                "Pet Count (max 5):", petCountField,
	                "Address:", addressField,
	                "Income Level (low, middle, high):", incomeLevelField,
	                "Contact Number:", contactNumberField,
	                "Civil Status (single, married):", civilStatusField,
	                "Reason for Adoption:", reasonField
	            };

	            while (true) {
	                int option = JOptionPane.showConfirmDialog(null, message, "Modify Adopter", JOptionPane.OK_CANCEL_OPTION);
	                if (option == JOptionPane.CANCEL_OPTION) {
	                    return; 
	                }

	                String newAdopterType = adopterTypeField.getText().trim();
	                String newFirstName = firstNameField.getText().trim();
	                String newLastName = lastNameField.getText().trim();
	                String newAgeText = ageField.getText().trim();
	                String newSex = sexField.getText().trim();
	                String newPetCountText = petCountField.getText().trim();
	                String newAddress = addressField.getText().trim();
	                String newIncomeLevel = incomeLevelField.getText().trim();
	                String newContactNumber = contactNumberField.getText().trim();
	                String newCivilStatus = civilStatusField.getText().trim();
	                String newReason = reasonField.getText().trim();

	                if (newAdopterType.isEmpty() || newFirstName.isEmpty() || newLastName.isEmpty() || 
	                    newAgeText.isEmpty() || newSex.isEmpty() || newPetCountText.isEmpty() || 
	                    newAddress.isEmpty() || newIncomeLevel.isEmpty() || newContactNumber.isEmpty() || 
	                    newCivilStatus.isEmpty() || newReason.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	                    continue;
	                }

	                int newAge = Integer.parseInt(newAgeText);
	                int newPetCount = Integer.parseInt(newPetCountText);

	                if (!newAdopterType.equals("adopter") && !newAdopterType.equals("rescuer") && !newAdopterType.equals("returnee")) {
	                    JOptionPane.showMessageDialog(null, "Adopter type must be 'adopter', 'rescuer', or 'returnee'.");
	                    continue;
	                }
	                if (newAge < 18) {
	                    JOptionPane.showMessageDialog(null, "Age must be 18 or older.");
	                    continue;
	                }
	                if (!newSex.equals("male") && !newSex.equals("female")) {
	                    JOptionPane.showMessageDialog(null, "Sex must be 'male' or 'female'.");
	                    continue;
	                }
	                if (newPetCount < 0 || newPetCount > 5) {
	                    JOptionPane.showMessageDialog(null, "Pet count must be between 0 and 5.");
	                    continue;
	                }
	                if (!newIncomeLevel.equals("low") && !newIncomeLevel.equals("middle") && !newIncomeLevel.equals("high")) {
	                    JOptionPane.showMessageDialog(null, "Income level must be 'low', 'middle', or 'high'.");
	                    continue;
	                }
	                if (!newCivilStatus.equals("single") && !newCivilStatus.equals("married")) {
	                    JOptionPane.showMessageDialog(null, "Civil status must be 'single' or 'married'.");
	                    continue;
	                }

	                String updateQuery = "UPDATE adopter SET adopter_type = ?, first_name = ?, last_name = ?, age = ?, sex = ?, pet_count = ?, " +
	                        "address = ?, income_level = ?, contact_number = ?, civil_status = ?, reason = ? WHERE adopter_id = ?";
	                try (PreparedStatement updateStmt = dbConnector.getConnection().prepareStatement(updateQuery)) {
	                    updateStmt.setString(1, newAdopterType);
	                    updateStmt.setString(2, newFirstName);
	                    updateStmt.setString(3, newLastName);
	                    updateStmt.setInt(4, newAge);
	                    updateStmt.setString(5, newSex);
	                    updateStmt.setInt(6, newPetCount);
	                    updateStmt.setString(7, newAddress);
	                    updateStmt.setString(8, newIncomeLevel);
	                    updateStmt.setString(9, newContactNumber);
	                    updateStmt.setString(10, newCivilStatus);
	                    updateStmt.setString(11, newReason);
	                    updateStmt.setInt(12, adopterId);  
	                    updateStmt.executeUpdate();
	                    JOptionPane.showMessageDialog(null, "Adopter details updated successfully!");
	                    loadAdopterData();
	                    break;
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Error updating adopter: " + ex.getMessage());
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error fetching adopter data: " + ex.getMessage());
	    }
	}

	private void modifyAdoptionData(int adoptionId) {
	    String query = "SELECT * FROM adoption WHERE adoption_id = ?";
	    try (PreparedStatement stmt = dbConnector.getConnection().prepareStatement(query)) {
	        stmt.setInt(1, adoptionId);
	        ResultSet resultSet = stmt.executeQuery();

	        if (resultSet.next()) {
	            int petId = resultSet.getInt("pet_id");
	            int adopterId = resultSet.getInt("adopter_id");
	            int employeeId = resultSet.getInt("employee_id");
	            String adoptionDate = resultSet.getString("adoption_date");
	            double adoptionFee = resultSet.getDouble("adoption_fee");

	            JTextField petIdField = new JTextField(String.valueOf(petId));
	            JTextField adopterIdField = new JTextField(String.valueOf(adopterId));
	            JTextField employeeIdField = new JTextField(String.valueOf(employeeId));
	            JTextField adoptionDateField = new JTextField(adoptionDate);
	            JTextField adoptionFeeField = new JTextField(String.valueOf(adoptionFee));

	            Object[] message = {
	                "Pet ID:", petIdField,
	                "Adopter ID:", adopterIdField,
	                "Employee ID:", employeeIdField,
	                "Adoption Date (yyyy-mm-dd):", adoptionDateField,
	                "Adoption Fee (between 100 and 2500):", adoptionFeeField
	            };

	            while (true) {
	                int option = JOptionPane.showConfirmDialog(null, message, "Modify Adoption", JOptionPane.OK_CANCEL_OPTION);
	                if (option == JOptionPane.CANCEL_OPTION) {
	                    return; 
	                }

	                String newPetIdText = petIdField.getText().trim();
	                String newAdopterIdText = adopterIdField.getText().trim();
	                String newEmployeeIdText = employeeIdField.getText().trim();
	                String newAdoptionDate = adoptionDateField.getText().trim();
	                String newAdoptionFeeText = adoptionFeeField.getText().trim();

	                if (newPetIdText.isEmpty() || newAdopterIdText.isEmpty() || newEmployeeIdText.isEmpty() ||
	                    newAdoptionDate.isEmpty() || newAdoptionFeeText.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	                    continue;
	                }

	                int newPetId = Integer.parseInt(newPetIdText);
	                int newAdopterId = Integer.parseInt(newAdopterIdText);
	                int newEmployeeId = Integer.parseInt(newEmployeeIdText);
	                double newAdoptionFee = Double.parseDouble(newAdoptionFeeText);

	                boolean valid = true;
	                String errorMessage = "Please fix the following errors:\n";

	                String petQuery = "SELECT * FROM pet WHERE pet_id = ? AND (adoption_status = 'available' OR adoption_status = 'returned')";
	                try (PreparedStatement petStmt = dbConnector.getConnection().prepareStatement(petQuery)) {
	                    petStmt.setInt(1, newPetId);
	                    ResultSet petResult = petStmt.executeQuery();
	                    if (!petResult.next()) {
	                        errorMessage += "- Pet ID must exist and have an adoption status of 'available' or 'returned'.\n";
	                        valid = false;
	                    }
	                }

	                String adopterQuery = "SELECT * FROM adopter WHERE adopter_id = ?";
	                try (PreparedStatement adopterStmt = dbConnector.getConnection().prepareStatement(adopterQuery)) {
	                    adopterStmt.setInt(1, newAdopterId);
	                    ResultSet adopterResult = adopterStmt.executeQuery();
	                    if (!adopterResult.next()) {
	                        errorMessage += "- Adopter ID must exist.\n";
	                        valid = false;
	                    } else {
	                        int petCount = adopterResult.getInt("pet_count");
	                        String adoptionHistoryQuery = "SELECT COUNT(*) FROM adoption WHERE adopter_id = ?";
	                        try (PreparedStatement adoptionHistoryStmt = dbConnector.getConnection().prepareStatement(adoptionHistoryQuery)) {
	                            adoptionHistoryStmt.setInt(1, newAdopterId);
	                            ResultSet adoptionHistoryResult = adoptionHistoryStmt.executeQuery();
	                            if (adoptionHistoryResult.next()) {
	                                int currentAdoptionCount = adoptionHistoryResult.getInt(1);
	                                if (currentAdoptionCount >= 5) {
	                                    errorMessage += "- Adopter cannot have more than 5 adopted pets.\n";
	                                    valid = false;
	                                }
	                            }
	                        }
	                    }
	                }

	                String employeeQuery = "SELECT * FROM employee WHERE employee_id = ?";
	                try (PreparedStatement employeeStmt = dbConnector.getConnection().prepareStatement(employeeQuery)) {
	                    employeeStmt.setInt(1, newEmployeeId);
	                    ResultSet employeeResult = employeeStmt.executeQuery();
	                    if (!employeeResult.next()) {
	                        errorMessage += "- Employee ID must exist.\n";
	                        valid = false;
	                    }
	                }

	                if (!newAdoptionDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
	                    errorMessage += "- Adoption date must be in the format yyyy-mm-dd.\n";
	                    valid = false;
	                }

	                if (newAdoptionFee < 100 || newAdoptionFee > 2500) {
	                    errorMessage += "- Adoption fee must be between 100 and 2500.\n";
	                    valid = false;
	                }

	                if (valid) {
	                    String updateQuery = "UPDATE adoption SET pet_id = ?, adopter_id = ?, employee_id = ?, adoption_date = ?, adoption_fee = ? WHERE adoption_id = ?";
	                    try (PreparedStatement updateStmt = dbConnector.getConnection().prepareStatement(updateQuery)) {
	                        updateStmt.setInt(1, newPetId);
	                        updateStmt.setInt(2, newAdopterId);
	                        updateStmt.setInt(3, newEmployeeId);
	                        updateStmt.setString(4, newAdoptionDate);
	                        updateStmt.setDouble(5, newAdoptionFee);
	                        updateStmt.setInt(6, adoptionId);
	                        updateStmt.executeUpdate();

	                        String updatePetStatusQuery = "UPDATE pet SET adoption_status = 'adopted' WHERE pet_id = ?";
	                        try (PreparedStatement updatePetStatusStmt = dbConnector.getConnection().prepareStatement(updatePetStatusQuery)) {
	                            updatePetStatusStmt.setInt(1, newPetId);
	                            updatePetStatusStmt.executeUpdate();
	                        }

	                        JOptionPane.showMessageDialog(null, "Adoption details updated successfully!");
	                        loadAdoptionData(); 
	                        loadPetData(); 
	                        break; 
	                    } catch (SQLException ex) {
	                        ex.printStackTrace();
	                        JOptionPane.showMessageDialog(null, "Error updating adoption: " + ex.getMessage());
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, errorMessage, "Invalid Input", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error fetching adoption data: " + ex.getMessage());
	    }
	}

	private void modifyEmployeeData(int employeeId) {
	    String query = "SELECT * FROM employee WHERE employee_id = ?";
	    try (PreparedStatement stmt = dbConnector.getConnection().prepareStatement(query)) {
	        stmt.setInt(1, employeeId);
	        ResultSet resultSet = stmt.executeQuery();

	        if (resultSet.next()) {
	            JTextField firstNameField = new JTextField(resultSet.getString("first_name"));
	            JTextField lastNameField = new JTextField(resultSet.getString("last_name"));
	            JTextField sexField = new JTextField(resultSet.getString("sex"));
	            JTextField ageField = new JTextField(String.valueOf(resultSet.getInt("age")));
	            JTextField employeeRoleField = new JTextField(resultSet.getString("employee_role"));
	            JTextField yearsOfExperienceField = new JTextField(String.valueOf(resultSet.getInt("years_of_experience")));
	            JTextField salaryField = new JTextField(String.valueOf(resultSet.getDouble("salary")));
	            JTextField numberOfHoursWorkedField = new JTextField(String.valueOf(resultSet.getInt("number_of_hours_worked")));
	            JTextField dateWorkedField = new JTextField(resultSet.getString("date_worked"));
	            JTextArea notesField = new JTextArea(resultSet.getString("notes"));

	            Object[] message = {
	                "First Name:", firstNameField,
	                "Last Name:", lastNameField,
	                "Sex (male, female):", sexField,
	                "Age (between 16 and 80):", ageField,
	                "Employee Role:", employeeRoleField,
	                "Years of Experience (>0):", yearsOfExperienceField,
	                "Salary (greater than 10,000 and less than 100,000):", salaryField,
	                "Number of Hours Worked (>0):", numberOfHoursWorkedField,
	                "Date Worked (yyyy-mm-dd):", dateWorkedField,
	                "Notes:", notesField
	            };

	            while (true) {
	                int option = JOptionPane.showConfirmDialog(null, message, "Modify Employee", JOptionPane.OK_CANCEL_OPTION);
	                if (option == JOptionPane.CANCEL_OPTION) {
	                    return;
	                }

	                String newSex = sexField.getText().toLowerCase();
	                String newFirstName = firstNameField.getText().trim();
	                String newLastName = lastNameField.getText().trim();
	                String newAgeText = ageField.getText().trim();
	                String newSalaryText = salaryField.getText().trim();
	                String newNumberOfHoursWorkedText = numberOfHoursWorkedField.getText().trim();
	                String newDateWorked = dateWorkedField.getText().trim();
	                String newYearsOfExperienceText = yearsOfExperienceField.getText().trim();

	                if (newFirstName.isEmpty() || newLastName.isEmpty() || newSex.isEmpty() || newAgeText.isEmpty() || 
	                    newSalaryText.isEmpty() || newNumberOfHoursWorkedText.isEmpty() || newDateWorked.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	                    continue;
	                }

	                int newAge = Integer.parseInt(newAgeText);
	                double newSalary = Double.parseDouble(newSalaryText);
	                int newNumberOfHoursWorked = Integer.parseInt(newNumberOfHoursWorkedText);
	                int newYearsOfExperience = Integer.parseInt(newYearsOfExperienceText);

	                boolean valid = true;
	                String errorMessage = "Please fix the following errors:\n";

	                if (!newSex.equals("male") && !newSex.equals("female")) {
	                    errorMessage += "- Sex must be either 'male' or 'female'.\n";
	                    valid = false;
	                }
	                if (newAge < 16 || newAge > 80) {
	                    errorMessage += "- Age must be between 16 and 80.\n";
	                    valid = false;
	                }
	                if (newSalary < 10000 || newSalary > 100000) {
	                    errorMessage += "- Salary must be between 10,000 and 100,000.\n";
	                    valid = false;
	                }
	                if (newNumberOfHoursWorked < 0) {
	                    errorMessage += "- Number of hours worked must greater than 0.\n";
	                    valid = false;
	                }
	                if (newYearsOfExperience <= 0) {
	                    errorMessage += "- Years of Experience must be greater than 0.\n";
	                    valid = false;
	                }
	                if (!newDateWorked.matches("\\d{4}-\\d{2}-\\d{2}")) {
	                    errorMessage += "- Date worked must be in the format yyyy-mm-dd.\n";
	                    valid = false;
	                }

	                if (valid) {
	                    String updateQuery = "UPDATE employee SET first_name = ?, last_name = ?, sex = ?, age = ?, employee_role = ?, " +
	                            "years_of_experience = ?, salary = ?, number_of_hours_worked = ?, date_worked = ?, notes = ? WHERE employee_id = ?";
	                    try (PreparedStatement updateStmt = dbConnector.getConnection().prepareStatement(updateQuery)) {
	                        updateStmt.setString(1, newFirstName);
	                        updateStmt.setString(2, newLastName);
	                        updateStmt.setString(3, newSex);
	                        updateStmt.setInt(4, newAge);
	                        updateStmt.setString(5, employeeRoleField.getText());
	                        updateStmt.setInt(6, newYearsOfExperience);
	                        updateStmt.setDouble(7, newSalary);
	                        updateStmt.setInt(8, newNumberOfHoursWorked);
	                        updateStmt.setString(9, newDateWorked);
	                        updateStmt.setString(10, notesField.getText());
	                        updateStmt.setInt(11, employeeId);
	                        updateStmt.executeUpdate();
	                        JOptionPane.showMessageDialog(null, "Employee details updated successfully!");
	                        loadEmployeeData();
	                        break;
	                    } catch (SQLException ex) {
	                        ex.printStackTrace();
	                        JOptionPane.showMessageDialog(null, "Error updating employee: " + ex.getMessage());
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, errorMessage, "Invalid Input", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error fetching employee data: " + ex.getMessage());
	    }
	}

	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
	    DefaultTableModel model = new DefaultTableModel() {
			@Override
	        public boolean isCellEditable(int row, int column) {
	            return true;  
	        }
	    };

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
