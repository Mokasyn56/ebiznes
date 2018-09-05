import { Component, OnInit } from '@angular/core';
import {ProductsService, Product} from './products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  getProducts;
  constructor(private productsService: ProductsService) {
  this.productsService.getProducts().subscribe((products: Product[]) => this.getProducts = products);
  }

  AddItem(id: number) {
    this.productsService.AddItemToBasket(id);
  }

  ngOnInit() {
  }

}
