import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import { SsnService } from './ssn.service';

describe('SsnService', () => {
  

  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule], 
    providers: [SsnService]
  }));

   it('should be created', () => {
    const service: SsnService = TestBed.get(SsnService);
    expect(service).toBeTruthy();
   });

   it('should have getAllSsns function', () => {
    const service: SsnService = TestBed.get(SsnService);
    expect(service.getAllSsns).toBeTruthy();
   });

});
