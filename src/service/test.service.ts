import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { TestDTO } from 'src/dto/testdto';
import { MicroService } from './microservice';


@Injectable({
    providedIn: 'root'
  })
  export class TestService extends MicroService<TestDTO>{
  
    constructor(http: HttpClient) {
      super(http, 'test', 'tests');
      
    }

  }