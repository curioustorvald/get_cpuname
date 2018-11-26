package net.torvald.getcpuname;

/**
 * Created by minjaesong on 2018-11-26.
 */
public class GetCpuNameTest {

    public static void main(String[] args) {
        try {
            System.out.println(System.getProperty("os.name").toUpperCase());

            System.out.print(">>>");
            System.out.print(GetCpuName.getModelName());
            System.out.println("<<<");

            System.out.print(">>>");
            System.out.print(GetCpuName.getCPUID());
            System.out.println("<<<");
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
