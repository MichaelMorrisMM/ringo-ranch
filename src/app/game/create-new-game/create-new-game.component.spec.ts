import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateNewGameComponent } from './create-new-game.component';

describe('CreateNewGameComponent', () => {
  let component: CreateNewGameComponent;
  let fixture: ComponentFixture<CreateNewGameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateNewGameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateNewGameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
