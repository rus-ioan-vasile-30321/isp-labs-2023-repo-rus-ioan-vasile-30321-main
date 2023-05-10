package isp.lab6.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws  Exception{

        List<Student> data= new ArrayList<>();

        char answer;
        String line;
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("Menu");
            System.out.println("1-Add a student to the list");
            System.out.println("2-Remove a student from the list");
            System.out.println("3-Update a student's information");
            System.out.println("4-Calculate the average grade of a student");
            System.out.println("5-Display the list of students");
            System.out.println("e-exit");

            line=fluxIn.readLine();
            answer=line.charAt(0);

            switch (answer){
                case '1':
                    Student student_read=new Student();
                    System.out.print("Name: ");
                    student_read.setName(fluxIn.readLine());
                    System.out.print("Id: ");
                    student_read.setId(fluxIn.readLine());
                    HashMap <String,Integer> grades=new HashMap<>();
                    grades.put("Mathematics",null);
                    grades.put("Informatics",null);
                    grades.put("Databases",null);
                    for (String i:grades.keySet()){
                        System.out.println("Grade at "+i+": ");
                        Integer integer= Integer.valueOf(fluxIn.readLine());
                        grades.replace(i,null,integer);
                    }
                    student_read.setGrades(grades);
                    data.add(student_read);
                    break;
                case '2':
                    student_read = new Student();
                    System.out.print("Student Id: ");
                    student_read.setId(fluxIn.readLine());
                    boolean ok= data.contains(student_read);
                    data.remove(student_read);
                    if(ok)System.out.println("Student REMOVED!");
                    else System.out.println("Student Don't FOUND!");
                    break;
                case '3':
                    student_read = new Student();
                    System.out.print("Student Id: ");
                    student_read.setId(fluxIn.readLine());
                    int index_std=-1;
                    if(data.contains(student_read)){
                        for(int i=0;i<data.size();i++) {
                            if(data.get(i).equals(student_read))
                                index_std=i;
                            break;
                        }
                        System.out.println("You have the next options:"+"|name|"+ "|id|"+"|grade|");
                    String choice;
                    System.out.print("Tap your answer: ");
                    choice=(fluxIn.readLine());
                    switch (choice){
                        case "name":
                            System.out.println("New student Name:");
                            String name_change=(fluxIn.readLine());
                            data.get(index_std).setName(name_change);
                            break;
                        case "id":
                            System.out.println("New student id:");
                            String id_change=(fluxIn.readLine());
                            data.get(index_std).setId(id_change);
                        case "grade":
                            try {
                                grades=data.get(index_std).getGrades();
                                System.out.println("Your old grades:"+grades.toString());
                                for (String i:grades.keySet()){
                                    System.out.println("Grade at "+i+": ");
                                    Integer integer= Integer.valueOf(fluxIn.readLine());
                                    grades.replace(i,integer);
                                }
                                data.get(index_std).setGrades(grades);
                            } catch (NumberFormatException | IOException e) {
                                throw new RuntimeException(e);
                            }

                            break;
                    }

                    }
                    break;
                case '4':
                    student_read = new Student();
                    System.out.print("Student Id: ");
                    student_read.setId(fluxIn.readLine());
                    index_std=-1;
                    for(int i=0;i<data.size();i++) {
                        if(data.get(i).equals(student_read))
                            index_std=i;
                        break;
                        }
                    System.out.println("Average of student: "+data.get(index_std).averageGrade());


                        break;
                case '5':
                    for(Object i:data)
                        System.out.println(i);
                    break;
                default:
                    System.out.println("Incorrect input!");
            }


        }while (answer!='e' && answer!='E');
        System.out.println("Program Finish!");
    }
}
