import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl='http://localhost:8080'
  constructor(private http: HttpClient) { }

  getAllEmployees():Observable<any[]>{
    return this.http.get<any[]>(`${this.baseUrl}/employee/`);
  }

  addEmployee(employee:Employee):Observable<Employee>{
  return this.http.post<Employee>(`${this.baseUrl}/employee/add`,employee);
  }

  updateEmployee(employeeId:number,employee:Employee):Observable<Employee>{
    return this.http.put<Employee>(`${this.baseUrl}/employee/update/${employeeId}`,employee);
    }

  deleteEmployee(employeeId:number):Observable<void>{
      return this.http.delete<void>(`${this.baseUrl}/employee/delete/${employeeId}`);
      }
}
