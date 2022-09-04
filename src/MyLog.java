import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLog {
    public Logger getLog(){
        Logger LOG = Logger.getLogger(MyLog.class.toString());
        try{
            FileHandler fh = new FileHandler("/root/mylog.log", true);
            fh.setFormatter(new SimpleFormatter());
            LOG.addHandler(fh);
        } catch (IOException e){
            e.printStackTrace();
        }
        return LOG;
    }
}