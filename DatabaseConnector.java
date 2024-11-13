package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        stmt.setInt(1, year);  // Set year
        stmt.setInt(2, month); // Set month
        return stmt.executeQuery();
    }
}
