import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {environment} from "../environments/environment";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [HttpClient]
})
export class AppComponent implements OnInit {

  min_value: string;
  max_value: string;
  numberOfSize: number;
  request: TractNumberRequest;
  coordinates: Coordinate[];

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(): void {
  }

  draw(): void {
    let canvas = <HTMLCanvasElement>document.getElementById('stage');
    if (canvas.getContext) {
      let ctx = canvas.getContext('2d');
      ctx.clearRect(0, 0, 1024, 960);
      this.coordinates.forEach(item => {
        ctx.beginPath();
        ctx.fillStyle = item.value ? "green" : "red";
        ctx.arc(item.x, item.y, 20, 0, 2 * Math.PI, true);
        ctx.closePath();
        ctx.fill();
        ctx.beginPath();
        ctx.fillStyle = "black";
        ctx.fillText(item.value ? item.value : "", item.x - 15, item.y + 3);
        ctx.fill();
      });
    }
  }

  postRequest() {
    console.log(this.min_value);
    console.log(this.max_value);
    console.log(this.numberOfSize);

    this.httpClient
    .post<TractNumberResponse>(environment.url, {
      "minNumber": this.min_value,
      "maxNumber": this.max_value,
      "numberOfSize": this.numberOfSize
    }, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        'Access-Control-Allow-Origin': 'http://localhost:4200'
      })
    })
    .subscribe(
      next => {
        this.extractDataCallBack(next)
      }, error => {
        this.extractErrorCallBack(error)
      }
    );
  }

  extractDataCallBack(response: TractNumberResponse) {
    let body = response.body;
    console.log(body);
    this.coordinates = body.coordinates;
    this.draw()
  }

  extractErrorCallBack(response
                         :
                         HttpErrorResponse
  ) {
    console.log(response);
    alert(response.error.errors.errorMessage)
  }

  isSetted(value
             :
             string
  ) {
    if (null != value)
      return "sphere green";
    else
      return "sphere red";
  }

  moveCoordinate(coordinate
                   :
                   Coordinate
  ) {
    return "margin-left: " + coordinate.x + "px; margin-top:" + coordinate.y + "px";
  }
}

export interface TractNumberRequest {
  numberOfSize: number;
  minNumber: string;
  maxNumber: string;
}

class TractNumberResponse {
  constructor(
    public responseStatus: string,
    public transaction: string,
    public errors: { errorMessage: string },
    public body: TractNumberResponseBody) {
  }
}

class TractNumberResponseBody {
  constructor(public coordinates: Coordinate[]) {
  }
}

class Coordinate {
  constructor(public x: number, public y: number, public value: string) {
  }
}
