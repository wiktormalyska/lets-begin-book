package org.wiktormalyska.letsbeginbook.screen;

import net.minecraft.client.gui.screen.Screen;
import org.wiktormalyska.letsbeginbook.utils.text.Description;
import org.wiktormalyska.letsbeginbook.utils.textures.Textures;

public class BookPagesHandler {
    private final Cover cover, backCover;
    public int openedPage;
    private final Screen[] pages;
    public BookPagesHandler(int amountOfPages) {
        this.cover = new Cover(
                Textures.CLOSED_BOOK,
                "Let's Begin Book",
                new Description("In this book you will find all the information you need to get started with the modpack!"));
        this.backCover = new Cover(
                Textures.CLOSED_BOOK_BACK,
                "End of the book",
                new Description("Enjoy the modpack!", -60));
        this.backCover.isBackCover();
        this.openedPage = 0;
        this.pages = new Screen[amountOfPages+2];
        this.pages[0] = cover;
        this.pages[pages.length-1] = backCover;
        for(int i =1; i<=pages.length-2; i++){
            this.pages[i] = new Page(Textures.OPENED_BOOK, "Page "+i,"Text L"+i,"Text R"+i);
        }
    }

    public Screen openBook() {
        openedPage=0;
        return cover;
    }
    public Screen openNextPage() {
        openedPage++;
        return this.pages[openedPage];
    }


    public Screen openPreviousPage() {
        openedPage--;
        return this.pages[openedPage];
    }
}
