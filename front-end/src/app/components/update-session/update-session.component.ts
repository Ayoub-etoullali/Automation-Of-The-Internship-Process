import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import Swal from "sweetalert2";
import { SessionService } from "../../services/session/session.service";
import { ActivatedRoute, Router } from "@angular/router";
import { Session } from "../../model/session";

@Component({
  selector: 'app-update-session',
  templateUrl: './update-session.component.html',
  styleUrls: ['./update-session.component.css']
})
export class UpdateSessionComponent implements OnInit {
  updateFormGroup!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private sessionService: SessionService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.updateFormGroup = this.fb.group({
      date: this.fb.control(null, [Validators.required]),
      description: this.fb.control(null, [Validators.required]),
    });
    this.getSession();
  }

  update() {
    if (this.updateFormGroup.valid) {
      const session: Session = this.updateFormGroup.value;
      session.id = +this.route.snapshot.params['id'];
      this.sessionService.updateSession(session).subscribe(
        {
          next: data => {
            Swal.fire({
              position: 'center',
              title: "Successfully updated!",
              showConfirmButton: false,
              timer: 1500
            });
          },
          error: err => {
            // Handle error
          }
        }
      );
    }
  }

  private getSession() {
    const sessionId = +this.route.snapshot.params['id'];
    this.sessionService.getSessionById(sessionId).subscribe(
      {
        next: data => {
          this.updateFormGroup.patchValue({
            date: data.date,
            description: data.description,
          });
        },
        error: err => {
          // Handle error
        }
      }
    );
  }
}
