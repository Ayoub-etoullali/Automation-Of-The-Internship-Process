import { Component } from '@angular/core';
import { Color, ScaleType } from '@swimlane/ngx-charts';
import { AuthService } from '../../../services/auth.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent {
  roles!: string | null;
  customerId: any;
  title = 'Angular Charts';

  constructor(private auth: AuthService, private router: Router) {
  }

  ngOnInit(): void {
    this.roles = localStorage.getItem("ROLES");
    if (localStorage.getItem("id") != undefined) {
      this.customerId = localStorage.getItem("id");
    }
  }

  view: [number, number] = [500, 400];

  // options for the chart
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Entreprise';
  showYAxisLabel = true;
  yAxisLabel = 'Stages';

  // colorScheme = {
  //   domain: ['#9370DB', '#87CEFA', '#FA8072', '#FF7F50', '#90EE90', '#9370DB']
  // };

  colorScheme: Color = {
    name: 'myColorScheme', // Provide a name for your color scheme
    selectable: true, // Specify whether the color scheme is selectable
    group: ScaleType.Ordinal, // Specify the group type of the color scheme (Ordinal, Linear, Time, etc.)
    domain: ['#9370DB', '#87CEFA', '#FA8072', '#FF7F50', '#90EE90', '#9370DB'] // Update with your desired color scheme
  };

  // data goes here
  public single = [
    {
      "name": "ADRIA",
      "value": 238
    },
    {
      "name": "OCP",
      "value": 98
    },
    {
      "name": "SQLI",
      "value": 398
    },
    {
      "name": "CAPGIMINI",
      "value": 25
    },
    {
      "name": "DLOITE",
      "value": 196
    },
    {
      "name": "ONEP",
      "value": 204
    }
  ];

  public multi = [
    {
      "name": "OCP",
      "series": [
        {
          "name": "2018",
          "value": 32
        },
        {
          "name": "2017",
          "value": 72
        }
      ]
    },

    {
      "name": "SQLI",
      "series": [
        {
          "name": "2018",
          "value": 56
        },
        {
          "name": "2017",
          "value": 76
        }
      ]
    },

    {
      "name": "ADRIA",
      "series": [
        {
          "name": "2018",
          "value": 29
        },
        {
          "name": "2017",
          "value": 209
        }
      ]
    },

    {
      "name": "ONEP",
      "series": [
        {
          "name": "2018",
          "value": 25
        },
        {
          "name": "2017",
          "value": 20
        }
      ]
    },

    {
      "name": "DELOITE",
      "series": [
        {
          "name": "2018",
          "value": 19
        },
        {
          "name": "2017",
          "value": 129
        }
      ]
    },

    {
      "name": "CAPGIMINI",
      "series": [
        {
          "name": "2018",
          "value": 204
        },
        {
          "name": "2017",
          "value": 14
        }
      ]
    }
  ];

  handleLogout() {
    this.auth.logout();
    this.roles = null;
    this.router.navigateByUrl("/login");
  }

}
