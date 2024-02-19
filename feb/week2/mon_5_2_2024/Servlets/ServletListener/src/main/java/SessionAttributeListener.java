

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class SessionAttributeListener
 *
 */
@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	String attributeName = se.getName();
        Object attributeValue = se.getValue();
        System.out.println("Attribute added to session: " + attributeName + " = " + attributeValue);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	String attributeName = se.getName();
        Object attributeValue = se.getValue();
        System.out.println("Attribute removed from session: " + attributeName + " = " + attributeValue);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	String attributeName = se.getName();
        Object oldValue = se.getValue();
        Object newValue = se.getSession().getAttribute(attributeName);
        System.out.println("Attribute replaced in session: " + attributeName + " - Old value: " + oldValue + ", New value: " + newValue);
    }
	
}
