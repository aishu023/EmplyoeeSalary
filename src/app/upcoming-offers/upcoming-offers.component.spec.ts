import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpcomingOffersComponent } from './upcoming-offers.component';

describe('UpcomingOffersComponent', () => {
  let component: UpcomingOffersComponent;
  let fixture: ComponentFixture<UpcomingOffersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpcomingOffersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpcomingOffersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
