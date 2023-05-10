package isp.lab6.exercise1;

import java.util.HashMap;


public class Student {
    private String id;
    private String name;
    HashMap<String,Integer> grades= new HashMap<>();

    public HashMap<String, Integer> getGrades() {
        return grades;
    }
    public Student(){

    }
    public Student(String id, String name, HashMap<String, Integer> grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrades(HashMap<String, Integer> grades) {
        this.grades = grades;
    }

    public float averageGrade(){
        float average=0;
        for(String i:this.grades.keySet()){
            average+=this.grades.get(i);
        }
        return average/3;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            Student p = (Student) obj;
            return p.id.equalsIgnoreCase(id);
        }
        else return false;
    }


}
