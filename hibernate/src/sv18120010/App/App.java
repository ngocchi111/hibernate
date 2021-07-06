package sv18120010.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    private JFrame frame = new JFrame();

    public JFrame settingFrame(){
        JFrame frame_set = new JFrame();
        frame_set.setTitle("Quan Ly Sinh Vien");
        frame_set.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_set.setSize(1500, 750);
        frame_set.setLayout(null);
        return frame_set;
    }

    public void run(){
        frame = settingFrame();
        JButton button_Student = new JButton("Sinh Viên");
        button_Student.setBounds(650, 250, 200, 30);
        frame.add(button_Student);
        JButton button_Teacher = new JButton("Giáo Vụ");
        button_Teacher.setBounds(650, 400, 200, 30);
        frame.add(button_Teacher);
        JPanel panel = new JPanel();
        panel.setBounds(200,50,1100,650);
        panel.setBackground(Color.blue);
        frame.add(panel);
        frame.setVisible(true);
        button_Student.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                App_Student appStudent = new App_Student();
                appStudent.run();
            }
        });
        button_Teacher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                App_Teacher appTeacher = new App_Teacher();
                appTeacher.run();
            }
        });
    }
}
