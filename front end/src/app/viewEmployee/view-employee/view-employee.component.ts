import { Component, OnInit } from '@angular/core';
import {Employee} from '../../model/employee';
import {EmployeeService} from '../../service/employee-service';


@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {
  employee:Employee[]=[];
  isUpdate=false;
  isDelete=false;
updateEmp:Employee=new Employee();
deleteEmp:Employee=new Employee();
msg:string;
errorMsg:string;
msg1:string;
errorMsg1:string;
  deleteRecord: boolean;
  constructor(private employeeService:EmployeeService) { }

  ngOnInit(): void {
    console.log("Am inside view component");
    this.employeeService.getAllEmployees().subscribe(data=>this.employee=data);
  }
  public viewUpdateEmployee(emp:Employee){
    //console.log("Update Emp :"+ JSON.stringify(emp));
    this.isUpdate=true;
    this.updateEmp=emp;
  }
  public updateEmployee(){
    console.log("Update Emp :"+ JSON.stringify(this.updateEmp));

    this.employeeService.updateEmployee(this.updateEmp).subscribe(  (data)=>{
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
     
      // get the latest data after update
      this.employeeService.getAllEmployees().subscribe(data=>this.employee=data);
      this.isUpdate=false;
  }
  public viewDeleteEmployee(emp:number){
    
    this.isDelete=true;
  }
public deleteEmployee(id:number){
  console.log("Delete employee id:" + id);

  this.employeeService.deleteEmployee(id).subscribe(  (data)=>{
    console.log("Data",data);
    this.msg1=data;
    this.errorMsg1=undefined;
        },
    (error)=>{
      this.errorMsg1=error.error;
    console.log(this.errorMsg1);
    this.msg1=undefined;
          }
    );
   
    // get the latest data after delete
    this.employeeService.getAllEmployees().subscribe(data=>this.employee=data);
    ()=>{this.isDelete=false;}
}
}
/* public deleteEmployee(id:number){
  this.employeeService.deleteEmployee(id).subscribe(  data => {  
          console.log(data);  
          this.deleteRecord=true;  
          this.employeeService.getAllEmployees().subscribe(data => this.employee =data )  ;
        },  
        error => console.log(error))     
      }    
    } */
  
