import { ThisReceiver } from "@angular/compiler";

export class RestaurantDto {

    restaurantName:string;
    contactNumber:string
    constructor(restaurantName:string,contactNumber:string)
    {

        this.restaurantName=restaurantName;
        this.contactNumber=contactNumber;
    }
}
