import { Component, OnInit } from '@angular/core';
import { QuestionsDTO } from 'src/dto/questionsdto';
import { TestsDTO } from 'src/dto/testsdto';
import { QuestionsService } from 'src/service/questions.service';
import { TestService } from 'src/service/test.service';

@Component({
  selector: 'app-questiontest',
  templateUrl: './questiontest.component.html',
  styleUrls: ['./questiontest.component.css']
})
export class QuestiontestComponent implements OnInit {
  questions: QuestionsDTO[];
  tests: TestsDTO[];
  testupdate: TestsDTO = new TestsDTO();
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
    this.questionservice.getAll().subscribe((questions) => {
      this.questions = questions;
    });
  }

  /**
   * check if dto list as initialized its question list
   */
  checktest(){
    if(this.testupdate==null||typeof this.testupdate==='undefined'){
      return;
    }
    if(this.testupdate.questions==null||typeof this.testupdate.questions==='undefined'){
      this.testupdate.questions = new Array();
    }
  }

  /**
   * find the index of a question in a specified list
   * @param question to get the index of
   * @param list to search in
   */
  findIndex(question: QuestionsDTO, list : QuestionsDTO[]) : number {
    let index = list.findIndex((q) =>{
      return q.id===question.id;
    });
    return index;
  }
  /**
   * add a question to a specified list
   * @param question to add
   * @param list target for the specified question
   */
  addquestiontoList(question : QuestionsDTO, list: QuestionsDTO[]) {
    list.push(question);
  }
  
  /**
   * remove a question to a specified list
   * @param question to add
   * @param list target for the specified question
   */
  removequestionfromList(question : QuestionsDTO, list : QuestionsDTO[]) {
    let index=this.findIndex(question, list)
    if(index >= 0){
      list.splice(index,1);
    }
  }

  /**
   * add a specified question to selected test
   * @param question to add
   */
  addquestion(question:QuestionsDTO){
    this.checktest();
    this.addquestiontoList(question, this.testupdate.questions);
    this.removequestionfromList(question, this.questions);
  }

  /**
   * remove a specified question from selected test
   * @param question to remove
   */
  removequestion(question:QuestionsDTO){
    this.checktest();
    this.removequestionfromList(question, this.testupdate.questions);
    this.addquestiontoList(question, this.questions);
  }

  /**
   * Updates the selected test
   */
  update(){
    this.checktest();
    this.testservice.update(this.testupdate).subscribe(() =>{
      this.getTest();
      this.getQuestions();
    });
  }

}
