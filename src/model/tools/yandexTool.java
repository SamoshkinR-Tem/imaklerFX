package model.tools;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by R-Tem on 08.06.2015.
 */
public class yandexTool {
    /**
     * GetCoordsJS - это файл getCoords.js который содержит в себе JavaScript
     * выполняемый браузером для получения координат записанных в нем объектов.
     * The following describes the two methods of working with this file.
    */
    public String[] readGetCoordsJS(){
        String[] coords = new String[2];
        FileUtil fileUtil = new FileUtil();
        ArrayList<String[]> strings = fileUtil.readStringFromFile("C:\\Users\\R-Tem\\Downloads\\export.txt", ":");
        for (int i = 0; i < strings.size(); i++) {
            coords = strings.get(i);
        }
        return coords;
    }
    public void writeGetCoordsJS(String address) {
        String jsFile = new String();
        jsFile = "ymaps.ready(init);\n" +
                "function init() {\n" +
                "    var myMap = new ymaps.Map('map', {\n" +
                "        center: [50.45, 30.52], // Киев\n" +
                "        zoom: 12\n" +
                "        });\n" +
                "    \n" +
                "    ymaps.geocode('" + address + "', {\n" +
                "\t\tresults: 1 // Если нужен только один результат, экономим трафик\n" +
                "\t}).then(function(res){\n" +
                "\t\t// Выбираем первый результат геокодирования.\n" +
                "        var firstGeoObject = res.geoObjects.get(0),\n" +
                "            // Координаты геообъекта.\n" +
                "            coords = firstGeoObject.geometry.getCoordinates(),\n" +
                "            // Область видимости геообъекта.\n" +
                "            bounds = firstGeoObject.properties.get('boundedBy');\t\t\n" +
                "\t\tmyMap.geoObjects.add(firstGeoObject);\n" +
                "\t\tvar content = firstGeoObject.properties.get('name') + \": [\" + coords + \"]\";\n" +
                "\t\talert(content);\n" +
                "\t\t$(document).ready(function(){\n" +
                "\t\t\t$.generateFile({\n" +
                "\t\t\t\tfilename\t: 'export.txt',\n" +
                "\t\t\t\tcontent\t\t:  content,\n" +
                "\t\t\t\tscript\t\t: 'download.php'\n" +
                "\t\t\t});\n" +
                "\t\t});\n" +
                "\t});\n" +
                "}";
        try {
            jsFile = new String(jsFile.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String path = "c:\\WebServers\\home\\imakler\\www\\app\\js\\getCoords.js";
        new FileUtil().writeStringToFile(jsFile, path, false);
    }
  /*===============================================================================================================*/
}
