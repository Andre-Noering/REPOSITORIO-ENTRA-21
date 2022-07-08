package classes;

public class HotDog extends Sanduiche{
    public HotDog() {
        this.adicionarIngrediente("Pão");
        this.adicionarIngrediente("Salsicha");
        this.adicionarIngrediente("Purê de Batata");
        this.adicionarIngrediente("Batata Palha");
        this.adicionarIngrediente("Vinagrete");
        this.adicionarIngrediente("Queijo Cheddar");
        this.adicionarIngrediente("Milho");
        this.adicionarIngrediente("Ervilha");
        this.setTipo("Hot Dog");
    }
}