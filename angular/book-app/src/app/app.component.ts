import {Component} from '@angular/core';
import {Book} from './model/Book';
import {NewBookModalComponent} from './modal-window/new-book-modal/new-book-modal.component';
import {BsModalService} from 'ngx-bootstrap/modal';
import {RestServiceService} from './service/rest-service.service';
import {SearchBookDTO} from './model/SearchBookDTO';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'book-app';
  books: Book[] = [];
  searchText: SearchBookDTO = {
    title: null,
    isbn: null
  };
  newBook: Book = {
    title: null,
    id: null,
    isbn: null,
    category: null,
    list_authors: null
  };

  constructor(public modalService: BsModalService, public restService: RestServiceService) {
    this.getAllBooks();
  }

  public getAllBooks() {
    this.restService.getAllBooks().subscribe(
      res => {
        this.books = res;
      },
      err => {
        window.alert('Błąd podczas wyświetlanai listy książek');
      }
    );
  }

  public addBook(book: Book) {
    this.restService.addNewBook(book).subscribe(
      res => {
        book.id = res.id;
        this.books.push(book);
        window.alert('Sucess added book');
      },
      err => {
        window.alert('Failed added book');
        console.log(err);
      }
    );
  }

  openModalNewBook() {
    const modalRef = this.modalService.show(NewBookModalComponent);
    modalRef.content.event.subscribe(res => {
      if (!res.isNotNullOrUndefined) {
        this.newBook.title = res.data.title;
        this.newBook.isbn = res.data.isbn;
        this.newBook.category=res.data.category;
        this.newBook.list_authors=res.data.list_authors;
        this.restService.addNewBook(this.newBook);
        this.refreshPage();
      }
    });
  }

  searchBook() {
    this.restService.getSearchBooks(this.searchText).subscribe(
      res => {
        this.books = res;
      },
      err => {
        window.alert('Błąd podczas wyświetlanai listy wyszukanych');
      }
    );
  }

  refreshPage() {
    window.location.reload();
  }
}
