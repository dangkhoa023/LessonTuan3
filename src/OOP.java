import java.util.Date;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

class Student {
    private int id;
    private String name;
    private Date birthDate;
    private Map<String, Double> grades;
    private Map<String, Date> updatedIn;
    private Map<String, String> updatedBy;

    public Student(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.grades = new HashMap<>();
        this.updatedIn = new HashMap<>();
        this.updatedBy = new HashMap<>();
    }

    public void viewGrades() {
        System.out.println("Student: " + name);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss");
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            String subject = entry.getKey();
            double grade = entry.getValue();
            Date updateTime = updatedIn.get(subject);
            String updatedTeacher = updatedBy.get(subject);
            System.out.println("Subject: " + subject + ", Grade: " + grade);
            if (updateTime != null && updatedTeacher != null) {
                System.out.println("Last Updated: " + dateFormat.format(updateTime) + " by: " + updatedTeacher);
            }
        }
    }
    //"EEE" sẽ hiển thị tên ngày trong tuần (ví dụ: "Sun" cho Chủ Nhật).
    //"MMM" sẽ hiển thị tên tháng (ví dụ: "Oct" cho tháng Mười).
    //"dd" sẽ hiển thị ngày trong tháng.
    //"HH:mm:ss" sẽ hiển thị giờ, phút và giây.

    public void updateGrade(String subject, double grade, Teacher teacher) {
        if (teacher.teachesSubject(subject)) {
            grades.put(subject, grade);
            updatedIn.put(subject, new Date());
            updatedBy.put(subject, teacher.getName());
        } else {
            System.out.println("Giáo viên không thể cập nhật môn học này");
        }
    }
}

class Teacher {
    private int id;
    private String name;
    private Date birthDate;
    private Set<String> subjects;

    public Teacher(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.subjects = new HashSet<>();
    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public boolean teachesSubject(String subject) {
        return subjects.contains(subject);
    }

    public String getName() {
        return name;
    }
}