import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ProdutoService } from '../../services/produto.service';
import { FormsModule } from '@angular/forms';
import { Produto } from '../../models/produto';

@Component({
  selector: 'app-cadastro',
  standalone: true,
  imports: [RouterModule, FormsModule],
  providers: [ProdutoService],
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.scss'
})
export class CadastroComponent {

  produto: Produto = new Produto();

  produtoService = inject(ProdutoService);
  router = inject(Router);
  route = inject(ActivatedRoute); // Ajustado para usar inject

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.produtoService.findById(+id).subscribe({
        next: (produto) => {
          this.produto = produto;
        },
        error: (erro) => {
          alert('Erro ao carregar o produto para edição!');
          console.error(erro);
        },
      });
    }
  }

  save() {
    if (!this.produto.name || !this.produto.description || !this.produto.price || this.produto.avaible === undefined) {
      alert('Por favor, preencha todos os campos obrigatórios!');
      return;
    }

    this.produtoService.save(this.produto).subscribe({
      next: resposta => {
        this.produto = new Produto();
        this.router.navigate(['/produtoslist']);
      },
      error: erro => {
        alert('Erro ao salvar produto!');
        console.error(erro);
      },
    });
  }
}

