import { Routes } from '@angular/router';
import { ProdutoslistComponent } from './components/produtoslist/produtoslist.component';
import { CadastroComponent } from './components/cadastro/cadastro.component';
import { PrincipalComponent } from './components/principal/principal.component';


export const routes: Routes = [
  {path: "", redirectTo: "principal", pathMatch: 'full'},
  {path: "principal",  component: PrincipalComponent},
  {path: "produtoslist", component: ProdutoslistComponent},
  {path: "cadastro", component: CadastroComponent},
  {path: "produto/edit/:id", component: CadastroComponent},
];
