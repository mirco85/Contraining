import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { TestDTO } from 'src/dto/testdto';


@Injectable({
    providedIn: 'root'
  })
  export class TestService extends AbstractService<TestDTO>{
  
    constructor(http: HttpClient) {
      super(http);
      this.type = 'test/api/tests';
    }

  }