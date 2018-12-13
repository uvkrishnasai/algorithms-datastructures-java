package concurrency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A school can have one or more teachers
 * A teacher can have one or more classes
 * A class can have one or more students
 */
public class VolatileX {

    public class School {
        public Map<String, List<Clazz>> teachers = new HashMap<>();
    }

    public class Clazz {
        public List<String> students = new ArrayList<>();

        public void print() {
            students.forEach(i -> System.out.print(i + ", "));
        }
    }

    public class TeacherThread extends Thread {

        private School school = null;
        private Clazz clazz = null;
        private String teacher = null;

        public TeacherThread(School school, String teacher, Clazz clazz) {
            this.school = school;
            this.teacher = teacher;
            this.clazz = clazz;
        }

        @Override
        public void run() {
            if (teacher != null) {
                if (!school.teachers.containsKey(teacher)) {
                    school.teachers.put(teacher, new ArrayList<>());
                }
                school.teachers.get(teacher).add(clazz);
            }
        }
    }

    public class ClazzThread extends Thread {

        private School school = null;
        private String teacher = null;
        private String student = null;

        public ClazzThread(School school, String teacher, String student) {
            this.school = school;
            this.teacher = teacher;
            this.student = student;
        }

        @Override
        public void run() {
            school.teachers.forEach((k,v) -> System.out.println(k + "," + v));
        }
    }

    public static void main(String[] args) {
        VolatileX ve = new VolatileX();

        School school = ve.new School();

        Clazz clazzA = ve.new Clazz();
        clazzA.students.add("John");
        clazzA.students.add("Mike");

        Clazz clazzB = ve.new Clazz();
        clazzB.students.add("Mathew");
        clazzB.students.add("David");

        school.teachers.put("Chris", new ArrayList<>());
        school.teachers.put("Charlie", new ArrayList<>());
        school.teachers.put("Wright", new ArrayList<>());
        school.teachers.put("Erie", new ArrayList<>());

        TeacherThread th1 = ve.new TeacherThread(school,"Mathew", clazzA);
        TeacherThread th2 = ve.new TeacherThread(school,"Mathew", clazzB);

        ClazzThread clazzTh1 = ve.new ClazzThread(school, "student1", "Mathew");

        th1.start();
        th2.start();
        school.teachers.entrySet().stream().filter(x -> x.getKey().equals("Mathew")).forEach(x -> {
            x.getValue().forEach(Clazz::print);
        });




    }

}
