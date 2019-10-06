import { Component, OnInit } from '@angular/core';
import {CategoryService} from 'src/service/category.service';
import { CategoryDTO } from 'src/dto/categorydto';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories : CategoryDTO[];
  categoryToInsert : CategoryDTO = new CategoryDTO();

  constructor(private service : CategoryService) { }

  ngOnInit() {
    this.getCategories();
  }

  /**
   * Call service (front-end) that calls on port 8080 (backend) GetAll() method.
   * When backend method is called, it returns a list of CategoryDTO.
   * With 'subscribe' we send and receive from backend data that can be used in front-end
   * We call the list as 'categories' and throught '=>' we tell how to use it.
   * We set global categories variable as the list we received.
   * We can call it from html 
   */
  getCategories() {
    this.service.getAll().subscribe(categories => this.categories = categories);
  }

  /**
   * Call front-end service delete (that calls backdend controller 'delete' method).
   * After receiving the response we recall getCategories() to update the list
   * @param category is the category we want to delete
   */
  delete(category : CategoryDTO) {
    this.service.delete(category.idcategory).subscribe(() => this.getCategories());
  }

  insert(category : CategoryDTO) {
    this.service.insert(category).subscribe(() => this.getCategories());
  }

  update(category : CategoryDTO) {
    this.service.update(category).subscribe(() => this.getCategories());
  }

  clear() {
    this.categoryToInsert = new CategoryDTO();
  }

}
