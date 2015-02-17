package store;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DbConListener
 *
 */
@WebListener
public class DbConListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DbConListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
        DbConnection db = new DbConnection();
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("db",db);
    }
	
}
