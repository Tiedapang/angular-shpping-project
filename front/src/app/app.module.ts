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
import { PaginationComponent } from './components/pagination/pagination.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { zh_CN } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import zh from '@angular/common/locales/zh';
import {NzButtonModule} from 'ng-zorro-antd/button';


registerLocaleData(zh);


// @ts-ignore
// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    ShoppingListComponent,
    ProductComponent,
    ProductionFormComponent,
    OrdersComponent,
    CartComponent,
    ShoppingComponent,
    PaginationComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NzButtonModule
  ],
  providers: [{ provide: NZ_I18N, useValue: zh_CN }],
  bootstrap: [AppComponent]
})
export class AppModule { }
