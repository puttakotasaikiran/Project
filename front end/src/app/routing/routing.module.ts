import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes,RouterModule} from '@angular/router';
import  {HomeComponent} from '../home/home.component';
import {AuthenticationService as AuthenticationGuard} from '../authentication.service';
import { ViewEmployeeComponent } from '../viewEmployee/view-employee/view-employee.component';
import { AddemployeeComponent } from '../addemployee/addemployee.component';
const routes:Routes=[
  {
    path:'home',component:HomeComponent,canActivate:[AuthenticationGuard]},
    {path:'viewEmp',component:ViewEmployeeComponent},
    {path:'addEmp',component:AddemployeeComponent}
];
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),
    CommonModule
  ],
  exports:[RouterModule]
})
export class RoutingModule { }
