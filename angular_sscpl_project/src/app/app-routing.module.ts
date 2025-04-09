import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [
  // {
  //   path:'login',component:LoginComponent
  // },{
  //   path:'userlist',component:UserComponent
  // },{
  //   path:'',redirectTo:'/login',pathMatch:'full'
  // },{
  //   path:'profile',component:ProfileComponent
  // },{
  // path:'course', component : CourseComponent,  
  // },{
  //   path:'subject', component: SubjectComponent
  // },{
  //   path:'enquiry', component:EnquiryComponent
  // },{
  //   path:'screening-test', component:ScreeningTestComponent
  // },{
  //   path:'enrollment', component:EnrollmentComponent
  // },{
  //   path:'group', component:GroupComponent
  // },{
  //   path:'user-reports',component:ReportsComponent
  // },
  {
    path:'employee',component:EmployeeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
