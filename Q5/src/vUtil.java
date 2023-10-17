/**Personal utility class of mine
 * I cleaned it up so only the used stuff is in it
 *
 *@version 2.0 (Oct 16th, 2023)
 *@author Steve Mastrokalos   */

public class vUtil {

    /**Creates a line of astriks to create a clean pagebreak
     *
     * @return
     */
    public static String pageBreak(){return pageBreak(true);}

    /**Creates a line of astriks to create a clean pagebreak
     *
     * @param Print Whether or not to print the line of astrisks
     * @return  line of astrisks
     */
    public static String pageBreak(boolean Print){
        String out = "";
        for(int i = 0; i < 30; i++) out += "*";

        if(Print) System.out.println("\n" + out + "\n");

        return out;
    }
}
