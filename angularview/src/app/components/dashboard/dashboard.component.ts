import { Component, OnInit } from '@angular/core';
import * as Chart from 'chart.js';
import { GasDataService } from 'src/app/services/gas-data.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  readerNames: string[] = [];
  dates: Date[] = [];
  valuesSets: number[][] = [];

  constructor(private gasDataService: GasDataService) { }

  ngOnInit(): void {
    this.getDailyGasData();
  }

  getDailyGasData() {
    this.gasDataService.getDailyGasData().subscribe(
      response => {
        this.readerNames = this.composeReaderNamesArray(response);

        this.dates = this.composeDatesArray(response)
        
        for (let i = 0; i < response.length; i++) {
          this.valuesSets[i] = this.composeValuesSetsArray(response[i].dailyConsumption);
        }

        this.renderChart();
      }
    )
  }

  composeValuesSetsArray (entry : any) {
    let valueSet: number[] = [];
    for (let value of entry) {
      valueSet.push(value.consumption);
    }
    return valueSet;
  }

  composeDatesArray (gasData : any) {
    let datesSet: Date[] = [];
    for (let date of gasData[0].dailyConsumption) {
      datesSet.push(date.date);
    }
    return datesSet;
  }

  composeReaderNamesArray (gasData: any) {
    let readerNames: string[] = [];
    for (let name of gasData) {
      readerNames.push(name.readerName);
    }
    return readerNames;
  }

  renderChart() {
    const canvas = <HTMLCanvasElement>document.getElementById('myChart');
    const ctx = canvas.getContext('2d');
    var myChart = new Chart(ctx, {
      type: 'line',
      data: {
        labels: this.dates,
        datasets: [{
          label: this.readerNames[0],
          data: this.valuesSets[0],
          borderColor: "#c45850",
          fill: false
        },
      {
        label: this.readerNames[1],
        data: this.valuesSets[1],
        borderColor: "#3e95cd",
        fill: false
      },
      {
        label: this.readerNames[2],
        data: this.valuesSets[2],
        borderColor: "#3cba9f",
        fill: false
      }]
      },
    });
  }
}
