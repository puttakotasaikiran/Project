import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../service/employee-service';
import {Employee} from '../model/employee';
@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit {
  employee:Employee=new Employee();
  msg:string;
  errorMsg:string;
    constructor(private empService:EmployeeService) { }
  
    ngOnInit(): void {
    }
    addEmployee(){
      console.log("Add new Employee.");
      console.log(this.employee);
      this.empService.addEmployee(this.employee).subscribe(
        (data)=>{
        console.log("Data",data);
        this.msg=data;
        this.errorMsg=undefined;
            },
        (error)=>{
          this.errorMsg=error.error;
        console.log(this.errorMsg);
        this.msg=undefined;
              }
        );
    }
  
  }
