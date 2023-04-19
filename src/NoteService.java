import java.util.Iterator;

public interface NoteService {

    public void newNote();
    public void addNote(Note note);

    public void updateNote(String title);

    public void deleteNote(String title);

    public Iterator<Note> getNotes();
}
