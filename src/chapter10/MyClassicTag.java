package chapter10;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by duongtq on 7/28/14.
 */
public class MyClassicTag extends TagSupport {

    private List<String> movies = new ArrayList<String>();
    private int current = 0;

    public MyClassicTag() {
        movies.add("Heat");
        movies.add("Pocahontas");
        movies.add("Lawrencerabia");
    }

    @Override
    public int doStartTag() throws JspException {
        setAttribute();
        return EVAL_BODY_INCLUDE;
    }

    private void setAttribute() {
        pageContext.setAttribute("movie", movies.get(current));
        current++;
    }

    @Override
    public int doAfterBody() throws JspException {
        while (current < movies.size()) {
            setAttribute();
            return EVAL_BODY_AGAIN;
        }

        return SKIP_BODY;
    }
}
