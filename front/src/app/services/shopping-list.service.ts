import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../components/product/Product';
import {PageAble} from '../components/pagination/PageAble';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ShoppingListService {
  constructor(private http: HttpClient) { }
  getProducts(): Observable<Product[]>{
    return this.http.get<Product[]>('/api/product/list');
  }
  saveProduct(product: Product): Observable<any>{
    return this.http.post('/api/product', product);
  }
  getProductsPageAble(pageAble): Observable<any> {
    return this.http.get(`/api/product/`, { params: pageAble }).pipe(
        map(res => res)
    );
  }
    deleteProduct(product: Product): Observable<any>{
    return this.http.delete(`/api/product/${product.id}`);
    }
}
