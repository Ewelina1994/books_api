import {Author} from './Author';

export class Book {
  id: number;
  title: string;
  isbn: string;
  category: string;
  authors: Author[]
}
