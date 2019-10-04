import { Injectable } from '@angular/core';
import {AbstractService} from './abstractservice';
import {HttpClient} from '@angular/common/http';
import { QuestionsDTO } from 'src/dto/questionsdto';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuestionsService extends AbstractService<QuestionsDTO> {

  constructor(http : HttpClient) {
    super(http);
    this.type = 'questions';
   }
}
