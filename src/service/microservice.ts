import { Injectable } from "@angular/core";
import {AbstractService} from './abstractservice';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class MicroService<DTO> extends AbstractService<DTO> {
    constructor(http : HttpClient, microserviceName : String, controllerMap : string) {
        super(http);
        this.port = "8080";
        this.pathToMicro =  microserviceName + '/api/' + controllerMap;
    }



}