import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static File audiofile;
    public static void main(String[] args) {
        // locate the audio file / song
        Scanner scr = new Scanner(System.in);
        String songName;
        String songPath;
        System.out.print("Is your song in the same folder? (y/n) ");
        String location = scr.nextLine().toUpperCase();
        char c = location.charAt(0);   // more convenience for the user if they accidentally wrote Yes or No

        switch (c)
        {
            case 'Y' ->
            {
                System.out.print("Enter song name.wav: ");
                songName = scr.nextLine();
                audiofile = new File(songName);
            }
            case 'N' ->
            {
                System.out.print("Enter Song Path: ");
                songPath = scr.nextLine();
                audiofile = new File(songPath);
            }
        }
        // Opening audio & audio controls
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audiofile))
        {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            String Choice="";
            while (!Choice.equals("Q"))
            {
                System.out.println("P = Play");
                System.out.println("Q = Quit");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.print("Enter your choice: ");

                Choice = scr.next().toUpperCase();

                switch(Choice)
                {
                    case "P" -> clip.start();
                    case "Q" -> clip.close();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "S" -> clip.stop();
                }
            }
        }
        // Catching possible errors
        catch(FileNotFoundException ef)
        {
            System.out.println("Couldn't Locate File");
        }
        catch(LineUnavailableException e)
        {
            System.out.println("Unable to access audio resource");
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported Audio File");
        }
        catch(IOException e)
        {
            System.out.println("Something Went Wrong");
        }
        finally {
            scr.close();
        }
    }
}

