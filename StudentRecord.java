import java.io.Serializable;
import java.util.Scanner;

public class StudentRecord {

    public static void main(String args[])
    {

        StudentRecord std=new StudentRecord();
        std.runMain();

    }
    void runMain()
    {
        Admin admin =new Admin();
        int i=0;
        do {
            System.out.println( "  Welcome To Student Management System  \n" +
                    "1.Add Student  \n" +
                    "2.View Student \n" +
                    "3.View all Student  \n" +
                    "4.Remove Student \n" +
                    "5.Report of Student \n" +
                    "6.Save \n" +
                    "7.Edit \n" +
                    "8.Exit \n" );
            Scanner s=new Scanner(System.in);
            i=s.nextInt();
            if(i==1)
            {
                admin.addStudent();
            }
            else if (i==2) {
                admin.viewSingleStudentWithId();}
            else if (i==4) {
                admin.removeStudentFromData();

            } else if (i==3) {
                admin.viewAllStudentDetails();
            } else if (i==5) {
                admin.studentReportWithId();
            }
            else if (i==6)
            {
                admin.saveDataInFile();
            }
            else if (i==7)
            {
                admin.editStudentWithId();
            }
            else if (i>=8)
            {
                admin.saveDataInFile();
                System.out.println("App exiting......Thank you for using the app");
            }


        }while (i<8 && i>0);
    }
}
class Student implements Serializable
{
    public Student(){}
    public Student(String name,int id,int mark1,int mark2)
    {
        this.name=name;
        this.id=id;
        this.mark2=mark2;
        this.mark1=mark1;
        status=(mark1+mark2>100);
    }
    String name;
    int id;
    int mark1;
    int mark2;
    boolean status;


}