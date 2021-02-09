import { Component, OnInit } from '@angular/core';
import { DailyGasData } from 'src/app/model/daily-gas-data';
import { GasDataService } from 'src/app/services/gas-data.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  gasData: DailyGasData[] = [];
  username: string = '';

  constructor(private gasDataService : GasDataService) { }

  ngOnInit(): void {
    this.username = sessionStorage.getItem('authenticatedUser');
    this.getDailyGasData();
  }

  getDailyGasData() {
    this.gasDataService.getDailyGasData(this.username).subscribe(
      response => {
        this.gasData = response;
      }
    )
}
}
