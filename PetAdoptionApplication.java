package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class PetAdoptionApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int selectedEmployeeId = -1;
	private int selectedPetId = -1;
	
	private JTextPane textPaneNameFilter;
	private JTextPane textPaneBreedFilter;
	private JTextPane textPaneSpeciesFilter;
	private JScrollPane scrollPaneFilter;
	private final ButtonGroup buttonGroupGender = new ButtonGroup();
	private final ButtonGroup buttonGroupStatus = new ButtonGroup();
	private final ButtonGroup buttonGroupIncome = new ButtonGroup();

	public PetAdoptionApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPetAdoptionApplication = new JLabel("Pet Adoption Application");
		lblPetAdoptionApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetAdoptionApplication.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPetAdoptionApplication.setBounds(10, 11, 479, 32);
		contentPane.add(lblPetAdoptionApplication);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblName.setBounds(10, 56, 92, 18);
		contentPane.add(lblName);
		
		JTextPane textPaneName = new JTextPane();
		textPaneName.setBounds(111, 54, 351, 23);
		contentPane.add(textPaneName);
		
		JLabel lblAge = new JLabel("Address");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge.setBounds(10, 87, 92, 18);
		contentPane.add(lblAge);
		
		JLabel lblAge_1 = new JLabel("Age");
		lblAge_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1.setBounds(10, 148, 92, 18);
		contentPane.add(lblAge_1);
		
		JTextPane textPaneAge = new JTextPane();
		textPaneAge.setBounds(111, 146, 141, 23);
		contentPane.add(textPaneAge);
		
		JLabel lblAge_1_1 = new JLabel("Sex");
		lblAge_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1_1.setBounds(218, 148, 92, 18);
		contentPane.add(lblAge_1_1);
		
		JLabel lblName_1 = new JLabel("Contact");
		lblName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblName_1.setBounds(10, 210, 92, 18);
		contentPane.add(lblName_1);
		
		JTextPane textPaneContact = new JTextPane();
		textPaneContact.setBounds(111, 208, 351, 23);
		contentPane.add(textPaneContact);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblReason.setBounds(10, 239, 92, 18);
		contentPane.add(lblReason);
		
		JLabel lblPetCount = new JLabel("Income Level");
		lblPetCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPetCount.setBounds(10, 301, 92, 18);
		contentPane.add(lblPetCount);
		
		JTextPane textPanePetCount = new JTextPane();
		textPanePetCount.setBounds(111, 333, 351, 23);
		contentPane.add(textPanePetCount);
		
		JLabel lblPetCount_1 = new JLabel("Pet Count");
		lblPetCount_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetCount_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblPetCount_1.setBounds(10, 335, 92, 18);
		contentPane.add(lblPetCount_1);
		
		scrollPaneFilter = new JScrollPane();
		scrollPaneFilter.setBounds(111, 482, 164, 102);
		contentPane.add(scrollPaneFilter);
		
		JLabel lblPets = new JLabel("Search Pet");
		lblPets.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPets.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblPets.setBounds(10, 484, 92, 18);
		contentPane.add(lblPets);
		
		textPaneNameFilter = new JTextPane();
		textPaneNameFilter.setBounds(365, 482, 97, 23);
		contentPane.add(textPaneNameFilter);
		textPaneNameFilter.getDocument().addDocumentListener(new DocumentListener() {
		    public void insertUpdate(DocumentEvent e) {
		        try {
					updatePetList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }

		    public void removeUpdate(DocumentEvent e) {
		        try {
					updatePetList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }

		    public void changedUpdate(DocumentEvent e) {
		        try {
					updatePetList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		
		JLabel lblEmployee_1 = new JLabel("Name");
		lblEmployee_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1.setBounds(264, 484, 92, 18);
		contentPane.add(lblEmployee_1);
		
		textPaneBreedFilter = new JTextPane();
		textPaneBreedFilter.setBounds(365, 516, 97, 23);
		contentPane.add(textPaneBreedFilter);
		textPaneBreedFilter.getDocument().addDocumentListener(new DocumentListener() {
		    public void insertUpdate(DocumentEvent e) {
		    	try {
					updatePetList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }

		    public void removeUpdate(DocumentEvent e) {
		        try {
					updatePetList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }

		    public void changedUpdate(DocumentEvent e) {
		        try {
					updatePetList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		JLabel lblEmployee_1_1 = new JLabel("Breed");
		lblEmployee_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_1.setBounds(264, 518, 92, 18);
		contentPane.add(lblEmployee_1_1);
		
		JLabel lblEmployee_1_1_1 = new JLabel("Species");
		lblEmployee_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_1_1.setBounds(264, 552, 92, 18);
		contentPane.add(lblEmployee_1_1_1);
		
		textPaneSpeciesFilter = new JTextPane();
		textPaneSpeciesFilter.setBounds(365, 550, 97, 23);
		contentPane.add(textPaneSpeciesFilter);
		textPaneSpeciesFilter.getDocument().addDocumentListener(new DocumentListener() {
		    public void insertUpdate(DocumentEvent e) {
		        try {
					updatePetList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }

		    public void removeUpdate(DocumentEvent e) {
		        try {
					updatePetList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }

		    public void changedUpdate(DocumentEvent e) {
		        try {
					updatePetList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setBounds(111, 88, 351, 47);
		contentPane.add(textAreaAddress);
		
		JTextArea textAreaReason = new JTextArea();
		textAreaReason.setBounds(111, 242, 351, 47);
		contentPane.add(textAreaReason);
		
		JLabel lblAge_1_2 = new JLabel("Status");
		lblAge_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAge_1_2.setBounds(10, 179, 92, 18);
		contentPane.add(lblAge_1_2);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");
		buttonGroupStatus.add(rdbtnSingle);
		rdbtnSingle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnSingle.setBounds(111, 178, 69, 23);
		contentPane.add(rdbtnSingle);
		
		JRadioButton rdbtnMarried = new JRadioButton("Married");
		buttonGroupStatus.add(rdbtnMarried);
		rdbtnMarried.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnMarried.setBounds(182, 178, 70, 23);
		contentPane.add(rdbtnMarried);
		
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
		btnNewButton_2_1.setBounds(10, 627, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblPetCount_1_1 = new JLabel("<html>\r\n<div style='text-align: center;'>\r\nHandling<br> \r\nEmployee\r\n</div>\r\n</html>");
		lblPetCount_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetCount_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblPetCount_1_1.setBounds(10, 390, 92, 55);
		contentPane.add(lblPetCount_1_1);
		
		JScrollPane scrollPaneFilter_1 = new JScrollPane();
		scrollPaneFilter_1.setBounds(111, 364, 164, 102);
		contentPane.add(scrollPaneFilter_1);
		
		JLabel lblEmployee_1_2 = new JLabel("Name");
		lblEmployee_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployee_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmployee_1_2.setBounds(264, 369, 92, 18);
		contentPane.add(lblEmployee_1_2);
		
		JTextPane textPaneNameFilter_1 = new JTextPane();
		textPaneNameFilter_1.setBounds(365, 367, 97, 23);
		contentPane.add(textPaneNameFilter_1);
		textPaneNameFilter_1.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        try {
					updateEmployeeList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        try {
					updateEmployeeList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        try {
					updateEmployeeList();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }

		    private void updateEmployeeList() throws SQLException {
		        String partialName = textPaneNameFilter_1.getText().trim();

		        if (partialName.isEmpty()) {
		            return;
		        }

		        DatabaseConnector dbConnector = new DatabaseConnector();

		        Map<Integer, String> employeeNames = dbConnector.getEmployeeNamesByPartialName(partialName);

		        JScrollPane scrollPane = (JScrollPane) scrollPaneFilter_1;
		        JTextArea textArea = new JTextArea();
		        textArea.setEditable(false); 

		        StringBuilder namesText = new StringBuilder();
		        if (employeeNames.isEmpty()) {
		            namesText.append("No matching employees found.");
		        } else {
		            for (Map.Entry<Integer, String> entry : employeeNames.entrySet()) {
		                int employeeId = entry.getKey();
		                String fullName = entry.getValue();

		                namesText.append(fullName).append(" (ID: ").append(employeeId).append(")\n");
		            }
		        }

		        textArea.setText(namesText.toString());
		        scrollPane.setViewportView(textArea);  
		    }
		});
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(199, 595, 100, 35);
		contentPane.add(btnApply);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroupGender.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnMale.setBounds(321, 148, 69, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroupGender.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnFemale.setBounds(392, 148, 70, 23);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnLow = new JRadioButton("Low");
		buttonGroupIncome.add(rdbtnLow);
		rdbtnLow.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnLow.setBounds(111, 301, 69, 23);
		contentPane.add(rdbtnLow);
		
		JRadioButton rdbtnMiddle = new JRadioButton("Middle");
		buttonGroupIncome.add(rdbtnMiddle);
		rdbtnMiddle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnMiddle.setBounds(182, 301, 70, 23);
		contentPane.add(rdbtnMiddle);
		
		JRadioButton rdbtnHigh = new JRadioButton("High");
		buttonGroupIncome.add(rdbtnHigh);
		rdbtnHigh.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		rdbtnHigh.setBounds(254, 301, 70, 23);
		contentPane.add(rdbtnHigh);
		btnApply.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String adopterType = "adopter";
		        String name = textPaneName.getText();
		        String[] nameParts = name.split(" ");
		        String firstName = "";
		        String lastName = "";
		        if (nameParts.length == 1) {
		            firstName = nameParts[0];
		            lastName = "";  
		        } else if (nameParts.length >= 2) {
		            firstName = nameParts[0];  
		            lastName = nameParts[nameParts.length - 1]; 
		        }
		        String address = textAreaAddress.getText();
		        String reason = textAreaReason.getText();
		        String ageText = textPaneAge.getText();
	        	String sex = null;
		        if (rdbtnMale.isSelected()) 
		        	sex = "male";
				else if (rdbtnFemale.isSelected()) 
					sex = "female";
		    	else JOptionPane.showMessageDialog(PetAdoptionApplication.this, "Please choose gender.");
		    	
		        String contact = textPaneContact.getText();
		        
		        String income = null;
		        if (rdbtnLow.isSelected()) 
		        	income = "low";
				else if (rdbtnMiddle.isSelected()) 
					income = "middle";
		    	else if (rdbtnHigh.isSelected()) 
					income = "high";
		    	else JOptionPane.showMessageDialog(PetAdoptionApplication.this, "Please choose income level.");
		    	
		        
		        String petCountText = textPanePetCount.getText();
				if (selectedEmployeeId != -1) 
		            System.out.println("Selected Employee ID: " + selectedEmployeeId);
		        else JOptionPane.showMessageDialog(PetAdoptionApplication.this, "Please select an employee.");
				
				if (selectedPetId != -1) 
		            System.out.println("Selected Pet ID: " + selectedPetId);
		        else JOptionPane.showMessageDialog(PetAdoptionApplication.this, "Please select a pet.");
		        
				
				String status = null;
				if (rdbtnSingle.isSelected())
					status = "single";
				else if (rdbtnMarried.isSelected()) 
					status = "married";
		    	else JOptionPane.showMessageDialog(PetAdoptionApplication.this, "Please choose civil status.");
		
		        int adopterId = 1; 
		        
		        String adoptionDate = "2024-11-16";

		        double adoptionFee = 100.00; 

		        DatabaseConnector dbConnector = new DatabaseConnector();
		        boolean success = false;
				try {
					int employeeId = selectedEmployeeId;
					int petId = selectedPetId;
					success = dbConnector.insertAdoptionRecord(petId, adopterId, employeeId, adoptionDate, adoptionFee, reason);
					boolean adopterSuccess = dbConnector.insertAdopter("adopter", firstName, lastName, Integer.parseInt(ageText), sex, Integer.parseInt(petCountText), address, income, contact, status, reason);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

		        if (success) 
		            JOptionPane.showMessageDialog(null, "Adoption record added successfully.");
		        else JOptionPane.showMessageDialog(null, "Failed to add adoption record.");
		        
		    }
		});
	}
	
	private void updatePetList() throws SQLException {
	    if (textPaneNameFilter == null || scrollPaneFilter == null) {
	        System.out.println("textPaneNameFilter or scrollPaneFilter is not initialized!");
	        return;
	    }

	    String nameFilter = textPaneNameFilter.getText().trim();
	    String breedFilter = textPaneBreedFilter.getText().trim();
	    String speciesFilter = textPaneSpeciesFilter.getText().trim();

	    if (nameFilter.isEmpty() && breedFilter.isEmpty() && speciesFilter.isEmpty()) {
	        return;  
	    }

	    DatabaseConnector dbConnector = new DatabaseConnector();

	    Map<Integer, String> petList = dbConnector.getPetsByFilters(nameFilter, breedFilter, speciesFilter);

	    JTextArea textArea = new JTextArea();
	    textArea.setEditable(false);  

	    StringBuilder petsText = new StringBuilder();
	    if (petList.isEmpty()) {
	        petsText.append("No matching pets found.");
	    } else {
	        for (Map.Entry<Integer, String> entry : petList.entrySet()) {
	            int petId = entry.getKey();
	            String petDetails = entry.getValue();

	            // Add pet details to the text
	            petsText.append(petDetails).append(" (ID: ").append(petId).append(")\n");
	        }
	    }

	    textArea.setText(petsText.toString());

	    scrollPaneFilter.setViewportView(textArea);  

	    textArea.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            String selectedText = textArea.getSelectedText();
	            if (selectedText != null && !selectedText.isEmpty()) {
	                String[] parts = selectedText.split(" \\(ID: ");
	                if (parts.length > 1) {
	                    String idString = parts[1].replace(")", "");
	                    try {
	                        selectedPetId = Integer.parseInt(idString);
	                    } catch (NumberFormatException ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            }
	        }
	    });
	}
}
