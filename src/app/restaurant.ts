export class Restaurant {
   
    restaurantName:string;
    ContactNumber:string;
    managerName:string;
    buildingName:string;
    area:string;
    streetNo:string;
    city:string;
    state:string;
    country:string;
    pincode:string;
    imageName:string;

   
 
 
    constructor( 
        restaurantName:string,
        ContactNumber:string,
        managerName:string,
        buildingName:string,
        area:string,
        streetNo:string,
        city:string,
        state:string,   
        country:string, 
        pincode:string,
        imageName:string

     ){
 
    this.restaurantName=restaurantName;
     this.ContactNumber=ContactNumber;
     this.managerName=managerName;
     this.buildingName=buildingName;
     this.area=area;
     this.streetNo=streetNo;
     this.city=city;
     this.country=country;
     this.state=state;
     this.pincode=pincode;
     this.imageName=imageName;

    
   
 
     }
}
