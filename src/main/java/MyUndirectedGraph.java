import java.util.List;

public class MyUndirectedGraph<T> implements UndirectedGraph<T> {
// ToDo: metod för att räkna den totala vikten

    /**
     * Antalet noder i grafen.
     *
     * @return antalet noder i grafen.
     */
    public int getNumberOfNodes() {
        return 0;
    }











    /**
     * Antalet bågar i grafen.
     *
     * @return antalet bågar i grafen.
     */
    public int getNumberOfEdges() {
        return 0;
    }








    /**
     * Lägger till en ny nod i grafen.
     *
     * @param newNode
     *            datat för den nya noden som ska läggas till i grafen.
     * @return false om noden redan finns.
     */
    public boolean add(T newNode) {
        return false;
    }









    /**
     * Kopplar samman tvä noder i grafen. Eftersom grafen är oriktad så spelar
     * det ingen roll vilken av noderna som står först. Det är också
     * fullständigt okej att koppla ihop en nod med sig själv. Däremot tillåts
     * inte multigrafer. Om två noder kopplas ihop som redan är ihopkopplade
     * uppdateras bara deras kostnadsfunktion.
     *
     * @param node1
     *            den ena noden.
     * @param node2
     *            den andra noden.
     * @param cost
     *            kostnaden för att ta sig mellan noderna. Denna måste vara >0
     *            för att noderna ska kunna kopplas ihop.
     * @return true om bägge noderna finns i grafen och kan kopplas ihop.
     */
    public boolean connect(T node1, T node2, int cost) {
        return false;
    }















    /**
     * Berättar om två noder är sammanbundan av en båge eller inte.
     *
     * @param node1
     *            den ena noden.
     * @param node2
     *            den andra noden.
     * @return om noderna är sammanbundna eller inte.
     */
    public boolean isConnected(T node1, T node2) {
        return false;
    }













    /**
     * Returnerar kostnaden för att ta sig mellan två noder.
     *
     * @param node1
     *            den ena noden.
     * @param node2
     *            den andra noden.
     * @return kostnaden för att ta sig mellan noderna eller -1 om noderna inte
     *         är kopplade.
     */
    public int getCost(T node1, T node2) {
        return 0;
    }











    /**
     * Gär en djupet-först-sökning efter en väg mellan två noder.
     *
     * Observera att denna metod inte använder sig av viktinformationen.
     *
     * @param start
     *            startnoden.
     * @param end
     *            slutnoden.
     * @return en lista över alla noder på vägen mellan start- och slutnoden. Om
     *         ingen väg finns är listan tom.
     */
    public List<T> depthFirstSearch(T start, T end) {

    }












    /**
     * Gär en bredden-först-sökning efter en väg mellan två noder.
     *
     * Observera att denna metod inte använder sig av viktinformationen. Ni ska
     * alltså inte implementera Dijkstra eller A*.
     *
     * @param start
     *            startnoden.
     * @param end
     *            slutnoden.
     * @return en lista över alla noder på vägen mellan start- och slutnoden. Om
     *         ingen väg finns är listan tom.
     */
    public List<T> breadthFirstSearch(T start, T end) {

    }














    /**
     * Returnerar en ny graf som utgär ett minimalt spännande träd till grafen.
     * Ni kan förutsätta att alla noder ingär i samma graf.
     *
     * @return en graf som representerar ett minimalt spånnande träd.
     */
    public UndirectedGraph<T> minimumSpanningTree() {

    }






}
