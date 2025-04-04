import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Creo una nuova istanza della classe SuperHero:
        SuperHero superHero = new SuperHero();

        // Creo la tabella (se già non esiste):
        //superHero.createTable();

        // Faccio un inserimento di alcuni supereroi dentro la tabella:
        //superHero.insertHeroes("Superman", SuperHero.TeamName.FREELANCE);
        //superHero.insertHeroes("Wolverine", SuperHero.TeamName.XMAN);
        //superHero.insertHeroes("Spiderman", SuperHero.TeamName.FANTASTIC4);

        // Faccio l'update della query inserendo il campo power:
        //superHero.updateQuery();

        // Faccio la stampa di tutti i supereroi:
        superHero.printAllHeroes();
    }
}