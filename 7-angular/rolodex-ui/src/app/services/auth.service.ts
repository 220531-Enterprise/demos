import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { url } from 'src/environments/environment';

/**
 * We need to make an HTTP Request to the auth controller of the API
 * http://localhost:5000/api/login ({username: "someone", password: "pass"})
 */
@Injectable({
  providedIn: 'root',
})
export class AuthService {

  // this will be sent as the header of the POST request
  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };

  loginUrl = url + '/login'; // http://localhost:5000/api/login

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {

    // this represents the body of the response
    const payload = {username, password} // (claims)

    // return the this.http.post method
    return this.http.post<any>(this.loginUrl, payload, { observe: 'response' })
    // replace this.httpOptions with { observe: 'response' }
    // alternatively add .pipe() to return any errors

    // create a custom error method
  }
}
