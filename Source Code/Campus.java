/**
 * Class containing a campuses' information
 */

public class Campus {

    private String location;

    //constructor to set campus location
    Campus(String location){
        this.location=location;
    }

    //return campus location in string format
    public String getLocation(){
        return this.location;
    }

}
