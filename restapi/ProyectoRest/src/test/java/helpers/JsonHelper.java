package helpers;

import org.json.JSONObject;
import java.util.Iterator;

public class JsonHelper {
    /**
     * valor que sea String -----> JSON
     *
     * @param json
     * @return
     */
    private static JSONObject convertStringToJSON(String json) {

        JSONObject jsonObject = new JSONObject(json);
        return jsonObject;
    }


    /**
     * comparar dos json, 1 expected result vs actual result
     * no compara los atributos que tengan la palabra IGNORE
     *
     * @param expectedResultJson
     * @param actualResultJson
     * @return
     */
    public static boolean areEqualJsons(String expectedResultJson, String actualResultJson) {
        boolean isEqual = true;

        JSONObject jsonObjectExpected = JsonHelper.convertStringToJSON(expectedResultJson);
        JSONObject jsonObjectActual = JsonHelper.convertStringToJSON(actualResultJson);

        Iterator<?> keyList = jsonObjectExpected.keys();
        while (keyList.hasNext()) {
            String key = (String) keyList.next();
            String valueExpected = String.valueOf(jsonObjectExpected.get(key));
            String valueActual = String.valueOf(jsonObjectActual.get(key));
            if (jsonObjectExpected.has(key) && jsonObjectActual.has(key)) {
                if (valueExpected.equals("IGNORE") || valueActual.equals("IGNORE")) {
                    System.out.println("INFO> el attributo [" + key + "]  se esta Ignorando para la verificacion");
                } else {
                    if (!valueExpected.equals(valueActual)) {
                        System.out.println("INFO> Error los valores del attributo  [" + key + "] son diferentes ," +
                                " Expected [" + valueExpected + "] vs Actual [" + valueActual + "]");
                        isEqual = false;
                    }
                }
            }else{
                System.out.println("El Schema es incorrecto el json no tiene este attributo "+key);
                isEqual = false;
            }
        }
        return isEqual;
    }
}