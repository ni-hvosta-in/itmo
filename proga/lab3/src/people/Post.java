package people;

public enum Post {
    CHIEFPHISICION("глава больницы"),
    DOCTOR("доктор"),
    NURSE("Медсестра");

    private final String post;

    Post (String post){
        this.post = post;
    }

    public String getPost(){
        return this.post;
    }

}
