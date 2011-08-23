package fr.exanpe.t5.demo.grouping;

public class MailboxSumUp
{
    private int total;
    private int unread;
    private int sent;
    private int deleted;

    public MailboxSumUp(int total, int unread, int sent, int deleted)
    {
        super();
        this.total = total;
        this.unread = unread;
        this.sent = sent;
        this.deleted = deleted;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public int getUnread()
    {
        return unread;
    }

    public void setUnread(int unread)
    {
        this.unread = unread;
    }

    public int getSent()
    {
        return sent;
    }

    public void setSent(int sent)
    {
        this.sent = sent;
    }

    public int getDeleted()
    {
        return deleted;
    }

    public void setDeleted(int deleted)
    {
        this.deleted = deleted;
    }

}
