import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/user';
import { UserServiceService } from 'src/app/user-service.service';
import { UrlResolver } from '@angular/compiler';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
   user= new User("","","",0,"");

  message : any;

  constructor(private service : UserServiceService) {

  }

  ngOnInit() {
  }

  public registerNow(){
    let response = this.service.doRegistration(this.user);
    response.subscribe(data => {
      this.message = data;
    });
  }

}
