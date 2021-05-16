import {Author} from "./Author";

export interface Book {
  id: number;
  title: string;
  isbn: string;
  category: string;
  list_authors: Author[]
}
