import {TestBed, async, ComponentFixture} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {HttpClientTestingModule, HttpTestingController} from "@angular/common/http/testing";
import {HttpClient} from "@angular/common/http";
import {By} from "@angular/platform-browser";

describe('AppComponent', () => {
  let httpClient: HttpClient;
  let httpTestingController: HttpTestingController;
  let fixture: ComponentFixture<AppComponent>;
  let appComponent: AppComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [HttpClientTestingModule]
    }).compileComponents();

    httpClient = TestBed.get(HttpClient);
    httpTestingController = TestBed.get(HttpTestingController);
    fixture = TestBed.createComponent(AppComponent);
    appComponent = fixture.componentInstance;

  }));

  it('should create the app', () => {
    expect(appComponent).toBeTruthy();
  });

  it(`should display hello world'`, () => {

    fixture.detectChanges();
    const req = httpTestingController.expectOne('api/hello');
    expect(req.request.method).toEqual('GET');
    req.flush({"msg":"Hello World"});
    fixture.detectChanges();
    expect(fixture.debugElement.query(By.css('.hello')).nativeElement.textContent).toContain('Hello World');
    httpTestingController.verify();
  });

});
