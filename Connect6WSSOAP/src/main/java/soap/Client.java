package soap;

import soap.webservice.ServerService;
import soap.webservice.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Client {
    static JFrame frame=new JFrame("Клиент меню");
    static JFrame playFrame=new JFrame("Клиент игра");
    static ArrayList<Place> places=new ArrayList<>();

    public  static final int PORT=2280;
    public static final String url="http://localhost:%d/Connect6?wsdl";
    public static Server service;

    static int player;
    static int pause;
    private static JLabel DisplayPlayer;
    private static JLabel DisplayWhoWin;
    static soap.webservice.InputOutput input;


    public static void main(String[] args) {
        CreateandSettingsFrame();
    }

    private static void CreateandSettingsFrame() {
        int x = 1200,y = 900;
        frame=SettingsFrame(frame,x,y);
        frame=SettingsButton(frame,x,y);
        SettingLabel(x);
    }

    private static void SettingLabel(int x)
    {
        DisplayPlayer=new JLabel();
        DisplayWhoWin=new JLabel("никто");
        DisplayPlayer.setBounds(x-300,0,200,100);
        DisplayWhoWin.setBounds(x-300,100,200,100);
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
                    service=new ServerService(new URL(String.format(url,PORT))).getServerPort();//создание клиенского прокси
                    player=service.givePlayer();
                    DisplayPlayer.setText(Integer.toString(player));
                    playFrame=SettingsFrame(playFrame,x,y);
                    SettingPlayFrame();
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

    static int whoseMove=1;
    private static void SettingPlayFrame() {
        int id = 0;
        for(int i = 0;i < 19;i++) {
            for(int j = 0;j < 19;j++) {
                Place place = new Place();
                place.id = id;
                place.button=new JButton(new ImageIcon("D:\\FotoForConnect6\\wood.PNG"));//здесь нужна начальная икона
                place.button.setBounds(j*40,i*40,40,40);
                place.button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(whoseMove==player && pause==0){
                            if(place.busy == 0){
                                place.busy=player;
                                if(player == 1){
                                    place.button.setBackground(Color.white);
                                    whoseMove=2;
                                    DataTransfer(place.id,player,whoseMove);
                                }else {
                                    place.button.setBackground(Color.BLACK);
                                    whoseMove = 1;
                                    DataTransfer(place.id,player,whoseMove);
                                }
                            }else {
                                System.out.println("busy");
                            }
                        }else{
                            System.out.println("no go or no your move");
                        }
                    }
                });
                places.add(place);
                playFrame.add(place.button);
                id++;
            }
        }
        playFrame.add(DisplayPlayer);
        playFrame.add(DisplayWhoWin);
    }

    public static void DataTransfer(int id,int player, int whoseMove) {
        service.inputData(id, player, whoseMove);
    }

    public static void Playerwin(int i,int inplayer) {
        int kol_vo = 1;
        int f = 1;
        if(i % 18 != 0){
            while(places.get(i).busy==places.get(i + f).busy) {
                kol_vo++;
                f++;
            }
        }
        f=1;
        if(i%19!=0){
            while(places.get(i).busy==places.get(i-f).busy) {
                kol_vo++;
                f++;
                if(!((i - f) % 19 != 0 && i - f > f * 19)) break;
            }
        }
        if(kol_vo >= 6) {
            if(inplayer==player){
                DisplayWhoWin.setText("pobedil");
            }else{
                DisplayWhoWin.setText("proigral");
            }
            pause=1;
        }
        kol_vo = 1;
        f = 1;

        kol_vo=Valid(i,f,kol_vo,19);
        if(kol_vo >= 6) {
            if(inplayer==player){
                DisplayWhoWin.setText("pobedil");
            }else{
                DisplayWhoWin.setText("proigral");
            }
            pause=1;
        }
        kol_vo = 1;
        f = 1;

        kol_vo=Valid(i,f,kol_vo,20);
        if(kol_vo >= 6) {
            if(inplayer==player){
                DisplayWhoWin.setText("pobedil");
            }else{
                DisplayWhoWin.setText("proigral");
            }
            pause=1;
        }
        kol_vo = 1;
        f = 1;

        kol_vo=Valid(i,f,kol_vo,18);
        if(kol_vo >= 6) {
            if(inplayer==player){
                System.out.println("pobedil");
                DisplayWhoWin.setText("pobedil");
            }else{
                System.out.println("proigral");
                DisplayWhoWin.setText("proigral");
            }
            pause=1;
        }
    }

    public static int Valid(int i,int f,int kol_vo,int n) {
        if(i+n<places.size()){
            while(places.get(i).busy==places.get(i+ n * f).busy) {
                kol_vo++;
                f++;
                if(!(i+n*f<places.size())) break;
            }}
        f=1;
        if(i-n>0){
            while(places.get(i).busy==places.get(i- n * f).busy) {
                kol_vo++;
                f++;
                if(!(i - n * f >= 0)) break;
            }}
        return kol_vo;
    }


    public static void Display()
    {
        Thread thread=new Thread(()->{
                while (true){
                    input=service.outputData();
                    if(input.getBusy()!=0){
                    places.get(input.getId()).busy= input.getBusy();
                    Playerwin(input.getId(), input.getBusy());
                    whoseMove= input.getWhosemove();
                    if(input.getBusy()==1){
                        places.get(input.getId()).button.setBackground(Color.white);
                    }else {
                        places.get(input.getId()).button.setBackground(Color.BLACK);
                    }
                    }
                }
        });
        thread.start();
    }
}
