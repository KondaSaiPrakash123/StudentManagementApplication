import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileManager extends DataManager{
        void creatNewFileWithDummyData()
        {
                Map<Integer,Student> dummy=new HashMap<>();
                Student fummydtudent=new Student("DummyName",-1,0,0);
                dummy.put(fummydtudent.id,fummydtudent);
                try {
                        FileOutputStream fos =new FileOutputStream("map");
                        ObjectOutputStream oos=new ObjectOutputStream(fos);
                        oos.writeObject(dummy);
                        oos.flush();
                        oos.close();
                        fos.close();
                } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }

        }
        void saveStudentFile(Map<Integer,Student> map)
        {
                try {
                        FileOutputStream fos=new FileOutputStream("map");
                        ObjectOutputStream oos=new ObjectOutputStream(fos);
                        oos.writeObject(map);

                        oos.close();
                        fos.close();
                        System.out.println("successfull...");
                }catch (IOException e)
                {
                        System.out.println(e);
                }
        }
        Map<Integer,Student> loadStudentFile()
        {
                Map<Integer, Student> m=null;
                try {

                                FileInputStream fis = new FileInputStream("map");
                                ObjectInputStream ois = new ObjectInputStream(fis);
                                m = (Map<Integer, Student>)ois.readObject();
                                ois.close();
                                fis.close();




                } catch (FileNotFoundException e) {
                        System.out.println("There is no file in the directory please create a new one");
                        System.out.println(0);
                } catch (IOException e) {
                        System.out.println("IOException");
                } catch (ClassNotFoundException e) {
                        System.out.println(0);
                }
                return (m);
        }
}
