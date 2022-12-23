import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    /*
    В этом классе происходит работа с классами (создание, чтение, запись и т.д.)
     */
    private static FileService instance;
    private  static File file;
    private FileService(){}

    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }

        file = new File("data.cvs");

        if (!file.isFile()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return instance;
    }


    public void writeInFile(String data, boolean append){
        FileWriter writer = null;

        try {
            writer = new FileWriter(file, append);
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer!=null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
