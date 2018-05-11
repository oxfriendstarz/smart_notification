package models;

/**
 * Created by jdulay on 5/11/2018.
 */
public class Report
{
    public Report(String _penName, String _location, String _type){
        penName=_penName;
        location=_location;
        type=_type;
    }

    public String penName;
    public String location;
    public String type;
    public int id;
    public boolean isAssured;
}


