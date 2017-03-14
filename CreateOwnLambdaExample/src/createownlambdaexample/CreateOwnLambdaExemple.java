package createownlambdaexample;

public class CreateOwnLambdaExemple {

    public static void main(String[] args) {

        // Anonym klass, ett objekt som skapas av ett interface (CanPrint) med metod (printIT). 
        CanPrint printer = new CanPrint() {
            @Override
            public void printIT(String var) {
                System.out.println("Printern printar följande: " + var);
            }
        };
        
        // Som ovan fast med lambda uttryck istället.
        CanPrint lambdaPrinter = var -> System.out.println("Lambdaprintern printar följande: " + var);
        
        // Använder objektet som skapades av den anonyma klassen. 
        printer.printIT("Skriv ut detta!");
        lambdaPrinter.printIT("Skriv ut detta!");

    }
}

// Interfacet får bara innehålla en metod, kallas funktionellt interface, för att kunna använda lambda!
// Fler metoder hade varit okej för vanliga anonyma klasser.
interface CanPrint {
    void printIT(String var);
}
