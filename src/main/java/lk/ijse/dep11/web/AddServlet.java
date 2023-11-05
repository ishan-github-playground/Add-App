package lk.ijse.dep11.web;

import lk.ijse.dep11.web.to.Add;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet({"/add", ""})
@MultipartConfig(location = "/tmp")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        Part picture = req.getPart("picture");
        BasicDataSource pool = (BasicDataSource)getServletContext().getAttribute("connectionPool");
        try {
            Connection connection = pool.getConnection();
            connection.setAutoCommit(false);
            String uploadsDirPath = getServletContext().getRealPath("/uploads/");
            UUID imageID = UUID.randomUUID();
            String picturePath=uploadsDirPath+imageID;
            try {

                PreparedStatement stmAdd = connection.prepareStatement("INSERT INTO add_table(name, description, price, path) VALUES (?,?,?,?)");
                stmAdd.setString(1, name);
                stmAdd.setString(2, description);
                stmAdd.setString(3, price);
                stmAdd.setString(4, "uploads/" + imageID);
                stmAdd.executeUpdate();

                System.out.println(picturePath);

                picture.write(picturePath);
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                e.printStackTrace();

            } finally {
                connection.setAutoCommit(true);
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException();
        }
        resp.sendRedirect("/app");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hi");
        BasicDataSource pool=(BasicDataSource)getServletContext().getAttribute("connectionPool");
        try (Connection connection = pool.getConnection()) {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM add_table");
            ArrayList<Add> addList = new ArrayList<>();
            while (rst.next()){
                String name = rst.getString("name");
                String description = rst.getString("description");
                String price = rst.getString("price");
                String path = rst.getString("path");
                addList.add(new Add(name,description,price,path));
            }
            req.setAttribute("addList",addList);
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
