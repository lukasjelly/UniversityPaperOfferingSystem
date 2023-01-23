/**
 * Class to contain a majors' information and store a majors' associated papers
 */

public class Major {

    private String name;
    private Paper [] papers = new Paper[MAX_PAPERS];
    private int paperCount = 0;

    static final int MAX_PAPERS = 100;

    //constructor sets major name
    Major(String name){
        this.name=name;
    }

    //get major name in string format
    public String getName(){
        return this.name;
    }

    //add array of associated papers to major
    public void addPapers(Paper [] newPapers){
        for (int i = 0; i<newPapers.length; i++){
            newPapers[i].addMajor(this);
            papers[paperCount] = newPapers[i];
            paperCount++;
        }

    }

    //get number of a papers associated to major
    public int getPaperCount (){
        return paperCount;
    }

    //get paper associated to major, at index i
    public Paper getPaper(int i){
        return papers[i];
    }

}
