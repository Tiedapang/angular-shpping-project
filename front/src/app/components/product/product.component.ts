import {Component, Input, OnInit} from '@angular/core';
import {Product} from './Product';
import {CartServiceService} from '../../services/cart-service.service';
import {Cart} from '../cart/Cart';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  @Input() product: Product;
  cart: Cart;
  constructor(private cartService: CartServiceService) { }

  ngOnInit(): void {
  }

  addCart(): void{
    this.cart = {count: 1, createTime: new Date(), product: this.product};
    this.cartService.addCart(this.cart);
  }
}
