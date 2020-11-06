import {Product} from '../product/Product';

export interface Order{
  id: number;
  createTime: Date;
  products: Product[];
}
