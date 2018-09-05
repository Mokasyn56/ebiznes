import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ShopComponent } from './shop/shop.component';
import { HomeComponent} from './home/home.component';
import {BasketComponent} from './basket/basket.component';
import {ProductsComponent} from './products/products.component';
import {LogoutComponent} from './logout/logout.component';
import {OrderComponent} from './order/order.component';
import {OrdersuccessComponent} from './ordersuccess/ordersuccess.component';
import {NotfinishedorderComponent} from './notfinishedorder/notfinishedorder.component';


const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'shop', component: ShopComponent },
  { path: 'basket', component: BasketComponent },
  { path: 'products', component: ProductsComponent },
  { path: 'logout', component: LogoutComponent},
  { path: 'order', component: OrderComponent},
  { path: 'ordersuccess', component: OrdersuccessComponent},
  { path: 'notfinishedorder', component: NotfinishedorderComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
