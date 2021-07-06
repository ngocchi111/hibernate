package sv18120010.App;

import sv18120010.Current.Current;
import sv18120010.dao.StudentDao;
import sv18120010.dao.TeacherDao;
import sv18120010.dao.SubjectDao;
import sv18120010.hibernate.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.chrono.JapaneseDate;
import java.util.Date;
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

        JLabel title = new JLabel("Đăng Nhập");
        title.setBounds(650,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

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
                    if (item.getState() !=0)
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
        JButton button_GV = new JButton("Danh sách tài khoản giáo vụ");
        JButton button_SV = new JButton("Danh sách sinh viên");
        JButton button_HK = new JButton("Danh Sách học kỳ");
        JButton button_MH = new JButton("Danh sách môn học");
        JButton button_CL = new JButton("Danh sách lớp");
        JButton button_DKHP = new JButton("Danh Sách kỳ đăng ký học phần");
        JButton button_HP = new JButton("Danh sách học phần");
        JButton button_DX = new JButton("Đăng Xuất");

        button_Acc.setBounds(650, 200, 300,30);
        button_GV.setBounds(650, 250, 300,30);
        button_SV.setBounds(650, 300, 300,30);
        button_HK.setBounds(650, 350, 300,30);
        button_MH.setBounds(650, 400, 300,30);
        button_CL.setBounds(650, 450, 300,30);
        button_DKHP.setBounds(650, 500, 300,30);
        button_HP.setBounds(650, 550, 300,30);
        button_DX.setBounds(650, 600, 300,30);

        frame.add(button_Acc);
        frame.add(button_GV);
        frame.add(button_SV);
        frame.add(button_HK);
        frame.add(button_MH);
        frame.add(button_CL);
        frame.add(button_DKHP);
        frame.add(button_HP);
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

        button_GV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                DSGV();
                return;
            }
        });

        button_SV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                DSSV();
                return;
            }
        });

        button_HK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                DSHK();
                return;
            }
        });

        button_MH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                DSMH();
                return;
            }
        });

        button_CL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                DSCL();
                return;
            }
        });

        button_DKHP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                DSDKHP();
                return;
            }
        });

        button_HP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                DSHP();
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

        JLabel title = new JLabel("Thông Tin Cá Nhân");
        title.setBounds(650,100,500,50);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        title.setForeground(Color.orange);
        frame.add(title);

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

        JLabel title = new JLabel("Thay đổi mật khẩu");
        title.setBounds(650,100,500,50);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        title.setForeground(Color.orange);
        frame.add(title);

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

    public void DSHP() {
        frame = settingFrame();

        JButton button_add = new JButton("Thêm Học Phần");
        button_add.setBounds(300,150,200,30);
        frame.add(button_add);

        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                addHP();
            }
        });

        JLabel title = new JLabel("Danh Sách Học Phần");
        title.setBounds(600,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

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
            if (item.getState() != 0){
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

                JButton button = new JButton("Xoá");
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
                        JOptionPane.showMessageDialog(null, "Xoá học phần thành công");
                        frame.setVisible(false);
                        frame.removeAll();
                        item.setState(0);
                        SubjectDao.upHP(item);
                        DSHP();
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

    public void addHP() {
        frame = settingFrame();

        JLabel title = new JLabel("Thêm Học Phần");
        title.setBounds(630,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

        JTextField textField_1 = new JTextField("");
        JTextField textField_2 = new JTextField("");
        JTextField textField_3 = new JTextField("");
        JTextField textField_4 = new JTextField("");
        JTextField textField_5 = new JTextField("");
        JTextField textField_6 = new JTextField("");

        textField_1.setBounds(560,200,200,30);
        textField_2.setBounds(560,250,200,30);
        textField_3.setBounds(560,300,200,30);
        textField_4.setBounds(560,350,200,30);
        textField_5.setBounds(560,400,200,30);
        textField_6.setBounds(560,450,200,30);

        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);
        frame.add(textField_4);
        frame.add(textField_5);
        frame.add(textField_6);

        JLabel label_1 = new JLabel("Mã HP");
        JLabel label_2 = new JLabel("Mã MH");
        JLabel label_3 = new JLabel("Mã GV");
        JLabel label_4 = new JLabel("Mã Lớp");
        JLabel label_5 = new JLabel("Ngày Học");
        JLabel label_6 = new JLabel("Thời Gian Học");

        label_1.setBounds(360,200, 200,30);
        label_2.setBounds(360,250, 200,30);
        label_3.setBounds(360,300, 200,30);
        label_4.setBounds(360,350, 200,30);
        label_5.setBounds(360,400, 200,30);
        label_6.setBounds(360,450, 200,30);

        JLabel label_GC1 = new JLabel("Ngày học: (1->7)->(thứ 2 -> chủ nhật)");
        JLabel label_GC2 = new JLabel("Thời gian học: (1->4)");
        JLabel label_GC3 = new JLabel("    1: ("+timeStudy(1)+"),    2: ("+timeStudy(2)+")");
        JLabel label_GC4 = new JLabel("    3: ("+timeStudy(3)+"),    4: ("+timeStudy(4)+")");

        label_GC1.setBounds(900,300,300,30);
        label_GC2.setBounds(900,350,300,30);
        label_GC3.setBounds(900,400,300,30);
        label_GC4.setBounds(900,450,300,30);

        frame.add(label_1);
        frame.add(label_2);
        frame.add(label_3);
        frame.add(label_4);
        frame.add(label_5);
        frame.add(label_6);
        frame.add(label_GC1);
        frame.add(label_GC2);
        frame.add(label_GC3);
        frame.add(label_GC4);

        JButton button_add = new JButton("Thêm");
        button_add.setBounds(650,520, 100,30);
        frame.add(button_add);

        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Course> courses= SubjectDao.getAllCourse();
                for (Course item: courses)
                    if (item.getIdCourse().equals(textField_1.getText())) {
                        JOptionPane.showMessageDialog(null,"Thêm Thành Công");
                        item.setState(1);
                        item.setIdTeacher(textField_3.getText());
                        item.setIdSubject(textField_2.getText());
                        item.setIdClassroom(textField_4.getText());
                        item.setDay(Integer.parseInt(textField_5.getText()));
                        item.setTime(Integer.parseInt(textField_6.getText()));
                        frame.setVisible(false);
                        frame.removeAll();
                        DSHP();
                        return;
                    }
                JOptionPane.showMessageDialog(null, "Ma HP không khả dụng vui lòng thử 'TD01', 'Toan06',...");
            }
        });

        JButton button_Home = new JButton("Quay lại");
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
                DSHP();
            }
        });

    }

    public void DSMH() {
        frame = settingFrame();

        JButton button_add = new JButton("Thêm Môn Học");
        button_add.setBounds(300,150,200,30);
        frame.add(button_add);

        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                addMH();
            }
        });

        JLabel title = new JLabel("Danh Sách Môn Học");
        title.setBounds(600,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

        JTextField textField_1 = new JTextField("Mã môn học");
        JTextField textField_2 = new JTextField("Tên môn học");
        JTextField textField_3 = new JTextField("Số tín chỉ");
        JTextField textField = new JTextField();
        JTextField textFields = new JTextField();

        textField_1.setBounds(360,200,100,30);
        textField_2.setBounds(460,200,100,30);
        textField_3.setBounds(560,200,100,30);
        textField.setBounds(660,200,100,30);
        textFields.setBounds(760,200,100,30);

        frame.add(textField);
        frame.add(textFields);
        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);

        List<Subject>subjects= SubjectDao.getAllSubject();
        int n=0;
        for (Subject item: subjects){
            if (item.getState() != 0){
                n++;
                JLabel textField1 = new JLabel(item.getIdSubject());
                JTextField textField2 = new JTextField(item.getName());
                JTextField textField3 = new JTextField(String.valueOf(item.getTimeStudy()));

                int p=n*30+200;

                textField1.setBounds(360,p,100,30);
                textField2.setBounds(460,p,100,30);
                textField3.setBounds(560,p,100,30);

                JButton button_delete = new JButton("Xoá");
                button_delete.setBounds(660,p,100,30);
                JButton button_save = new JButton("Lưu");
                button_save.setBounds(760,p,100,30);

                frame.add(textField1);
                frame.add(textField2);
                frame.add(textField3);
                frame.add(button_save);
                frame.add(button_delete);

                button_delete.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Xoá môn học thành công");
                        frame.setVisible(false);
                        frame.removeAll();
                        item.setState(0);
                        DSMH();
                    }
                });
                button_save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Cập nhật môn học thành công");
                        frame.setVisible(false);
                        frame.removeAll();
                        item.setName(textField2.getText());
                        item.setTimeStudy(Integer.parseInt(textField3.getText()));
                        DSMH();
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

    public void addMH() {
        frame = settingFrame();

        JLabel title = new JLabel("Thêm Môn Học");
        title.setBounds(630,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

        JTextField textField_1 = new JTextField("");
        JTextField textField_2 = new JTextField("");
        JTextField textField_3 = new JTextField("");

        textField_1.setBounds(560,200,200,30);
        textField_2.setBounds(560,250,200,30);
        textField_3.setBounds(560,300,200,30);

        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);

        JLabel label_1 = new JLabel("Mã môn học");
        JLabel label_2 = new JLabel("Tên môn học");
        JLabel label_3 = new JLabel("Số tín chỉ");

        label_1.setBounds(360,200, 200,30);
        label_2.setBounds(360,250, 200,30);
        label_3.setBounds(360,300, 200,30);

        frame.add(label_1);
        frame.add(label_2);
        frame.add(label_3);

        JButton button_add = new JButton("Thêm");
        button_add.setBounds(650,520, 100,30);
        frame.add(button_add);

        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Subject> courses= SubjectDao.getAllSubject();
                for (Subject item: courses)
                    if (item.getIdSubject().equals(textField_1.getText())) {
                        JOptionPane.showMessageDialog(null,"Thêm Thành Công");
                        item.setState(1);
                        item.setTimeStudy(Integer.parseInt(textField_3.getText()));
                        item.setName(textField_2.getText());
                        frame.setVisible(false);
                        frame.removeAll();
                        DSMH();
                        return;
                    }
                JOptionPane.showMessageDialog(null, "Ma HP không khả dụng vui lòng thử 'TheDuc', 'VTP',...");
            }
        });

        JButton button_Home = new JButton("Quay lại");
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
                DSMH();
            }
        });

    }

    public void DSGV() {
        frame = settingFrame();

        JLabel title = new JLabel("Danh Sách Tài Khoản Giáo Viên");
        title.setBounds(550,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

        JTextField textField_1 = new JTextField("Tài khoản");
        JTextField textField_2 = new JTextField("Tên Giáo Viên");
        JTextField textField_3 = new JTextField("Mã giáo viên");
        JTextField textField_4 = new JTextField("Khoa");
        JTextField textField_5 = new JTextField("SDT");
        JTextField textField_6 = new JTextField("Địa chỉ");
        JTextField textField = new JTextField();
        JTextField textField_s = new JTextField();

        textField_1.setBounds(360,200,100,30);
        textField_2.setBounds(460,200,100,30);
        textField_3.setBounds(560,200,100,30);
        textField_4.setBounds(660,200,100,30);
        textField_5.setBounds(760,200,100,30);
        textField_6.setBounds(860,200,100,30);
        textField.setBounds(960,200,100,30);
        textField_s.setBounds(1060,200,100,30);

        frame.add(textField);
        frame.add(textField_s);
        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);
        frame.add(textField_4);
        frame.add(textField_5);
        frame.add(textField_6);

        JButton button_add = new JButton("Thêm tài khoản giáo viên");
        button_add.setBounds(300,150,200,30);
        frame.add(button_add);

        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                addGV();
            }
        });

        List<Teacher> teachers = TeacherDao.getAllTeacher();
        List<AccountTeacher> accountTeachers = TeacherDao.getAllAccount();
        int n=0;
        for (Teacher item: teachers) {
            boolean t = false;
            for (AccountTeacher as : accountTeachers){
                if (as.getState() != 0 && item.getIdTeacher().equals(as.getUsername()))
                    t = true;
        }
            if (t){
                n++;
                JTextField textField1 = new JTextField(item.getIdTeacher());
                JTextField textField2 = new JTextField(item.getName());
                JTextField textField3 = new JTextField(item.getIdTeacher());
                JTextField textField4 = new JTextField(item.getFaculty());
                JTextField textField5 = new JTextField(item.getPhone());
                JTextField textField6 = new JTextField(item.getAddress());

                int p = n * 30 + 200;

                textField1.setBounds(360, p, 100, 30);
                textField2.setBounds(460, p, 100, 30);
                textField3.setBounds(560, p, 100, 30);
                textField4.setBounds(660, p, 100, 30);
                textField5.setBounds(760, p, 100, 30);
                textField6.setBounds(860, p, 100, 30);

                JButton button = new JButton("Reset");
                button.setBounds(960, p, 100, 30);
                JButton button_1 = new JButton("Xoá");
                button_1.setBounds(1060, p, 100, 30);

                frame.add(textField1);
                frame.add(textField2);
                frame.add(textField3);
                frame.add(textField4);
                frame.add(textField5);
                frame.add(textField6);
                frame.add(button);
                frame.add(button_1);

                button_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Xoá thành công");
                        frame.setVisible(false);
                        frame.removeAll();
                        for (AccountTeacher as: accountTeachers)
                            if (item.getIdTeacher().equals(as.getUsername()))
                                as.setState(0);
                        DSGV();
                    }
                });

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Reset thành công");
                        frame.setVisible(false);
                        frame.removeAll();
                        for (AccountTeacher as: accountTeachers)
                            if (item.getIdTeacher().equals(as.getUsername()))
                                as.setPassword("222222");
                        DSGV();
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

    public void addGV() {
        frame = settingFrame();

        JLabel title = new JLabel("Danh Sách Giáo Viên Chưa Có Tài Khoản");
        title.setBounds(550,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

        JTextField textField_1 = new JTextField("Tài khoản");
        JTextField textField_2 = new JTextField("Tên Giáo Viên");
        JTextField textField_3 = new JTextField("Mã giáo viên");
        JTextField textField_4 = new JTextField("Khoa");
        JTextField textField_5 = new JTextField("SDT");
        JTextField textField_6 = new JTextField("Địa chỉ");
        JTextField textField = new JTextField();
        JTextField textField_s = new JTextField();

        textField_1.setBounds(360,200,100,30);
        textField_2.setBounds(460,200,100,30);
        textField_3.setBounds(560,200,100,30);
        textField_4.setBounds(660,200,100,30);
        textField_5.setBounds(760,200,100,30);
        textField_6.setBounds(860,200,100,30);
        textField.setBounds(960,200,100,30);
        textField_s.setBounds(1060,200,100,30);

        frame.add(textField);
        frame.add(textField_s);
        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);
        frame.add(textField_4);
        frame.add(textField_5);
        frame.add(textField_6);

        List<Teacher> teachers = TeacherDao.getAllTeacher();
        List<AccountTeacher> accountTeachers = TeacherDao.getAllAccount();
        int n=0;
        for (Teacher item: teachers) {
            boolean t = true;
            for (AccountTeacher as : accountTeachers){
                if (as.getState() != 0 && item.getIdTeacher().equals(as.getUsername()))
                    t = false;
            }
            if (t){
                n++;
                JTextField textField1 = new JTextField(item.getIdTeacher());
                JTextField textField2 = new JTextField(item.getName());
                JTextField textField3 = new JTextField(item.getIdTeacher());
                JTextField textField4 = new JTextField(item.getFaculty());
                JTextField textField5 = new JTextField(item.getPhone());
                JTextField textField6 = new JTextField(item.getAddress());

                int p = n * 30 + 200;

                textField1.setBounds(360, p, 100, 30);
                textField2.setBounds(460, p, 100, 30);
                textField3.setBounds(560, p, 100, 30);
                textField4.setBounds(660, p, 100, 30);
                textField5.setBounds(760, p, 100, 30);
                textField6.setBounds(860, p, 100, 30);

                JButton button = new JButton("Reset");
                button.setBounds(960, p, 100, 30);
                JButton button_1 = new JButton("Thêm");
                button_1.setBounds(1060, p, 100, 30);

                frame.add(textField1);
                frame.add(textField2);
                frame.add(textField3);
                frame.add(textField4);
                frame.add(textField5);
                frame.add(textField6);
                frame.add(button);
                frame.add(button_1);

                button_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                        frame.setVisible(false);
                        frame.removeAll();
                        for (AccountTeacher as: accountTeachers)
                            if (item.getIdTeacher().equals(as.getUsername())) {
                                as.setState(1);
                                as.setPassword("222222");
                            }
                        addGV();
                    }
                });
            }
        }
        JButton button_Home = new JButton("Quay Lại");
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
                DSGV();
            }
        });
    }

    public void DSSV() {
        frame = settingFrame();

        JLabel title = new JLabel("Danh Sách Sinh Viên");
        title.setBounds(600,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

        JTextField textField_1 = new JTextField("MSSV");
        JTextField textField_2 = new JTextField("Tên");
        JTextField textField_3 = new JTextField("Lop");
        JTextField textField_4 = new JTextField("Khoa");
        JTextField textField_5 = new JTextField("SDT");
        JTextField textField_6 = new JTextField("DiaChi");
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

        List<Student> students = StudentDao.getAllStudent();
        int n=0;
        for (Student item: students){
            {
                n++;
                JTextField textField1 = new JTextField(item.getIdStudent());
                JTextField textField2 = new JTextField(item.getName());
                JTextField textField3 = new JTextField(item.getIdclass());
                JTextField textField4 = new JTextField(item.getFaculty());
                JTextField textField5 = new JTextField(item.getPhone());
                JTextField textField6 = new JTextField(item.getAddress());

                int p=n*30+200;

                textField1.setBounds(360,p,100,30);
                textField2.setBounds(460,p,100,30);
                textField3.setBounds(560,p,100,30);
                textField4.setBounds(660,p,100,30);
                textField5.setBounds(760,p,100,30);
                textField6.setBounds(860,p,100,30);

                JButton button = new JButton("reset password");
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
                        JOptionPane.showMessageDialog(null, "Reset mật khẩu thành công");
                        frame.setVisible(false);
                        frame.removeAll();
                        List<AccountStudent> accountStudents = StudentDao.getAllAccount();
                        for (AccountStudent a: accountStudents)
                            if (a.getUsername().equals(item.getIdStudent()))
                                a.setPassword("111111");
                        DSSV();
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

    public void DSCL() {
        frame = settingFrame();

        JLabel title = new JLabel("Danh Sách Lớp");
        title.setBounds(600,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

        JTextField textField_1 = new JTextField("Mã lớp");
        JTextField textField_2 = new JTextField("Tối đa");
        JTextField textField_3 = new JTextField("Số Nam");
        JTextField textField_4 = new JTextField("Số Nữ");
        JTextField textField_5 = new JTextField("Tổng");

        textField_1.setBounds(360,200,100,30);
        textField_2.setBounds(460,200,100,30);
        textField_3.setBounds(560,200,100,30);
        textField_4.setBounds(660,200,100,30);
        textField_5.setBounds(760,200,100,30);

        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);
        frame.add(textField_4);
        frame.add(textField_5);

        List<Classroom> classrooms = SubjectDao.getAllClassroom();
        int n=0;
        for (Classroom item: classrooms){
            {
                n++;
                JTextField textField1 = new JTextField(item.getIdClassroom());
                JTextField textField2 = new JTextField(String.valueOf(item.getLimit()));
                JTextField textField3 = new JTextField(String.valueOf(item.getGirl()));
                JTextField textField4 = new JTextField(String.valueOf(item.getBoy()));
                JTextField textField5 = new JTextField(String.valueOf(item.getBoy()+item.getGirl()));

                int p=n*30+200;

                textField1.setBounds(360,p,100,30);
                textField2.setBounds(460,p,100,30);
                textField3.setBounds(560,p,100,30);
                textField4.setBounds(660,p,100,30);
                textField5.setBounds(760,p,100,30);


                frame.add(textField1);
                frame.add(textField2);
                frame.add(textField3);
                frame.add(textField4);
                frame.add(textField5);
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

    public void DSHK() {
        frame = settingFrame();

        JLabel title = new JLabel("Danh Sách Học Kỳ");
        title.setBounds(600,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

        JTextField textField_1 = new JTextField("Mã Học Kỳ");
        JTextField textField_2 = new JTextField("Tên");
        JTextField textField_3 = new JTextField("Năm");

        textField_1.setBounds(360,200,100,30);
        textField_2.setBounds(460,200,100,30);
        textField_3.setBounds(560,200,100,30);

        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);

        List<Semester> semesters = new SubjectDao().getAllSemester();
        int n=0;
        for (Semester item: semesters){
            {
                n++;
                JTextField textField1 = new JTextField(item.getIdSemester());
                JTextField textField2 = new JTextField(item.getNameSemester());
                JTextField textField3 = new JTextField(String.valueOf(item.getYearStudy()));

                int p=n*30+200;

                textField1.setBounds(360,p,100,30);
                textField2.setBounds(460,p,100,30);
                textField3.setBounds(560,p,100,30);


                frame.add(textField1);
                frame.add(textField2);
                frame.add(textField3);
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

    public void DSDKHP() {
        frame = settingFrame();

        JButton button_add = new JButton("Thêm Kỳ Đăng Ký Học Phần");
        button_add.setBounds(300,150,200,30);
        frame.add(button_add);

        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                addDKHP();
            }
        });

        JLabel title = new JLabel("Danh Sách Kỳ Đăng Ký Học Phần");
        title.setBounds(550,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

        JTextField textField_1 = new JTextField("Mã Kỳ DKHP");
        JTextField textField_2 = new JTextField("Bắt đầu");
        JTextField textField_3 = new JTextField("Kết thúc");

        textField_1.setBounds(360,200,100,30);
        textField_2.setBounds(460,200,100,30);
        textField_3.setBounds(560,200,100,30);

        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);

        List<Dkhpsesion> dkhpsesions = SubjectDao.getAllDkhpsesion();
        int n=0;
        for (Dkhpsesion item: dkhpsesions){
            if (item.getState() != 0){
                n++;
                JTextField textField1 = new JTextField(item.getIdDkhPsesion());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                JTextField textField2 = new JTextField(dateFormat.format(item.getTimeStart()));
                JTextField textField3 = new JTextField(dateFormat.format(item.getTimeEnd()));

                int p=n*30+200;

                textField1.setBounds(360,p,100,30);
                textField2.setBounds(460,p,100,30);
                textField3.setBounds(560,p,100,30);

                frame.add(textField1);
                frame.add(textField2);
                frame.add(textField3);

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

    public void addDKHP() {
        frame = settingFrame();

        JLabel title = new JLabel("Thêm Học Phần");
        title.setBounds(630,100,500,50);
        title.setForeground(Color.orange);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(title);

        JTextField textField_1 = new JTextField("");
        JTextField textField_2 = new JTextField();
        JTextField textField_3 = new JTextField();
        JTextField textField_4 = new JTextField();
        JTextField textField_5 = new JTextField("");
        JTextField textField_6 = new JTextField("");
        JTextField textField_7 = new JTextField("");

        textField_1.setBounds(560,200,200,30);
        textField_2.setBounds(560,250,200,30);
        textField_3.setBounds(560,300,200,30);
        textField_4.setBounds(560,350,200,30);
        textField_5.setBounds(560,400,200,30);
        textField_6.setBounds(560,450,200,30);
        textField_7.setBounds(560,500,200,30);

        frame.add(textField_1);
        frame.add(textField_2);
        frame.add(textField_3);
        frame.add(textField_4);
        frame.add(textField_5);
        frame.add(textField_6);
        frame.add(textField_7);

        JLabel label_1 = new JLabel("Mã Học Kỳ");
        JLabel label_2 = new JLabel("Ngày bắt dầu");
        JLabel label_3 = new JLabel("Tháng bắt đầu");
        JLabel label_4 = new JLabel("Năm bắt đầu");
        JLabel label_5 = new JLabel("Ngày kết thúc");
        JLabel label_6 = new JLabel("Tháng kết thúc");
        JLabel label_7 = new JLabel("Năm kết thúc");

        label_1.setBounds(360,200, 200,30);
        label_2.setBounds(360,250, 200,30);
        label_3.setBounds(360,300, 200,30);
        label_4.setBounds(360,350, 200,30);
        label_5.setBounds(360,400, 200,30);
        label_6.setBounds(360,450, 200,30);
        label_7.setBounds(360,500, 200,30);

        frame.add(label_1);
        frame.add(label_2);
        frame.add(label_3);
        frame.add(label_4);
        frame.add(label_5);
        frame.add(label_6);
        frame.add(label_7);

        JButton button_add = new JButton("Thêm");
        button_add.setBounds(650,550, 100,30);
        frame.add(button_add);

        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Dkhpsesion> dkhpsesions = SubjectDao.getAllDkhpsesion();
                for (Dkhpsesion item: dkhpsesions)
                    if (item.getIdDkhPsesion().equals(textField_1.getText()) && item.getState() ==0 ) {
                        JOptionPane.showMessageDialog(null,"Thêm Thành Công");
                        item.setState(1);
                        try {
                            //DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                            String timeStart = textField_4.getText() + "-" + textField_3.getText() + "-" + textField_2.getText();
                            Date simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd").parse(timeStart);
                            item.setTimeStart((java.sql.Date) simpleDateFormat1);
                            String timeEnd = textField_7.getText() + "-" + textField_6.getText() + "-" + textField_5.getText();
                            simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd").parse(timeEnd);
                            item.setTimeEnd((java.sql.Date) simpleDateFormat1);
                            frame.setVisible(false);
                            frame.removeAll();
                            DSDKHP();
                            return;
                            //item.setTimeStart(new SimpleDateFormat("yyyy-mm-dd").parse(timeStart));
                            //item.setTimeEnd(simpleDateFormat.parse(timeEnd));
                        } catch (ParseException parseException) {
                            parseException.printStackTrace();
                        }
                        frame.setVisible(false);
                        frame.removeAll();
                        DSDKHP();
                        return;
                    }
                JOptionPane.showMessageDialog(null, "Ma HP không khả dụng vui lòng thử 'HK3-21-L1',...");
            }
        });

        JButton button_Home = new JButton("Quay lại");
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
                DSDKHP();
            }
        });

    }

    public void run(){
        signIn("");
    }
}
