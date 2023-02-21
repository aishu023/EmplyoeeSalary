import { Component } from '@angular/core';
import { Restaurant } from '../restaurant';
import { RestaurantOperationService } from '../restaurant-operation.service';

@Component({
  selector: 'app-admin-work',
  templateUrl: './admin-work.component.html',
  styleUrls: ['./admin-work.component.css']
})
export class AdminWorkComponent {

  __restaurantService: RestaurantOperationService;

  constructor(restaurantService: RestaurantOperationService) {
    this.__restaurantService = restaurantService;
  }

  readRestaurants( restaurantName:string,
    managerName:string,
   contactNumber:string,
    buildingName:string,
    area:string,
   streetNo:string,
   city:string,
   state:string,
   country:string,
   pincode:string,
   imageName:string){
    console.log(restaurantName+" "+managerName+" "+contactNumber+" "+buildingName+""+country);
    let restaurantFromUser:Restaurant= new Restaurant(restaurantName,managerName,contactNumber,buildingName,area,streetNo,city,state,country,pincode,imageName);
    this.__restaurantService.addRestaurants(restaurantFromUser);
    

  }

}
