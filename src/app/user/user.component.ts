import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from '../restaurant';
import { RestaurantOperationService } from '../restaurant-operation.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  __restaurantService:RestaurantOperationService; // creating object of Service layer


  router:Router;
   allRestaurants : Array<Restaurant> = [];
   
 
  
 
   constructor(restaurantService:RestaurantOperationService,router:Router)   {
     this.__restaurantService = restaurantService;
     this.allRestaurants = this.__restaurantService.getRestaurantArr();
    
     this.router=router;
     
   }
 
 

  getFilterCity(filterValue:string){
    this.allRestaurants=this.__restaurantService.getRestaurantByCity(filterValue);

  }


  getFilterState(filterValue:string){
    this.allRestaurants=this.__restaurantService.getRestaurantByState(filterValue);

  }

  getFilterRestaurantName(filterValue:string){
    this.allRestaurants=this.__restaurantService.getRestaurantByRestaurantName(filterValue);

  }

  
}
