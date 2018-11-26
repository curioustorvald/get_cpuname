package net.torvald.getcpuname;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A simple set of commands to get CPU's name (e.g. Intel (R) Core(TM) i7-6700K ...) and manufacturer (e.g. GenuineIntel)
 *
 * Created by minjaesong on 2018-11-26.
 */
public class GetCpuName {

    private static final int LINUX = 0;
    private static final int WIN = 1;
    private static final int OSX = 2;

    private static int getOS() {
        String OS = System.getProperty("os.name").toUpperCase();
        if (OS.contains("WIN")) {
            return WIN;
        }
        else if (OS.contains("OS X")) {
            return OSX;
        }
        else {
            return LINUX;
        }
    }

    public static String getModelName() throws IOException {
        String lineRead;
        String returnLine = "";
        BufferedReader br;
        boolean lineFound = false;

        switch (getOS()) {
            case WIN:
                br = runCmdAndGetReader("wmic cpu get name");

                // actually try to read
                while ( (lineRead = br.readLine()) != null) {
                    lineRead = lineRead.trim(); // strings are somehow shit dirty
                    // only keep the longest readLine, this is a rule of thumb
                    if (!lineRead.startsWith("Name") && lineRead.length() > returnLine.length()) {
                        returnLine = lineRead;
                    }
                }

                br.close();
                return returnLine;
            case LINUX:
                br = runCmdAndGetReader("cat /proc/cpuinfo | grep 'model name'");

                // actually try to read
                while ( (lineRead = br.readLine()) != null) {
                    // filter line "model name    : ........"
                    if (lineRead.startsWith("model name")) {
                        while (!lineRead.startsWith(":")) {
                            lineRead = lineRead.substring(1);
                        } // slowly drop a char from the beginning until we see ':'

                        lineRead = lineRead.substring(2); // drop ': '
                        lineFound = true;
                        break;
                    }
                }

                br.close();

                if (!lineFound) throw new InternalError();

                return lineRead;
            case OSX:
                br = runCmdAndGetReader("sysctl -a | grep machdep.cpu.brand_string");

                // actually try to read
                while ( (lineRead = br.readLine()) != null) {
                    // filter line "model name    : ........"
                    if (lineRead.startsWith("machdep.cpu.brand_string")) {
                        while (!lineRead.startsWith(":")) {
                            lineRead = lineRead.substring(1);
                        } // slowly drop a char from the beginning until we see ':'

                        lineRead = lineRead.substring(2); // drop ': '
                        lineFound = true;
                        break;
                    }
                }

                br.close();

                if (!lineFound) throw new InternalError();

                return lineRead;
        }

        return "InternalError";
    }

    public static String getCPUID() throws IOException {
        String lineRead;
        String returnLine = "";
        BufferedReader br;
        boolean lineFound = false;

        switch (getOS()) {
            case WIN:
                br = runCmdAndGetReader("wmic cpu get manufacturer");

                // actually try to read
                while ( (lineRead = br.readLine()) != null) {
                    lineRead = lineRead.trim(); // strings are somehow shit dirty
                    // only keep the longest readLine, this is a rule of thumb
                    if (!lineRead.startsWith("Manufacturer") && lineRead.length() > returnLine.length()) {
                        returnLine = lineRead;
                    }
                }

                br.close();
                return returnLine;
            case LINUX:
                br = runCmdAndGetReader("cat /proc/cpuinfo | grep 'vendor_id'");

                // actually try to read
                while ( (lineRead = br.readLine()) != null) {
                    // filter line "vendor_id    : ........"
                    if (lineRead.startsWith("vendor_id")) {
                        while (!lineRead.startsWith(":")) {
                            lineRead = lineRead.substring(1);
                        } // slowly drop a char from the beginning until we see ':'

                        lineRead = lineRead.substring(2); // drop ': '
                        lineFound = true;
                        break;
                    }
                }

                br.close();

                if (!lineFound) throw new InternalError();

                return lineRead;
            case OSX:
                br = runCmdAndGetReader("sysctl -a | grep machdep.cpu.vendor");

                // actually try to read
                while ( (lineRead = br.readLine()) != null) {
                    // filter line "model name    : ........"
                    if (lineRead.startsWith("machdep.cpu.vendor")) {
                        while (!lineRead.startsWith(":")) {
                            lineRead = lineRead.substring(1);
                        } // slowly drop a char from the beginning until we see ':'

                        lineRead = lineRead.substring(2); // drop ': '
                        lineFound = true;
                        break;
                    }
                }

                br.close();

                if (!lineFound) throw new InternalError();

                return lineRead;
        }

        return "InternalError";
    }

    private static BufferedReader runCmdAndGetReader(String cmd) throws IOException {
        Process p = Runtime.getRuntime().exec(cmd);
        InputStreamReader ir = new InputStreamReader(p.getInputStream());
        BufferedReader br = new BufferedReader(ir);

        return br;
    }

}
