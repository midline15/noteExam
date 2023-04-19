import java.util.Iterator;
import java.util.Scanner;

public class NoteUI {
    private Scanner sc = new Scanner(System.in);

    public int menu() {
        System.out.println("1. 새 파일");
        System.out.println("2. 불러오기");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 종료");
        int menuId = Integer.parseInt(sc.nextLine());
        return menuId;
    }

    public void printNoteList(Iterator<Note> iter) {
        while (iter.hasNext()) {
            Note note = iter.next();
            System.out.println("제목 : " + note.getTitle());
            System.out.println("날짜 : " + note.getTime());
            System.out.println("==================================================");
        }
    }

    public String inputTitle() {
        System.out.print("편집할 파일 제목 : ");
        return sc.nextLine();
    }

}
