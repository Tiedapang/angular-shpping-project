import { Component } from '@angular/core';
import {CartServiceService} from './services/cart-service.service';
import {Cart} from './components/cart/Cart';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-shopping';
  constructor() {
  }
}
