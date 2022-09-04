import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class f {
    private String filename;
    private String filepath;

    public f(){

    };
    public f(String filename, String filepath){
        this.filename = filename;
        this.filepath = filepath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public static void main(String[] args) {
        File f = new File("E:/a/test.txt");
        try{
            FileOutputStream fos = new FileOutputStream(f);
        } catch (IOException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
