package dns;

/**
 * @author Jorge Silva Borda
 */
public class Main {

    public static void main(String[] args) {
        Ipfy ip = new Ipfy();
        while(true){
            System.out.println(ip.getIp());
        }
    }
}
