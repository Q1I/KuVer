/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuver.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author q1
 */
public class BackupTest {

    /**
     * Execute shellCmd
     *
     * @param cmd
     * @return 0 = success, 1 = fail
     */
    public static int executeShellCmd(String cmd) {
        System.out.println("Execute Shell Command: " + cmd);
        int exitValue = 1;
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(new String[]{"cmd", "/c", cmd});
//            cmd /c start cmd.exe
//            Process process = runtime.exec(new String[]{"mysqldump", "-udave","-p1234qwer","KuVer",">","bllaa.sql"});
            exitValue = process.waitFor();
            System.out.println("exit value: " + exitValue);
            BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = buf.readLine()) != null) {
                System.out.println("exec response: " + line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return exitValue;
    }

//    public static void main(String args[]) {
//        executeShellCmd("mysqldump -udave -p1234qwer KuVer > backup/chickenwingssss.sql");
//    }
}
