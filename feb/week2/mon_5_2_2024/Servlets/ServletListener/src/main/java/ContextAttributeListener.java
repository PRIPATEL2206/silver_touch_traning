

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextAttributeListener
 *
 */
@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public ContextAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	String attributeName = scae.getName();
        Object attributeValue = scae.getValue();
        System.out.println("Attribute added to context: " + attributeName + " = " + attributeValue);
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	String attributeName = scae.getName();
        Object attributeValue = scae.getValue();
        System.out.println("Attribute removed from context: " + attributeName + " = " + attributeValue);
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	String attributeName = scae.getName();
        Object oldValue = scae.getValue();
        Object newValue = scae.getServletContext().getAttribute(attributeName);
        System.out.println("Attribute replaced in context: " + attributeName + " - Old value: " + oldValue + ", New value: " + newValue);
    }
	
}
