import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ValidatorService {
  form: FormGroup | undefined;
  constructor() { }

  public setForm(form: FormGroup): void {
    this.form = form;
  }

  validateRequired(control: string): string {
    if (this.form?.get(control)?.hasError('required')) {
      return 'You must enter a value!';
    }
    return '';
  }
}
