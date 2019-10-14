import {CategoryDTO} from './categorydto';
import { QuestionsDTO } from './questionsdto';


export class TestDTO {

    id: number;
 
    category: CategoryDTO;
 
    timeTest: number;
    
    testName: String;

    questions: QuestionsDTO[];
 }