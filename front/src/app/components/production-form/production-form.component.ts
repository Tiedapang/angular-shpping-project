import { Component, OnInit } from '@angular/core';
import {Product} from '../product/Product';
import {ShoppingListService} from '../../services/shopping-list.service';
import {Observable} from 'rxjs';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {NzMessageService} from 'ng-zorro-antd/message';

@Component({
  selector: 'app-production-form',
  templateUrl: './production-form.component.html',
  styleUrls: ['./production-form.component.scss']
})
export class ProductionFormComponent implements OnInit {

  formProduct = new FormGroup({
    id: new FormControl(0),
    name: new FormControl('', [Validators.required]),
    price: new FormControl(0, [Validators.required, Validators.pattern(/^[+-]?(0|([1-9]\d*))(\.\d+)?$/)]),
    unit: new FormControl(''),
    imgPath: new FormControl('')
  });
  constructor(private shoppingListService: ShoppingListService, private message: NzMessageService) {
  }

  ngOnInit(): void {
  }
  doSubmit(): void {
    this.shoppingListService.saveProduct(this.formProduct.value)
        .subscribe((data: any) => {
          this.message.success('恭喜您🎉，添加商品信息成功！');
        });
  }
}
