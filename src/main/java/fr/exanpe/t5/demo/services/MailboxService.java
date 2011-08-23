package fr.exanpe.t5.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.exanpe.t5.demo.grouping.Mail;
import fr.exanpe.t5.demo.grouping.MailboxSumUp;

public class MailboxService
{
    private static final int NB_MAIL_RECEIVED = 32;

    public MailboxSumUp getSumUp()
    {
        return new MailboxSumUp(NB_MAIL_RECEIVED, 4, 12, 120);
    }

    public List<Mail> getMailsReceived()
    {
        List<Mail> list = new ArrayList<Mail>(NB_MAIL_RECEIVED);

        for (int i = 1; i < NB_MAIL_RECEIVED + 1; i++)
            list.add(new Mail(i, "Subject " + i,
                    "Hey what's up ! \n This representents a mail content. No real interest writing a new one everytime ! Just to notice this is the mail number "
                            + i, new Date(), "sender" + i + "@mail.com"));

        return list;
    }
}
