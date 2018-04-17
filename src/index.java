/**
 * @author Huy
 */
public class index {
    public static void main(String[] args) {
        String[] abc = new String[3];
        Set<String> a = new Set<>(abc);
        a.set(0, "huy");
        a.set(1, "HUYHUY");
        System.out.println(a.toString());
        PC p = new PC("ACER", 1995, "Intel", a);
        PC[] pcpro = new PC[1];
        Set<PC> pcp = new Set<>(pcpro);
        pcp.set(0, p);

        System.out.println(pcp.toString());
    }
}
