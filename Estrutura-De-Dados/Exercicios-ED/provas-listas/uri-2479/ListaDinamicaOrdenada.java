package Exemplo;

public class ListaDinamicaOrdenada {
    private No primeiro;
    private No ultimo;
    private int tamanho;
    public ListaDinamicaOrdenada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    public void addOrdenado(String item) {
        No novo = new No(item);

        if (primeiro == null) { // Lista vazia
            primeiro = novo;
            ultimo = novo;
            tamanho++;
        } else if (novo.dado.compareTo(primeiro.dado) < 0) { // Inicio da lista
            novo.proximo = primeiro;
            primeiro = novo;
            tamanho++;
        } else if (novo.dado.compareTo(ultimo.dado) > 0) { // Final da lista
            ultimo.proximo = novo;
            ultimo = novo;
            tamanho++;
        } else {
            No anterior = null;
            No atual = primeiro;
            //atualizando o 'atual' ate o fim se o 'novo' continuar sendo maior
            while (atual != null && novo.dado.compareTo(atual.dado) > 0) {
                anterior = atual;
                atual = atual.proximo;
            }
            anterior.proximo = novo;
            novo.proximo = atual;
            tamanho++;
        }
    }
    public void exibir() {
        No atual = primeiro;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
        //System.out.println();
    }
    public boolean contem(String valor){
        No aux = this.primeiro;
        No chave = new No(valor);
        while (aux != null){
            if(aux.dado.compareTo(chave.dado) == 0){
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }
    public String get(int pos){
        No aux = this.primeiro;
        int i = 0;
        if(pos >= 0 && pos < this.tamanho)
        {
            while(i < pos)
            {
                aux = aux.proximo;
                i++;
            }
            if(aux != null)
            {
                return aux.dado;
            }
        }
        return null;
    }
    public int tamanho()
    {
        return this.tamanho;
    }
}
