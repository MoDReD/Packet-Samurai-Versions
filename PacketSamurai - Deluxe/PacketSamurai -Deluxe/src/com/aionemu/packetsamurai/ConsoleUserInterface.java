/**
 * 
 */
package com.aionemu.packetsamurai;

import java.awt.SplashScreen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Ulysses R. Ribeiro
 *
 */
public class ConsoleUserInterface implements IUserInterface
{

    public ConsoleUserInterface()
    {
        SplashScreen.getSplashScreen().close();
    }
    
    public void log(String text)
    {
    	log(text, false);
    }
    public void log(String text, boolean display)
    {
    	if (display)
    		System.out.println(text);
        
        try {
			File outFile = new File("log.txt");
			
			// input
			FileInputStream fis  = new FileInputStream("log.txt");
			BufferedReader in = new BufferedReader
			    (new InputStreamReader(fis));
			
			// output         
			FileOutputStream fos = new FileOutputStream(outFile);
			PrintWriter out = new PrintWriter(fos);
			
			String thisLine = "";
			
			while ((thisLine = in.readLine()) != null) {
			  out.println(thisLine);
			}
			out.println("text");
			
			out.flush();
			out.close();
			in.close();
        } catch (Exception e) {
			System.out.println(e.toString());
		}
    }
    
    public void close()
    {
        PacketSamurai.saveConfig();
    }
}
