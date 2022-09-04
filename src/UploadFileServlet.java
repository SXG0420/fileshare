import com.alibaba.fastjson2.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
public class UploadFileServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String filename = null;
        try{
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            factory.setSizeThreshold(20480*20480);

            List items = null;
            try{
                items = upload.parseRequest(request);
            } catch (Exception e){
                e.printStackTrace();
            }
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    filename = item.getName();
                    String fileFolder = request.getServletContext().getRealPath("upload");
                    fd fd = new fd();
                    fd.getConnection();
                    fd.addFile(filename, fileFolder);
                    Runtime.getRuntime().exec("python3 /root/test.py");
                    File f = new File(fileFolder, filename);
                    f.getParentFile().mkdirs();
                    InputStream is = item.getInputStream();
                    FileOutputStream fos = new FileOutputStream(f);
                    byte[] b = new byte[20480*20480];
                    int length = 0;
                    while ((length = is.read(b)) != -1) {
                        fos.write(b, 0, length);
                    }
                    fos.close();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
