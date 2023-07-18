import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class Client {
    static JFrame mainWindow=new JFrame("Client");
    static JScrollPane FirstscrollPane=new JScrollPane();
    static JScrollPane SecondscrollPane=new JScrollPane();
    static JScrollPane ThirdscrollPane=new JScrollPane();
    static String courses[] = { "Customer","Order","Good"};
    static ArrayList<Customer> customers =new ArrayList<>();
    static ArrayList<Order> orders =new ArrayList<>();
    static ArrayList<Good> goods =new ArrayList<>();
    static JDBCPostgreSQLExample podklForsas=null;

    public static void main(String[] args) {
       Display();
    }

    private static void Display(){
        SettingWindows(mainWindow);
        CreateMenuButton();
        CreateComboBox();
    }

    private static void SettingWindows(JFrame v){
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLayout(null);
        v.setSize(1200,900);
        v.setVisible(true);
    }

    private static void CreateMenuButton(){
       ButtonForConnectServer();
       ButtonForUpdate();
       ProcButton();
    }

    private static void ButtonForConnectServer(){
        JButton connectForServer=new JButton("Присоединиться");
        connectForServer.setBounds(0,0,200,50);
        connectForServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBCPostgreSQLExample podklForsas= new JDBCPostgreSQLExample();
            }
        });
        mainWindow.add(connectForServer);
    }

    private static void ButtonForUpdate(){
        JButton updateForServer=new JButton("Обновить");
        updateForServer.setBounds(0,50  ,200,50);
        updateForServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateFirstscrollPane();
                UpdateSecondScrollPane();
                UpdateThirdscrollPane();
            }
        });
        mainWindow.add(updateForServer);
    }

    private static void UpdateFirstscrollPane(){
        while(customers.size()!=0){
            FirstscrollPane.remove(customers.size()-1);
            customers.remove(customers.size()-1);
        }
        FirstscrollPane.remove(0);
        try {
            podklForsas.ReadDataCustomer(customers);
        }catch (SQLException f){
            System.out.println("no read");
        }
        System.out.println(customers.size());
        SettingFirstscrollPane();
    }


    private static void SettingFirstscrollPane(){
        FirstscrollPane.setBounds(600,0,550,800);
        int n=0;
        for(int i = 0; i< customers.size(); i++) {
            JButton f1 = new JButton(customers.get(i).getid()+" "+ customers.get(i).getName());
            int f=i;
            n=i;
            f1.setBounds(0, i*50, 550, 50);
            f1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame dialog=new JFrame();
                    dialog.setLayout(null);
                    dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    dialog.setBounds(0,0,300,100);

                    JButton delete=new JButton("Удалить");
                    delete.setBounds(0,0,100,30);
                    delete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                podklForsas.DeleteDataCustomer(customers.get(f).getid());
                            }catch (SQLException f){
                                System.out.println("no may delete");
                            }
                        }
                    });

                    JButton change=new JButton("Изменить");
                    change.setBounds(100,0,100,30);
                    change.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                podklForsas.UpdateDataCustomer("f", customers.get(f).getid());
                            }catch (SQLException f){
                                System.out.println("no Update");
                            }
                        }
                    });

                    dialog.add(delete);
                    dialog.add(change);
                    dialog.setVisible(true);
                }
            });
            FirstscrollPane.add(f1);
        }


        JButton create=new JButton("новая запись");
        create.setBounds(0, (n+1)*50, 550, 50);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame createRecord=new JFrame("create");
                createRecord.setLayout(null);
                createRecord.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                createRecord.setBounds(0,0,500,200);
                JTextField full_name=new JTextField();
                full_name.setBounds(0,0,100,30);
                createRecord.add(full_name);

                JTextField phone=new JTextField();
                phone.setBounds(0,30,100,30);
                createRecord.add(phone);

                JTextField address=new JTextField();
                address.setBounds(0,60,100,30);
                createRecord.add(address);

                JButton add=new JButton("Добавить");
                add.setBounds(0,90,100,30);
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                        podklForsas.InsertDataCustomer(105,full_name.getText());
                        }catch (SQLException a){
                         System.out.println("no create");
                        }
                    }
                });
                createRecord.add(add);
                createRecord.setVisible(true);
            }
        });

        FirstscrollPane.add(create);

        FirstscrollPane.createVerticalScrollBar();
        FirstscrollPane.setVisible(false);
        mainWindow.add(FirstscrollPane);
    }

    private static void UpdateSecondScrollPane(){
        while(orders.size()!=0){
            SecondscrollPane.remove(orders.size()-1);
            orders.remove(orders.size()-1);
        }
        SecondscrollPane.remove(0);
        try {
            podklForsas.ReadDataOrder(orders);
        }catch (SQLException f){
            System.out.println("no read");
        }
        System.out.println(orders.size());
        SettingSecondscrollPane();

    }

    private static void SettingSecondscrollPane(){
        SecondscrollPane.setBounds(600,0,550,800);



        int n=0;
        for(int i = 0; i< orders.size(); i++) {
            JButton f1 = new JButton(orders.get(i).getCode_customer()+" "+ orders.get(i).getPaymentType());
            int f=i;
            n=i;
            f1.setBounds(0, i*50, 550, 50);
            f1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame dialog=new JFrame();
                    dialog.setLayout(null);
                    dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    dialog.setBounds(0,0,300,100);

                    JButton delete=new JButton("Удалить");
                    delete.setBounds(0,0,100,30);
                    delete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                podklForsas.DeleteDataCustomer(orders.get(f).getCode_customer());
                            }catch (SQLException f){
                                System.out.println("no may delete");
                            }
                        }
                    });

                    JButton change=new JButton("Изменить");
                    change.setBounds(100,0,100,30);
                    change.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                podklForsas.UpdateDataCustomer("f", orders.get(f).getCode_customer());
                            }catch (SQLException f){
                                System.out.println("no Update");
                            }
                        }
                    });

                    dialog.add(delete);
                    dialog.add(change);
                    dialog.setVisible(true);
                }
            });
            SecondscrollPane.add(f1);
        }


        JButton create=new JButton("новая запись");
        create.setBounds(0, (n+1)*50, 550, 50);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame createRecord=new JFrame("create");
                createRecord.setLayout(null);
                createRecord.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                createRecord.setBounds(0,0,500,200);
                JTextField full_name=new JTextField();
                full_name.setBounds(0,0,100,30);
                createRecord.add(full_name);

                JTextField phone=new JTextField();
                phone.setBounds(0,30,100,30);
                createRecord.add(phone);

                JTextField address=new JTextField();
                address.setBounds(0,60,100,30);
                createRecord.add(address);

                JButton add=new JButton("Добавить");
                add.setBounds(0,90,100,30);
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /*    try {
                         podklForsas.InsertDataOrder(105,full_name.getText());
                        }catch (SQLException a){
                            System.out.println("no create");
                        }*/
                    }
                });
                createRecord.add(add);
                createRecord.setVisible(true);
            }
        });

        SecondscrollPane.add(create);



        SecondscrollPane.createVerticalScrollBar();
        SecondscrollPane.setVisible(false);
        mainWindow.add(SecondscrollPane);
    }


    private static void UpdateThirdscrollPane(){
        while(goods.size()!=0){
            ThirdscrollPane.remove(goods.size()-1);
            goods.remove(goods.size()-1);
        }
        ThirdscrollPane.remove(0);
        try {
            podklForsas.ReadDataGood(goods);
        }catch (SQLException f){
            System.out.println("no read");
        }
        System.out.println(goods.size());
        SettingThirdscrollPane();
    }


    private static void SettingThirdscrollPane(){
        ThirdscrollPane.setBounds(600,0,550,800);
        int n=0;
        for(int i = 0; i< goods.size(); i++) {
            JButton f1 = new JButton(goods.get(i).getCode_representative()+" "+ goods.get(i).getDelivery()+" "+ goods.get(i).getDescription());
            int f=i;
            n=i;
            f1.setBounds(0, i*50, 550, 50);
            f1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame dialog=new JFrame();
                    dialog.setLayout(null);
                    dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    dialog.setBounds(0,0,300,100);

                    JButton delete=new JButton("Удалить");
                    delete.setBounds(0,0,100,30);
                    delete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                podklForsas.DeleteDataCustomer(goods.get(f).getCode_representative());
                            }catch (SQLException f){
                                System.out.println("no may delete");
                            }
                        }
                    });

                    JButton change=new JButton("Изменить");
                    change.setBounds(100,0,100,30);
                    change.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                podklForsas.UpdateDataCustomer("f", goods.get(f).getCode_representative());
                            }catch (SQLException f){
                                System.out.println("no Update");
                            }
                        }
                    });

                    dialog.add(delete);
                    dialog.add(change);
                    dialog.setVisible(true);
                }
            });
            ThirdscrollPane.add(f1);
        }


        JButton create=new JButton("новая запись");
        create.setBounds(0, (n+1)*50, 550, 50);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame createRecord=new JFrame("create");
                createRecord.setLayout(null);
                createRecord.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                createRecord.setBounds(0,0,500,200);
                JTextField full_name=new JTextField();
                full_name.setBounds(0,0,100,30);
                createRecord.add(full_name);

                JTextField phone=new JTextField();
                phone.setBounds(0,30,100,30);
                createRecord.add(phone);

                JTextField address=new JTextField();
                address.setBounds(0,60,100,30);
                createRecord.add(address);

                JButton add=new JButton("Добавить");
                add.setBounds(0,90,100,30);
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /*    try {
                         podklForsas.InsertDataOrder(105,full_name.getText());
                        }catch (SQLException a){
                            System.out.println("no create");
                        }*/
                    }
                });
                createRecord.add(add);
                createRecord.setVisible(true);
            }
        });

        ThirdscrollPane.add(create);


        ThirdscrollPane.createVerticalScrollBar();
        ThirdscrollPane.setVisible(false);
        mainWindow.add(ThirdscrollPane);
    }

    private static void CreateComboBox(){
        JComboBox cb = new JComboBox(courses);
        cb.setBounds(0,100,200,50);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb.getSelectedIndex()==0){
                    ThirdscrollPane.setVisible(false);
                    SecondscrollPane.setVisible(false);
                    FirstscrollPane.setVisible(true);

                }
                if(cb.getSelectedIndex()==1){
                    ThirdscrollPane.setVisible(false);
                    SecondscrollPane.setVisible(true);
                    FirstscrollPane.setVisible(false);
                }
                if(cb.getSelectedIndex()==2){
                    ThirdscrollPane.setVisible(true);
                    SecondscrollPane.setVisible(false);
                    FirstscrollPane.setVisible(false);
                }
            }
        });
        mainWindow.add(cb);
    }

    private static void ProcButton(){

        JTextField textField=new JTextField();
        textField.setBounds(0,300,200,30);
        JButton proc=new JButton("процедура");
        proc.setBounds(0,400,200,30);
        proc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    podklForsas.Procedure(textField.getText());
                }catch (SQLException a){
                    System.out.println("Proc no active");
                }
            }
        });

        mainWindow.add(textField);
        mainWindow.add(proc);
    }


}
