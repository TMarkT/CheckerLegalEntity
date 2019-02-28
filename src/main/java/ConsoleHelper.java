import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleHelper {

    private static String inputText() {
        String s = "";
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "windows-1251"));
            s = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String getINN() {
        String INN = null;
        while (true) {
            System.out.println("Введите ИНН:");
            INN = inputText();
            if (INN.matches("([0-9]){10,12}")) break;
            System.out.println("Некорректный ввод ИНН");
            continue;
        }
        return INN;
    }

    public static String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(new Date());
    }

}
