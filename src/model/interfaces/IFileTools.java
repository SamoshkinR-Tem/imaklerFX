package model.interfaces;

import java.util.ArrayList;

/**
 * Created by R-Tem on 08.06.2015.
 */
public interface IFileTools<T> {

    void writeObjToFile(T obj, String folderAndFileName);
    void writeStringToFile(String text, String folderAndFileName, Boolean addToEnd);

    ArrayList<T> readObjFromFile(String folderAndFileName);
    ArrayList<String[]> readStringFromFile(String folderAndFileName, String RegExp);

}
