package ActivityTracker.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService ss;

    @Autowired
    public StudentController(StudentService ss) {
        this.ss = ss;
    }

    @GetMapping
    public List<Student> hello() {
        return ss.getStudents();
    }
}
