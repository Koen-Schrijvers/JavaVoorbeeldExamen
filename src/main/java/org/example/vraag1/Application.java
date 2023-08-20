package org.example.vraag1;

import org.example.vraag1.dao.DirectorDao;
import org.example.vraag1.model.Director;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Director d = new Director("test", null);
        DirectorDao.getInstance().createDirector(d);
        int size = DirectorDao.getInstance().getDirectors().size();
        System.out.println(size);
    }
}
