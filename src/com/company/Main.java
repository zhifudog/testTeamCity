package com.company;

import java.io.*;
import java.net.*;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        URL url = null;
        URLConnection urlConnection = null;
        BufferedReader br  = null;
        PrintWriter pw = null;
        String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";
        try {

            url = new URL("https://bbs.csdn.net/topics/390765699");
            urlConnection = url.openConnection();
            pw = new PrintWriter(new FileWriter("D:/taobaoUrl111.txt"),true);
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Pattern p = Pattern.compile(regex);
            String buff = null;
            while((buff = br.readLine()) != null)
            {
                Matcher mat_m = p.matcher(buff);
                while(mat_m.find()){
                    pw.println(mat_m.group());
                }
            }
            System.out.print("worm sucuess");
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            pw.close();
        }

    }
}
