
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RegistrationPortal {
    private static RegistrationPortal instance;
    private final List<Student> registeredStudents;

    private RegistrationPortal() {
        this.registeredStudents = Collections.synchronizedList(new ArrayList<>());
    }

    public static synchronized RegistrationPortal getRegistrationPortal() {
        if (instance == null) {
            instance = new RegistrationPortal();
        }
        return instance;
    }

    public void register(Student student) {
        registeredStudents.add(student);
    }

    public List<Student> getRegisteredStudents() {
        return new ArrayList<>(registeredStudents);
    }
}
