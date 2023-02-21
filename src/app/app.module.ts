import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminWorkComponent } from './admin-work/admin-work.component';
import { UserComponent } from './user/user.component';
import { UpcomingOffersComponent } from './upcoming-offers/upcoming-offers.component';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { FormsModule } from '@angular/forms';
const allLinks:Routes = [
  {path:'launchrestuarant',component:AdminWorkComponent},
  {path:'restaurants',component:UserComponent},
  {path:'upcomingoffers',component:UpcomingOffersComponent },
  {path:'restaurantDetails/:rid',component:RestaurantDetailsComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    AdminWorkComponent,
    UserComponent,
    UpcomingOffersComponent,
    RestaurantDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,RouterModule.forRoot(allLinks),
    FormsModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
