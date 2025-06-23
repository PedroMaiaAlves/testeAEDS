public class Cliente {

    private String nome;
    private int documento;
    //TODO: escolher uma estrutura de dados para armazenar pedidos do cliente
    private Lista<Pedido> pedidos;
    
    

    public Cliente(String nome, int documento){
        if(!nome.contains(" ") && nome.split(" ").length!=2)
            throw new IllegalArgumentException("Favor cadastrar cliente com um nome e um sobrenome");
        if(documento < 10_000)
            throw new IllegalArgumentException("Documentos válidos devem ter pelo menos 5 dígitos");
            this.documento = documento;
            this.nome = nome;
    
    }

    public void adicionarPedido(Pedido novo){
        if(novo == null){
            throw new IllegalArgumentException("Não se pode guardar um produto vazio no pedido");
        } else {
            pedidos.inserir(novo);
        }
    }


    public double totalGasto(){
        return pedidos.calcularValorTotal((pedido -> pedido.valorFinal()));
    }

    @Override
    public String toString(){
        return nome+" ("+documento+")";
    }
    
    @Override
    public int hashCode(){
        return documento;
    }
    
}
