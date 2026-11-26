package WS;

import dao.INoteDao;
import dao.Note;
import dao.NoteDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/notes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoteRest {

    private final INoteDao dao = new NoteDao();

    @GET
    public List<Note> getAllNotes() {
        return dao.getAllNotes();
    }

    @GET
    @Path("/{id}")
    public Note getNoteById(@PathParam("id") int id) {
        return dao.getNoteById(id);
    }

    @GET
    @Path("/student/{idStudent}")
    public List<Note> getNotesByStudent(@PathParam("idStudent") int idStudent) {
        return dao.getNotesByStudent(idStudent);
    }

    @POST
    public Map<String, String> addNote(Note n) {
        dao.addNote(n);
        return Map.of("message", "Note ajoutée avec succès");
    }

    @PUT
    @Path("/{id}")
    public Map<String, String> updateNote(@PathParam("id") int id, Note n) {
        dao.updateNote(id, n);
        return Map.of("message", "Note modifiée avec succès");
    }

    @DELETE
    @Path("/{id}")
    public Map<String, String> deleteNote(@PathParam("id") int id) {
        dao.deleteNote(id);
        return Map.of("message", "Note supprimée avec succès");
    }
}