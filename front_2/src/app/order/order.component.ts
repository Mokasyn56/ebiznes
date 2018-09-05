import { Component, OnInit } from '@angular/core';
import {OrderService, Order} from './order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

getOrder;

  constructor(private orderService: OrderService) {
    this.orderService.getOrder().subscribe((order: Order) => this.getOrder = order);
   }

  ngOnInit() {
  }

}
