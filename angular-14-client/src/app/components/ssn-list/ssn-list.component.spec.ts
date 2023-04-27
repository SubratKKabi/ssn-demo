import { ComponentFixture, TestBed, fakeAsync, inject ,tick} from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import { SsnsListComponent } from './ssn-list.component';
import { By } from '@angular/platform-browser';
import { Ssn } from 'src/app/models/ssn.model';
import { of } from 'rxjs';
import { SsnService as SsnService } from 'src/app/services/ssn.service';
describe('SsnsListComponent', () => {
  let component: SsnsListComponent;
  let fixture: ComponentFixture<SsnsListComponent>;
  let ssnService;
  let element;

  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule], 
    providers: [SsnsListComponent,SsnService ]
  }));

  /*beforeEach(inject([SsnService], s => {
    ssnService = s;
    fixture = TestBed.createComponent(SsnsListComponent);
    component = fixture.componentInstance;
    element = fixture.nativeElement;
  }));*/


  it('should be created', () => {
    const service: SsnsListComponent = TestBed.get(SsnsListComponent);
    expect(service).toBeTruthy();
   });

   it('should have getData function', () => {
    const service: SsnsListComponent = TestBed.get(SsnsListComponent);
    expect(service.saveSSN).toBeTruthy();
   });


   /*it("should call retrieveSsns and return list of ssns", fakeAsync(() => {
    const response: Ssn[] = [];

    component.retrieveSsns;

    tick();
  
    expect(component.ssns).toEqual(response);
  }));*/


   /*it("should create a post in an array", () => {
    const service: SsnsListComponent = TestBed.get(SsnsListComponent);
    const ssn : Ssn[] =[{id:"1", ssn: "Arson" }];
    const data = {
      ssn: ssn
    };
    
    service.saveSSN();
    expect(service.saveSSN).toBeGreaterThanOrEqual(1);
  });*/
});
