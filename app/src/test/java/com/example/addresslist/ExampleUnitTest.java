package com.example.addresslist;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.addresslist.dao.LiaisonDao;
import com.example.addresslist.entity.Liaison;

import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testDao(){
        LiaisonDao liaisonDao = new LiaisonDao();
        liaisonDao.addLiaison(new Liaison("郭茂通","22233"));

        List<Liaison> list = liaisonDao.selectLiaisonByName("郭茂通");

        for (Liaison liaison : list) {
            System.out.println(liaison);
        }

    }
}