package org.wiktormalyska.letsbeginbook.screen;

import net.minecraft.client.gui.screen.Screen;
import org.wiktormalyska.letsbeginbook.utils.text.Description;
import org.wiktormalyska.letsbeginbook.utils.textures.Textures;

public class BookPagesHandler {
    private final Cover cover, backCover;
    private final int amountOfPages;
    public int openedPage;
    private final Page[] pages;
    public BookPagesHandler(int amountOfPages) {
        this.cover = new Cover(
                Textures.CLOSED_BOOK,
                "Let's Begin Book",
                new Description("In this book you will find all the information you need to get started with the modpack!"));
        this.backCover = new Cover(
                Textures.CLOSED_BOOK_BACK,
                "jkhgfhjkuiytrfghjiouytrfdghjytrdfgcvbhjuytfrghjuhytrfgcvbhjgytfrdcvb",
                new Description("Enjoy the modpack!"));
        this.backCover.isBackCover();
        this.openedPage = 0;
        this.amountOfPages = amountOfPages;
        this.pages = new Page[amountOfPages];

        this.pages[0]=new Page(Textures.OPENED_BOOK,
                "top0",
                "left0",
                "right0"
        );
    }

    public Screen openBook() {
        return cover;
    }

    public Screen openNextPage(){
        if (openedPage < amountOfPages+1){
            openedPage++;
        }
        if (openedPage == amountOfPages+1){
            openedPage--;
            return backCover;
        }
        return pages[openedPage-1];
    }

    public Screen openPreviousPage(){
        if (openedPage > amountOfPages+1){
            openedPage--;
        }
        if (openedPage == amountOfPages){
            openedPage++;
            return cover;
        }
        return pages[openedPage-1];
    }
}
