package adminpage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class calendar extends JFrame {
     private List<String> appointments;

    private JTextField dateField;
    private JTextField appointmentField;

    public calendar() {
        appointments = new ArrayList<>();

        setTitle("Appointment Calendar");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel dateLabel = new JLabel("Date:");
        panel.add(dateLabel);        Component dateField = new JTextField();
        panel.add(dateField);

        JLabel appointmentLabel = new JLabel("Appointment:");
        panel.add(appointmentLabel);
        appointmentField = new JTextField();
        panel.add(appointmentField);

        JButton addButton = new JButton("Add Appointment");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                Toolkit date = dateField.getToolkit();
                String appointment = appointmentField.getText();

                if (appointment.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter an appointment.");
                    return;
                }

                appointments.add(appointment);
                JOptionPane.showMessageDialog(null, "Appointment added successfully.");
            }
        });
        panel.add(addButton);

        JButton viewButton = new JButton("View Appointments");
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder appointmentsText = new StringBuilder("Appointments:\n");
                for (String appointment : appointments) {
                    appointmentsText.append(appointment).append("\n");
                }
                JOptionPane.showMessageDialog(null, appointmentsText.toString());
            }
        });
        panel.add(viewButton);

        add(panel);
        setVisible(true);
    }
}