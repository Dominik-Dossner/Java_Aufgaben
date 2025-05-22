import java.io.IOException;
import java.util.*;
import de.tha.prog2.blatt6.tools.GameDataProvider;
import de.tha.prog2.blatt6.tools.Game;


public class Aufgabe2 {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Spieltag: ");
            int spieltag = scanner.nextInt();
            //Spieldaten
            GameDataProvider provider = new GameDataProvider();

            Map<String, Team> teams = berechneTabelle(provider, spieltag);
            List<Team> tabelle = new ArrayList<>(teams.values());

            sortiereTabelle(tabelle);
            druckeTabelle(tabelle, spieltag);
        }
    }

    private static void sortiereTabelle(List<Team> teams) {
        teams.sort(Comparator
                //ruft Methode für jedes Team auf -> Sortierung wird umgedreht
                .comparingInt(Team::getPunkte)
                .thenComparingInt(Team::Tordifferenz) // bei gleichen Punkten
                .thenComparingInt(Team::getToreFuer).reversed()); // bei gleiche Tordifferenz
    }

    private static Map<String, Team> berechneTabelle(GameDataProvider provider, int maxSpieltag) {
        Map<String, Team> teams = new HashMap<>(); // String teamname, teams = Statistik

        for(int i = 1; i <= maxSpieltag; i++) {
            ArrayList<Game> spiele = provider.getGames(i); // Spiele werden zurückgegeben

            for(Game game : spiele) {
                //computeIfAbsent wird nur erstellt != existiert
                teams.computeIfAbsent(game.homeTeam, Team::new);
                teams.computeIfAbsent(game.awayTeam, Team::new);

                //Statistik von beiden Teams
                teams.get(game.homeTeam).addSpiele(game.homeGoals, game.awayGoals);
                teams.get(game.awayTeam).addSpiele(game.awayGoals, game.homeGoals);
            }
        }

        return teams;
    }

    private static void druckeTabelle(List<Team> teams, int spieltag) {
        System.out.println("====== Tabelle nach Spieltag " + spieltag + " ======");
        System.out.printf("%-5s %-22s %2s %2s %2s %2s %7s %3s %4s%n",
                           "Platz", "Verein", "Sp", "S", "U", "N", "T:GT", "TD", "Pkte");

        for(int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            String tore = team.getToreFuer() + ":" + team.getToregegen();

            System.out.printf("%-5s %-22s %2s %2s %2s %2s %7s %3s %4s%n",
                    i + 1,
                    team.getName(),
                    team.getSpiele(),
                    team.getSiege(),
                    team.getNiederlagen(),
                    team.getUnentschieden(),
                    tore,
                    team.Tordifferenz(),
                    team.getPunkte()
                    );
        }
    }
}