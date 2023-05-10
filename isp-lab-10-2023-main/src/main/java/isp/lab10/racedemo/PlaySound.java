/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab10.racedemo;

import java.io.File;
import javax.sound.sampled.*;

/**
 *
 * @author mihai
 */
public class PlaySound extends Thread{

    private Clip clip;
    boolean sound;
    public PlaySound() {

    }

    public void startSound() {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(".\\shanghai-formula-1-grand-prix.wav")));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {



    }
    public void stopSound(){
        if(clip!=null)
            clip.stop();
        sound=false;
    }
    
    public static void main(String[] args) throws InterruptedException {
        PlaySound ps = new PlaySound();
        ps.startSound();
        Thread.sleep(15000);
        ps.stopSound();
    }
}
