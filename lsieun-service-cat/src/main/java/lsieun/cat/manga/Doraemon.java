package lsieun.cat.manga;


import lsieun.service.AnimalManga;

public class Doraemon implements AnimalManga {
    @Override
    public String getName() {
        return "哆啦A梦";
    }

    @Override
    public String talk() {
        return "时间就像一张网，你撒在哪里，你的收获就在哪里。";
    }
}
