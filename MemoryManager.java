import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class MemoryManager extends DataManager{
    FileManager f=new FileManager();
    Map<Integer,Student> mp;
    public MemoryManager()
    {
        Path p= Paths.get("C:\\Users\\Z004M0EB\\eclipse-enterprise\\Miniproject\\map");
        if(!Files.exists(p))
        {
            f.creatNewFileWithDummyData();
            mp=f.loadStudentFile();
            mp.remove(-1);
        }
        else
        {
            mp=f.loadStudentFile();
        }

    }

    void addStudentInMap(Student student)
    {


        mp.put(student.id,student);
    }
    void studentDataSave()
    {
        f.saveStudentFile(mp);

    }
    void  deleteStudent(Integer id)
    {
        Student student=mp.get(id);
        if(student==null)
        {
            System.out.println("The student with given id is does not exist");
        }
        else
        {
            mp.remove(id);
            f.saveStudentFile(mp);

        }
    }
    Student viewStudent(int id)
    {
        Student student=mp.get(id);
        if(student==null)
        {

            return null;
        }
        else
        {
            return (student);
        }
    }
    Map<Integer,Student> sortMap()
    {
        TreeMap<Integer,Student> tm=new TreeMap<>(mp);
        return tm;
    }
    boolean checkStudent(int id)
    {
        if(mp.get(id)==null)
        {
            return(true);
        }
        else return (false);

    }

}
