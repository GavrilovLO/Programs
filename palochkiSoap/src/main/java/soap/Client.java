package soap;
import soap.webservice.GivePlayer;
import soap.webservice.Server;
import soap.webservice.ServerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

public class Client {
    static JFrame frame=new JFrame("Клиент меню");
    static JFrame playFrame=new JFrame("Клиент игра");
    static ArrayList<MainButton> mainbuttons=new ArrayList<>();

    public  static final int PORT=2280;
    public static final String url="http://localhost:%d/Palochki?wsdl";
    public static Server service;
    static soap.webservice.InputOutput input;

    static int player=1;
    static int pause;
    static int whoseMove=1;


    public static void main(String[] args) {
        CreateFrames();
    }

    private static void CreateFrames(){
        int x = 900,y = 600;
        frame=SettingsFrame(frame,x,y);
        frame=SettingsButton(frame,x,y);
    }

    private static JFrame SettingsFrame(JFrame v,int x,int y) {
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLayout(null);
        v.setSize(x,y);
        v.setVisible(true);
        return v;
    }

    private static JFrame SettingsButton(JFrame v,int x,int y) {
        JButton buttonPLAY=new JButton("Играть");
        buttonPLAY.setBounds(x/2-x/8,y/2-y/8,x/4,y/4);

        buttonPLAY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Здесь подключение к серверу");
                try {
                    service=new ServerService(new URL(String.format(url,PORT))).getServerPort();
                    player=service.givePlayer(); // ждём, что скажет сервер
                    playFrame=SettingsFrame(playFrame,x,y);
                    PlayFrame();
                    v.setVisible(false);
                    Display();
                }catch (MalformedURLException ex) {
                    System.out.println("ne podl");
                }
            }
        });
        v.add(buttonPLAY);
        return v;
    }

    private static void PlayFrame(){
        BlackBoxForPlayFrame();
        ButtonForPlayFrame();
    }
    private static void BlackBoxForPlayFrame(){
        for (int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                JButton button=new JButton();
                button.setBackground(Color.BLACK);
                button.setBounds(i*90,j*90,30,30);
                playFrame.add(button);
            }
        }
    }

    private static void ButtonForPlayFrame(){
        CreateButton();
        EventForCreateButton();
    }

    private static void CreateButton(){
        JButton b1=new JButton();
        b1.setBounds(30,30,60,60);
        JButton b2=new JButton();
        b2.setBounds(120,30,60,60);
        JButton b3=new JButton();
        b3.setBounds(30,120,60,60);
        JButton b4=new JButton();
        b4.setBounds(120,120,60,60);

        Button leftUp=new Button();
        leftUp.but=new JButton();
        leftUp.but.setBounds(30,0,60,30);
        Button rightUp=new Button();
        rightUp.but=new JButton();
        rightUp.but.setBounds(120,0,60,30);

        Button leftLeftUp=new Button();
        leftLeftUp.but=new JButton();
        leftLeftUp.but.setBounds(0,30,30,60);
        Button leftRightUp=new Button();
        leftRightUp.but=new JButton();
        leftRightUp.but.setBounds(90,30,30,60);
        Button rightRightUp=new Button();
        rightRightUp.but=new JButton();
        rightRightUp.but.setBounds(180,30,30,60);

        Button leftUpDown=new Button();
        leftUpDown.but=new JButton();
        leftUpDown.but.setBounds(30,90,60,30);
        Button rightUpDown=new Button();
        rightUpDown.but=new JButton();
        rightUpDown.but.setBounds(120,90,60,30);

        Button leftLeftDown=new Button();
        leftLeftDown.but=new JButton();
        leftLeftDown.but.setBounds(0,120,30,60);
        Button leftRightDown=new Button();
        leftRightDown.but=new JButton();
        leftRightDown.but.setBounds(90,120,30,60);
        Button rightRightDown=new Button();
        rightRightDown.but=new JButton();
        rightRightDown.but.setBounds(180,120,30,60);

        Button leftDown=new Button();
        leftDown.but=new JButton();
        leftDown.but.setBounds(30,180,60,30);
        Button rightDown=new Button();
        rightDown.but=new JButton();
        rightDown.but.setBounds(120,180,60,30);

        for (int i=0;i<4;i++){
            MainButton mainButton=new MainButton();
            switch (i){
                case 0:
                    mainButton.mainbut=b1;
                    mainButton.left=leftLeftUp;
                    mainButton.up=leftUp;
                    mainButton.right=leftRightUp;
                    mainButton.down=leftUpDown;
                    break;
                case 1:
                    mainButton.mainbut=b2;
                    mainButton.left=leftRightUp;
                    mainButton.up=rightUp;
                    mainButton.right=rightRightUp;
                    mainButton.down=rightUpDown;
                    break;
                case 2:
                    mainButton.mainbut=b3;
                    mainButton.left=leftLeftDown;
                    mainButton.up=leftUpDown;
                    mainButton.right=leftRightDown;
                    mainButton.down=leftDown;
                    break;
                case 3:
                    mainButton.mainbut=b4;
                    mainButton.left=leftRightDown;
                    mainButton.up=rightUpDown;
                    mainButton.right=rightRightDown;
                    mainButton.down=rightDown;
                    break;
            }
            mainbuttons.add(mainButton);
            playFrame.add(mainButton.mainbut);
            playFrame.add(mainButton.left.but);
            playFrame.add(mainButton.up.but);
            playFrame.add(mainButton.right.but);
            playFrame.add(mainButton.down.but);
        }
    }
    private static void EventForCreateButton(){
        for(int i=0;i<mainbuttons.size();i++){
            int  id=i;
            MainButton button;
            button=mainbuttons.get(i);
            button.left.but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(player==whoseMove && button.left.busy==0){
                        if(player==1){
                            button.left.but.setBackground(Color.blue);
                            button.left.busy=1;
                            whoseMove=2;
                        }else{
                            button.left.but.setBackground(Color.red);
                            button.left.busy=2;
                            whoseMove=1;
                        }
                        FillingCheck(player);
                        DataTransfer(id,"l",player,whoseMove);
                        System.out.println("left");
                    }else{
                        System.out.println("no");
                    }
                }
            });

            mainbuttons.get(i).up.but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(player==whoseMove && button.up.busy==0) {
                        if(player==1){
                            button.up.but.setBackground(Color.blue);
                            button.up.busy=1;
                            whoseMove=2;
                        }else{
                            button.up.but.setBackground(Color.red);
                            button.up.busy=2;
                            whoseMove=1;
                        }
                        FillingCheck(player);
                        DataTransfer(id,"u",player,whoseMove);
                        System.out.println("up");
                    }else{
                        System.out.println("no");
                    }
                }
            });

            mainbuttons.get(i).right.but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(player==whoseMove && button.right.busy==0){
                        if(player==1){
                            button.right.but.setBackground(Color.blue);
                            button.right.busy=1;
                            whoseMove=2;
                        }else{
                            button.right.but.setBackground(Color.red);
                            button.right.busy=2;
                            whoseMove=1;
                        }
                        FillingCheck(player);
                        DataTransfer(id,"r",player,whoseMove);
                        System.out.println("right");
                    }else{
                        System.out.println("no");
                    }
                }
            });

            mainbuttons.get(i).down.but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(player==whoseMove && button.down.busy==0 ){
                        if(player==1){
                            button.down.but.setBackground(Color.blue);
                            button.down.busy=1;
                            whoseMove=2;
                        }else{
                            button.down.but.setBackground(Color.red);
                            button.down.busy=2;
                            whoseMove=1;
                        }
                        FillingCheck(player);
                        DataTransfer(id,"d",player,whoseMove);
                        System.out.println("down");
                    }else{
                        System.out.println("no");
                    }
                }
            });
            mainbuttons.set(i,button);
        }
    }

    private  static void FillingCheck(int busy){
        for (int i=0;i<mainbuttons.size();i++){
            if(mainbuttons.get(i).busy==0){
                if(mainbuttons.get(i).left.busy>0 && mainbuttons.get(i).up.busy>0 && mainbuttons.get(i).right.busy>0 && mainbuttons.get(i).down.busy>0){
                    mainbuttons.get(i).busy=busy;
                    if(busy==1){
                        mainbuttons.get(i).mainbut.setBackground(Color.blue);
                    }else{
                        mainbuttons.get(i).mainbut.setBackground(Color.red);
                    }
                }
            }
        }
    }

    public static void DataTransfer(int id , String side , int player, int whoseMove)
    {
       service.inputData(id, side, player, whoseMove);
    }

    public static void Display()
    {
        Thread thread=new Thread(()->{
                while (true){
                    input=service.outputData();
                    int inId= input.getId();
                    String inSide= input.getSide();
                    int busy= input.getBusy();
                    switch (inSide){
                        case "l":
                            mainbuttons.get(inId).left.busy=busy;
                            if (busy==1){
                                mainbuttons.get(inId).left.but.setBackground(Color.blue);
                            }else{
                                mainbuttons.get(inId).left.but.setBackground(Color.red);
                            }
                            break;
                        case "u":
                            mainbuttons.get(inId).up.busy=busy;
                            if (busy==1){
                                mainbuttons.get(inId).up.but.setBackground(Color.blue);
                            }else{
                                mainbuttons.get(inId).up.but.setBackground(Color.red);
                            }
                            break;
                        case "r":

                            mainbuttons.get(inId).right.busy=busy;
                            if (busy==1){
                                mainbuttons.get(inId).right.but.setBackground(Color.blue);
                            }else{
                                mainbuttons.get(inId).right.but.setBackground(Color.red);
                            }
                            break;
                        case "d":
                            mainbuttons.get(inId).down.busy=busy;
                            if (busy==1){
                                mainbuttons.get(inId).down.but.setBackground(Color.blue);
                            }else{
                                mainbuttons.get(inId).down.but.setBackground(Color.red);
                            }
                            break;
                    }
                    FillingCheck(busy);
                    whoseMove=input.getWhosemove();
                }
        });
        thread.start();
    }
}