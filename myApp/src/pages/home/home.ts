import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Camera, CameraOptions } from '@ionic-native/camera';
import { Http, Headers } from '@angular/http';
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
    lng: 0,
    base64Image: "",
    description: "",
    hashtag: "",
    avatar64: ""
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
  post(apiUrl: string, data: any = {}) {
    let headers = new Headers({'Content-Type': 'application/json', 'Accept': 'application/json'});
    return this.http.post(apiUrl, JSON.stringify(data), headers);
  }

  logForm() {
    this.post("http://192.168.56.1:8080/report/new/user/ionic", {
      username: "jas",
      type: "crime",
      location: {
        markedLocation: "up",
        longitude: this.security.lng,
        latitude: this.security.lat,
      },
      hashtag: this.security.hashtag,
      description: this.security.description,
      image: this.security.base64Image
    }).subscribe(data => {alert(data)});
    alert("Successfully report.");
  }

  takePicture(){
    const options: CameraOptions = {
      quality: 100,
      destinationType: this.camera.DestinationType.DATA_URL,
      encodingType: this.camera.EncodingType.JPEG,
      mediaType: this.camera.MediaType.PICTURE
    }

    this.camera.getPicture(options).then((imageData) => {
      this.security.avatar64 = "data:image/jpeg;base64," + imageData;
      this.security.base64Image = imageData;
    }, (err) => {
      console.log(err);
    });

  }

}
