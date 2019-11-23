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
    this.postRequest();
  }

  postRequest() {

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
    this.coordinates = body.coordinates;
  }

  extractErrorCallBack(response: HttpErrorResponse) {
    console.log(response.error.errors);
  }

  isSetted(value
             :
             string
  ):
    string {
    if (null != value)
      return "green";
    else
      return "red";
  }

  moveCoordinate(coordinate
                   :
                   Coordinate
  ) {
    return "border-left: " + coordinate.x + "px; border-top:" + coordinate.y + "px"
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
