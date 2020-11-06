import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ShoppingListComponent} from './components/shopping-list/shopping-list.component';
import {ProductionFormComponent} from './components/production-form/production-form.component';
import {OrdersComponent} from './components/orders/orders.component';


const routes: Routes = [
  {path: 'shopping', component: ShoppingListComponent},
  {path: 'addProduction', component: ProductionFormComponent},
  {path: 'orders', component: OrdersComponent},
  {path: '', pathMatch: 'full', redirectTo: '/shopping'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
