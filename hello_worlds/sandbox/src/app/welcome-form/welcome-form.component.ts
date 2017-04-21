import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome-form',
  templateUrl: './welcome-form.component.html',
  styleUrls: ['./welcome-form.component.css']
})
export class WelcomeFormComponent {
  text: string = "Willkommen Benutzer!";

  addWelcomeText(){
    return this.text;
  }

}
