import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  // userform: FormGroup;
  // genders: SelectItem[];

  constructor() { }

  ngOnInit() {
    // this.userform = this.fb.group({
    //   'firstname': new FormControl('', Validators.required),
    //   'lastname': new FormControl('', Validators.required),
    //   'password': new FormControl('', Validators.compose([Validators.required, Validators.minLength(6)])),
    //   'description': new FormControl(''),
    //   'gender': new FormControl('', Validators.required)
    // });
    //
    // this.genders = [];
    // this.genders.push({label:'Select Gender', value:''});
    // this.genders.push({label:'Male', value:'Male'});
    // this.genders.push({label:'Female', value:'Female'});
  }

  onSubmit(value: string) {
    // this.messageService.add({severity:'info', summary:'Success', detail:'Form Submitted'});
  }
}
