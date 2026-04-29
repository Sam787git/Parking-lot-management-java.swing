package parking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ParkVehicle extends JFrame implements ActionListener {

    JTextField vehicleNo;

    public ParkVehicle() {
        setTitle("Park Vehicle");
        setSize(300,150);
        setLayout(new GridLayout(2,2));

        vehicleNo = new JTextField();

        add(new JLabel("Vehicle No")); add(vehicleNo);

        JButton btn = new JButton("Park");
        btn.addActionListener(this);
        add(btn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try (Connection con = DBConnection.getConnection()) {

            // assign next slot
            ResultSet rs = con.createStatement().executeQuery(
                "SELECT MAX(slot_no) FROM parking"
            );

            int slot = 1;
            if (rs.next() && rs.getInt(1) != 0) {
                slot = rs.getInt(1) + 1;
            }

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO parking (vehicle_no, slot_no, status) VALUES (?, ?, 'Parked')"
            );

            pst.setString(1, vehicleNo.getText());
            pst.setInt(2, slot);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Parked at Slot: " + slot);
            dispose(); new Dashboard();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
