import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../models/produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  http = inject(HttpClient);

  API = "http://localhost:8080/produtos";

  constructor() { }

  listAll(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.API+"/listAll");
  }

  findById(id: number): Observable<Produto> {
    return this.http.get<Produto>(this.API+"/"+id);
  }

  save(produto: Produto): Observable<Produto[]> {
    return this.http.post<Produto[]>(this.API+"/save", produto);
  }

  update(produto: Produto, id: number): Observable<Produto[]> {
    return this.http.put<Produto[]>(this.API+"/"+id, produto);
  }

  delete(id: number){
    return this.http.delete<void>(this.API+"/"+id);
  }
}
