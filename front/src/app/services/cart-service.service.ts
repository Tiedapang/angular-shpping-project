import { Injectable } from '@angular/core';
import {Cart} from '../components/cart/Cart';
import {HttpClient} from '@angular/common/http';
import {Product} from '../components/product/Product';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {

  constructor(private http: HttpClient) { }
  addCart(cart: Cart): void{
    this.http.post('/api/cart', cart).subscribe((data: any) => {
      //  data:返回的数据
      alert('添加成功！');
    });
  }

  checkCart(): Observable<Cart[]>{
    return this.http.get<Cart[]>('/api/cart');
  }
}
