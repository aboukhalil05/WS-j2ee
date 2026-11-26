package dao;

public class Enseignant {

    private int idEnseignant;
    private String nomEnseignant;
    private String prenomEnseignant;
    private String specialite;
    private String email;

    public Enseignant() {
    }

    public Enseignant(String nomEnseignant, String prenomEnseignant, String specialite, String email) {
        this.nomEnseignant = nomEnseignant;
        this.prenomEnseignant = prenomEnseignant;
        this.specialite = specialite;
        this.email = email;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public String getPrenomEnseignant() {
        return prenomEnseignant;
    }

    public void setPrenomEnseignant(String prenomEnseignant) {
        this.prenomEnseignant = prenomEnseignant;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Enseignant [idEnseignant=" + idEnseignant + ", nomEnseignant=" + nomEnseignant
                + ", prenomEnseignant=" + prenomEnseignant + ", specialite=" + specialite + ", email=" + email + "]";
    }
}