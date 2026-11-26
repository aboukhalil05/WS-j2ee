package dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class TestDao {

    public static void main(String[] args) {
        DaoImpl d = new DaoImpl();

        // 1. Insérer des étudiants de test
        d.addStudent(new Student("Malika", "Bennani", Date.valueOf(LocalDate.of(2004, 12, 23))));
        d.addStudent(new Student("Alae", "Alami", Date.valueOf(LocalDate.of(2003, 5, 14))));

        // 2. Afficher tous les étudiants
        List<Student> sds = d.getAllStudent();
        sds.forEach(System.out::println);
    }
}