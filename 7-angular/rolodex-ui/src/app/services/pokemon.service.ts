import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pokemon } from '../models/pokemon';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  pokeUrl = `https://pokeapi.co/api/v2/pokemon`;

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  }

  constructor(private http: HttpClient) { }

  getPokemonById(id: number): Observable<any> {

    // fetch the id, the name, and the sprite of the pokemon
    return this.http.get<any>(`${this.pokeUrl}/${id}`, this.httpOptions)
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
