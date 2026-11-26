package dao;

import java.util.List;

public interface IEnseignantDao {
    void addEnseignant(Enseignant e);
    Enseignant getEnseignantById(int id);
    List<Enseignant> getAllEnseignants();
    void updateEnseignant(int id, Enseignant e);
    void deleteEnseignant(int id);
}