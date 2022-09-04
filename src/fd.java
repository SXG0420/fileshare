import java.sql.*;

public class fd {
    public fd(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/filedb?characterEncoding=UTF-8", "neeko", "luotianyi0.");
    }

    public void addFile(String filename, String filepath){
        String sql = "insert into file values(null, ?, ?)";
        try(Connection c = getConnection(); PreparedStatement s = c.prepareStatement(sql);) {
            s.setString(1, filename);
            s.setString(2, filepath);
            s.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public f getfile(){
        f f = new f();
        try(Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from file limit 1";
            ResultSet rs = s.executeQuery(sql);
            f.setFilename(rs.getString("filename"));
            f.setFilepath(rs.getString("filepath"));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return f;
    }

}
