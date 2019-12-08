import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private hello : Observable<object>;

  constructor(private http: HttpClient) {
   this.hello = this.http.get("http://localhost:8080/hello");
  }

}
