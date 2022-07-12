import { url } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { User } from '../models/user';

// the entire purpose is to make HTTPRequests to our server
// Injectable allows us to use a singleton instance of this class within other components

// WHERE am I making the requests

// http://localhost:5000/api/users

@Injectable({
  providedIn: 'root'
})
export class UserService {

  userUrl: string =  url + `/users`;

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  }

  constructor(private http: HttpClient) { }

  // any method that invokes this, must subscribe to the return value
  findAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl, this.httpOptions)
      .pipe(catchError(this.handleError));
  }

  findUserById(id: number): Observable<User> {
    // http://localhost:5000/api/users/3
    return this.http.get<User>(`${this.userUrl}/${id}`, this.httpOptions)
     .pipe(catchError(this.handleError));
  }

  deleteUserById(id: number): Observable<any> {
    // http://localhost:5000/api/users/3
    return this.http.delete(`${this.userUrl}/${id}`, this.httpOptions)
     .pipe(catchError(this.handleError));
  }

  registerUser(user: User): Observable<User> {
    // 3 params: url, request body, options (headers)
    return this.http.post<User>(`${this.userUrl}/add`, user, this.httpOptions)
      .pipe(catchError(this.handleError));
  }


  private handleError(httpError: HttpErrorResponse) {

    if (httpError.error instanceof ErrorEvent) {
      console.log('an error occured: ', httpError.error.message);
    } else {
      console.error(`
        Backend returned code ${httpError.status}
        body was: ${httpError.error}
      `)
    }

    return throwError(() => new Error('something really bad happened'));
  }
}
