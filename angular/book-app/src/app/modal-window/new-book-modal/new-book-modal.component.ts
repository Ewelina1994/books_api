import {Component, EventEmitter, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BsModalRef} from 'ngx-bootstrap/modal';
import {Book} from '../../model/Book';

@Component({
  selector: 'app-new-book-modal',
  templateUrl: './new-book-modal.component.html',
  styleUrls: ['./new-book-modal.component.scss']
})
export class NewBookModalComponent implements OnInit {
  list: any[] = [];
  book: FormGroup;
  public event: EventEmitter<any> = new EventEmitter();

  constructor(private formBuilder: FormBuilder, public bsModalRef: BsModalRef) {
    this.book = formBuilder.group({
      title: [this.list[0], [Validators.required, Validators.minLength(3)]],
      isbn: [this.list[1], [Validators.required, Validators.minLength(3)]]
    });
  }

  ngOnInit(): void {
  }

  saveToList(book: any) {
    if (this.book.dirty && this.book.valid) {
      this.event.emit({data: this.book.value, res: 200});
      this.bsModalRef.hide();
    }
  }
}
