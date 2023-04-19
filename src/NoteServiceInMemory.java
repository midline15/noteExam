import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NoteServiceInMemory implements NoteService {
    private ArrayList<Note> notes = new ArrayList<>();
    Scanner sc;

    public NoteServiceInMemory() {
        sc = new Scanner(System.in);
    }

    @Override
    public void newNote() {
        String title = null;
        Note note = new Note(title);
        edit(note);
    }

    @Override
    public void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public Iterator<Note> getNotes() {
        return notes.iterator();
    }

    @Override
    public void updateNote(String title) {
        if (exists(title)) {
            edit(findNote(title));
        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }
    }

    private void edit(Note note) {
        System.out.println("==================================");
        System.out.println("/x 나가기 /s 저장 /a 다른이름으로저장");
        System.out.println("/z 한줄 지우기 ");
        System.out.println("==================================");
        while (true) {
            String str = sc.nextLine().toString();
            if (str.equals("/x")) {
                quit(note);
                break;
            } else if (str.equals("/s")) {
                save(note);
            } else if (str.equals("/a")) {
                saveAs(note.getText());
            } else if (str.equals("/z")) {
                note.stringDel();
            } else {
                note.stringAdd(str);
                System.out.println(str);
            }
        }
    }

    private void quit(Note note) {
        while (true) {
            System.out.print("저장?(y/n) : ");
            String s = sc.nextLine();
            if (s.equals("y") || s.equals("Y")) {
                save(note);
                break;
            } else if (s.equals("n") || s.equals("N")) {
                break;
            }
        }
    }

    private void save(Note note) {
        if (note.getTitle() == null) {
            System.out.print("제목 : ");
            note.setTitle(sc.nextLine());
        }
        note.setText(note.getText());
        note.setTime(LocalDateTime.now().toString());
        addNote(note);
    }



    private void saveAs(ArrayList<String> text) {
        ArrayList<String> t = new ArrayList<>();
        for (int i = 0; i < text.size(); i++) {
            t.add(text.get(i));
        }
        System.out.print("제목 : ");
        Note note = new Note(sc.nextLine(), t, LocalDateTime.now().toString());
        addNote(note);
    }


    @Override
    public void deleteNote(String title) {
        if (exists(title)) {
            notes.remove(findNote(title));
        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }
    }

    private boolean exists(String title) {

        if (findNote(title) == null) {
            return false;
        } else {
            return true;
        }
    }

    private Note findNote(String title) {
        Note findNote = null;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getTitle().equals(title)) {
                findNote = notes.get(i);
                break;
            }
        }
        return findNote;
    }

}
