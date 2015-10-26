package chapter10;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by duongtq on 7/28/14.
 */
public class Test extends SimpleTagSupport {

    @Override
    public void doTag() throws IOException, JspException {
        List l = new ArrayList();
        l.clear();
        getParent();
        getJspContext().getOut().println("A SimpleTag handler !!!");
    }
}
