import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    /*
    В этом классе происходит работы с файлами (создание, чтение, написание и т.д.)
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


    public List<Account> readFile() {
        FileReader reader = null;
        List<Account> accounts = new ArrayList<>();

        try {
            reader = new FileReader(file);
            int x;
            String account = "";
            while ((x = reader.read()) != -1) {
                if (x == 59){ // если точка с запятой
                    String[] newAccount = account.split(",");
                    newAccount[0] = newAccount[0].replaceAll("\n", "");
                    accounts.add(new Account(newAccount[0],newAccount[1],newAccount[2],newAccount[3],
                            Boolean.parseBoolean(newAccount[4])));
                } else {
                    account += (char) x;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return accounts;
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