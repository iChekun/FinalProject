package by.epam.chekun.controller.tag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInfoTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        final Date date = new Date();
        final String dateNow = dateFormat.format(date);
        final String time = "<b>" + dateNow + " </b>";

        try {
            JspWriter out = pageContext.getOut();
            out.write(time);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
