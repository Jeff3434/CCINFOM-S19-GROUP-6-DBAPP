package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseConnector {
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/petadoption", "root", "admin");
    }

    public ResultSet fetchPetData() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("SELECT * FROM pet");
    }
    
    public ResultSet fetchAdopterData() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("SELECT * FROM adopter");
    }
    
    public ResultSet fetchAdoptionData() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("SELECT * FROM adoption");
    }
    
    public ResultSet fetchEmployeeData() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("SELECT * FROM employee");
    }

    public ResultSet fetchAdoptionHistory(int year, int month) throws SQLException {
        String sql = "SELECT YEAR(a.adoption_date) AS adoption_year, "
                   + "MONTH(a.adoption_date) AS adoption_month, "
                   + "COUNT(a.adoption_id) AS total_adoptions, "
                   + "GROUP_CONCAT(DISTINCT DATE(a.adoption_date) ORDER BY a.adoption_date) AS adoption_dates, "
                   + "GROUP_CONCAT(DISTINCT CONCAT(ad.first_name, ' ', ad.last_name) ORDER BY a.adoption_date) AS adopters "
                   + "FROM adoption a "
                   + "JOIN adopter ad ON a.adopter_id = ad.adopter_id "
                   + "WHERE YEAR(a.adoption_date) = ? AND MONTH(a.adoption_date) = ? "
                   + "GROUP BY adoption_year, adoption_month "
                   + "ORDER BY adoption_year DESC, adoption_month DESC";

        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, year);  
        stmt.setInt(2, month); 
        return stmt.executeQuery();
    }

    public ResultSet fetchEmployeeAdoptionData(String employeeName, String breed, String species) throws SQLException {
        String sql = "SELECT e.employee_id, "
                   + "e.first_name AS employee_first_name, "
                   + "e.last_name AS employee_last_name, "
                   + "e.years_of_experience, "
                   + "p.pet_name AS pet_name, "
                   + "p.breed AS pet_breed, "
                   + "p.species AS pet_species, "
                   + "p.adoption_status AS pet_adoption_status "
                   + "FROM adoption a "
                   + "JOIN pet p ON a.pet_id = p.pet_id "
                   + "JOIN employee e ON a.employee_id = e.employee_id "
                   + "WHERE e.first_name = ? AND p.breed = ? AND p.species = ? "
                   + "ORDER BY e.employee_id, p.adoption_status DESC";

        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, employeeName); 
        stmt.setString(2, breed);        
        stmt.setString(3, species);       
        return stmt.executeQuery();
    }

    public ResultSet fetchAdoptionTrends(int year, int month) throws SQLException {
        String sql = "SELECT YEAR(a.adoption_date) AS adoption_year, "
                   + "MONTH(a.adoption_date) AS adoption_month, "
                   + "p.species AS pet_species, "
                   + "p.adoption_status AS pet_adoption_status, "
                   + "ad.income_level AS adopter_income_level, "
                   + "SUM(a.adoption_fee) AS total_adoption_fee, " 
                   + "COUNT(a.adoption_id) AS total_adoptions "
                   + "FROM adoption a "
                   + "JOIN pet p ON a.pet_id = p.pet_id "
                   + "JOIN adopter ad ON a.adopter_id = ad.adopter_id "
                   + "WHERE YEAR(a.adoption_date) = ? AND MONTH(a.adoption_date) = ? "
                   + "GROUP BY adoption_year, adoption_month, pet_species, pet_adoption_status, adopter_income_level "
                   + "ORDER BY adoption_year DESC, adoption_month DESC, total_adoptions DESC";

        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, year);  
        stmt.setInt(2, month); 
        return stmt.executeQuery();
    }
    
    public ResultSet fetchAdoptionRevenue(int year, int month) throws SQLException {
        String sql = "SELECT YEAR(a.adoption_date) AS adoption_year, "
                   + "MONTH(a.adoption_date) AS adoption_month, "
                   + "SUM(a.adoption_fee) AS total_adoption_revenue, "
                   + "GROUP_CONCAT(DISTINCT DATE(a.adoption_date) ORDER BY a.adoption_date) AS adoption_dates, "
                   + "GROUP_CONCAT(DISTINCT CONCAT(e.first_name, ' ', e.last_name) ORDER BY a.adoption_date) AS employees, "
                   + "GROUP_CONCAT(DISTINCT e.salary ORDER BY a.adoption_date) AS employee_salaries "
                   + "FROM adoption a "
                   + "JOIN employee e ON a.employee_id = e.employee_id "
                   + "WHERE YEAR(a.adoption_date) = ? AND MONTH(a.adoption_date) = ? "
                   + "GROUP BY adoption_year, adoption_month "
                   + "ORDER BY adoption_year DESC, adoption_month DESC";

        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, year);  
        stmt.setInt(2, month); 
        return stmt.executeQuery();
    }
    
    public boolean insertAdoptionRecord(int petId, int adopterId, int employeeId, String adoptionDate, double adoptionFee, String reason) throws SQLException {
        String sql = "INSERT INTO adoption (pet_id, adopter_id, employee_id, adoption_date, adoption_fee) VALUES (?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, petId);
            pst.setInt(2, adopterId);
            pst.setInt(3, employeeId);
            pst.setString(4, adoptionDate);
            pst.setDouble(5, adoptionFee);

            int rowsAffected = pst.executeUpdate();
            
            if (rowsAffected > 0) {
                String updatePetSql = "UPDATE pet SET adoption_status = 'adopted' WHERE pet_id = ?";
                try (PreparedStatement updatePst = conn.prepareStatement(updatePetSql)) {
                    updatePst.setInt(1, petId);
                    updatePst.executeUpdate();
                }

                if (reason != null && !reason.isEmpty()) {
                    String updateReasonSql = "UPDATE adoption SET reason = ? WHERE pet_id = ? AND adopter_id = ?";
                    try (PreparedStatement updateReasonPst = conn.prepareStatement(updateReasonSql)) {
                        updateReasonPst.setString(1, reason);
                        updateReasonPst.setInt(2, petId);
                        updateReasonPst.setInt(3, adopterId);
                        updateReasonPst.executeUpdate();
                    }
                }

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Map<Integer, String> getEmployeeNamesByPartialName(String partialName) throws SQLException {
        Map<Integer, String> employeeNames = new HashMap<>();
        Connection conn = getConnection();
        String query = "SELECT employee_id, first_name, last_name FROM employee WHERE first_name LIKE ? OR last_name LIKE ?";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, "%" + partialName + "%");
            pst.setString(2, "%" + partialName + "%");
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                employeeNames.put(employeeId, firstName + " " + lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeNames;
    }
    
    public Map<Integer, String> getPetInfoByFilters(String nameFilter, String breedFilter, String speciesFilter) throws SQLException {
        Map<Integer, String> petInfo = new HashMap<>();
        Connection conn = getConnection();
        String query = "SELECT pet_id, name, breed, species FROM pets WHERE name LIKE ? AND breed LIKE ? AND species LIKE ?";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, "%" + nameFilter + "%");
            pst.setString(2, "%" + breedFilter + "%");
            pst.setString(3, "%" + speciesFilter + "%");
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int petId = rs.getInt("pet_id");
                String name = rs.getString("name");
                String breed = rs.getString("breed");
                String species = rs.getString("species");

                petInfo.put(petId, name + " - " + breed + " - " + species);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petInfo;
    }
    
    public Map<Integer, String> getPetsByFilters(String nameFilter, String breedFilter, String speciesFilter) throws SQLException {
        Map<Integer, String> pets = new HashMap<>();
        Connection conn = getConnection();
        String query = "SELECT pet_id, pet_name, breed, species FROM pet WHERE pet_name LIKE ? AND breed LIKE ? AND species LIKE ?";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, "%" + nameFilter + "%");
            pst.setString(2, "%" + breedFilter + "%");
            pst.setString(3, "%" + speciesFilter + "%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int petId = rs.getInt("pet_id");
                String name = rs.getString("name");
                String breed = rs.getString("breed");
                String species = rs.getString("species");

                pets.put(petId, name + " (" + breed + ", " + species + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
    
    public boolean insertAdopter(String adopterType, String firstName, String lastName, int age, String sex, int petCount,
    	String address, String income, String contact, String civilStatus, String reason) throws SQLException {
		String query = "INSERT INTO adopter (adopter_type, first_name, last_name, age, sex, pet_count, address, income_level, contact_number, civil_status, reason) " +
		  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, adopterType);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setInt(4, age);
			stmt.setString(5, sex);
			stmt.setInt(6, petCount);
			stmt.setString(7, address);
			stmt.setString(8, income);
			stmt.setString(9, contact);
			stmt.setString(10, civilStatus);
			stmt.setString(11, reason);
			
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		}
	}

    
    public int getLastInsertedAdopterId() throws SQLException {
	    String query = "SELECT LAST_INSERT_ID()";  
	    try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {
	        if (rs.next()) {
	            return rs.getInt(1); 
	        } else {
	            throw new SQLException("Failed to retrieve the last inserted adopter_id.");
	        }
	    }
	}
    
    

}
