package org.expansaojava.service;



import org.expansaojava.dto.ProdutoDto;
import org.expansaojava.model.Loja;
import org.expansaojava.model.Produto;
import org.expansaojava.repository.LojaRepository;
import org.expansaojava.repository.ProdutoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class ProdutoService {

    @Inject
    private ProdutoRepository produtoRepository;

    @Inject
    private LojaRepository lojaRepository;

    public List<ProdutoDto> produtoPorLoja(long idLoja){
        List<Produto> produtosPorLoja = produtoRepository.findByLoja(idLoja);
        return mapProdutoDto(produtosPorLoja);

    }

    public void adicionarProduto(ProdutoDto produto){
        Loja loja = lojaRepository.findById(produto.getIdLoja());

        produtoRepository.persist(new Produto(loja, produto.getMarca(), produto.getModelo(),produto.getMarca(), produto.getPreco()));

    }

    public void editarProduto(ProdutoDto produto, Long id){

        Produto produtoAlterado = produtoRepository.findById(id);
        produtoAlterado.setDescricao(produto.getDescricao());
        produtoAlterado.setPreco(produto.getPreco());
        produtoRepository.persist(produtoAlterado);

    }

    public void deletarProduto(Long id){
        Produto produto = produtoRepository.findById(id);
        produtoRepository.delete(produto);

    }

    private List<ProdutoDto> mapProdutoDto(List<Produto> produtos){
        List<ProdutoDto> produtoDTO = new ArrayList<>();

        produtos.forEach(item->{
            ProdutoDto prods = new ProdutoDto(item.getId(), item.getLoja().getId(), item.getMarca(), item.getModelo(), item.getDescricao(), item.getPreco());
            produtoDTO.add(prods);
        });

        return produtoDTO;
    }

}
