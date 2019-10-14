import { Injectable } from "@angular/core";
import {AbstractService} from './abstractservice';
import {CategoryDTO} from 'src/dto/categorydto';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class CategoryService extends AbstractService<CategoryDTO> {
    constructor(http : HttpClient) {
        super(http);
        this.type = "category";
    }

    /* ALL CRUD HAS BEEN IMPORTED FROM PARENT CLASS */
}