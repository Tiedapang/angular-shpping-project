import {Component, Input, OnInit} from '@angular/core';
import {installPackage} from '@angular/cli/tasks/install-package';
import {Cart} from './Cart';
import {CartServiceService} from '../../services/cart-service.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  @Input() carts: Cart[];
  constructor(private cartService: CartServiceService) { }

  ngOnInit(): void {

  }

  editCartNum(cart: Cart, count: number): void{
    cart.count = cart.count + count;
    this.cartService.addCart(cart);
  }
}
