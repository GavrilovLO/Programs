package soap;
import com.sun.tools.ws.wsdl.document.Output;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Server {
    public static final int PORT=2280;
    private static int id=0;
    private static int busy=0;
    private static String side="f";
    private static int whosemove=1;
    private static int player=0;
    private static InputOutput Output=new InputOutput();

    @WebMethod
    public int GivePlayer(){
        player++;
        return player;
    }

    @WebMethod
    public InputOutput OutputData() {
        Output.id=id;
        Output.side=side;
        Output.busy=busy;
        Output.whosemove=whosemove;
        return Output;
    }

    @WebMethod
    public void InputData(int x1,String side,int busy1,int whosemove){
        this.id=x1;
        this.side=side;
        this.busy=busy1;
        this.whosemove=whosemove;
    }

    public static void main(String[]args)  {
        Server service=new Server();
        String url=String.format("http://localhost:%d/Palochki",PORT);
        Endpoint.publish(url,service);//публикация веб-сервиса
    }
}