package lk.ijse.dep11.web.listener;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.sql.SQLException;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener");
        String appPath = sce.getServletContext().getRealPath("/");
        new File(appPath,"uploads").mkdir();

        BasicDataSource pool = new BasicDataSource();
        pool.setUsername("root");
        pool.setPassword("oppo33");
        pool.setDriverClassName("com.mysql.cj.jdbc.Driver");
        pool.setUrl("jdbc:mysql://localhost:12500/dep11_add_app");
        pool.setInitialSize(5);
        pool.setMaxTotal(15);
        sce.getServletContext().setAttribute("connectionPool",pool);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            ((BasicDataSource)sce.getServletContext().getAttribute("connectionPool")).close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
