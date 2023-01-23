/**
 * Main class to add data about a school and call display methods
 */

public class Main {

    //display authors information
    private static void displayInfo(){
        System.out.println("****************************************");
        System.out.println("Assignment 1, 159.234 Semester 1 2022");
        System.out.println("Submitted by: Lukas Jehle, ID: 20009320");
        System.out.println("My major at Massey: Information Technology");
        System.out.println("****************************************");
        System.out.println();
    }

    public static void main(String[] args) {

        //create campuses
        Campus pn = new Campus("PN");
        Campus ak = new Campus("Auckland");
        Campus ds = new Campus("Distance"); //"distance" considered a "campus"
        Campus [] allCampuses = new Campus[] {
                ds,
                ak,
                pn,
        };

        //create papers
        Paper informationTechnologyPrinciples = new Paper("Information Technology Principles", "158100");
        Paper webBasedITFundamentals = new Paper("Web-based IT Fundamentals", "158120");
        Paper appliedProgramming = new Paper("Applied Programming", "159101");
        Paper algorithmsAndDataStructures = new Paper("Algorithms and Data Structures", "159201");
        Paper objectOrientedProgramming = new Paper("Object-Oriented Programming", "159234");
        Paper databaseDevelopment = new Paper("Database Development", "158337");
        Paper professionalismInTheInformationSciences = new Paper("Professionalism in the Information Sciences", "158345");
        Paper [] allPapers = new Paper[]{
                informationTechnologyPrinciples,
                webBasedITFundamentals,
                appliedProgramming,
                algorithmsAndDataStructures,
                objectOrientedProgramming,
                databaseDevelopment,
                professionalismInTheInformationSciences
        };

        //create majors
        Major informationTechnology = new Major("IT");
        Major informationScience = new Major("IS");
        Major computerScience = new Major("CS");
        Major dataScience = new Major("DS");
        Major softwareEngineering = new Major("SE");

        //create assessment types
        Assessment assignment = new Assessment("Assignment");
        Assessment test = new Assessment("Test");
        Assessment exam = new Assessment("Exam");

        //create lecturers and assign campus to lecturer in constructor
        Lecturer lecturer1 = new Lecturer("1105236", "Amy", "Sheffield", new Campus[] {pn, ds});
        Lecturer lecturer2 = new Lecturer("1235894", "Victoria", "Jensen", new Campus[] {pn, ds});
        Lecturer lecturer3 = new Lecturer("7225669", "James", "Lee", new Campus[] {pn, ds});
        Lecturer lecturer4 = new Lecturer("1328991", "Colin", "Delmont", new Campus[] {pn, ds});
        Lecturer lecturer5 = new Lecturer("1562347", "Thomas", "Becker", new Campus[] {ak, ds});
        Lecturer lecturer6 = new Lecturer("5664789", "Steven", "Hobbs", new Campus[] {ak, ds});
        Lecturer lecturer7 = new Lecturer("3658947", "Andrew", "Jackson", new Campus[] {ak, ds});
        Lecturer lecturer8 = new Lecturer("6332698", "Jonathon", "Wood", new Campus[] {ak, ds});
        Lecturer lecturer9 = new Lecturer("12345678", "Mickey", "Mouse", new Campus[] {ak, ds});
        Lecturer lecturer10 = new Lecturer("20009320", "Lukas", "Jehle", new Campus[] {ak, ds});
        Lecturer [] allLecturers = new Lecturer[]{
                lecturer1,
                lecturer2,
                lecturer3,
                lecturer4,
                lecturer5,
                lecturer6,
                lecturer7,
                lecturer8,
                lecturer9,
                lecturer10
        };

        //randomly assign lecturer to each papers' offering
        informationTechnologyPrinciples.addLecturers(allLecturers, allCampuses);
        webBasedITFundamentals.addLecturers(allLecturers,allCampuses);
        appliedProgramming.addLecturers(allLecturers,allCampuses);
        algorithmsAndDataStructures.addLecturers(allLecturers,allCampuses);
        objectOrientedProgramming.addLecturers(allLecturers, allCampuses);
        databaseDevelopment.addLecturers(allLecturers,allCampuses);
        professionalismInTheInformationSciences.addLecturers(allLecturers,allCampuses);

        //assign assessments to papers
        informationTechnologyPrinciples.addAssessment(assignment, 70);
        informationTechnologyPrinciples.addAssessment(test, 30);
        webBasedITFundamentals.addAssessment(assignment, 60);
        webBasedITFundamentals.addAssessment(test, 40);
        appliedProgramming.addAssessment(assignment, 50);
        appliedProgramming.addAssessment(test, 50);
        algorithmsAndDataStructures.addAssessment(assignment, 40);
        algorithmsAndDataStructures.addAssessment(test, 20);
        algorithmsAndDataStructures.addAssessment(exam, 40);
        objectOrientedProgramming.addAssessment(assignment, 50);
        objectOrientedProgramming.addAssessment(test, 10);
        objectOrientedProgramming.addAssessment(exam, 40);
        databaseDevelopment.addAssessment(assignment, 60);
        databaseDevelopment.addAssessment(exam, 40);
        professionalismInTheInformationSciences.addAssessment(assignment, 100);

        //create array of papers associated with a major
        Paper [] informationTechnologyPapers = new Paper[]{
                informationTechnologyPrinciples,
                webBasedITFundamentals,
                appliedProgramming,
                databaseDevelopment,
                professionalismInTheInformationSciences
        };
        Paper [] informationSciencePapers = new Paper[]{
                informationTechnologyPrinciples,
                webBasedITFundamentals,
                appliedProgramming,
                algorithmsAndDataStructures,
                professionalismInTheInformationSciences
        };
        Paper [] computerSciencePapers = new Paper[] {
                appliedProgramming,
                algorithmsAndDataStructures,
                objectOrientedProgramming,
                professionalismInTheInformationSciences
        };
        Paper [] dataSciencePapers = new Paper[]{
                appliedProgramming,
                algorithmsAndDataStructures,
                databaseDevelopment,
                professionalismInTheInformationSciences
        };
        Paper [] softwareEngineeringPapers = new Paper[]{
                appliedProgramming,
                algorithmsAndDataStructures,
                objectOrientedProgramming,
                databaseDevelopment,
                professionalismInTheInformationSciences
        };

        //assign papers to majors
        informationTechnology.addPapers(informationTechnologyPapers);
        informationScience.addPapers(informationSciencePapers);
        computerScience.addPapers(computerSciencePapers);
        dataScience.addPapers(dataSciencePapers);
        softwareEngineering.addPapers(softwareEngineeringPapers);

        //create new school
        School school1 = new School("School of Mathematical and Computational Sciences");

        //assign majors to school
        school1.addMajor(informationTechnology);
        school1.addMajor(informationScience);
        school1.addMajor(computerScience);
        school1.addMajor(dataScience);
        school1.addMajor(softwareEngineering);

        //assign papers to school
        school1.addPapers(allPapers);

        //assign lecturers to school;
        school1.addLecturers(allLecturers);

        //display required information
        displayInfo();
        school1.displayName();
        school1.displayAllPapers();
        school1.displayPapersForMajor(informationTechnology);
        exam.displayAllPapers();
        assignment.displayPapers(50);
        school1.displayPaperOfferings();
        school1.displayPapersForLecturer(lecturer10);
        school1.displayLecturer(objectOrientedProgramming, ak);
    }
}
