package com.buster.models;

/**
 * Created by Ramon on 5/12/2018.
 */
public class BusterConstants {
    public enum ReportType {
        CRIME("crime"),
        EMERGENCY("emergency"),
        FIRE("fire");

        ReportType(String title) {
            this.title = title;
        }

        public String getTitle(){
            return title;
        }

        private String title;

    }
}
