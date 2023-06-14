import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import Swal from 'sweetalert2';
import { Session } from "../../model/session";
import { SessionService } from "../../services/session/session.service";

@Component({
  selector: 'app-add-session',
  templateUrl: './add-session.component.html',
  styleUrls: ['./add-session.component.css']
})
export class AddSessionComponent implements OnInit {

  newSessionFormGroup!: FormGroup;

  constructor(private fb: FormBuilder, private sessionService: SessionService, private router: Router) {
  }

  ngOnInit(): void {
    this.newSessionFormGroup = this.fb.group({
      date: [null, Validators.required], // Update control name to "date"
      description: [null, Validators.required] // Update control name to "description"
    });
  }

  addSession() {
    let session: Session = this.newSessionFormGroup.value;
    this.sessionService.createSession(session).subscribe(
      data => {
        Swal.fire({
          position: 'center',
          title: "Session successfully saved!",
          showConfirmButton: false,
          timer: 1500
        });
        this.newSessionFormGroup.reset();
      },
      err => {
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: err.message,
          showConfirmButton: false,
          timer: 1500
        });
      }
    );
  }
}
