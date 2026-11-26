package dao;

import java.util.List;

public interface INoteDao {
    void addNote(Note n);
    Note getNoteById(int id);
    List<Note> getAllNotes();
    List<Note> getNotesByStudent(int idStudent);
    void updateNote(int id, Note n);
    void deleteNote(int id);
}