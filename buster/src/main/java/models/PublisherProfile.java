package models;

/**
 * Created by jdulay on 5/11/2018.
 */
public class PublisherProfile
{
    public PublisherProfile(String _realName, String _penName, String _email, String _address, int _mobileNumber){
        realName = _realName;
        penName = _penName;
        contactInformation = new ContactInformation(_email,_address,_mobileNumber);
        legitimacyRating = 100;
    }
    public String realName;
    public String penName;
    public double legitimacyRating;
    public ContactInformation contactInformation;
    public Report[] reports;
    public double rating;
}
