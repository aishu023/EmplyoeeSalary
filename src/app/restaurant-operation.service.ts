import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from './restaurant';
import { RestaurantDto } from './restaurant-dto';

@Injectable({
  providedIn: 'root'
})
export class RestaurantOperationService {
  
  baseURL:string = 'http://localhost:2003';
  restaurantByCityEndPoint:string=this.baseURL+'/restaurant/city';
//localhost:2003/restaurant/city/pune

  restaurantArr:Restaurant[]=[];
  constructor(private http:HttpClient) { 
    
    console.log("Inside Constructor "+this.restaurantByCityEndPoint);
  }

  getRestaurantDetailsByCity(city:string):Observable<RestaurantDto[]>{
    console.log("Inside Method 1 "+this.restaurantByCityEndPoint);
    this.restaurantByCityEndPoint=this.restaurantByCityEndPoint+'/'+city;
    console.log("After adding city 2 "+this.restaurantByCityEndPoint);

    return this.http.get<RestaurantDto[]>(`${this.restaurantByCityEndPoint}`);
  }

 

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
    
  


 

    
  
 


