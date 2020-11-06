import { Component, OnInit } from '@angular/core';
import {ShoppingListService} from '../../services/shopping-list.service';
import {Product} from '../product/Product';
import {Cart} from '../cart/Cart';
import {CartServiceService} from '../../services/cart-service.service';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.scss']
})
export class ShoppingListComponent implements OnInit {
  products: Product[];
  carts: Cart[];
  isCartAvailable: boolean;
  constructor(private shoppingListService: ShoppingListService, private cartService: CartServiceService) {
    this.isCartAvailable = false;
  }

  ngOnInit(): void {
    this.shoppingListService.getProducts().subscribe(products => this.products = products);
  }
  checkCart(): void{
    this.isCartAvailable = !this.isCartAvailable;
    this.cartService.checkCart().subscribe(carts => this.carts = carts);
  }

}
