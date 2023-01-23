/**
 * Class containing an assessment types' information and to store:
 *  -papers that have that assessment type
 * - the weight of that assessment for a paper
 * Class has methods to display information associated with an assessment
 */

public class Assessment {

    private String name;
    private Paper [] papers = new Paper[MAX_PAPERS];
    private int paperCount = 0;
    private double [] weight = new double[MAX_PAPERS];

    static final int MAX_PAPERS = 100;

    //constructor to set assessment name
    Assessment(String name){
        this.name =  name;
    }

    //get assessment name in string format
    public String getName(){
        return this.name;
    }

    //add a paper associated with an assessment
    //paper and weight arrays are associated (they line up)
    public void addPaper(Paper newPaper, double newWeight){
        papers[paperCount] = newPaper;
        weight[paperCount] = newWeight;
        paperCount++;
    }


    /**
     * Display methods to display tasks as required
     */

    //TASK 4: display all papers that have "this" assessment type
    public void displayAllPapers(){
        System.out.println("------------------ Task 4 ------------------");
        System.out.println("Papers that have " + this.getName().toLowerCase() + ":");

        //search for each paper
        for (int i = 0; i<paperCount; i++){
            System.out.println("Paper - " + papers[i].getPaperNumber() + " " + papers[i].getName());
        }
        System.out.println("Total number of papers that have " + this.getName().toLowerCase() + ": " + paperCount);
        System.out.println("\n");
    }

    //TASK 5: display papers with assessment weights higher than minPercentage
    public void displayPapers(double minPercentage){
        System.out.println("------------------ Task 5 ------------------");
        System.out.println("Papers that their " + this.getName().toLowerCase() + "s weighted more than " + minPercentage + "%:");

        //search each paper
        int paperCountPercentage = 0; //count papers that have assessment weights higher than minPercentage
        for (int i = 0; i<paperCount; i++) {
            if (weight[i]>minPercentage){
                //found a paper that has assessment weight higher than minPercentage
                System.out.println("Paper - " + papers[i].getPaperNumber() + " " + papers[i].getName());
                paperCountPercentage++;
            }
        }
        System.out.println("Total number of papers that have " + this.getName().toLowerCase() + "s weighted more than " + minPercentage + "%: " + paperCountPercentage);
        System.out.println("\n");
    }
}
