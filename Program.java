import java.util.Scanner;
public class Program{
    public class todo{
        int id;
        String text;
        boolean status;
        todo(int i, String t, boolean s){
            id = i;
            text = t;
            status = s;
        }
    }
    public static void main(String[] args) {
        todo[] todos = new todo[0];
        while(true) {
            System.out.println("1- Create --- 2- Update --- 3- Delete");
            if(todos.length > 0) {
                for (int i = 0; i < todos.length; i++) {
                    System.out.print(todos[i].text);
                    System.out.println(" - " + ((todos[i].status) ? "Done" : "Undone"));
                }
            } else System.out.println("There is nothing to do");
            Scanner scn = new Scanner(System.in);
            switch (scn.nextInt()) {
                case 1:
                    todos = Create(todos);
                    break;
                case 2:
                    System.out.println("Select which item to update");
                    int iU = scn.nextInt() - 1;
                    todos[iU].status = Update(todos,iU);
                    break;
                case 3:
                    System.out.println("Select which item to delete");
                    int iD = scn.nextInt() - 1;
                    todos = Delete(todos,iD);
                    break;
                default:
                    break;
            }
        }
    }
    public todo[] Create(todo[] m){
        todo[] n = new todo[m.length + 1];
        for (int i = 0; i < n.length; i++) {
            if (i < m.length) n[i] = m[i];
        }
        int id = n.length;
        String text = new Scanner(System.in).nextLine();
        boolean status = false;
        n[n.length- 1] = new todo(id,text,status);
        return n;
    }
    public boolean Update(todo[] a, int i){
        return !a[i].status;
    }
    public todo[] Delete(todo[] m, int skip){
        todo[] n = new todo[m.length - 1];
        for (int i = 0; i < m.length; i++) {
            if (i < skip) {
                n[i] = m[i];
            } else if (i == skip) {
                continue;
            } else {
                n[i - 1] = m[i];
            }
        }
        return n;
    }
}