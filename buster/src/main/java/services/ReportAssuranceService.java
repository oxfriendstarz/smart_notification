package services;

import models.Report;

/**
 * Created by jdulay on 5/11/2018.
 */
public class ReportAssuranceService {
    private double recurringReportCoefficient;
    private double reporterAssuranceCoefficient;
    private double assuranceCoefficient;
    public ReportAssuranceService(Report report)
    {
        // get to database all reports with the same occurrence in the same location
        recurringReportCoefficient = getCoefficientOfRecurringReport();

        // get the assurance of the reporter
        reporterAssuranceCoefficient = getCoefficientOfReporterAssurance();
        assuranceCoefficient = 100 * reporterAssuranceCoefficient * recurringReportCoefficient;
    }

    public boolean isAssured()
    {
        return assuranceCoefficient > 50;
    }

    public int getNumberOfRecurringReport()
    {
        return 1;
    }

    private double getCoefficientOfRecurringReport(){
        // get all report legitimacy
        return 1.0;
    }

    public double getCoefficientOfReporterAssurance(){
        // get the assurance of the reporter
        // get reporters profile at database via penname
        // reporters rating
        // report count vs isLegit True Count
        return 1.0;
    }
}
