import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService implements CanActivate {

  constructor() { }
  canActivate(): boolean{
    if(1){
      return true;
    }
    else{
      return false;
    }
  }
}
