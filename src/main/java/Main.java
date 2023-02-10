import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
       mainApp();
    }


    public static void mainApp(){
        while (true) {
            Account acc = login();
            if (acc != null) {
                System.out.println("Jesteś zalogowany!");
                customerMenu();
                break;
            } else {
                System.out.println("Niepoprawne hasło lub login spróbuj ponownie");
            }
        }
    }

    public static void customerMenu(){
        System.out.println("Wybierz, co chcesz zrobić: ");
        System.out.println("Wpisz 1, jeśli chcesz przeglądać kawy według zadanych parametrów");
        System.out.println("Wpisz 2, jeśli chcesz złożyć zamówienie");
        System.out.println("Wpisz 3, jeśli chcesz zobaczyć swoje poprzednie zamówienia");
        int answer = sc.nextInt();
        switch (answer){
            case 1:
                filterCoffee();
                break;
            case 2:
                //tu miejsce na funkcję służącą do składania zamówienia
                break;
            case 3:
                //tu miejsce na funkcję drukującą poprzednie zamówienia
                break;
            default:
                System.out.println("Podano złą odpowiedź");
                customerMenu();
                break;
        }
    }

    public static Account login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj login:");
        String login = sc.nextLine();
        System.out.println("Podaj haslo:");
        String password = sc.nextLine();
        return DatabaseConnection.checkIfAccountExists(login,password);
    }

    public static void filterCoffee() {
        List<String> conditions = new ArrayList<>();
        List<String> attributes = new ArrayList<>();
        while (true) {
            System.out.println("Wybierz po czym chcesz filtrować kawy: ");
            System.out.println("1 - aromat, 2- kwasowość, 3 - słodycz");
            System.out.println("4 - ocena, 5 - typ, 6 - producent");
            System.out.println("7 - region, 8 - kraj, 0 - zakończ filtrowanie");
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.println(DatabaseConnection.filterCoffees(attributes, conditions));
                break;
            } else if (choice <= 4 && choice >= 1) {
                sc.nextLine();
                System.out.println("Podaj zakres wartości (w postaci 2-4)");
                String range = sc.nextLine();
                if (range.length() > 4 || !range.contains("-")) {
                    System.out.println("Błędne dane. Spróbuj jeszcze raz.");
                } else {
                    if (choice == 1) {
                        attributes.add("aromat");
                    } else if (choice == 2) {
                        attributes.add("kwasowość");
                    } else if (choice == 3) {
                        attributes.add("słodycz");
                    } else {
                        attributes.add("ocena");
                    }
                    conditions.add(range);
                }

            } else {
                String attribute = switch (choice) {
                    case 5 -> "typy";
                    case 6 -> "producenci";
                    case 7 -> "rejon";
                    case 8 -> "kraj";
                    default -> "";
                };
                sc.nextLine();
                System.out.println("Podaj " + attribute + "-y ");
                System.out.println("Gdy więcej niż jeden, wtedy oddziel je przecinkiem (a,b,c):");
                String condition = sc.nextLine();
                attributes.add(attribute);
                conditions.add(condition);
            }
        }
    }
}