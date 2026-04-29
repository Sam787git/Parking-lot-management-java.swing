package parking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ExitVehicle extends JFrame implements ActionListener {

    JTextField vehicleNo;

    public ExitVehicle() {
        setTitle("Exit Vehicle");
        setSize(300,150);
        setLayout(new GridLayout(2,2));

        vehicleNo = new JTextField();
        add(new JLabel("Vehicle No")); add(vehicleNo);

        JButton btn = new JButton("Exit");
        btn.addActionListener(this);
        add(btn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement pst = con.prepareStatement(
                "UPDATE parking SET status='Exited', exit_time=NOW() WHERE vehicle_no=? AND status='Parked'"
            );

            pst.setString(1, vehicleNo.getText());
            int rows = pst.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Vehicle Exited");
            } else {
                JOptionPane.showMessageDialog(this, "Vehicle not found");
            }

            dispose(); new Dashboard();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}