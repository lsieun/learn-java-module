module lsieun.service.dog {
    requires lsieun.service;

    provides lsieun.service.AnimalManga
        with lsieun.dog.manga.Inuyasha;
}