package school.sorokin.javacore;

import school.sorokin.javacore.view.ConsoleView;

public class App 
{
    public static void main( String[] args ) {
        ConsoleView cs = new ConsoleView();
        while (true) {
        cs.showMenu();
        cs.chooseMenuItem();
        }
    }
}
