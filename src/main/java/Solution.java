import unisoft.ws.FNSNDSCAWS2;
import unisoft.ws.FNSNDSCAWS2Port;
import unisoft.ws.fnsndscaws2.request.NdsRequest2;
import unisoft.ws.fnsndscaws2.request.ObjectFactory;
import unisoft.ws.fnsndscaws2.response.NdsResponse2;

public class Solution {
    public static void main(String[] args) {
        //Заполнение данными
        String INN = ConsoleHelper.getINN();
        String date = ConsoleHelper.getDate();

        //создание запроса
        ObjectFactory requestFactory = new ObjectFactory();
        NdsRequest2.NP np = requestFactory.createNdsRequest2NP();
        np.setINN(INN);
        np.setDT(date);
        NdsRequest2 request = requestFactory.createNdsRequest2();
        request.getNP().add(np);

        //отправка запроса, получение ответа
        FNSNDSCAWS2 fnsndscaws2 = new FNSNDSCAWS2();
        FNSNDSCAWS2Port port = fnsndscaws2.getFNSNDSCAWS2Port();
        NdsResponse2 response  = port.ndsRequest2(request);

        //вывод запроса на экран
        String state = response.getNP().get(0).getState();
        System.out.println(States.getStates().get(state));

    }
}
