package parking;

import javax.swing.*;
import java.sql.*;

public class ViewParking extends JFrame {

    JTextArea area;

    public ViewParking() {
        setTitle("Parking Status");
        setSize(500,300);

        area = new JTextArea();
        add(new JScrollPane(area));

        load();
        setVisible(true);
    }

    void load() {
        try (Connection con = DBConnection.getConnection()) {

            ResultSet rs = con.createStatement().executeQuery(
                "SELECT * FROM parking"
            );

            while (rs.next()) {
                area.append(
                    "Vehicle: " + rs.getString("vehicle_no") +
                    " | Slot: " + rs.getInt("slot_no") +
                    " | Status: " + rs.getString("status") + "\n"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
