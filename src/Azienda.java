import java.sql.*;

public class Azienda {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/join_1a1";
    private static final String USER = "root";
    private static final String PASS = "root";

    // Trova i nomi e i cognomi dei dipendenti insieme ai nomi dei progetti su cui stanno lavorando.
    public void query1() throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement statement = conn.createStatement();

        String printQuery = """
                SELECT d.nome, d.cognome, p.nome_progetto
                FROM dipendenti d
                inner join progetti p on d.id_progetto = p.id_progetto;
                """;

        ResultSet resultSet = statement.executeQuery(printQuery);

        System.out.println("\n" +
                "\u001B[33m" +
                "Trova i nomi e i cognomi dei dipendenti insieme ai nomi dei progetti su cui stanno lavorando:" +
                "\u001B[0m");

        //Finchè ci sono dati dentro a resultSet col ciclo while li stampo tutti:
        while (resultSet.next()) {
            System.out.println("\n" + "\u001B[32m" + " Nome: " + resultSet.getString("nome"));
            System.out.println(" Cognome: " + resultSet.getString("cognome"));
            System.out.println(" Progetto: " + resultSet.getString("nome_progetto") + "\u001B[0m");
        }

        conn.close();
    }

    //Trova il nome del progetto su cui sta lavorando un dipendente specifico
    //(ad esempio, il dipendente con id_dipendente = 1).
    public void query2() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement statement = conn.createStatement();

        String printQuery = """
                SELECT dipendenti.nome, dipendenti.cognome, dipendenti.id_dipendente, progetti.nome_progetto
                FROM dipendenti
                inner join progetti on dipendenti.id_progetto = progetti.id_progetto
                where id_dipendente = 1;
                """;

        ResultSet resultSet = statement.executeQuery(printQuery);

        System.out.println("\n" +
                "\u001B[33m" +
                "Trova il nome del progetto su cui sta lavorando un dipendente specifico\n" +
                "(ad esempio, il dipendente con id_dipendente = 1)" +
                "\u001B[0m");

        while (resultSet.next()) {
            System.out.println("\n" + "\u001B[32m" + " Nome: " + resultSet.getString("nome"));
            System.out.println(" Cognome: " + resultSet.getString("cognome"));
            System.out.println(" ID_Dipendente: " + resultSet.getString("id_dipendente"));
            System.out.println(" Progetto: " + resultSet.getString("nome_progetto") + "\u001B[0m");
        }

        conn.close();
    }

    //Trova i dipendenti che non sono assegnati a nessun progetto.
    public void query3() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement statement = conn.createStatement();

        String printQuery = """
                SELECT *
                FROM dipendenti d
                left join progetti p on d.id_progetto = p.id_progetto
                where p.id_progetto is null;
                """;

        ResultSet resultSet = statement.executeQuery(printQuery);

        System.out.println("\n" +
                "\u001B[33m" +
                "Trova i dipendenti che non sono assegnati a nessun progetto:" +
                "\u001B[0m");

        while (resultSet.next()) {
            System.out.println("\n" + "\u001B[32m" + " Nome: " + resultSet.getString("nome"));
            System.out.println(" Cognome: " + resultSet.getString("cognome"));
            System.out.println(" ID_Dipendente: " + resultSet.getString("id_dipendente"));
            System.out.println(" ID_Progetto: " + resultSet.getString("id_progetto") + "\u001B[0m");
        }

        conn.close();
    }

    //Trova i progetti che non hanno dipendenti assegnati.
    public void query4() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement statement = conn.createStatement();

        String printQuery = """
                SELECT p.nome_progetto, p.id_progetto, d.id_dipendente
                FROM progetti p
                left join dipendenti d on d.id_progetto = p.id_progetto
                where id_dipendente is null;
                """;

        ResultSet resultSet = statement.executeQuery(printQuery);

        System.out.println("\n" +
                "\u001B[33m" +
                "Trova i progetti che non hanno dipendenti assegnati:" +
                "\u001B[0m");

        while (resultSet.next()) {
            System.out.println("\n" + "\u001B[32m" + " Progetto: " + resultSet.getString("nome_progetto"));
            System.out.println(" ID_Progetto: " + resultSet.getString("id_progetto"));
            System.out.println(" ID_Dipendente: " + resultSet.getString("id_dipendente") + "\u001B[0m");
        }

        conn.close();
    }

    //Conta il numero totale di progetti assegnati ai dipendenti.
    public void query5() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement statement = conn.createStatement();

        String printQuery = """
                SELECT COUNT(progetti.nome_progetto) as numero_progetti_assegnati
                FROM dipendenti
                inner join progetti on dipendenti.id_progetto = progetti.id_progetto;
                """;

        ResultSet resultSet = statement.executeQuery(printQuery);

        System.out.println("\n" +
                "\u001B[33m" +
                "Conta il numero totale di progetti assegnati ai dipendenti:" +
                "\u001B[0m");

        while (resultSet.next()) {
            System.out.println("\n" + "\u001B[32m" + " Progetto: " + resultSet.getString("nome_progetto"));
            System.out.println(" ID_Progetto: " + resultSet.getString("id_progetto"));
            System.out.println(" ID_Dipendente: " + resultSet.getString("id_dipendente") + "\u001B[0m");
        }

        conn.close();
    }
}