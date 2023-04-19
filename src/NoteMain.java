public class NoteMain {

    public static void main(String[] args) {

        NoteUI noteUI = new NoteUI();
        NoteService noteServiceInMemory = new NoteServiceInMemory();

        while (true) {
            int menuId = noteUI.menu();
            if (menuId == 5) {
                break;
            } else if (menuId == 1) {
                noteServiceInMemory.newNote();
            } else if (menuId == 2) {
                noteUI.printNoteList(noteServiceInMemory.getNotes());

                noteServiceInMemory.updateNote(noteUI.inputTitle());
            } else if (menuId == 3) {
                noteServiceInMemory.updateNote(noteUI.inputTitle());
            } else if (menuId == 4) {
                noteServiceInMemory.deleteNote(noteUI.inputTitle());
            } else {
                System.out.println("12345중에서만 눌러라");
            }
        }

    }
}
