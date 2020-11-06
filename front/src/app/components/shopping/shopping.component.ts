import { Component, OnInit } from '@angular/core';
import {Cart} from '../cart/Cart';
import {CartServiceService} from '../../services/cart-service.service';

@Component({
  selector: 'app-shopping',
  templateUrl: './shopping.component.html',
  styleUrls: ['./shopping.component.scss']
})
export class ShoppingComponent implements OnInit {
  constructor() {
  }
  ngOnInit(): void {
  }

}
