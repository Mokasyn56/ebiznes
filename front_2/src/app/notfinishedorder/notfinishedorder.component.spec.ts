import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotfinishedorderComponent } from './notfinishedorder.component';

describe('NotfinishedorderComponent', () => {
  let component: NotfinishedorderComponent;
  let fixture: ComponentFixture<NotfinishedorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotfinishedorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotfinishedorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
