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
  testupdate: TestDTO = new TestDTO();
  questiontoadd: QuestionsDTO = new QuestionsDTO();
  questiontoremove: QuestionsDTO = new QuestionsDTO();

  constructor(private questionservice: QuestionsService, private testservice: TestService) { }

  ngOnInit() {
    this.getTest();
    this.getQuestions();
  }
  getTest() {
    this.testservice.getAll().subscribe((test) => {
      this.tests = test;
    });
  }
  getQuestions() {
    this.questionservice.getAllAvailable().subscribe((questions) => {
      this.questions = questions;
    });
  }
  checktest(){
    if(this.testupdate==null||typeof this.testupdate==='undefined'){
      return;
    }
    if(this.testupdate.questions==null||typeof this.testupdate.questions==='undefined'){
      this.testupdate.questions = new Array();
    }
  }
  addquestion(question:QuestionsDTO){
    this.checktest();
    this.testupdate.questions.push(question);
  }
  removequestion(question:QuestionsDTO){
    this.checktest();
    let index=this.testupdate.questions.findIndex((q) =>{
      return q.id===question.id;
    });
    if(index >= 0){
      this.testupdate.questions.splice(index,1);
    }
  }
  update(){
    this.checktest();
    this.testservice.update(this.testupdate).subscribe(() =>{
      this.getTest();
      this.getQuestions();
    });
  }

}
