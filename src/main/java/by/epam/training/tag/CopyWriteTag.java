package by.epam.training.tag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class CopyWriteTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        String copyWrite = "©. 2019";
        try {
            JspWriter out = pageContext.getOut();
            out.write(copyWrite);
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }

}
