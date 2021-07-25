package br.com.zup.orange.projetozupspring1.util;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GetDate {

    //Converte String para Date
    public Date getDate(String data) throws Exception {
        try {
            SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
            return spf.parse(data);
        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    //Converte String para LocalDate
    public LocalDate getLocalDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }

    //Converte Date para String
    public String getDate(Data data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    //Converte LocalDate para String
    public String getLocalDate(LocalDate data) {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }


}
