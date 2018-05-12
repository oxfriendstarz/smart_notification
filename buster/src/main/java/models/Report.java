package models;

import models.BusterConstants.ReportType;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jdulay on 5/11/2018.
 */

public class Report {
    public Report(String _penName, ReportType _type, String _description) {
        penName = _penName;
        type = _type;
        description = _description;
        id = (long) (Math.random() * 1000000000000L);

        location = new Location().getCurrentLocation();
        currentTime = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(Calendar.getInstance().getTime());

    }

    public String penName;
    public String description;
    public Location location;
    public ReportType type;
    public long id;
    public String currentTime;
    public boolean isLegit;
}


