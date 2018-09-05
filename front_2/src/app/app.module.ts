import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ShopComponent } from './shop/shop.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { BasketComponent } from './basket/basket.component';
import { LogoutComponent } from './logout/logout.component';
import { ProductsComponent } from './products/products.component';
import { ProductsService } from './products/products.service';
import { BasketService } from './basket/basket.service';
import { OrderComponent } from './order/order.component';
import { OrderService } from './order/order.service';
import { OrdersuccessComponent } from './ordersuccess/ordersuccess.component';
import { NotfinishedorderComponent } from './notfinishedorder/notfinishedorder.component';


@NgModule({
  declarations: [
    AppComponent,
    ShopComponent,
    HomeComponent,
    BasketComponent,
    LogoutComponent,
    ProductsComponent,
    OrderComponent,
    OrdersuccessComponent,
    NotfinishedorderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HttpModule
  ],
  providers: [ProductsService, BasketService, OrderService],
  bootstrap: [AppComponent],
})
export class AppModule { }
