package com.cadastroproduto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastroproduto.entities.Produto;
import com.cadastroproduto.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/listAll")
    public ResponseEntity<List<Produto>> findAll() {
        try {
            List<Produto> produtos = service.findAll();
            return ResponseEntity.ok(produtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value="/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
    	try {
    		Produto obj = service.findProdutoById(id);
    		return ResponseEntity.ok().body(obj);
    	}catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
	}
    
    @PostMapping("/save")
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        try {
            Produto createdProduto = service.createProduto(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    

	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto obj) {
		try {
			obj = service.updateProduto(id, obj);
			return ResponseEntity.ok().body(obj);
		}catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
		try {
			service.deleteProduto(id);
	        return ResponseEntity.noContent().build();
		}catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }    
    }
	
	
	@ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + e.getMessage());
    }
}

