import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  username : any[]=[];
  user : any;

  constructor(private service : UserServiceService) { }

  ngOnInit() {
  }

  public findUserByUsername(){
    let response = this.service.getUserByUsername(this.username);
    response.subscribe(data => this.user = data);
  }
}
