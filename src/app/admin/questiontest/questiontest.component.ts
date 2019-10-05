import { Component, OnInit } from '@angular/core';
import { QuestionsDTO } from 'src/dto/questionsdto';
import { TestDTO } from 'src/dto/testdto';
import { QuestionsService } from 'src/service/questions.service';
import { TestService } from 'src/service/test.service';

@Component({
  selector: 'app-questiontest',
  templateUrl: './questiontest.component.html',
  styleUrls: ['./questiontest.component.css']
})
export class QuestiontestComponent implements OnInit {
  questions: QuestionsDTO[];
  tests: TestDTO[];
  testupdate: TestDTO = new TestDTO;
  constructor(private questionservice: QuestionsService, private testservice: TestService) { }

  ngOnInit() {
  }

}
