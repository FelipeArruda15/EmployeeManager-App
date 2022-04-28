import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Funcionario } from './funcionario';
import { FuncionarioService } from './funcionario.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public funcionarios: Funcionario[] = [];

  constructor(private service: FuncionarioService) { }

  ngOnInit(): void {
    this.obterFuncionarios();
  }

  public obterFuncionarios(): void {
    this.service.obterFuncionarios().subscribe(
      (resposta: Funcionario[]) => {
        this.funcionarios = resposta;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

}
