import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiServiceUrl =environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  public getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiServiceUrl}/allemployees`);
  }

  public addEmployee(employee:Employee):Observable<any>{
    return this.http.post(`${this.apiServiceUrl}/addemployee`,employee,{responseType: 'text'});
  }

  public updateEmployee(employeeId:number,employee:Employee):Observable<any>{
    return this.http.put(`${this.apiServiceUrl}/updateemployee/${employeeId}`,employee,{responseType:'text'});
  }

  public deleteEmployee(employeeId:number):Observable<any>{
    return this.http.delete(`${this.apiServiceUrl}/deleteemployee/${employeeId}`,{responseType:'text'});
  }

  public getEmployeeByid(employeeId:number):Observable<Employee>{
    return this.http.get<Employee>(`${this.apiServiceUrl}/employeebyid/${employeeId}`);
  }

}
