/**
 * Class containing a papers' information and to store:
 * - majors that the paper belongs to
 * - assessments for that paper
 * - a lecturer for each campus where the paper is taught
 */

public class Paper {

    private String name;
    private String paperNumber;
    private Major [] majors =  new Major[MAX_MAJORS];
    private int majorCount = 0;
    private Assessment [] assessments = new Assessment[MAX_ASSESSMENTS];
    private int assessmentCount = 0;
    private Lecturer [] lecturers = new Lecturer[MAX_LECTURER];
    private int lecturerCount = 0;
    private Campus [] campuses = new Campus[MAX_CAMPUS];
    private int campusCount = 0;

    static final int MAX_MAJORS = 100;
    static final int MAX_ASSESSMENTS = 100;
    static final  int MAX_LECTURER = 100;
    static final int MAX_CAMPUS=100;

    //constructor to set paper name and number
    Paper(String name, String paperNumber){
        this.name = name;
        this.paperNumber = paperNumber;
    }

    //get paper name in string format
    public String getName(){
        return this.name;
    }

    //get paper number in string format
    public String getPaperNumber(){
        return this.paperNumber;
    }

    //get campus location at given index in string format
    public String getCampusLocation(int index){
        return this.campuses[index].getLocation();
    }

    //get a campus at given index
    public Campus getCampus(int index){
        return this.campuses[index];
    }

    //add an associated major to a paper
    public void addMajor(Major newMajor){
        majors[majorCount] = newMajor;
        majorCount++;
    }

    //get all majors associated with a paper in string format
    public String getMajors(){
        StringBuilder listOfMajors = new StringBuilder();
        for (int i = 0; i<majorCount; i++){
            listOfMajors.append(majors[i].getName());
            listOfMajors.append(" ");
        }
        return listOfMajors.toString();
    }

    //add an associated assessment to a paper
    public void addAssessment(Assessment newAssessment, double weight){
        newAssessment.addPaper(this, weight);
        assessments[assessmentCount] = newAssessment;
        assessmentCount++;
    }

    //add a random lecturer that may teach at each campus where paper is taught
    //lecturer and campus arrays are associated (they line up)
    public void addLecturers(Lecturer [] allLecturers, Campus [] allCampuses){
        for (int i = 0; i<allCampuses.length; i++){
            lecturers[i] = getRandomLecturer(allCampuses[i], allLecturers);
            lecturers[i].addPaper(this);
            campuses[i]=allCampuses[i];
            lecturerCount++;
            campusCount++;
        }
    }

    //get a random lecturer who is located at a given campus
    private Lecturer getRandomLecturer(Campus campus, Lecturer [] allLecturers){
        Lecturer [] allLecturersAtCampus = allLecturersAtCampus(campus, allLecturers);
        int randIndex = (int) (Math.random()*(allLecturersAtCampus.length));
        //ensure lecturer has max 4 papers assigned
        while (true){
            if (allLecturersAtCampus[randIndex].getPaperCount() < 4){
                return allLecturersAtCampus[randIndex]; //next method below
            }
            else{
                //get a different lecturer
                randIndex = (int) (Math.random()*(allLecturersAtCampus.length));
            }
        }
    }

    //get array of all lecturers at a given campus
    private Lecturer [] allLecturersAtCampus (Campus campus, Lecturer [] allLecturers){
        Lecturer allLecturersAtCampus [] = new Lecturer[MAX_LECTURER];

        //search all lecturers
        int lecturerIndex = 0;
        for (int i = 0; i<allLecturers.length; i++){

            //search each lecturers' campus
            for (int j = 0; j<allLecturers[i].getCampusCount(); j++){
                if(allLecturers[i].getCampus(j) == campus){
                    //found a lecturer who teaches at given campus
                    allLecturersAtCampus[lecturerIndex] = allLecturers[i];
                    lecturerIndex++;
                }
            }

        }

        //convert to array of correct size
        //this is to ensure that random index has appropriate max index value
        //can be avoided with dynamic array but have not been taught about this yet sorry!
        Lecturer [] allLecturersAtCampus2 = new Lecturer[lecturerIndex];
        for (int i = 0; i<lecturerIndex; i++){
            allLecturersAtCampus2[i]=allLecturersAtCampus[i];
        }
        return allLecturersAtCampus2;
    }

    //get lecturers' full name in string format at given index
    public String getLecturerFullName(int index){
        return lecturers[index].getFullName();
    }

    //get lecturer at given index
    public Lecturer getLecturer(int index){
        return lecturers[index];
    }

    //get number of lecturers who teach that paper
    public int getLecturerCount(){
        return this.lecturerCount;
    }

    //get number of campuses where paper is taught
    public int getCampusCount(){
        return this.campusCount;
    }
}
