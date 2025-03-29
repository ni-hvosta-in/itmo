package plan;

public enum Exit {
    DOOR("дверь"),
    HOLE("дыра"),
    WINDOW("окно");

    private final String exit;

    Exit (String exit){
        this.exit = exit;
    }

    public String getExit(){
        return this.exit;
    }
}
