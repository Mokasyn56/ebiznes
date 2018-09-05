import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Http, Headers, Response, Jsonp, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';


export interface Order {
  products:  String ;
  price: number ;
}

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  getOrder(): Observable<Order> {
    return this.http.get<Order>('http://localhost:9090/getPreparedOrder');
  }

}
