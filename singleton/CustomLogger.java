import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class CustomLogger {
    private static  CustomLogger instance;
    private String fileName = "log.txt";
    private CustomLogger() {
    }
    public static CustomLogger getInstance() {
        if (instance == null) {
            instance = new CustomLogger();
        }
        return instance;
    }
    public void log(String message) {
        //open the file
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter("./desgin-patterens/singleton/" + fileName, true);
            bw = new BufferedWriter(fw);
            bw.write("\n " + new Date().toString() + ": " + message);

        }
        catch (IOException e){
            System.err.println(e);
        }
        finally {
            try{ //I just don't want to handle the errors in the main app.
                if(bw != null) {
                    bw.close();
                }
                }catch(IOException e){
                    System.err.println(e);
                }
        }

    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public void close(){ //i don't really understand what you mean by closing the logger, do you mean closing the bufferWriter? or removing the instance?
        // removing instance

    }
}