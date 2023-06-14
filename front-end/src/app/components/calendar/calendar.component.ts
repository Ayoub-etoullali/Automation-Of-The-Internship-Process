import { Component, OnInit } from '@angular/core';
import { CalendarEvent } from '../../model/CalendarEvent';
import { CalendarService } from '../../services/calendar/calendar.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {
  calendarEvents: CalendarEvent[] = [];
  calendarOptions: any; // Ajoutez cette ligne

  constructor(private calendarService: CalendarService) { }

  ngOnInit() {
    this.getCalendarEvents();
    this.calendarOptions = {
      // Ajoutez vos options de configuration ici
      // Par exemple : initialView: 'dayGridMonth'
    };
  }

  getCalendarEvents() {
    this.calendarService.getCalendarEvents().subscribe(
      events => {
        this.calendarEvents = events;
      },
      error => {
        console.log(error);
      }
    );
  }
}
