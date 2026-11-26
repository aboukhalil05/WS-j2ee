package dao;

public class Note {

    private int idNote;
    private double valeur;
    private int idStudent;
    private int idMatiere;

    public Note() {
    }

    public Note(double valeur, int idStudent, int idMatiere) {
        this.valeur = valeur;
        this.idStudent = idStudent;
        this.idMatiere = idMatiere;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    @Override
    public String toString() {
        return "Note [idNote=" + idNote + ", valeur=" + valeur
                + ", idStudent=" + idStudent + ", idMatiere=" + idMatiere + "]";
    }
}