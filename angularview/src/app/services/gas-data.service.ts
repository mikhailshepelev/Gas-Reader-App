import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DailyGasData } from '../model/daily-gas-data';
import { API_URL } from "../app.constants";

@Injectable({
  providedIn: 'root'
})
export class GasDataService {

  constructor(private http : HttpClient) { }

  getDailyGasData(username: string) {
    return this.http.get<DailyGasData[]>(`${API_URL}/${username}/gasdata`);
  }
}
