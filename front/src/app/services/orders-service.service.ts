import { Injectable } from '@angular/core';
import {Product} from '../components/product/Product';
import {Order} from '../components/orders/Order';

@Injectable({
  providedIn: 'root'
})
export class OrdersServiceService {

  constructor() { }
  addOrder(order: Order): void{

  }
}
