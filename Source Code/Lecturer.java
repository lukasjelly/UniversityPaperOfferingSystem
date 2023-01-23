/**
 * Class to contain a lecturers' information and store associated:
 * - campus availability
 * - papers taught
 */

public class Lecturer {

    private String id;
    private String firstName;
    private String lastName;
    private Campus [] campuses = new Campus[MAX_CAMPUSES];
    private int campusCount = 0;
    private Paper [] papers = new Paper[MAX_PAPERS];
    private int paperCount = 0;

    static final int MAX_CAMPUSES = 100;
    static final int MAX_PAPERS = 100;

    //constructor to set lecturer information
    Lecturer(String id, String firstName, String lastName, Campus [] newCampuses){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.campuses = newCampuses; //array storing campuses where lecturer may teach
        this.campusCount= newCampuses.length;
    }

    //add a new paper that lecturer teaches
    public void addPaper(Paper newPaper){
        papers[paperCount] = newPaper;
        paperCount++;
    }

    //get number of papers that lecturer teaches
    public int getPaperCount(){
        return this.paperCount;
    }

    //get lecturers' full name in string format
    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        fullName.append(firstName + " " + lastName);
        return fullName.toString();
    }

    //get a campus where lecturer may teach at given index
    public Campus getCampus(int index){
        return campuses[index];
    }

    //get number of campuses where lecturer may teach
    public int getCampusCount(){
        return campusCount;
    }

}
