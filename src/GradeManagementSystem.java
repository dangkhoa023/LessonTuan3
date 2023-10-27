import java.util.Date;
public class GradeManagementSystem {
    public static void main(String[] args) {
        Student student = new Student(1, "Đăng", new Date());
        Teacher teacher = new Teacher(1, "Khoa", new Date());
        teacher.addSubject("Math");
        teacher.addSubject("Science");

        student.viewGrades();
        student.updateGrade("History", 9.0, teacher);



        student.updateGrade("Math", 9.0, teacher);
        student.viewGrades();
    }
}