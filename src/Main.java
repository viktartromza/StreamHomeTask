import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D://President.txt"));
        String str;
        ArrayList<String> list = new ArrayList<String>();
        while ((str = reader.readLine()) != null) {
            if (!str.isEmpty()) {
                list.add(str);
            }
        }
        String[] subStr = list.toArray(new String[0]);
        Map<Integer, String> president = new HashMap<>();
        for (int i = 0; i < subStr.length; i++) {
            president.put(i, subStr[i].replaceAll(" ", ""));//Создать набор данных в формате id-name, сохраненный в Map.
        }
        ArrayList<String> listPres = new ArrayList<String>();
        for (Map.Entry<Integer, String> entry : president.entrySet()) {
            if (entry.getKey() == 1 || entry.getKey() == 2 || entry.getKey() == 5 || entry.getKey() == 8 || entry.getKey() == 9 || entry.getKey() == 13) {
                listPres.add(entry.getValue());
            }//Необходимо отобрать из этого набора только те данные, id которых попадает в числовой диапазон 1/2/5/8/9/13
        }
        listPres.stream().filter(x -> (x.length() % 2 == 1)).map(x -> {
            StringBuilder sb = new StringBuilder();
            return sb.append(x).reverse();
        }).forEach(System.out::println);
        //Среди отобранных значений отобрать только те, которые имеют нечетное количество букв в имени.
        //После чего вернуть список List имен, записанных буквами задом наперед.
    }
}
