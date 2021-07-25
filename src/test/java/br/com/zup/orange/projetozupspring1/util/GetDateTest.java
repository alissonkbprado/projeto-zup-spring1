package br.com.zup.orange.projetozupspring1.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class GetDateTest {

    @Test
    void testeConversaoDataParaString() {

        GetDate getDate = new GetDate();

        try {
            Date teste = getDate.getDate("01/10/1980");

            Assertions.assertEquals(Date.class, teste.getClass());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}