package people;

public enum TypeClothing {
    NAKED("голый вид"),
    DRESSED("одетый вид");

    private final String TypeCl;

    TypeClothing (String TypeCl){
        this.TypeCl = TypeCl;
    }

    public String getTypeCl(){
        return this.TypeCl;
    }

}
