package dao;

import java.util.List;

public interface IMatiereDao {

    void addMatiere(Matiere m);

    Matiere getMatiereById(int id);

    List<Matiere> getAllMatieres();

    List<Matiere> getMatieresByEnseignant(int idEnseignant);

    void updateMatiere(int id, Matiere m);

    void deleteMatiere(int id);
}