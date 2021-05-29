import {Component, Input, OnInit} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap/modal';
import {Book} from '../model/Book';
import {RestServiceService} from '../service/rest-service.service';
import {NewBookModalComponent} from '../modal-window/new-book-modal/new-book-modal.component';
import {Author} from '../model/Author';

@Component({
  selector: 'app-list-books',
  templateUrl: './list-books.component.html',
  styleUrls: ['./list-books.component.scss']
})
export class ListBooksComponent implements OnInit {
  @Input()
  books: Book[] = [];
  editBook: Book = {
    id: null,
    title: null,
    isbn: null,
    category: null,
    authors: null
  }
  bsModalRef: BsModalRef;
  constructor(private restService: RestServiceService, private modalService: BsModalService) { }

  ngOnInit(): void {
  }

  openModalEditBook(el: Book) {
    const initialState = {
      list: [
        {
          title: el.title,
          isbn: el.isbn,
          category: el.category,
          authors: el.authors
        }
      ]
    };
    this.bsModalRef = this.modalService.show(NewBookModalComponent, {initialState});
    this.bsModalRef.content.event.subscribe(res => {
      if (!res.isNotNullOrUndefined) {
        this.editBook.id = el.id;
        this.editBook.title = res.data.title;
        this.editBook.isbn = res.data.title;
        this.editBook.category = res.data.category;
        this.editBook.authors = res.data.authors;
        this.editBookMethod(this.editBook);
      }
    });
  }

  refreshPage() {
    window.location.reload();
  }

  private editBookMethod(editBook: Book) {
    this.restService.addNewBook(editBook).subscribe(
      res => {
        window.alert('Sucess edit book');
        this.refreshPage();
      },
      err => {
        window.alert('Failed edit book');
        console.log(err);
      }
    );
  }
}
