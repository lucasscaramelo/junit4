package services;

import daos.LocacaoDAO;
import entities.Filme;
import entities.Locacao;
import entities.Usuario;
import exceptions.FilmeSemEstoqueException;
import exceptions.LocadoraException;
import utils.DataUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static utils.DataUtils.adicionarDias;

public class LocacaoService {

    private LocacaoDAO dao;

    public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws FilmeSemEstoqueException, LocadoraException {
        if(usuario == null) {
            throw new LocadoraException("Usuario vazio");
        }

        if(filmes == null || filmes.isEmpty()) {
            throw new LocadoraException("Filme vazio");
        }

        for(Filme filme: filmes) {
            if(filme.getEstoque() == 0) {
                throw new FilmeSemEstoqueException();
            }
        }

        Locacao locacao = new Locacao();
        locacao.setFilmes(filmes);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        Double valorTotal = 0d;
        for(int i = 0; i < filmes.size(); i++) {
            Filme filme = filmes.get(i);
            Double valorFilme = filme.getPrecoLocacao();
            switch (i) {
                case 2: valorFilme = valorFilme * 0.75; break;
                case 3: valorFilme = valorFilme * 0.5; break;
                case 4: valorFilme = valorFilme * 0.25; break;
                case 5: valorFilme = 0d; break;
            }
            valorTotal += valorFilme;
        }
        locacao.setValor(valorTotal);

        //Entrega no dia seguinte
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        if(DataUtils.verificarDiaSemana(dataEntrega, Calendar.SUNDAY)) {
            dataEntrega = adicionarDias(dataEntrega, 1);
        }
        locacao.setDataRetorno(dataEntrega);

        //Salvando a locacao...
        dao.salvar(locacao);

        return locacao;
    }

    public void setLocacaoDAO(LocacaoDAO dao) {
        this.dao = dao;
    }
}
