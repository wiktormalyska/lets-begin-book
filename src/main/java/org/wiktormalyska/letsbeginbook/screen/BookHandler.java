package org.wiktormalyska.letsbeginbook.screen;

import net.minecraft.client.gui.screen.Screen;
import org.wiktormalyska.letsbeginbook.utils.text.Description;
import org.wiktormalyska.letsbeginbook.utils.textures.Textures;

public class BookHandler {
    private final Cover cover, backCover;
    private int amountOfPages;
    public int openedPage;
    private final Page[] pages;
    public BookHandler(int amountOfPages) {
        this.cover = new Cover(
                Textures.CLOSED_BOOK,
                "Let's Begin Book",
                new Description(0x646464, "In this book you will find all the information you need to get started with the modpack!")
        );
        this.backCover = new Cover(
                Textures.CLOSED_BOOK_BACK,
                "jkhgfhjkuiytrfghjiouytrfdghjytrdfgcvbhjuytfrghjuhytrfgcvbhjgytfrdcvb",
                new Description(0x646464, "Enjoy the modpack!")
        );
        this.backCover.isBackCover();
        this.openedPage = 0;
        this.amountOfPages = amountOfPages+2;
        this.pages = new Page[amountOfPages];
        this.pages[0]=new Page(Textures.OPENED_BOOK, "Welcome to Let's Begin!", "This book is a guide to the mod Let's Begin. It will help you to get started with the modpack and will show you all the features of the modpack.","ytdydfgycfgcgfdgyfdtfdtdtdytdtdtytrddyrderydytddgfgfgyfydtsrfghjbkhgyfdxgcvbhjuytfgcvbhjyugtrdgfcvhguytrdgfxcvhguytrdf");
    }

    public Screen openBook() {
        return cover;
    }

    public Screen openNextPage(){
        if (openedPage < amountOfPages){
            openedPage++;
        }
        if (openedPage == amountOfPages){
            return backCover;
        }
        return pages[openedPage];
    }

    public Screen openPreviousPage(){
        if (openedPage > amountOfPages){
            openedPage--;
        }
        if (openedPage == amountOfPages){
            return cover;
        }
        return pages[openedPage];
    }
}
