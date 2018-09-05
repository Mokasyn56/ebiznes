import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {

  constructor(private http: HttpClient) { }


  configUrl = 'http://localhost:9090/logout/facebook';

  getConfig() {
    this.http.get(this.configUrl);
  }

}
