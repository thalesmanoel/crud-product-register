import { Component, inject } from '@angular/core';
import { Produto } from '../../models/produto';
import { Router, RouterModule } from '@angular/router';
import { ProdutoService } from '../../services/produto.service';

@Component({
  selector: 'app-produtoslist',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './produtoslist.component.html',
  styleUrl: './produtoslist.component.scss'
})
export class ProdutoslistComponent {
  lista: Produto[] = [];

  produtoService = inject(ProdutoService);
  router = inject(Router);
  constructor(){

    this.listAll();
  }

  listAll(){
    this.produtoService.listAll().subscribe({
      next: lista => {
        this.lista = lista;
      },
      error: erro => {
        console.error('Erro ao buscar os dados:', erro);
        alert("Ocorreu algum erro!");
      },
    });
  }

  edit(produto: Produto){
    console.log(produto);
    this.router.navigate(['/produto/edit', produto.id]);
  }

  deleteById(id: number){
    if (confirm("Tem certeza que deseja deletar esse registro?")) {
      this.produtoService.delete(id).subscribe({
        next: () => {
          this.lista = this.lista.filter(produto => produto.id !== id);
        },
        error: erro => {
          alert('Erro ao deletar produto!');
          console.error(erro);
        }
      });
    }
  }

  ordenarPorPreco() {
    this.lista.sort((a, b) => a.price - b.price);
  }
}
