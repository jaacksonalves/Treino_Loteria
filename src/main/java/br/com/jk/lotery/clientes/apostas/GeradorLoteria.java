package br.com.jk.lotery.clientes.apostas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeradorLoteria {

    public List<Integer> geraNumerosLoteria() {
        List<Integer> numerosPossiveis = new ArrayList<>();

        for (int i = 1; i <= 60; i++) {
            numerosPossiveis.add(i);
        }

        Collections.shuffle(numerosPossiveis);

        List<Integer> numerosEscolhidos = numerosPossiveis.subList(0, 6);
        Collections.sort(numerosEscolhidos);

        return numerosEscolhidos;

    }


}
