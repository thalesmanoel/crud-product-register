package com.cadastroproduto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastroproduto.entities.Produto;
import com.cadastroproduto.repository.ProdutoRepository;
import com.cadastroproduto.service.exception.ResourceNotFoundException;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public Produto createProduto(Produto produto) {
        return repository.save(produto);
    }
	
	public List<Produto> findAll(){
		return repository.findAll();
	}	
	
	public Produto findProdutoById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Produto updateProduto(Long id, Produto produtoUpdated) {
        Optional<Produto> produtoOpt = repository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            
            produto.setName(produtoUpdated.getName());
            produto.setDescription(produtoUpdated.getDescription());
            produto.setPrice(produtoUpdated.getPrice());
            produto.setAvaible(produtoUpdated.getAvaible());
            
            return repository.save(produto);
        }
        else 
        {
        	throw new ResourceNotFoundException(id);
        }
	}
	
	public void deleteProduto(Long id) {
        repository.deleteById(id);
    }
	
	
	

}
