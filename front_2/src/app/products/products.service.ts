import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Http, Headers, Response, Jsonp, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

export interface Product {
  id: number;
  name:  String ;
  description:  String ;
  category: String;
  price: number ;
}

export class Item {
  productId: number;
  count: number;

  constructor(id: number, num: number) {
    this.productId = id;
    this.count = num;
  }

}

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }
  AddItemToBasket(id: number) {
    const newitem = { productId: id, count: 1};
    const req = this.http.post('http://localhost:9090/addBacketItem', {
      productId: id,
      count: 1
    }).subscribe(
        res => {
          console.log(res);
        },
        err => {
          console.log('Error occured');
        }
      );
    alert('Produkt został dodany do koszyka!');
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('http://localhost:9090/products');
  }
}
