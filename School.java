/**
 * Class to contain a schools' information and store all associated:
 *  -majors
 * - papers
 * - lecturers
 * Class has methods to display information associated with a school
 */

public class School {

    private String name;
    private Major [] majors = new Major[MAX_MAJOR];
    private int majorCount = 0;
    private Paper [] papers = new Paper[MAX_PAPERS];
    private int paperCount = 0;
    private Lecturer [] lecturers = new Lecturer[MAX_LECTURER];

    static final int MAX_MAJOR = 100;
    static final int MAX_PAPERS = 100;
    static final int MAX_LECTURER = 100;


    //constructor sets school name
    School(String name){
        this.name=name;;
    }

    //return school name in string format
    public String getName(){
        return this.name;
    }

    //add a major to school
    public void addMajor(Major newMajor){
        majors[majorCount]= newMajor;
        majorCount++;
    }

    //add array of papers to school
    public void addPapers(Paper [] newPapers){
        for (int i = 0; i<newPapers.length; i++) {
            papers[paperCount] = newPapers[i];
            paperCount++;
        }
    }

    //add array of lecturers to school
    public void addLecturers(Lecturer[] newLecturers){
        for (int i = 0; i<newLecturers.length; i++){
            lecturers[i]= newLecturers[i];
        }
    }


    /**
     * Display methods to display tasks as required
     */

    //TASK 1: display name of school
    public void displayName(){
        System.out.println("------------------ Task 1 ------------------");
        System.out.println("School full name: " + getName() + "\n");
    }

    //TASK 2: display all papers
    public void displayAllPapers(){
        System.out.println("------------------ Task 2 ------------------");
        System.out.println("All papers details:");
        for (int i = 0; i<paperCount; i++){
            System.out.println(papers[i].getPaperNumber() + " " + papers[i].getName() + " ("+ papers[i].getMajors() + ")");
        }
        System.out.println("\n");
    }

    //TASK 3: display papers associated with a given major
    public void displayPapersForMajor (Major major){
        System.out.println("------------------ Task 3 ------------------");
        System.out.println("Papers that belong to Major " + major.getName() + ":");
        for (int i = 0; i<major.getPaperCount(); i++){
            System.out.println("Paper - " + major.getPaper(i).getPaperNumber() + " " + major.getPaper(i).getName() );
        }
        System.out.println("Total matching papers in specified Major - "+ major.getName()+ ": " + major.getPaperCount());
        System.out.println("\n");
    }

    //TASK 6: display paper offering details
    public void displayPaperOfferings (){
        System.out.println("------------------ Task 6 ------------------");
        System.out.println("Paper offering details: ");
        for (int i = 0; i<paperCount; i++){
            for (int j = 0; j<papers[i].getCampusCount(); j++){
                System.out.printf("%s %-9s %s\n",papers[i].getPaperNumber(), papers[i].getCampusLocation(j), papers[i].getLecturerFullName(j));
            }
        }
        System.out.println();
    }

    //TASK 7: display paper offerings for a given lecturer
    public void displayPapersForLecturer(Lecturer lecturer){
        System.out.println("------------------ Task 7 ------------------");
        System.out.println("The Paper offerings that I teach: ");

        //search each paper for given lecturer
        for (int i = 0; i< paperCount; i++){

            //search each offering of papers[i] for given lecturer
            for (int j = 0; j<papers[i].getCampusCount(); j++){

                if (papers[i].getLecturer(j) == lecturer){
                    //found given lecturer in papers' offering
                    System.out.printf(
                            "Paper offering - %s  %s  Lecturer: %s\n",
                            papers[i].getPaperNumber(),
                            papers[i].getCampusLocation(j), // campus and lecturer array correspond to each other
                            papers[i].getLecturerFullName(j) // campus and lecturer array correspond to each other
                            );
                }
            }
        }
        System.out.println();
    }

    //TASK 8: display lecturer of a papers' given offering
    public void displayLecturer(Paper paper, Campus campus){
        System.out.println("------------------ Task 8 ------------------");
        System.out.printf("The lecturer of %s offering of %s:\n", campus.getLocation(), paper.getPaperNumber());

        //find given paper, store in paperIndex
        int paperIndex = -1;
        for (int i = 0; i<paperCount; i++){
            if (papers[i]==paper){
                paperIndex = i;
                break;
            }
        }
        
        //find campus of given paper, store in campusIndex.
        //NOTE: campus and lecturer array correspond to each other
        int campusIndex = -1;
        for (int i = 0; i<papers[paperIndex].getCampusCount(); i++){
            if (papers[paperIndex].getCampus(i) == campus){
                campusIndex = i;
                break;
            }
        }

        System.out.printf("Lectures Name: %s\n", papers[paperIndex].getLecturer(campusIndex).getFullName());
        System.out.printf("The lecturer is teaching %d paper(s)", papers[paperIndex].getLecturer(campusIndex).getPaperCount());
    }
}
