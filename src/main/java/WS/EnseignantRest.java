package WS;

import dao.Enseignant;
import dao.EnseignantDao;
import dao.IEnseignantDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/enseignants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnseignantRest {

    private final IEnseignantDao dao = new EnseignantDao();

    @GET
    public List<Enseignant> getAllEnseignants() {
        return dao.getAllEnseignants();
    }

    @GET
    @Path("/{id}")
    public Enseignant getEnseignantById(@PathParam("id") int id) {
        return dao.getEnseignantById(id);
    }

    @POST
    public Map<String, String> addEnseignant(Enseignant e) {
        dao.addEnseignant(e);
        return Map.of("message", "Enseignant ajouté avec succès");
    }

    @PUT
    @Path("/{id}")
    public Map<String, String> updateEnseignant(@PathParam("id") int id, Enseignant e) {
        dao.updateEnseignant(id, e);
        return Map.of("message", "Enseignant modifié avec succès");
    }

    @DELETE
    @Path("/{id}")
    public Map<String, String> deleteEnseignant(@PathParam("id") int id) {
        dao.deleteEnseignant(id);
        return Map.of("message", "Enseignant supprimé avec succès");
    }
}