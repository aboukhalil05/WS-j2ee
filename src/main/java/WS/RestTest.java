package WS;

import dao.DaoImpl;
import dao.IDao;
import dao.Student;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestTest {

    private final IDao dao = new DaoImpl();

    // 1. GET ALL : Afficher tous les étudiants
    // URL : GET http://localhost:8080/WS-j2ee-1.0-SNAPSHOT/api/students
    @GET
    public List<Student> getAllStudents() {
        return dao.getAllStudent();
    }

    // 2. GET BY ID : Afficher un seul étudiant par son ID
    // URL : GET http://localhost:8080/WS-j2ee-1.0-SNAPSHOT/api/students/1
    @GET
    @Path("/{id}")
    public Student getStudentById(@PathParam("id") int id) {
        return dao.getStudentById(id);
    }

    // 3. POST : Ajouter un nouvel étudiant
    // URL : POST http://localhost:8080/WS-j2ee-1.0-SNAPSHOT/api/students
    @POST
    public Map<String, String> addStudent(Student s) {
        dao.addStudent(s);
        return Map.of("message", "Étudiant ajouté avec succès");
    }

    // 4. PUT : Modifier un étudiant existant
    // URL : PUT http://localhost:8080/WS-j2ee-1.0-SNAPSHOT/api/students/1
    @PUT
    @Path("/{id}")
    public Map<String, String> updateStudent(@PathParam("id") int id, Student s) {
        dao.updateStudent(id, s);
        return Map.of("message", "Étudiant modifié avec succès");
    }

    // 5. DELETE : Supprimer un étudiant par son ID
    // URL : DELETE http://localhost:8080/WS-j2ee-1.0-SNAPSHOT/api/students/1
    @DELETE
    @Path("/{id}")
    public Map<String, String> deleteStudent(@PathParam("id") int id) {
        dao.deleteStudent(id);
        return Map.of("message", "Étudiant supprimé avec succès");
    }
}