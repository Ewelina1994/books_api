import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Book} from '../model/Book';
import {HttpClient} from '@angular/common/http';
import {SearchBookDTO} from '../model/SearchBookDTO';

@Injectable({
  providedIn: 'root'
})
export class RestServiceService {
  private BASE_URL = 'http://localhost:8080/books';
  private GET_SEARCH_BOOKS_URL = `${this.BASE_URL}\\search`;

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<Book[]>{
    return this.http.get<Book[]>(this.BASE_URL);
  }

  getSearchBooks(searchBook: SearchBookDTO): Observable<Book[]>{
    return this.http.get<Book[]>(this.GET_SEARCH_BOOKS_URL);
  }
  addNewBook(book: Book): Observable<Book>{
    // return this.http.request(this.BASE_URL, book)
    //   .map((res: Response) => {};
      return this.http.post<Book>(this.BASE_URL, book);
  }
  updateBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.BASE_URL, book);
  }
}
