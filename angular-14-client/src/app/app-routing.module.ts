import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SsnsListComponent } from './components/ssn-list/ssn-list.component';



const routes: Routes = [
  { path: '', redirectTo: 'ssns', pathMatch: 'full' },
  { path: 'ssns', component: SsnsListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }