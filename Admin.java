import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Admin {
    MemoryManager memoryManager=new MemoryManager();
    void addStudent()
    {
        try {
            Scanner s=new Scanner(System.in);
            System.out.println("Please Enter the student name");
            String name=s.nextLine();
            System.out.println("Enter the id of the student");
            int id=s.nextInt();
            System.out.println("Enter the mark of the student in Maths");
            int markMaths=s.nextInt();
            System.out.println("Enter the mark of the student in Science");
            int markScience=s.nextInt();
            Student student=new Student(name,id,markMaths,markScience);
            if(memoryManager.checkStudent(id))
            {
                memoryManager.addStudentInMap(student);
            }
            else
                System.out.println("Already a student exist");

        }
        catch (InputMismatchException i)
        {
            System.out.println("Please enter the valid data Something happens here");
        }







    }
    void removeStudentFromData()
    {
        try {
            System.out.println("Enter the id of the student to remove");
            Scanner s=new Scanner(System.in);
            int id=s.nextInt();
            memoryManager.deleteStudent(id);
        }catch (InputMismatchException i)
        {
            System.out.println("Please enter the id in Integer only ");
        }
    }
    void saveDataInFile()
    {
        memoryManager.studentDataSave();
        System.out.println("The data is saved in the file.....");
    }
    void viewSingleStudentWithId()
    {
        try {
            System.out.println("Enter the id of the student to view");

            Scanner s=new Scanner(System.in);
            int id=s.nextInt();
            Student std=memoryManager.viewStudent(id);
            if(std==null)
            {
                System.out.println("\nTHe student with given id is does not exist\n");
            }
            else
            {
                System.out.println( "\nName of the Student  --->  "+std.name+"\n" +
                        "Id of the student    --->  "+std.id+"\n" +
                        "Mark-1 of the student--->  "+std.mark1+"\n" +
                        "Mark-2 of the student--->  "+std.mark2+"\n\n");
            }
        }
        catch (InputMismatchException i)
        {
            System.out.println("Please Enter id as integer only");
        }


    }
    void studentReportWithId()
    {

        try {
            System.out.println("Enter the id of the student to view");

            Scanner s=new Scanner(System.in);
            int id=s.nextInt();
            Student std=memoryManager.viewStudent(id);

            if(std==null)
            {
                System.out.println("THe student with given id is does not exist");
            }
            else
            {
                if(std.status)
                {
                    System.out.println( "The student has cleared the exam!");
                }
                else
                {
                    System.out.println("This student can't clear the exam");
                }

            }
        }
        catch (InputMismatchException i)
        {
            System.out.println("Please Enter id as integer only");
        }

    }
    void editStudentWithId()  {
        try {
            System.out.println("Enter the id of the student for Editing the details");
            InputStreamReader ir=new InputStreamReader(System.in);
            BufferedReader reader=new BufferedReader(ir);
            int id=Integer.parseInt(reader.readLine());
            System.out.println("Enter the Name of the student ");
            String name=reader.readLine();
            System.out.println("Enter the new Mark 1");
            int mark1=Integer.parseInt(reader.readLine());
            System.out.println("Enter the new Mark 2");
            int mark2=Integer.parseInt(reader.readLine());
            Student student=new Student(name,id,mark1,mark2);
            memoryManager.addStudentInMap(student);
        }catch (IOException i)
        {
            System.out.println("Some IOException are occured");
        }
    }
    void viewAllStudentDetails()
    {

        Map<Integer,Student> sortedMap=memoryManager.sortMap();
        if(sortedMap==null)
        {
            System.out.println("No student in the directory it is nil..");
        }
        else
        {
            for (Map.Entry me : sortedMap.entrySet()) {
                Student student=(Student) me.getValue();
                System.out.println( "Name --->"+student.name+"\n" +
                        "id   --->"+student.id+"\n" +
                        "Mark1--->"+student.mark1+"\n" +
                        "Mark2--->"+student.mark2+"\n");
            }
        }

    }
}
