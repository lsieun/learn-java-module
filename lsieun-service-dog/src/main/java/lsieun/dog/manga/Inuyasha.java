package lsieun.dog.manga;

import lsieun.service.AnimalManga;

public class Inuyasha implements AnimalManga {
    @Override
    public String getName() {
        return "犬夜叉";
    }

    @Override
    public String talk() {
        return "命运的红线一旦断了，就再也接不上了。";
    }
}
