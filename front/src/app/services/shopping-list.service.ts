import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../components/product/Product';

@Injectable({
  providedIn: 'root'
})
export class ShoppingListService {
  constructor(private http: HttpClient) { }
  getProducts(): Observable<Product[]>{
    return this.http.get<Product[]>('/api/product/list');
  }
  saveProduct(product: Product): void{
    this.http.post('/api/product', product).subscribe((data: any) => {
      //  data:返回的数据
      alert('添加成功！');
    });
  }
}
