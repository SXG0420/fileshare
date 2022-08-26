import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class test extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try{
            PrintWriter pw = response.getWriter();
            pw.println("success");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
