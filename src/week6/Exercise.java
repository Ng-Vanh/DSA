package week6;

import java.util.*;

public class Exercise {
    private static class Student {
        private int id;
        private String fname;
        private double cgpa;

        public Student(int id, String fname, double cgpa) {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getFname() {
            return fname;
        }

        public double getCgpa() {
            return cgpa;
        }
    }

    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/java-sort/problem
        //Bai 4:
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Comparator<Student> compare = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getCgpa() != o2.getCgpa()) {
                    return Double.compare(o2.getCgpa(), o1.getCgpa());
                } else if (!o1.getFname().equals(o2.getFname())) {
                    return o1.getFname().compareTo(o2.getFname());
                } else {
                    return Integer.compare(o1.getId(), o2.getId());
                }
            }
        };
        Collections.sort(studentList, compare);

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }

    public static void printArray(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    //Bai 3:
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        //https://www.hackerrank.com/challenges/insertionsort1/problem
        int lastElement = arr.get(n - 1);
        int i = n - 2;

        while (i >= 0 && arr.get(i) > lastElement) {
            arr.set(i + 1, arr.get(i));
            i--;
            printArray(arr);
        }

        arr.set(i + 1, lastElement);
        printArray(arr);
    }

    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        //Bai 5: https://www.hackerrank.com/challenges/insertionsort2/problem

        for (int i = 1; i < n; i++) {
            int tmp = arr.get(i);
            int j = i - 1;
            while (j >= 0 && tmp < arr.get(j)) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, tmp);
            printArray(arr);
        }
    }


}
