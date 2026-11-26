package dao;

public class Matiere {

    private int idMatiere;
    private String nomMatiere;
    private double coefficient;
    private int idEnseignant;

    public Matiere() {
    }

    public Matiere(String nomMatiere, double coefficient, int idEnseignant) {
        this.nomMatiere = nomMatiere;
        this.coefficient = coefficient;
        this.idEnseignant = idEnseignant;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    @Override
    public String toString() {
        return "Matiere [idMatiere=" + idMatiere + ", nomMatiere=" + nomMatiere
                + ", coefficient=" + coefficient + ", idEnseignant=" + idEnseignant + "]";
    }
}