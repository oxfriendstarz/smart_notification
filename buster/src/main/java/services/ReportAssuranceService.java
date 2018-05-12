package services;

import com.buster.models.PublisherProfile;
import com.buster.models.Report;
import temporary.tempDatabaseKasiHard;

import java.util.ArrayList;

/**
 * Created by jdulay on 5/11/2018.
 */
public class ReportAssuranceService {
    private double recurringReportCoefficient;
    private double reporterAssuranceCoefficient;
    private double assuranceCoefficient;
    private Report report;
    public ReportAssuranceService(Report _report)
    {
        report = _report;
        // get to database all reports with the same occurrence in the same location
        recurringReportCoefficient = getCoefficientOfRecurringReport();

        // get the assurance of the reporter
        reporterAssuranceCoefficient = getCoefficientOfReporterAssurance(report);
        assuranceCoefficient = 100 * reporterAssuranceCoefficient * recurringReportCoefficient;
    }

    public boolean isAssured()
    {
        return assuranceCoefficient > 50;
    }

    public int getNumberOfRecurringReport()
    {
        return tempDatabaseKasiHard.reports.size();
    }

    private double getCoefficientOfRecurringReport(){
        // get all report legitimacy
        return 1.0;
    }

    public double getCoefficientOfReporterAssurance(Report report){
        // get the assurance of the reporter
        // get reporters profile at database via penname
        // reporters rating
        ArrayList<Report> publishersReports  = new ArrayList<Report>();
        for (PublisherProfile temp : tempDatabaseKasiHard.publisherProfile) {
            if(temp.penName == report.username){
                publishersReports = temp.reports;
            }
        }

        if(publishersReports.size()==0){
            return 1;
        }

        int legitimacyCount=0;
        for (Report publishersReport : publishersReports) {
            if(publishersReport.isLegit = false){
                legitimacyCount++;
            }
        }


        // report count vs isLegit True Count
        return legitimacyCount/publishersReports.size();
    }
}
