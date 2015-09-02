package controller;

import model.entities.Flat;

/**
 * Created by R-Tem on 08.06.2015.
 */
public class NewFlatDataCtrl {
    public Error verifyNewFlatData(String address, String parameters,
                                   String condition, String contactNumber,
                                   String contactName, String price, String kievDistrict){
        Error error = new Error();
        if(address.equals("")){
            error.setErrorBoolean(true);
            error.setErrorText("Заполните поле \"Адресс\", пожалуйста!");
            return error;
        } else error.getNewFlat().setAddress(address);
        if (parameters.equals("")){
            error.setErrorBoolean(true);
            error.setErrorText("Заполните поле \"Параметры\", пожалуйста!");
            return error;
        } else error.getNewFlat().setParameters(parameters);
        if (condition.equals("")){
            error.setErrorBoolean(true);
            error.setErrorText("Заполните поле \"Состояние\", пожалуйста!");
            return error;
        } else error.getNewFlat().setCondition(condition);
        if (contactNumber.equals("")){
            error.setErrorBoolean(true);
            error.setErrorText("Заполните поле \"Тел.\", пожалуйста!");
            return error;
        } else error.getNewFlat().setContactNumber(contactNumber);
        if (contactName.equals("")){
            error.setErrorBoolean(true);
            error.setErrorText("Заполните поле \"Имя\", пожалуйста!");
            return error;
        } else error.getNewFlat().setContactName(contactName);
        if (price.equals("")){
            error.setErrorBoolean(true);
            error.setErrorText("Заполните поле \"Цена\", пожалуйста!");
            return error;
        } else error.getNewFlat().setPrice(price);
        if (kievDistrict.equals("")){
            error.setErrorBoolean(true);
            error.setErrorText("Заполните поле \"Микро-рн.\", пожалуйста!");
            return error;
        } else error.getNewFlat().setKievDistrict(kievDistrict);
        return error;
    }
    public static class Error {
        private Boolean errorBoolean = false;
        private String errorText = "";
        private Flat newFlat = new Flat();

        public Boolean getErrorBoolean() {
            return errorBoolean;
        }
        public void setErrorBoolean(Boolean errorBoolean) {
            this.errorBoolean = errorBoolean;
        }

        public String getErrorText() {
            return errorText;
        }
        public void setErrorText(String errorText) {
            this.errorText = errorText;
        }

        public Flat getNewFlat() {
            return newFlat;
        }
        public void setNewFlat(Flat newFlat) {
            this.newFlat = newFlat;
        }
    }
}