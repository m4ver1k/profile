import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './components/app.component';
import {HttpClientModule} from '@angular/common/http';
import {ProfileComponent} from './components/profile/profile.component';
import {ReactiveFormsModule} from '@angular/forms';
import {PanelModule} from 'primeng/panel';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ButtonModule,
    ToastModule,
    MessageModule,
    DropdownModule,
    ReactiveFormsModule,
    PanelModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
