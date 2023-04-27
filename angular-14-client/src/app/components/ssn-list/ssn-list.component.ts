import { Component, OnInit } from '@angular/core';
import { Ssn } from 'src/app/models/ssn.model';
import { SsnService as SsnService } from 'src/app/services/ssn.service';

import { AbstractControl, FormControl, FormGroup } from '@angular/forms';
import { ssnInputValidator } from '../../ssnInputValidator';
@Component({
  selector: 'app-ssn-list',
  templateUrl: './ssn-list.component.html',
  styleUrls: ['./ssn-list.component.css']
})
export class SsnsListComponent implements OnInit {
  public maxSSNInput = 11;
  public showSSN = false;
  ssns?: Ssn[];
  currentSsn: Ssn ={};
  currentIndex = -1;
  title = '';
  result='';
  
  //submitted = false;
  public ssnSample = new FormGroup({
    ssn: new FormControl('', [ssnInputValidator])
  })
  constructor(private ssnService: SsnService) { }

  ngOnInit(): void {
    this.ssn?.setValue('');
   // this.retrieveTutorials();
   // this.retrieveSsns();
  }

  public inputSSN(): void {
    this.ssn?.setValue(this.getSSNValidFormat(this.ssn.value))
  }
  public get ssn(): AbstractControl | null {
    return this.ssnSample.get('ssn');
  }

  private getSSNValidFormat(ssn: string): string| null {
    if (ssn === null || ssn === undefined) { return null; }
    
    const pattern = /\d{3}-\d{2}-\d{4}/g;
    let formattedSSN = ssn as any;
    const result = pattern.test(formattedSSN);
    if (!result) {
      formattedSSN = formattedSSN.match(/\d*/g).join('')
      .match(/(\d{0,3})(\d{0,2})(\d{0,4})/).slice(1).join('-')
      .replace(/-*$/g, '');
    }
    
    return formattedSSN;
  }


  retrieveSsns(): void {
    this.ssnService.getAllSsns()
      .subscribe({
        next: (data) => {
          this.ssns = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }



  refreshList(): void {

    this.currentSsn = {};
    this.currentIndex = -1;
 
  }

  setActiveSsn(ssn: Ssn, index: number): void {
    this.currentSsn = ssn;
    this.currentIndex = index;
  }

 

  removeAllSsns(): void {
    this.ssnService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.ssns =[];
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }




  saveSSN(): void {
    console.log("ssn: "+this.ssn?.value);
    const data = {
      ssn: this.ssn?.value,
    };

    this.ssnService.saveSSN(data)
      .subscribe({
        next: (res) => {
          console.log(res[0]);
          this.result =res[0];
          //this.submitted = true;
          this.ssn?.setValue(this.getSSNValidFormat(''))
        },
        error: (e) => console.error(e)
      });
  }


  public toggleSSNValue() : void {
    this.showSSN = !this.showSSN;
  }

  public getSSNType(): string {
    return this.showSSN ? 'text' : 'password';
  }

}