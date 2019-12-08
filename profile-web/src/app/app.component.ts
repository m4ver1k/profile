import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Msg} from "./models/models";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private hello : Observable<string>;

  constructor(private http: HttpClient) {
    this.hello = this.http.get<Msg>("api/hello").pipe(map(e => e.msg));
  }

}
