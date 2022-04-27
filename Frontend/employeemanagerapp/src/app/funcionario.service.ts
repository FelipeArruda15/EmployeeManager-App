import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Funcionario } from './funcionario';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {
  private apiServerUrl = '';

  constructor(private http: HttpClient) { }

  public obterFuncionarios(): Observable<Funcionario[]>{
    return this.http.get<Funcionario[]>(`${this.apiServerUrl}/funcionario/todos`);
  }

  public adicionarFuncionario(funcionario: Funcionario): Observable<Funcionario>{
    return this.http.post<Funcionario>(`${this.apiServerUrl}funcionario/adicionar`, funcionario);
  }

  public atualizarFuncionario(funcionario: Funcionario): Observable<Funcionario>{
    return this.http.put<Funcionario>(`${this.apiServerUrl}funcionario/atualizar`, funcionario);
  }

  public deletarFuncionario(funcionarioId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}funcionario/deletar/${funcionarioId}`);
  }
}
