import { EventEmitter, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TemplateTestNgModule } from '../../../template-test-ng/src/public-api';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormControl, FormGroup } from '@angular/forms';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    TemplateTestNgModule,
    FormControl,
    FormGroup,
    FormsModule,
    ReactiveFormsModule,
    EventEmitter
      
  ]
})
export class AppModule { }
