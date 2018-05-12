import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Http } from '@angular/http';

@Component({
  selector: 'page-contact',
  templateUrl: 'contact.html'
})
export class ContactPage {

  constructor(public navCtrl: NavController, public http: Http) {

  }

  profile = {};

  post(apiUrl: string, data: any = {}) {
    return this.http.post(apiUrl, JSON.stringify(data));
  }

  subscribeForm() {
  	console.log(this.profile)
  }

}
