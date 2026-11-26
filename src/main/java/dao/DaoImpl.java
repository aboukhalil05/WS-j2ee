package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements IDao {

    private final String s1 = "com.mysql.cj.jdbc.Driver";
    private final String s2 = "jdbc:mysql://localhost:3306/WS_j2ee?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private final String s3 = "root";
    private final String s4 = "2005";

    @Override
    public void addStudent(Student s) {
        String sql = "INSERT INTO STUDENTS(FIRST_NAME_STUDENT, LAST_NAME_STUDENT, DATE_BIRTH_STUDENT) VALUES(?, ?, ?)";
        try {
            Class.forName(s1);
            try (Connection connection = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, s.getFirstNameStudent());
                ps.setString(2, s.getLastNameStudent());
                ps.setDate(3, s.getDateBirthStudent());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(int id) {
        Student st = null;
        String sql = "SELECT * FROM STUDENTS WHERE ID_STUDENT = ?";
        try {
            Class.forName(s1);
            try (Connection connection = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        st = new Student();
                        st.setIdStudent(rs.getInt("ID_STUDENT"));
                        st.setFirstNameStudent(rs.getString("FIRST_NAME_STUDENT"));
                        st.setLastNameStudent(rs.getString("LAST_NAME_STUDENT"));
                        st.setDateBirthStudent(rs.getDate("DATE_BIRTH_STUDENT"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> stds = new ArrayList<>();
        String sql = "SELECT * FROM STUDENTS";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Student etd = new Student();
                    etd.setIdStudent(rs.getInt("ID_STUDENT"));
                    etd.setFirstNameStudent(rs.getString("FIRST_NAME_STUDENT"));
                    etd.setLastNameStudent(rs.getString("LAST_NAME_STUDENT"));
                    etd.setDateBirthStudent(rs.getDate("DATE_BIRTH_STUDENT"));
                    stds.add(etd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stds;
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM STUDENTS WHERE ID_STUDENT = ?";
        try {
            Class.forName(s1);
            try (Connection connection = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(int id, Student s) {
        String sql = "UPDATE STUDENTS SET FIRST_NAME_STUDENT = ?, LAST_NAME_STUDENT = ?, DATE_BIRTH_STUDENT = ? WHERE ID_STUDENT = ?";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, s.getFirstNameStudent());
                ps.setString(2, s.getLastNameStudent());
                ps.setDate(3, s.getDateBirthStudent());
                ps.setInt(4, id);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}