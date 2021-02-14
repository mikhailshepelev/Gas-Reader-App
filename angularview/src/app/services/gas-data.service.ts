import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from "../app.constants";

@Injectable({
  providedIn: 'root'
})
export class GasDataService {

  constructor(private http : HttpClient) { }

  getDailyGasData() {
    return this.http.get<any>(`${API_URL}/gasdata`);
  }
}

interface GetResponseGasData {
    readerName; 
    dailyConsumption: {
      date : string,
      dailyConsumption: number
    }
}
