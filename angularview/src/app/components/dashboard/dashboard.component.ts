import { Component, OnInit } from '@angular/core';
import * as Chart from 'chart.js';
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

  constructor(private gasDataService: GasDataService) { }

  ngOnInit(): void {
    this.username = sessionStorage.getItem('authenticatedUser');
    this.getDailyGasData();
  }

  getDailyGasData() {
    this.gasDataService.getDailyGasData(this.username).subscribe(
      response => {
        this.gasData = response;
        let dates: Date[] = this.gasData.map(a => a.date);
        let values: number[] = this.gasData.map(b => b.dailyConsumption);
        this.renderChart(values, dates);
      }
    )
  }

  renderChart(data, labels) {
    const canvas = <HTMLCanvasElement>document.getElementById('myChart');
    const ctx = canvas.getContext('2d');
    var myChart = new Chart(ctx, {
      type: 'line',
      data: {
        labels: labels,
        datasets: [{
          label: 'Gas consumption',
          data: data,
          borderColor: 'rgba(75, 192, 192, 1)',
          backgroundColor: 'rgba(75, 192, 192, 0.2)',
        }]
      },
    });
  }
}
