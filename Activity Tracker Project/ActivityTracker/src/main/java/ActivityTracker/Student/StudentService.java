package ActivityTracker.Student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(1,
                        "Saurav",
                        25,
                        "shah.saurav@yahoo.com",
                        LocalDate.of(1995, 10, 05))
        );
    }
}
