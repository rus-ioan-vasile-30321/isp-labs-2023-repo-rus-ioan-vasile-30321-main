package isp.lab10.raceapp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Race!");
        JFrame frame = new JFrame("Semaphore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SemaphorePanel semaphorePanel = new SemaphorePanel();

        frame.getContentPane().add(semaphorePanel);
        frame.pack();
        frame.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();


        frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();

        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setBounds(300,0,500,300);
        frame.setVisible(true);
        JFrame frame2 = new JFrame("Semaphore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Car car1 = new Car("Red car", carPanel,semaphoreThread);
        Car car2 = new Car("Blue car", carPanel,semaphoreThread);
        Car car3 = new Car("Green car", carPanel,semaphoreThread);
        Car car4 = new Car("Yellow car", carPanel,semaphoreThread);

        car1.start();
        car2.start();
        car3.start();
        car4.start();



    }
}
