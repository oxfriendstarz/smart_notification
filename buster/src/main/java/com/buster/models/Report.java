package com.buster.models;

import com.buster.models.BusterConstants.ReportType;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jdulay on 5/11/2018.
 */

@Entity
@Table(name = "Report")
public class Report {

    @Id
    @GeneratedValue
    @Column(name="id")
    public Long id;

    @Column(name="username")
    public String username;

    @Column(name="description")
    public String description;

    @Embedded
    @Column(name="location")
    public Location location;

    @Column(name="type")
    public String type;

    @Column(name="status")
    public String status;

    @Column(name="time")
    public String time;

    @Column(name="isLegit")
    public boolean isLegit;

    @Column(name="upVotes")
    public long upVotes;

    @Column(name="downVotes")
    public long downVotes;

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isLegit() {
        return isLegit;
    }

    public void setLegit(boolean legit) {
        isLegit = legit;
    }

    public long getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(long upVotes) {
        this.upVotes = upVotes;
    }

    public long getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(long downVotes) {
        this.downVotes = downVotes;
    }

<<<<<<< HEAD
    public Report(){}

    public Report(String username, ReportType _type, String _description) {
=======
    public Report(String username, String _type, String _description) {
>>>>>>> 62db7bcfbece8e095ac4e772693cf33c481a0bf5
        this.username = username;
        type = _type;
        description = _description;
        location = new Location().getCurrentLocation();
        time = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(Calendar.getInstance().getTime());
    }

    public Report(){
        location = new Location().getCurrentLocation();
        time = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(Calendar.getInstance().getTime());
    }
}


