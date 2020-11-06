import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShoppingListComponent } from './components/shopping-list/shopping-list.component';
import { ProductComponent } from './components/product/product.component';
import { ProductionFormComponent } from './components/production-form/production-form.component';
import { OrdersComponent } from './components/orders/orders.component';
import { CartComponent } from './components/cart/cart.component';
import { ShoppingComponent } from './components/shopping/shopping.component';


@NgModule({
  declarations: [
    AppComponent,
    ShoppingListComponent,
    ProductComponent,
    ProductionFormComponent,
    OrdersComponent,
    CartComponent,
    ShoppingComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
