import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Http, Headers, Response, Jsonp, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';


export interface BasketProduct {
  name:  String ;
  count: number;
  price: number ;
}

@Injectable({
  providedIn: 'root'
})

export class BasketService {

  constructor(private http: HttpClient) { }

  getProductsFromBacket(): Observable<BasketProduct[]> {
    return this.http.get<BasketProduct[]>('http://localhost:9090/getBacketItems');
  }
}
