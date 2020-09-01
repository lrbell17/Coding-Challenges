package com.que;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int GetID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getCGPA(){
        return cgpa;
    }
 }

class Priorities {
	
     public List<Student> getStudents(List<String> events){

        List<Student> priorityQue = new ArrayList<Student>();
         
         for (String event : events){
             
            if (event.equals("SERVED")){
            	priorityQue.remove(0);
            }
            else{
                String[] eventSplit = event.split(" ");
                
                Student stu = new Student(Integer.parseInt(eventSplit[3]), eventSplit[1],
                		Double.parseDouble(eventSplit[2]));
                
                priorityQue.add(stu);
                priorityQue.sort(Comparator.comparingDouble(Student::getCGPA).reversed());

            }
  
         }
         
         return priorityQue;
     }
 }


public class PriorityQueChallenge {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
    	
    	System.out.println("Enter Input:");
        int totalEvents = Integer.parseInt(scan.nextLine());    
        
        
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}