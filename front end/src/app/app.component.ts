import { Component, Input,ViewEncapsulation } from '@angular/core';

import { EmployeeService } from './service/employee-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent {
  
  title = 'Comments records';
 
  constructor(private router:Router) { }

  ngOnInit(): void {
    this.router.navigate(['home']);
}
}
 