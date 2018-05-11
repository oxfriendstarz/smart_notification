package com.buster.controller;


import models.Report;
import services.ReportAssuranceService;

/**
 * Created by jdulay on 5/11/2018.
 */


public class PublisherController {


    public static void main(String[] args) {

        Report report = new Report("Anonymous","Crime");
        PublisherController publisherController = new PublisherController(report);

    }
    public PublisherController(Report report){
        //receive post from publisher

        //check post Credibility
        ReportAssuranceService reportAssuranceService = new ReportAssuranceService(report);
        if(reportAssuranceService.isAssured()){
            System.out.println("Report is Assured");
            System.out.println("Sending it to Message Broker");
        }
        else{
            System.out.println("NOT REPORT NOT Assured");
            System.out.println("Sending rejected report from user");
        }
        //send to message broker
    }





}
