import {Component, Input, OnInit} from '@angular/core';
import {Product} from './Product';
import {CartServiceService} from '../../services/cart-service.service';
import {Cart} from '../cart/Cart';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ShoppingListService} from '../../services/shopping-list.service';
import {NzModalService} from 'ng-zorro-antd/modal';
import {NzMessageService} from 'ng-zorro-antd/message';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  @Input() product: Product;
  cart: Cart;
  isVisible = false;
  warnningVisible = false;
  updateProduct: any;
  // tslint:disable-next-line:max-line-length
  constructor(private cartService: CartServiceService, private shoppingListService: ShoppingListService, private message: NzMessageService, private modal: NzModalService) { }

  ngOnInit(): void {
    this.updateProduct = new FormGroup({
      id: new FormControl(this.product.id),
      name: new FormControl(this.product.name, Validators.required),
      price: new FormControl(this.product.price, [Validators.required, Validators.pattern(/^[+-]?(0|([1-9]\d*))(\.\d+)?$/)]),
      unit: new FormControl(this.product.unit),
      imgPath: new FormControl(this.product.imgPath)
    });
  }

  addCart(): void{
    this.cart = {count: 1, createTime: new Date(), product: this.product};
    this.cartService.addCart(this.cart);
  }

  editProduct(): void{
    this.isVisible = true;
  }
  handleOk(): void {
    this.shoppingListService.saveProduct(this.updateProduct.value).subscribe((data: any) => {
      this.message.success('恭喜您🎉，修改商品信息成功！');
      this.product = this.updateProduct.value;
    });
    this.isVisible = false;
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  submitForm(): void{
  }

  updateConfirmValidator(): void{
  }

  confirmDelete(): void{
  }

  cancel(): void{
  }

  warning(): void {
    this.modal.warning({
      nzTitle: '删除商品',
      nzContent: '您确认要删除该商品信息吗？',
      nzOkText: '确定',
      nzCancelText: '取消',
      nzOnOk:  () =>
              new Promise((resolve, reject) => {
                setTimeout(resolve , 1000);
              }).then(
                  () => {
                    this.shoppingListService.deleteProduct(this.product).subscribe((data: any) => {
                      this.message.success('恭喜您🎉，删除商品信息成功！');
                      window.location.reload();
                    });
                  }
              ).catch(() => console.log('Oops errors!'))
    });
  }
}
