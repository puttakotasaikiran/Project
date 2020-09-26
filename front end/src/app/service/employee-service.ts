import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
    constructor(private http:HttpClient) { }
    addEmployee(employee: Employee):Observable<any> {
      return this.http.post("http://localhost:8102/api/mongo/com/add",employee,{responseType:'text'});
     }
   
  
    public getAllEmployees():Observable<any>{
    console.log("Am inside get all employees !");
    return this.http.get("http://localhost:8102/api/mongo/com/getall"); 
    }
    public updateEmployee(updateEmp:Employee):Observable<any>{
      return this.http.put("http://localhost:8102/api/mongo/com/update/"+updateEmp.id,updateEmp,{responseType:'text'});
    }
    public deleteEmployee(deleteEmp:number):Observable<any>{
      return this.http.delete("http://localhost:8102/api/mongo/com/delete/"+deleteEmp,{responseType:'text'}); 
    }
}
