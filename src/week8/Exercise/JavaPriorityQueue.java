package week8.Exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JavaPriorityQueue {
    //https://www.hackerrank.com/challenges/java-priority-queue/problem
    private class Student{
        private int id;
        private String name;
        private double cgpa;
        public Student(int id, String name, double cgpa){
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getID() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCGPA() {
            return cgpa;
        }
    }
    class StudentComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Student && o2 instanceof Student) {
                Student s1 = (Student) o1;
                Student s2 = (Student) o2;
                if (s1.getCGPA() > s2.getCGPA()) {
                    return -1;
                } else if (s1.getCGPA() < s2.getCGPA()) {
                    return 1;
                } else {
                    int nameComparison = s1.getName().compareTo(s2.getName());
                    if (nameComparison != 0) {
                        return nameComparison;
                    } else {
                        if (s1.getID() > s2.getID()) {
                            return -1;
                        } else if (s1.getID() < s2.getID()) {
                            return 1;
                        }
                    }
                }
            }
            return 0;
        }
    }
    private class Priorities{
       public List<Student> getStudents(List<String> events){
            PriorityQueue<Student> queue = new PriorityQueue<>(new StudentComparator());
            for(String event : events){
                String[] split = event.split(" ");
                if(split.length > 1){
                    int id = Integer.parseInt(split[3]);
                    String name = split[1];
                    double cgpa = Double.parseDouble(split[2]);
                    Student student = new Student(id, name, cgpa);
                    queue.add(student);
                }else{
                    queue.poll();
                }

            }
            List<Student> students = new ArrayList<Student>();
            while(!queue.isEmpty()){
                Student student = queue.poll();
                students.add(student);
            }
            return students;
        }
    }

    public static void main(String[] args) {
        }

}
