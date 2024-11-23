package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Choice;

public class PetAdmissionApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldYear;
	private JTextField textFieldMonth;
	private JTextField textFieldDay;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldAge1;
	private JTextField textFieldContact;
	private Choice choiceEmployee;
	private final ButtonGroup btnGrpSex = new ButtonGroup();
	private final ButtonGroup btnGrpSpaNeu = new ButtonGroup();
	private final ButtonGroup btnGrpVacc = new ButtonGroup();
	private final ButtonGroup btnGrpTraLe = new ButtonGroup();
	private final ButtonGroup btnGrpSex1 = new ButtonGroup();
	private final ButtonGroup btnGrpStatus = new ButtonGroup();
	private final ButtonGroup btnGrpIncLe = new ButtonGroup();
	private DatabaseConnector dbConnector = new DatabaseConnector();

	public PetAdmissionApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPetAdmissionApplication = new JLabel("Pet Admission Application");
		lblPetAdmissionApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetAdmissionApplication.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPetAdmissionApplication.setBounds(10, 11, 554, 32);
		contentPane.add(lblPetAdmissionApplication);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblName.setBounds(10, 76, 92, 18);
		contentPane.add(lblName);
		
		JTextField textFieldName = new JTextField();
		textFieldName.setBounds(111, 74, 453, 23);
		contentPane.add(textFieldName);
		
		JLabel lblBreed = new JLabel("Breed");
		lblBreed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreed.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblBreed.setBounds(10, 107, 92, 18);
		contentPane.add(lblBreed);
		
		JTextField textFieldBreed = new JTextField();
		textFieldBreed.setBounds(111, 105, 453, 23);
		contentPane.add(textFieldBreed);
		
		JLabel lblSpecies = new JLabel("Species");
		lblSpecies.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpecies.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSpecies.setBounds(10, 138, 92, 18);
		contentPane.add(lblSpecies);
		
		JTextField textFieldSpecies = new JTextField();
		textFieldSpecies.setBounds(111, 136, 453, 23);
		contentPane.add(textFieldSpecies);
		
		JLabel lblAge_1_1 = new JLabel("Sex");
		lblAge_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAge_1_1.setBounds(318, 169, 92, 18);
		contentPane.add(lblAge_1_1);
		
		JTextField textFieldAge = new JTextField();
		textFieldAge.setBounds(111, 167, 141, 23);
		contentPane.add(textFieldAge);
		
		JLabel lblAge_1 = new JLabel("Age");
		lblAge_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblAge_1.setBounds(10, 169, 92, 18);
		contentPane.add(lblAge_1);
		
		JLabel lblAge_1_2 = new JLabel("Color");
		lblAge_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblAge_1_2.setBounds(10, 200, 92, 18);
		contentPane.add(lblAge_1_2);
		
		JTextField textFieldColor = new JTextField();
		textFieldColor.setBounds(111, 198, 141, 23);
		contentPane.add(textFieldColor);
		
		JLabel lblVaccination = new JLabel("Vaccinated?");
		lblVaccination.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVaccination.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblVaccination.setBounds(10, 231, 92, 18);
		contentPane.add(lblVaccination);
		
		JRadioButton rdbtnYes1 = new JRadioButton("Yes");
		btnGrpVacc.add(rdbtnYes1);
		rdbtnYes1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnYes1.setBounds(111, 230, 52, 23);
		contentPane.add(rdbtnYes1);
		
		JRadioButton rdbtnNo1 = new JRadioButton("No");
		btnGrpVacc.add(rdbtnNo1);
		rdbtnNo1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNo1.setBounds(174, 230, 52, 23);
		contentPane.add(rdbtnNo1);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		btnGrpSpaNeu.add(rdbtnYes);
		rdbtnYes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnYes.setBounds(425, 200, 52, 23);
		contentPane.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		btnGrpSpaNeu.add(rdbtnNo);
		rdbtnNo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNo.setBounds(494, 200, 52, 23);
		contentPane.add(rdbtnNo);
		
		JLabel lblVaccination_1 = new JLabel("Spayed/Neutered?");
		lblVaccination_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVaccination_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblVaccination_1.setBounds(262, 200, 150, 18);
		contentPane.add(lblVaccination_1);
		
		JLabel lblTrainingLevel = new JLabel("Training Level");
		lblTrainingLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrainingLevel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTrainingLevel.setBounds(10, 262, 92, 18);
		contentPane.add(lblTrainingLevel);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblDate.setBounds(10, 293, 92, 18);
		contentPane.add(lblDate);
		
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
		btnNewButton_2_1.setBounds(10, 747, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		btnGrpSex.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnFemale.setBounds(494, 167, 70, 23);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		btnGrpSex.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnMale.setBounds(426, 167, 69, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnIntermediate = new JRadioButton("Intermediate");
		btnGrpTraLe.add(rdbtnIntermediate);
		rdbtnIntermediate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnIntermediate.setBounds(326, 260, 103, 23);
		contentPane.add(rdbtnIntermediate);
		
		JRadioButton rdbtnNone = new JRadioButton("None");
		btnGrpTraLe.add(rdbtnNone);
		rdbtnNone.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnNone.setBounds(111, 260, 103, 23);
		contentPane.add(rdbtnNone);
		
		JRadioButton rdbtnBasic = new JRadioButton("Basic");
		btnGrpTraLe.add(rdbtnBasic);
		rdbtnBasic.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnBasic.setBounds(218, 260, 103, 23);
		contentPane.add(rdbtnBasic);
		
		JRadioButton rdbtnAdvanced = new JRadioButton("Advanced");
		btnGrpTraLe.add(rdbtnAdvanced);
		rdbtnAdvanced.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnAdvanced.setBounds(434, 260, 103, 23);
		contentPane.add(rdbtnAdvanced);
		
		textFieldYear = new JTextField();
		textFieldYear.setBounds(120, 293, 82, 23);
		contentPane.add(textFieldYear);
		
		textFieldMonth = new JTextField();
		textFieldMonth.setBounds(211, 293, 82, 23);
		contentPane.add(textFieldMonth);
		
		textFieldDay = new JTextField();
		textFieldDay.setBounds(301, 293, 82, 23);
		contentPane.add(textFieldDay);
		
		JLabel lblDate_1 = new JLabel("YYYY");
		lblDate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDate_1.setBounds(125, 316, 73, 18);
		contentPane.add(lblDate_1);
		
		JLabel lblDate_1_1 = new JLabel("MM");
		lblDate_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDate_1_1.setBounds(216, 316, 73, 18);
		contentPane.add(lblDate_1_1);
		
		JLabel lblDate_1_1_1 = new JLabel("DD");
		lblDate_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDate_1_1_1.setBounds(306, 316, 73, 18);
		contentPane.add(lblDate_1_1_1);
		
		JLabel lblAdopterName = new JLabel("First Name");
		lblAdopterName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdopterName.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblAdopterName.setBounds(10, 374, 92, 18);
		contentPane.add(lblAdopterName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(111, 372, 163, 23);
		contentPane.add(textFieldFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblLastName.setBounds(299, 376, 92, 18);
		contentPane.add(lblLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(401, 374, 163, 23);
		contentPane.add(textFieldLastName);
		
		JLabel lblAdopterName_1 = new JLabel("Animal");
		lblAdopterName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdopterName_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAdopterName_1.setBounds(10, 47, 92, 18);
		contentPane.add(lblAdopterName_1);
		
		JLabel lblAdopterName_1_1 = new JLabel("Rescuer");
		lblAdopterName_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdopterName_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAdopterName_1_1.setBounds(10, 345, 92, 18);
		contentPane.add(lblAdopterName_1_1);
		
		JLabel lblAge = new JLabel("Address");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAge.setBounds(10, 417, 92, 18);
		contentPane.add(lblAge);
		
		JLabel lblAge_1_3 = new JLabel("Age");
		lblAge_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAge_1_3.setBounds(10, 463, 92, 18);
		contentPane.add(lblAge_1_3);
		
		textFieldAge1 = new JTextField();
		textFieldAge1.setBounds(111, 461, 141, 23);
		contentPane.add(textFieldAge1);
		
		JLabel lblAge_1_1_1 = new JLabel("Sex");
		lblAge_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAge_1_1_1.setBounds(298, 465, 92, 18);
		contentPane.add(lblAge_1_1_1);
		
		JLabel lblName_1 = new JLabel("Contact");
		lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblName_1.setBounds(10, 525, 92, 18);
		contentPane.add(lblName_1);
		
		textFieldContact = new JTextField();
		textFieldContact.setBounds(111, 523, 448, 23);
		contentPane.add(textFieldContact);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblReason.setBounds(10, 571, 92, 18);
		contentPane.add(lblReason);
		
		JLabel lblPetCount = new JLabel("Income Level");
		lblPetCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPetCount.setBounds(10, 616, 92, 18);
		contentPane.add(lblPetCount);
		
		JLabel lblPetCount_1 = new JLabel("Pet Count");
		lblPetCount_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPetCount_1.setBounds(10, 650, 92, 18);
		contentPane.add(lblPetCount_1);
		
		JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setBounds(111, 403, 453, 47);
		contentPane.add(textAreaAddress);
		
		JTextArea textAreaReason = new JTextArea();
		textAreaReason.setBounds(111, 557, 448, 47);
		contentPane.add(textAreaReason);
		
		JLabel lblAge_1_2_1 = new JLabel("Status");
		lblAge_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAge_1_2_1.setBounds(10, 494, 92, 18);
		contentPane.add(lblAge_1_2_1);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");
		btnGrpStatus.add(rdbtnSingle);
		rdbtnSingle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnSingle.setBounds(111, 492, 69, 23);
		contentPane.add(rdbtnSingle);
		
		JRadioButton rdbtnMarried = new JRadioButton("Married");
		btnGrpStatus.add(rdbtnMarried);
		rdbtnMarried.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnMarried.setBounds(182, 492, 70, 23);
		contentPane.add(rdbtnMarried);
		
		JLabel lblPetCount_1_1 = new JLabel("<html>\r\n<div style='text-align: center;'>\r\nHandling<br> \r\nEmployee\r\n</div>\r\n</html>");
		lblPetCount_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPetCount_1_1.setBounds(10, 679, 92, 55);
		contentPane.add(lblPetCount_1_1);
		
		JRadioButton rdbtnMale_1 = new JRadioButton("Male");
		btnGrpSex1.add(rdbtnMale_1);
		rdbtnMale_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnMale_1.setBounds(408, 463, 69, 23);
		contentPane.add(rdbtnMale_1);
		
		JRadioButton rdbtnFemale_1 = new JRadioButton("Female");
		btnGrpSex1.add(rdbtnFemale_1);
		rdbtnFemale_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnFemale_1.setBounds(479, 463, 70, 23);
		contentPane.add(rdbtnFemale_1);
		
		JRadioButton rdbtnLow = new JRadioButton("Low");
		btnGrpIncLe.add(rdbtnLow);
		rdbtnLow.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnLow.setBounds(111, 616, 69, 23);
		contentPane.add(rdbtnLow);
		
		JRadioButton rdbtnMiddle = new JRadioButton("Middle");
		btnGrpIncLe.add(rdbtnMiddle);
		rdbtnMiddle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnMiddle.setBounds(182, 616, 70, 23);
		contentPane.add(rdbtnMiddle);
		
		JRadioButton rdbtnHigh = new JRadioButton("High");
		btnGrpIncLe.add(rdbtnHigh);
		rdbtnHigh.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnHigh.setBounds(254, 616, 70, 23);
		contentPane.add(rdbtnHigh);
		
		Choice choicePetCount = new Choice();
		choicePetCount.setBounds(111, 649, 97, 20);
		contentPane.add(choicePetCount);
		for (int i = 1; i <= 4; i++) {
			choicePetCount.add(String.valueOf(i)); 
        }
		
		choiceEmployee = new Choice();
		choiceEmployee.setBounds(111, 696, 164, 20);
		contentPane.add(choiceEmployee);
		
		populateEmployeeChoice();
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(413, 664, 100, 35);
		contentPane.add(btnApply);
		btnApply.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String petName = textFieldName.getText();
		        String breed = textFieldBreed.getText();
		        String species = textFieldSpecies.getText().toLowerCase(); // Convert to lowercase for comparison
		        String ageText = textFieldAge.getText();
		        String sex = rdbtnMale.isSelected() ? "male" : "female";
		        String color = textFieldColor.getText();
		        String spayedNeutered = rdbtnYes.isSelected() ? "yes" : "no";
		        String vaccinated = rdbtnYes1.isSelected() ? "yes" : "no";
		        String trainingLevel = rdbtnNone.isSelected() ? "none" : 
		                               rdbtnBasic.isSelected() ? "basic" : 
		                               rdbtnIntermediate.isSelected() ? "intermediate" : "advanced";
		        String arrivalDate = textFieldYear.getText() + "-" + textFieldMonth.getText() + "-" + textFieldDay.getText();

		        String firstName = textFieldFirstName.getText();
		        String lastName = textFieldLastName.getText();
		        String address = textAreaAddress.getText();
		        String adopterAgeText = textFieldAge1.getText();
		        String adopterSex = rdbtnMale_1.isSelected() ? "male" : "female";
		        String status = rdbtnSingle.isSelected() ? "single" : "married";
		        String contact = textFieldContact.getText();
		        String reason = textAreaReason.getText();
		        String incomeLevel = rdbtnLow.isSelected() ? "low" : 
		                             rdbtnMiddle.isSelected() ? "middle" : "high";
		        String petCountText = choicePetCount.getSelectedItem().toString();
		        String selectedItem = choiceEmployee.getSelectedItem().toString();
		        String[] parts = selectedItem.split(" - ");
		        int employeeId = Integer.parseInt(parts[0]);
		        
		        if (!isValidDate(textFieldYear.getText(), textFieldMonth.getText(), textFieldDay.getText())) {
		            JOptionPane.showMessageDialog(null, "Arrival date is not valid.");
		            return;
		        }

		        if (petName.isEmpty() || breed.isEmpty() || species.isEmpty() || ageText.isEmpty() || sex.isEmpty() 
		            || color.isEmpty() || spayedNeutered.isEmpty() || vaccinated.isEmpty() || trainingLevel.isEmpty() 
		            || arrivalDate.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() 
		            || adopterAgeText.isEmpty() || adopterSex.isEmpty() || status.isEmpty() || contact.isEmpty()
		            || reason.isEmpty() || incomeLevel.isEmpty() || petCountText.isEmpty() || selectedItem.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
		            return;
		        }

		        if (!species.equals("dog") && !species.equals("cat") && !species.equals("bird")) {
		            JOptionPane.showMessageDialog(null, "Species must be 'dog', 'cat', or 'bird'.");
		            return;
		        }

		        int age;
		        int adopterAge;
		        int petCount;
		        try {
		            age = Integer.parseInt(ageText);
		            adopterAge = Integer.parseInt(adopterAgeText);
		            petCount = Integer.parseInt(petCountText);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Age must be a valid number.");
		            return; 
		        }
		        
		        if (age <= 0 || age > 20) {
		            JOptionPane.showMessageDialog(null, "Pet age must be greater than 0 and less than or equal to 20.");
		            return;
		        }
		        
		        if (adopterAge < 8 || adopterAge > 80) {
		            JOptionPane.showMessageDialog(null, "Adopter age must be between 8 and 80.");
		            return;
		        }

		        String petQuery = "INSERT INTO pet (pet_name, breed, species, color, age, sex, arrival_date, vaccination_status, spayed_neutered, training_level, adoption_status) " +
		                          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'available')";
		        
		        String adopterQuery = "INSERT INTO adopter (adopter_type, first_name, last_name, age, sex, pet_count, address, income_level, contact_number, civil_status, reason) " +
		                              "VALUES ('rescuer', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		        
		        String adoptionQuery = "INSERT INTO adoption (pet_id, adopter_id, employee_id, adoption_date, adoption_fee) " +
		                               "VALUES (?, ?, ?, CURDATE(), 1500)"; 

		        try (Connection conn = dbConnector.getConnection(); 
		             PreparedStatement petStmt = conn.prepareStatement(petQuery, PreparedStatement.RETURN_GENERATED_KEYS);
		             PreparedStatement adopterStmt = conn.prepareStatement(adopterQuery, PreparedStatement.RETURN_GENERATED_KEYS);
		             PreparedStatement adoptionStmt = conn.prepareStatement (adoptionQuery)) {
		            
		            petStmt.setString(1, petName);
		            petStmt.setString(2, breed);
		            petStmt.setString(3, species);
		            petStmt.setString(4, color);
		            petStmt.setInt(5, age);
		            petStmt.setString(6, sex);
		            petStmt.setString(7, arrivalDate);
		            petStmt.setString(8, vaccinated);
		            petStmt.setString(9, spayedNeutered);
		            petStmt.setString(10, trainingLevel);
		            petStmt.executeUpdate();
		            
		            ResultSet petRs = petStmt.getGeneratedKeys();
		            petRs.next();
		            int petId = petRs.getInt(1);

		            adopterStmt.setString(1, firstName);
		            adopterStmt.setString(2, lastName);
		            adopterStmt.setInt(3, adopterAge);
		            adopterStmt.setString(4, adopterSex);
		            adopterStmt.setInt(5, petCount);
		            adopterStmt.setString(6, address);
		            adopterStmt.setString(7, incomeLevel);
		            adopterStmt.setString(8, contact);
		            adopterStmt.setString(9, status);
		            adopterStmt.setString(10, reason);
		            adopterStmt.executeUpdate();

		            ResultSet adopterRs = adopterStmt.getGeneratedKeys();
		            adopterRs.next();
		            int adopterId = adopterRs.getInt(1);

		            adoptionStmt.setInt(1, petId);
		            adoptionStmt.setInt(2, adopterId);
		            adoptionStmt.setInt(3, employeeId);
		            adoptionStmt.executeUpdate();

		            JOptionPane.showMessageDialog(null, "Pet and adopter added successfully with admission fee of 1500!");

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error adding pet, adopter, or adoption record: " + ex.getMessage());
		        }
		    }
		});
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
	
	private boolean isValidDate(String year, String month, String day) {
	    try {
	        int y = Integer.parseInt(year);
	        int m = Integer.parseInt(month);
	        int d = Integer.parseInt(day);
	        if (m < 1 || m > 12) return false;
	        if (d < 1 || d > 31) return false;
	        if (m == 2) {
	            return (d <= (isLeapYear(y) ? 29 : 28));
	        }
	        if (m == 4 || m == 6 || m == 9 || m == 11) {
	            return d <= 30;
	        }
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	private boolean isLeapYear(int year) {
	    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
