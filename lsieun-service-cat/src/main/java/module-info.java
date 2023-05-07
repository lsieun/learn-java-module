module lsieun.service.cat {
    requires lsieun.service;

    provides lsieun.service.AnimalManga
        with lsieun.cat.manga.Doraemon;
}