package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;

public class CarRace {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();

        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setSize(500,300);
        frame.setVisible(true);
        JFrame frame2 = new JFrame("Semaphore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SemaphorePanel semaphorePanel = new SemaphorePanel();

        frame2.getContentPane().add(semaphorePanel);
        frame2.pack();
        frame2.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);



        semaphoreThread.start();

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

class Car extends Thread {
    private String name;
    private int distance = 0;
    private CarPanel carPanel;

    public static int carsFinish=0;
    SemaphoreThread semaphoreThread;
    public Car(String name, CarPanel carPanel, SemaphoreThread semaphoreThread) {
        //set thread name;
        this.semaphoreThread=semaphoreThread;
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
    }

    public void run() {
        while (distance < 400) {
            try {
                // pause for a moment to simulate the passage of time
                if(semaphoreThread!=null){
                    semaphoreThread.join();
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // simulate the car moving at a random speed
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;

            carPanel.updateCarPosition(name, distance);

        }
        carPanel.carFinished(name);
    }

}

class CarPanel extends JPanel {


    private int[] carPositions;
    private String[] carNames;
    private Color[] carColors;

    public CarPanel() {
        carPositions = new int[4];
        carNames = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
        carColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 4; i++) {
            int yPos = 50 + i * 50; // Vertical position of the car
            int xPos = carPositions[i]; // Horizontal position of the car
            int carSize = 30; // Size of the car

            g.setColor(carColors[i]);
            g.fillOval(xPos, yPos, carSize, carSize);
            g.setColor(Color.BLACK);
            g.drawString(carNames[i], xPos, yPos - 5);
        }
    }

    public void updateCarPosition(String carName, int distance) {
        int carIndex = getCarIndex(carName);
        if (carIndex != -1) {
            carPositions[carIndex] = distance;
            repaint();
        }
    }

    public void carFinished(String carName) {
        System.out.println("Car finished race.");
    }

    private int getCarIndex(String carName) {
        for (int i = 0; i < 4; i++) {
            if (carNames[i].equals(carName)) {
                return i;
            }
        }
        return -1;
    }
}
