import {Product} from '../product/Product';


export interface Cart{
  count: number;
  createTime: Date;
  product: Product;
}
