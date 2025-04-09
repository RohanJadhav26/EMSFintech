import { Component } from '@angular/core';
import { Employee } from '../model/employee.model';
import { EmployeeService } from '../employee.service';
import { subscribe } from 'diagnostics_channel';

@Component({
  selector: 'app-employee',
  standalone: false,
  
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {

  employees:Employee[]=[];
  employee: Employee={} as Employee;
  isEditing: Boolean=false;
  constructor(private employeeService:EmployeeService){}
  ngOnInit():void{
    this.loadEmployees();
  }

  loadEmployees(){
    this.employeeService.getAllEmployees().subscribe(employees=>{
      this.employees=employees;
      console.log(employees);
    });
  }

  addEmployee(){
    if(this.isEditing){
      this.employeeService.updateEmployee(this.employee.id!,this.employee).subscribe(()=>{
        this.isEditing=false;
        this.loadEmployees();
      });
  }else{
    
    this.employeeService.addEmployee(this.employee).subscribe(()=>{
      this.loadEmployees();
     
    })
    this.employee={} as Employee;
  }
  }

  deleteEmployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe(()=>{
      this.loadEmployees();
    })
  }

  editEmployee(employee:Employee){
    this.employee={...employee};
    this.isEditing=true;

  }
}
