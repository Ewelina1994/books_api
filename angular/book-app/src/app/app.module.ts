import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListBooksComponent } from './list-books/list-books.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { ModalModule, BsModalRef } from 'ngx-bootstrap/modal';
import {CommonModule} from "@angular/common";
import { NewBookModalComponent } from './modal-window/new-book-modal/new-book-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    ListBooksComponent,
    NewBookModalComponent
  ],
  imports: [
    ModalModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    CommonModule,
    ReactiveFormsModule,
  ],
  providers: [BsModalRef],
  bootstrap: [AppComponent]
})
export class AppModule { }
