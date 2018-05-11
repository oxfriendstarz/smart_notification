package services;

/**
 * Created by jdulay on 5/11/2018.
 */
public class ReportAssuranceService {
    private int numberOfCorrespondence;
    private String message;

    public ReportAssuranceService(int numberOfCorrespondence)
    {

    }

    public double getAssuranceCoefficient()
    {
        int logicBehind = numberOfCorrespondence * 100;
        return logicBehind;
    }
}
