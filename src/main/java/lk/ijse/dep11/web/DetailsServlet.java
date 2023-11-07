package lk.ijse.dep11.web;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        int i = Integer.parseInt(id);
        BasicDataSource pool = (BasicDataSource)getServletContext().getAttribute("connectionPool");
        try {
            Connection connection = pool.getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM add_table WHERE id=?");
            stm.setInt(1,i);
            ResultSet rst = stm.executeQuery();

            rst.next();
            String path = rst.getString("path");
            req.setAttribute("path",path);
            getServletContext().getRequestDispatcher("/WEB-INF/details.jsp").forward(req,resp);

        } catch (SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
