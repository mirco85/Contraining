import { Component, OnInit } from '@angular/core';
import { TestService } from 'src/service/test.service';
import { CategoryService } from 'src/service/category.service';
import { TestDTO } from 'src/dto/testdto';
import { CategoryDTO } from 'src/dto/categorydto';


@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  tests: TestDTO[];
  testtoinsert: TestDTO = new TestDTO();
  categories : CategoryDTO[];

  constructor(private service: TestService, private categoryService : CategoryService) { }

  ngOnInit() {
    this.getTest();
  }
  getTest() {
    this.service.getAll().subscribe((test) => {
      this.tests = test;
    });
    this.categoryService.getAll().subscribe((categories) => {
      this.categories = categories;
    });
  }

  delete(test: TestDTO) {
    this.service.delete(test.id).subscribe(() => this.getTest());
  }

  update(test: TestDTO) {
    this.service.update(test).subscribe(() => this.getTest());
  }

  insert(test: TestDTO) {
    this.service.insert(test).subscribe(() => this.getTest());
  }

  clear(){
    this.testtoinsert = new TestDTO();
  }



}
