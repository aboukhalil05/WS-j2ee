package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoteDao implements INoteDao {

    private final String s1 = "com.mysql.cj.jdbc.Driver";
    private final String s2 = "jdbc:mysql://localhost:3306/WS_j2ee?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private final String s3 = "root";
    private final String s4 = "2005";

    @Override
    public void addNote(Note n) {
        String sql = "INSERT INTO NOTES(VALEUR, ID_STUDENT, ID_MATIERE) VALUES(?, ?, ?)";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDouble(1, n.getValeur());
                ps.setInt(2, n.getIdStudent());
                ps.setInt(3, n.getIdMatiere());
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Note getNoteById(int id) {
        Note note = null;
        String sql = "SELECT * FROM NOTES WHERE ID_NOTE = ?";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        note = new Note();
                        note.setIdNote(rs.getInt("ID_NOTE"));
                        note.setValeur(rs.getDouble("VALEUR"));
                        note.setIdStudent(rs.getInt("ID_STUDENT"));
                        note.setIdMatiere(rs.getInt("ID_MATIERE"));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return note;
    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> liste = new ArrayList<>();
        String sql = "SELECT * FROM NOTES";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Note note = new Note();
                    note.setIdNote(rs.getInt("ID_NOTE"));
                    note.setValeur(rs.getDouble("VALEUR"));
                    note.setIdStudent(rs.getInt("ID_STUDENT"));
                    note.setIdMatiere(rs.getInt("ID_MATIERE"));
                    liste.add(note);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return liste;
    }

    @Override
    public List<Note> getNotesByStudent(int idStudent) {
        List<Note> liste = new ArrayList<>();
        String sql = "SELECT * FROM NOTES WHERE ID_STUDENT = ?";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idStudent);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Note note = new Note();
                        note.setIdNote(rs.getInt("ID_NOTE"));
                        note.setValeur(rs.getDouble("VALEUR"));
                        note.setIdStudent(rs.getInt("ID_STUDENT"));
                        note.setIdMatiere(rs.getInt("ID_MATIERE"));
                        liste.add(note);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return liste;
    }

    @Override
    public void updateNote(int id, Note n) {
        String sql = "UPDATE NOTES SET VALEUR = ?, ID_STUDENT = ?, ID_MATIERE = ? WHERE ID_NOTE = ?";
        try {
            Class.forName(s1);
            try (Connection con = DriverManager.getConnection(s2, s3, s4);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDouble(1, n.getValeur());
                ps.setInt(2, n.getIdStudent());
                ps.setInt(3, n.getIdMatiere());
                ps.setInt(4, id);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteNote(int id) {
        String sql = "DELETE FROM NOTES WHERE ID_NOTE = ?";
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