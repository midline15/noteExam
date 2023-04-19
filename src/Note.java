import java.util.ArrayList;

public class Note {
    private String title;
    private ArrayList<String> text = new ArrayList<>();
    private String time;

    public Note(String title) {
        this.title = title;
    }

    public Note(String title, ArrayList<String> text, String time) {
        this.title = title;
        this.text = text;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public void stringDel(){
       if(this.getText() != null) text.remove(text.size()-1);
       else System.out.println("빈 파일입니다.");
    }
    public void stringAdd(String string){
        text.add(string);
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }

    public ArrayList<String> getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
