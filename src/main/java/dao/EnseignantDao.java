package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnseignantDao implements IEnseignantDao {

    private final String s1 = "com.mysql.cj.jdbc.Driver";
    private final String s2 = "jdbc:mysql://localhost:3306/WS_j2ee?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private final String s3 = "root";
    private final String s4 = "2005";

    @Override
    public void addEnseignant(Enseignant e) {
        String sql = "INSERT INTO ENSEIGNANTS(NOM_ENSEIGNANT, PRENOM_ENSEIGNANT, SPECIALITE, EMAIL) VALUES(?, ?, ?, ?)";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, e.getNomEnseignant());
                ps.setString(2, e.getPrenomEnseignant());
                ps.setString(3, e.getSpecialite());
                ps.setString(4, e.getEmail());
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Enseignant getEnseignantById(int id) {
        Enseignant ens = null;
        String sql = "SELECT * FROM ENSEIGNANTS WHERE ID_ENSEIGNANT = ?";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        ens = new Enseignant();
                        ens.setIdEnseignant(rs.getInt("ID_ENSEIGNANT"));
                        ens.setNomEnseignant(rs.getString("NOM_ENSEIGNANT"));
                        ens.setPrenomEnseignant(rs.getString("PRENOM_ENSEIGNANT"));
                        ens.setSpecialite(rs.getString("SPECIALITE"));
                        ens.setEmail(rs.getString("EMAIL"));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ens;
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        List<Enseignant> liste = new ArrayList<>();
        String sql = "SELECT * FROM ENSEIGNANTS";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Enseignant ens = new Enseignant();
                    ens.setIdEnseignant(rs.getInt("ID_ENSEIGNANT"));
                    ens.setNomEnseignant(rs.getString("NOM_ENSEIGNANT"));
                    ens.setPrenomEnseignant(rs.getString("PRENOM_ENSEIGNANT"));
                    ens.setSpecialite(rs.getString("SPECIALITE"));
                    ens.setEmail(rs.getString("EMAIL"));
                    liste.add(ens);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return liste;
    }

    @Override
    public void updateEnseignant(int id, Enseignant e) {
        String sql = "UPDATE ENSEIGNANTS SET NOM_ENSEIGNANT = ?, PRENOM_ENSEIGNANT = ?, SPECIALITE = ?, EMAIL = ? WHERE ID_ENSEIGNANT = ?";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, e.getNomEnseignant());
                ps.setString(2, e.getPrenomEnseignant());
                ps.setString(3, e.getSpecialite());
                ps.setString(4, e.getEmail());
                ps.setInt(5, id);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEnseignant(int id) {
        String sql = "DELETE FROM ENSEIGNANTS WHERE ID_ENSEIGNANT = ?";
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