package WS;

import dao.IMatiereDao;
import dao.Matiere;
import dao.MatiereDao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/matieres")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatiereRest {

    private final IMatiereDao dao = new MatiereDao();

    @GET
    public List<Matiere> getAllMatieres() {
        return dao.getAllMatieres();
    }

    @GET
    @Path("/{id}")
    public Matiere getMatiereById(@PathParam("id") int id) {
        return dao.getMatiereById(id);
    }

    @GET
    @Path("/enseignant/{idEnseignant}")
    public List<Matiere> getMatieresByEnseignant(@PathParam("idEnseignant") int idEnseignant) {
        return dao.getMatieresByEnseignant(idEnseignant);
    }

    @POST
    public Map<String, String> addMatiere(Matiere m) {
        dao.addMatiere(m);
        return Map.of("message", "Matière ajoutée avec succès");
    }

    @PUT
    @Path("/{id}")
    public Map<String, String> updateMatiere(@PathParam("id") int id, Matiere m) {
        dao.updateMatiere(id, m);
        return Map.of("message", "Matière modifiée avec succès");
    }

    @DELETE
    @Path("/{id}")
    public Map<String, String> deleteMatiere(@PathParam("id") int id) {
        dao.deleteMatiere(id);
        return Map.of("message", "Matière supprimée avec succès");
    }
}