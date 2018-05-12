package temporary;

import com.buster.controller.PublisherController;
import models.*;

/**
 * Created by jdulay on 5/12/2018.
 */
public class Scenarios {
    public static void TwoPersonsReported(){
        PublisherProfile publisher = new PublisherProfile("RJRALD", "RJRALD", "Email@.com", "myAddress", "0998");
        tempDatabaseKasiHard.publisherProfile.add(publisher);
        PublisherProfile publisher2 = new PublisherProfile("RAMON CAPUNPON", "RAMON", "Email@.com", "myAddress", "0998");
        tempDatabaseKasiHard.publisherProfile.add(publisher);

        Report report = new Report("RJRALD", BusterConstants.ReportType.CRIME, "si jas sinasaksak");
        PublisherController publisherController = new PublisherController();
        publisherController.receiveReport(report);
        report = new Report("RAMON CAPUNPON",BusterConstants.ReportType.CRIME, "si jas totoong sinasaksak");
        publisherController.receiveReport(report);
    }

    public static void OneReportedButFalseAlarm(){
        PublisherProfile publisher = new PublisherProfile("RJRALD", "RJRALD", "Email@.com", "myAddress", "0998");
        tempDatabaseKasiHard.publisherProfile.add(publisher);

        Report report = new Report("RJRALD",BusterConstants.ReportType.CRIME, "si jas sinasaksak");
        PublisherController publisherController = new PublisherController();
        publisherController.receiveReport(report);

        System.out.println("==============================");
        SubscriberProfile subscriber = new SubscriberProfile("RJRALD", "RJRALD", "Email@.com", "myAddress", "0998");

        //Subscriber set the report as fake report
        System.out.println(subscriber.realName +" has marked "+publisher.penName+ " as fake report");
        publisher.reports.get(0).isLegit = false;

        Report report2 = new Report("RJRALD",BusterConstants.ReportType.CRIME, "may binabaril naman ulet");
        publisherController.receiveReport(report2);
    }

}
