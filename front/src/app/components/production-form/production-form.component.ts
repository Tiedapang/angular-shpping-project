import { Component, OnInit } from '@angular/core';
import {Product} from '../product/Product';
import {ShoppingListService} from '../../services/shopping-list.service';
import {Observable} from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-production-form',
  templateUrl: './production-form.component.html',
  styleUrls: ['./production-form.component.scss']
})
export class ProductionFormComponent implements OnInit {

  formProduct = new FormGroup({
    id: new FormControl(0),
    name: new FormControl(''),
    price: new FormControl(0),
    unit: new FormControl(''),
    imgPath: new FormControl('')
  });
  constructor(private shoppingListService: ShoppingListService) {
  }

  ngOnInit(): void {
  }
  // tslint:disable-next-line:typedef
  doSubmit() {
    this.shoppingListService.saveProduct(this.formProduct.value);

  }
}
