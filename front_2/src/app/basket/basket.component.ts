import { Component, OnInit } from '@angular/core';
import {BasketService, BasketProduct} from './basket.service';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit {
  getBasketProducts: BasketProduct[];
  totalamount: number;
  constructor(private backetService: BasketService) {
    this.backetService.getProductsFromBacket().subscribe((products: BasketProduct[]) => this.getBasketProducts = products);
  }

  ngOnInit() {
  }

  getTotal() {
    let total = 0;
    for (let i = 0; i < this.getBasketProducts.length; i++) {
            total += this.getBasketProducts[i].price;
            this.totalamount = total;
        }
        return total;
    }
}

