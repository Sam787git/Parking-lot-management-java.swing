package parking;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Parking Lot System");
        setSize(600,300);
        setLayout(new FlowLayout());

        JButton park = new JButton("Park Vehicle");
        JButton view = new JButton("View Parking");
        JButton exit = new JButton("Exit Vehicle");

        add(park);
        add(view);
        add(exit);

        park.addActionListener(e -> new ParkVehicle());
        view.addActionListener(e -> new ViewParking());
        exit.addActionListener(e -> new ExitVehicle());

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
