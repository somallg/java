package chapter10;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by duongtq on 7/28/14.
 */
public class Repeater extends SimpleTagSupport {

    private String surprise;

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().setAttribute("here", "Middle doTag()");
        getJspContext().getOut().println(surprise);
        getJspBody().invoke(null);
    }

    public String getSurprise() {
        return surprise;
    }

    public void setSurprise(String surprise) {
        this.surprise = surprise;
    }
}
