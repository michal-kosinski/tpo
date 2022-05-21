import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Books")
public class Books extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://mysql:3306/tpo?characterEncoding=latin1&useConfigs=maxPerformance&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "my-secret-pw";



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "My Db Diary";
        String docType =  "<!DOCTYPE html>\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></header>\n" +
                "<body bgcolor = \"#f3f3f3\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<h3 align = \"center\"><a href=\"http://localhost:8080/Books/Books.html\">"+
                "Add new entry</a></h3>");

        try {

            Class.forName(JDBC_DRIVER);

            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);


            Statement stmt = con.createStatement();
            String sql = "SELECT id, date, title, content FROM ENTRIES";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int id = rs.getInt("id");
                Timestamp ts = rs.getTimestamp("date");
                String entryTitle = rs.getString("title");
                String entryContent = rs.getString("content");

                out.println("<h3 align = \"center\">" + id + ": " + ts.toString() + "</h3>");
                out.println("<h2 align = \"center\">" + entryTitle + "</h2><br>");
                out.println(entryContent + "<br>");
            }
            out.println("</body></html>");

            rs.close();
            stmt.close();
            con.close();
        } catch(Exception se) {
            se.printStackTrace();
        }

    }}

