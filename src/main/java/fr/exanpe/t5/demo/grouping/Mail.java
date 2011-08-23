package fr.exanpe.t5.demo.grouping;

import java.io.Serializable;
import java.util.Date;

public class Mail implements Serializable
{
    private int id;
    private String subject;
    private String content;
    private Date date;
    private String from;

    public Mail(int id, String subject, String content, Date date, String from)
    {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.date = date;
        this.from = from;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

}
