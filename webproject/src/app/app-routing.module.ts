import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SearchComponent} from './search/search.component';
import {AllUsersComponent} from './all-users/all-users.component';
import {RegisterComponent} from './register/register.component';
const routes: Routes = [
  {
      path:"", redirectTo:"register",pathMatch:"full"
  },
  {
      path:"search" , component:SearchComponent
  },
  {
      path:"all-users" , component:AllUsersComponent
  },
  {
      path:"register" , component:RegisterComponent
  },
  {
      path:"**", component:RegisterComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
