package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MatiereDao implements IMatiereDao {

    private final String s1 = "com.mysql.cj.jdbc.Driver";
    private final String s2 = "jdbc:mysql://localhost:3306/WS_j2ee?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private final String s3 = "root";
    private final String s4 = "2005";

    @Override
    public void addMatiere(Matiere m) {
        String sql = "INSERT INTO MATIERES(NOM_MATIERE, COEFFICIENT, ID_ENSEIGNANT) VALUES(?, ?, ?)";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, m.getNomMatiere());
                ps.setDouble(2, m.getCoefficient());
                ps.setInt(3, m.getIdEnseignant());
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Matiere getMatiereById(int id) {
        Matiere mat = null;
        String sql = "SELECT * FROM MATIERES WHERE ID_MATIERE = ?";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        mat = new Matiere();
                        mat.setIdMatiere(rs.getInt("ID_MATIERE"));
                        mat.setNomMatiere(rs.getString("NOM_MATIERE"));
                        mat.setCoefficient(rs.getDouble("COEFFICIENT"));
                        mat.setIdEnseignant(rs.getInt("ID_ENSEIGNANT"));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mat;
    }

    @Override
    public List<Matiere> getAllMatieres() {
        List<Matiere> liste = new ArrayList<>();
        String sql = "SELECT * FROM MATIERES";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Matiere mat = new Matiere();
                    mat.setIdMatiere(rs.getInt("ID_MATIERE"));
                    mat.setNomMatiere(rs.getString("NOM_MATIERE"));
                    mat.setCoefficient(rs.getDouble("COEFFICIENT"));
                    mat.setIdEnseignant(rs.getInt("ID_ENSEIGNANT"));
                    liste.add(mat);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return liste;
    }

    @Override
    public List<Matiere> getMatieresByEnseignant(int idEnseignant) {
        List<Matiere> liste = new ArrayList<>();
        String sql = "SELECT * FROM MATIERES WHERE ID_ENSEIGNANT = ?";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idEnseignant);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Matiere mat = new Matiere();
                        mat.setIdMatiere(rs.getInt("ID_MATIERE"));
                        mat.setNomMatiere(rs.getString("NOM_MATIERE"));
                        mat.setCoefficient(rs.getDouble("COEFFICIENT"));
                        mat.setIdEnseignant(rs.getInt("ID_ENSEIGNANT"));
                        liste.add(mat);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return liste;
    }

    @Override
    public void updateMatiere(int id, Matiere m) {
        String sql = "UPDATE MATIERES SET NOM_MATIERE = ?, COEFFICIENT = ?, ID_ENSEIGNANT = ? WHERE ID_MATIERE = ?";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, m.getNomMatiere());
                ps.setDouble(2, m.getCoefficient());
                ps.setInt(3, m.getIdEnseignant());
                ps.setInt(4, id);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteMatiere(int id) {
        String sql = "DELETE FROM MATIERES WHERE ID_MATIERE = ?";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}