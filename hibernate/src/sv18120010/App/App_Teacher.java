package sv18120010.App;

import sv18120010.Current.Current;
import sv18120010.dao.TeacherDao;
import sv18120010.dao.SubjectDao;
import sv18120010.hibernate.AccountTeacher;
import sv18120010.hibernate.Course;
import sv18120010.hibernate.DKHP;
import sv18120010.hibernate.Teacher;

import java.time.chrono.JapaneseDate;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App_Teacher {

    private JFrame frame = new JFrame();
    private static String username = "";
    private static String password = "";
    private static String idAcc="";

    public JFrame settingFrame() {
        JFrame frame_set = new JFrame();
        frame_set.setTitle("Quan Ly Sinh Vien");
        frame_set.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_set.setSize(1500, 750);
        frame_set.setLayout(null);
        return frame_set;
    }

    public void signIn(String Error) {
        frame = settingFrame();
        JTextField textUser = new JTextField();
        JPasswordField textPass = new JPasswordField();
        textUser.setBounds(650, 250, 200, 30);
        textPass.setBounds(650, 350, 200, 30);
        frame.add(textUser);
        frame.add(textPass);
        JButton buttonSignIn = new JButton("Đăng Nhập");
        buttonSignIn.setBounds(650, 450, 200, 30);
        frame.add(buttonSignIn);

        JButton buttonBack = new JButton("Trở Lại");
        buttonBack.setBounds(650, 550, 200, 30);
        frame.add(buttonBack);

        JLabel label = new JLabel(Error);
        label.setBounds(620, 400, 260, 30);
        frame.add(label);
        JLabel label_1 = new JLabel("Tên Đăng Nhập");
        label_1.setBounds(550, 250, 100, 30);
        frame.add(label_1);
        JLabel label_2 = new JLabel("Mật khẩu");
        label_2.setBounds(550, 350, 100, 30);
        frame.add(label_2);
        JPanel panel = new JPanel();
        panel.setBounds(200, 50, 1100, 650);
        panel.setBackground(Color.blue);
        frame.add(panel);
        frame.setVisible(true);
        buttonSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                List<AccountTeacher> accountTeachers = TeacherDao.getAllAccount();
                for (AccountTeacher item : accountTeachers)
                    if (item.getUsername().equals(textUser.getText()) && item.getPassword().equals(textPass.getText())) {
                        frame.setVisible(false);
                        frame.removeAll();
                        username = item.getUsername();
                        password = item.getPassword();
                        idAcc = item.getIdAccount();
                        Home();
                        return;
                    }
                signIn("Tên tài khoản hoặc mật khẩu không chính xác");
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                App a = new App();
                a.run();
            }
        });
    }
    public void Home(){
        frame = settingFrame();
        JPanel panel = new JPanel();
        panel.setBounds(200,50,1100,650);
        panel.setBackground(Color.blue);
        JButton button_Acc = new JButton("Thông Tin Cá Nhân");
        JButton button_DK = new JButton("Đăng Ký Học Phần");
        JButton button_LS = new JButton("Lịch Sử Đăng Ký Học Phần");
        JButton button_DX = new JButton("Đăng Xuất");
        button_Acc.setBounds(650, 200, 260, 30);
        button_DK.setBounds(650, 300, 260, 30);
        button_LS.setBounds(650, 400, 260, 30);
        button_DX.setBounds(650,500,260,30);
        frame.add(button_Acc);
        frame.add(button_DK);
        frame.add(button_LS);
        frame.add(button_DX);
        frame.add(panel);
        frame.setVisible(true);
        button_Acc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                Account();
                return;
            }
        });
        button_DK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                DKHP();
                return;
            }
        });
        button_LS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                lsDKHP();
                return;
            }
        });
        button_DX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                App x = new App();
                x.run();
                return;
            }
        });
    }

    public void Account(){
        frame = settingFrame();
        Teacher st = TeacherDao.getTeacher(username);
        JLabel textField_1 = new JLabel(st.getIdTeacher());
        JTextField textField_2 = new JTextField(st.getName());
        JTextField textField_3 = new JTextField(st.getFaculty());
        JTextField textField_4 = new JTextField(st.getAddress());
        JTextField textField_5 = new JTextField(st.getPhone());

        JLabel label_1 = new JLabel("Mã Giáo Viên");
        JLabel label_2 = new JLabel("Họ và tên");
        JLabel label_3 = new JLabel("Khoa");
        JLabel label_4 = new JLabel("Điện thoại");
        JLabel label_5 = new JLabel("Địa chỉ");

        JButton button_DKM = new JButton("Đổi Mật Khẩu");
        JButton button_Luu = new JButton("Lưu Thay Đổi");

        textField_1.setBounds(650,200,300,30);
        textField_2.setBounds(650,250,300,30);
        textField_3.setBounds(650,300,300,30);
        textField_4.setBounds(650,350,300,30);
        textField_5.setBounds(650,400,300,30);

        label_1.setBounds(550,200,100,30);
        label_2.setBounds(550,250,100,30);
        label_3.setBounds(550,300,100,30);
        label_4.setBounds(550,350,100,30);
        label_5.setBounds(550,400,100,30);

        button_DKM.setBounds(650,600,200,30);
        button_Luu.setBounds(650,550,200,30);

        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);
        frame.add(textField_4);
        frame.add(textField_5);

        frame.add(label_1);
        frame.add(label_2);
        frame.add(label_3);
        frame.add(label_4);
        frame.add(label_5);

        frame.add(button_DKM);
        frame.add(button_Luu);

        JButton button_Home = new JButton("Home");
        button_Home.setBounds(650,670, 100,30);
        frame.add(button_Home);

        JPanel panel = new JPanel();
        panel.setBounds(200,50,1100,650);
        panel.setBackground(Color.blue);
        frame.add(panel);
        frame.setVisible(true);

        button_DKM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                rePassWord("");
            }
        });

        button_Luu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                st.setName(textField_2.getText());
                st.setFaculty(textField_3.getText());
                st.setPhone(textField_4.getText());
                st.setAddress(textField_5.getText());
                TeacherDao.updateTeacher(st);
                JOptionPane.showMessageDialog(null,"Lưu thành công");
                frame.setVisible(false);
                frame.removeAll();
                Home();
            }
        });

        button_Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                Home();
            }
        });
    }

    public void rePassWord(String Error) {
        frame=settingFrame();
        AccountTeacher accountTeacher = TeacherDao.getAccount(idAcc);
        JPasswordField textPass = new JPasswordField();
        JPasswordField rePass = new JPasswordField();
        JPasswordField comfirm = new JPasswordField();
        textPass.setBounds(650,250,200,30);
        rePass.setBounds(650,300,200,30);
        comfirm.setBounds(650,350,200,30);
        frame.add(textPass);
        frame.add(rePass);
        frame.add(comfirm);
        JButton buttonComfirm= new JButton("Xác nhận");
        buttonComfirm.setBounds(650,450,200,30);
        frame.add(buttonComfirm);
        JLabel label = new JLabel(Error);
        label.setBounds(620,400,260,30);
        frame.add(label);
        JLabel label_1 = new JLabel("Mật khẩu cũ");
        label_1.setBounds(500,250,100,30);
        frame.add(label_1);
        JLabel label_2 = new JLabel("Mật khẩu mới");
        label_2.setBounds(500,300,100,30);
        frame.add(label_2);
        JLabel label_3 = new JLabel("Xác nhận mật khẩu mới");
        label_3.setBounds(500,350,150,30);
        frame.add(label_3);

        JButton button_Home = new JButton("Home");
        button_Home.setBounds(650,670, 100,30);
        frame.add(button_Home);

        JPanel panel = new JPanel();
        panel.setBounds(200,50,1100,650);
        panel.setBackground(Color.blue);
        frame.add(panel);
        frame.setVisible(true);
        buttonComfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (password.equals(textPass.getText())) {
                    if (rePass.getText().equals(comfirm.getText())) {
                        JOptionPane.showMessageDialog(null, "Thay đổi mật khẩu thành công");
                        frame.setVisible(false);
                        frame.removeAll();
                        password=rePass.getText();
                        accountTeacher.setPassword(password);
                        TeacherDao.updateAccount(accountTeacher);
                        Home();
                        return;
                    }
                    else {
                        frame.setVisible(false);
                        frame.removeAll();
                        rePassWord("Mật khẩu mới không khớp");
                        return;
                    }
                }
                frame.setVisible(false);
                frame.removeAll();
                rePassWord("Mật khẩu cũ không chính xác");
                return;
            }
        });

        button_Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                Home();
            }
        });
    }

    String timeStudy(int x)
    {
        if (x==1)
            return "7:30 – 9:30";
        if (x==2)
            return "9:30 – 11:30";
        if (x==3)
            return "13:30 – 15:30";
        return "15:30 – 17:30";
    }

    public void DKHP() {
        frame = settingFrame();

        JTextField textField_1 = new JTextField("Mã HP");
        JTextField textField_2 = new JTextField("Mã môn học");
        JTextField textField_3 = new JTextField("Mã giáo viên");
        JTextField textField_4 = new JTextField("Mã lớp học");
        JTextField textField_5 = new JTextField("Ngày hoc");
        JTextField textField_6 = new JTextField("Thời gian học");
        JTextField textField = new JTextField();

        textField_1.setBounds(360,200,100,30);
        textField_2.setBounds(460,200,100,30);
        textField_3.setBounds(560,200,100,30);
        textField_4.setBounds(660,200,100,30);
        textField_5.setBounds(760,200,100,30);
        textField_6.setBounds(860,200,100,30);
        textField.setBounds(960,200,100,30);

        frame.add(textField);
        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);
        frame.add(textField_4);
        frame.add(textField_5);
        frame.add(textField_6);

        List<Course> courses= null;
        courses = SubjectDao.getAllCourse();
        int n=0;
        for (Course item: courses){
            if (SubjectDao.isDKHP(item.getIdCourse(), username)){
                n++;
                JTextField textField1 = new JTextField(item.getIdCourse());
                JTextField textField2 = new JTextField(item.getIdSubject());
                JTextField textField3 = new JTextField(item.getIdTeacher());
                JTextField textField4 = new JTextField(item.getIdClassroom());
                JTextField textField5 = new JTextField("T"+String.valueOf(item.getDay()+1));
                JTextField textField6 = new JTextField(timeStudy(item.getTime()));

                int p=n*30+200;

                textField1.setBounds(360,p,100,30);
                textField2.setBounds(460,p,100,30);
                textField3.setBounds(560,p,100,30);
                textField4.setBounds(660,p,100,30);
                textField5.setBounds(760,p,100,30);
                textField6.setBounds(860,p,100,30);

                JButton button = new JButton("Đăng ký");
                button.setBounds(960,p,100,30);

                frame.add(textField1);
                frame.add(textField2);
                frame.add(textField3);
                frame.add(textField4);
                frame.add(textField5);
                frame.add(textField6);
                frame.add(button);

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (SubjectDao.total_HP(username) < 8) {
                            JOptionPane.showMessageDialog(null, "Đăng ký học phần thành công");
                            frame.setVisible(false);
                            frame.removeAll();
                            DKHP dkhp = SubjectDao.getDKHP(Current.currentSemester.getIdSemester() + "-" + item.getIdTeacher());
                            if (dkhp != null)
                                dkhp.setIdSemester(Current.currentSemester.getIdSemester());
                            SubjectDao.addDKHP(dkhp, item.getIdClassroom());
                            DKHP();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Bạn chỉ có thể đăng ký tối đa 8 học phần");
                            frame.setVisible(false);
                            frame.removeAll();
                            DKHP();
                        }
                    }
                });

            }
        }
        JButton button_Home = new JButton("Home");
        button_Home.setBounds(650,670, 100,30);
        frame.add(button_Home);

        JPanel panel = new JPanel();
        panel.setBounds(200,50,1100,650);
        panel.setBackground(Color.blue);
        frame.add(panel);
        frame.setVisible(true);

        button_Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                Home();
            }
        });

    }

    public void lsDKHP() {
        frame = settingFrame();

        JTextField textField_1 = new JTextField("Mã HP");
        JTextField textField_2 = new JTextField("Mã môn học");
        JTextField textField_3 = new JTextField("Mã giáo viên");
        JTextField textField_4 = new JTextField("Mã lớp học");
        JTextField textField_5 = new JTextField("Ngày hoc");
        JTextField textField_6 = new JTextField("Thời gian học");
        JTextField textField = new JTextField();

        textField_1.setBounds(360,200,100,30);
        textField_2.setBounds(460,200,100,30);
        textField_3.setBounds(560,200,100,30);
        textField_4.setBounds(660,200,100,30);
        textField_5.setBounds(760,200,100,30);
        textField_6.setBounds(860,200,100,30);
        textField.setBounds(960,200,150,30);

        frame.add(textField);
        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);
        frame.add(textField_4);
        frame.add(textField_5);
        frame.add(textField_6);

        List<Course> courses= null;
        courses = SubjectDao.getAllCourse();
        int n=0;
        if (courses.size() > 0)
            for (Course item: courses){
                if (SubjectDao.isLsDKHP(item.getIdCourse(), username)){
                    n++;
                    JTextField textField1 = new JTextField(item.getIdCourse());
                    JTextField textField2 = new JTextField(item.getIdSubject());
                    JTextField textField3 = new JTextField(item.getIdTeacher());
                    JTextField textField4 = new JTextField(item.getIdClassroom());
                    JTextField textField5 = new JTextField("T"+String.valueOf(item.getDay()+1));
                    JTextField textField6 = new JTextField(timeStudy(item.getTime()));

                    int p=n*30+200;

                    textField1.setBounds(360,p,100,30);
                    textField2.setBounds(460,p,100,30);
                    textField3.setBounds(560,p,100,30);
                    textField4.setBounds(660,p,100,30);
                    textField5.setBounds(760,p,100,30);
                    textField6.setBounds(860,p,100,30);

                    JButton button = new JButton("Huỷ đăng ký");
                    button.setBounds(960,p,150,30);

                    frame.add(textField1);
                    frame.add(textField2);
                    frame.add(textField3);
                    frame.add(textField4);
                    frame.add(textField5);
                    frame.add(textField6);
                    frame.add(button);

                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null, "Huỷ ký học phần thành công");
                            frame.setVisible(false);
                            frame.removeAll();
                            List<DKHP> dkhps = SubjectDao.dkhps();
                            DKHP dkhp = SubjectDao.getDKHP(Current.currentSemester.getIdSemester()+"-"+item.getIdTeacher());
                            dkhp.setIdSemester("HK1-21");
                            SubjectDao.subDKHP(dkhp,item.getIdClassroom());
                            lsDKHP();
                        }
                    });

                }
            }
        JButton button_Home = new JButton("Home");
        button_Home.setBounds(650,670, 100,30);
        frame.add(button_Home);

        JPanel panel = new JPanel();
        panel.setBounds(200,50,1100,650);
        panel.setBackground(Color.blue);
        frame.add(panel);
        frame.setVisible(true);

        button_Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                Home();
            }
        });
    }

    public void run(){
        signIn("");
        //DKHP();
    }
}
