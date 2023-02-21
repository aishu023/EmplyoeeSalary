import { Injectable } from '@angular/core';
import { Restaurant } from './restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantOperationService {
  

  constructor() { }


  restaurantArr:Restaurant[]=[];

  addRestaurants(restaurantFromUser:Restaurant){
    this.restaurantArr.push(restaurantFromUser); 
    console.log("Inside Restaurant Service : Restuarant Added "+restaurantFromUser.restaurantName);
    console.log(" Total Restaurant Are :- "+this.restaurantArr.length);
  }

  getRestaurantArr():Restaurant[]
  {
    return this.restaurantArr;
  }
  getRestaurantByCity(filterCity:string):Restaurant[]
  {
    
     let outputArr:Restaurant[] = [];

   this.restaurantArr.forEach(r=>{
     if(r.city == filterCity)
    {
        outputArr.push(r);
      }
   });
  return outputArr;
  }
 
  getRestaurantByRestaurantName(filterRestaurantName:string):Restaurant[]
  {
    
     let outputArr:Restaurant[] = [];

   this.restaurantArr.forEach(r=>{
     if(r.restaurantName == filterRestaurantName)
    {
        outputArr.push(r);
      }
   });
  return outputArr;
  }
  
  getRestaurantByState(filterState:string):Restaurant[]
  {
     let outputArr:Restaurant[] = [];

   this.restaurantArr.forEach(r=>{
     if(r.state == filterState)
    {
        outputArr.push(r);
      }
   });
  return outputArr;
  }
  } 
    
  


 

    
  
 


