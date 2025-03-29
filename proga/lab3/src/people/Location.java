package people;

public enum Location {
    HOSPITAL("больница"),
    PANTRY("кладовая"),
    OTHER("где-то");

    private String Place;

    Location (String Place){
        this.Place = Place;
    }

    public String getLocation(){
        return this.Place;
    }
}
