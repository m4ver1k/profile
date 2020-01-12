import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {SelectItem} from 'primeng';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userform: FormGroup;
  genders: SelectItem[];


  constructor() { }

  ngOnInit() {
    this.userform = new FormGroup({
      realName: new FormControl('', Validators.required),
      displayName: new FormControl('', Validators.required),
      date: new FormControl(''),
      password: new FormControl('', Validators.compose([Validators.required, Validators.minLength(6)])),
      description: new FormControl(''),
      gender: new FormControl('', Validators.required)
    });

    this.genders = [];
    this.genders.push({label: 'Select Gender', value: ''});
    this.genders.push({label: 'Male', value: 'Male'});
    this.genders.push({label: 'Female', value: 'Female'});
  }

  onSubmit(value: string) {
  }
}
