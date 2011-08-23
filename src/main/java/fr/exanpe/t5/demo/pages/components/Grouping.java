package fr.exanpe.t5.demo.pages.components;

import java.util.LinkedList;
import java.util.List;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.exanpe.t5.demo.grouping.Mail;
import fr.exanpe.t5.demo.grouping.MailboxSumUp;
import fr.exanpe.t5.demo.services.MailboxService;
import fr.exanpe.t5.lib.components.TabView;

public class Grouping
{
    @Property
    private MailboxSumUp sumUp;

    @Property
    @Persist
    private List<Mail> mailsOpen;

    @Property
    @Persist
    private List<Mail> mailsReceived;

    @Property
    private Mail iteMail;

    @Inject
    private MailboxService service;

    @Component(id = "tabview")
    private TabView tabView;

    void onActivate()
    {
        sumUp = service.getSumUp();
    }

    @OnEvent(value = EventConstants.ACTION, component = "received")
    void initReceivedMails()
    {
        mailsReceived = service.getMailsReceived();
        tabView.setSelectedTab("tabReceived");
    }

    void onActionFromOpen(int mailId)
    {
        if (mailsOpen == null)
            mailsOpen = new LinkedList<Mail>();

        for (Mail m : mailsReceived)
            if (m.getId() == mailId)
            {
                mailsOpen.add(m);
                break;
            }
    }

    void onActionFromClose(int mailId)
    {
        if (mailsOpen == null)
            return;

        for (Mail m : mailsReceived)
            if (m.getId() == mailId)
            {
                mailsOpen.remove(m);
                break;
            }
        tabView.setSelectedTab("tabReceived");
    }

    public String getShortenedSubject()
    {
        if (iteMail.getSubject().length() > 20)
            return iteMail.getSubject().substring(0, 20) + "...";
        return iteMail.getSubject();
    }

    public String getShortenedContent()
    {
        if (iteMail.getContent().length() > 40)
            return iteMail.getContent().substring(0, 40) + "...";
        return iteMail.getContent();
    }

    public String getShortenedFrom()
    {
        if (iteMail.getFrom().length() > 20)
            return iteMail.getFrom().substring(0, 20) + "...";
        return iteMail.getFrom();
    }
}
