import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginFormComponent } from './login-form/login-form.component';
import {TabComponent, TabsComponent} from './tabs/tabs.component';
import { WelcomeFormComponent } from './welcome-form/welcome-form.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    TabsComponent,
    TabComponent,
    WelcomeFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
