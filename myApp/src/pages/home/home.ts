import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Camera, CameraOptions } from '@ionic-native/camera';
import { Http } from '@angular/http';
import { Geolocation } from '@ionic-native/geolocation';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
  providers: [
    Camera, Geolocation
  ]
})
export class HomePage {

  security = {
    lat: 0,
    lng: 0
  }

  constructor(public navCtrl: NavController, private camera: Camera, public http: Http, private geolocation: Geolocation) {
    this.geolocation.getCurrentPosition().then((resp) => {

      this.security.lat = resp.coords.latitude;
      this.security.lng = resp.coords.longitude;
    }).catch((error) => {
      console.log('Error getting location', error);
    });

    let watch = this.geolocation.watchPosition();
    watch.subscribe((data) => {
      this.security.lat = data.coords.latitude
      this.security.lng = data.coords.longitude
    })
  }

  logForm() {
    console.log(this.security)
  }

  takePicture(){
    const options: CameraOptions = {
      quality: 100,
      destinationType: this.camera.DestinationType.DATA_URL,
      encodingType: this.camera.EncodingType.JPEG,
      mediaType: this.camera.MediaType.PICTURE
    }

    this.camera.getPicture(options).then((imageData) => {
      let base64Image = 'data:image/jpeg;base64,' + imageData;
      console.log(base64Image);
    }, (err) => {
      console.log(err);
    });

  }

}
