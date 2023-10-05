package org.wiktormalyska.letsbeginbook.screen;

import net.minecraft.client.gui.screen.Screen;
import org.wiktormalyska.letsbeginbook.utils.text.Description;
import org.wiktormalyska.letsbeginbook.utils.textures.Textures;

public class BookPagesHandler {
    private final Cover cover, backCover;
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
    public Screen openNextPage() {
        // Check if there's only one page, and the user is on it.
    }


    public Screen openPreviousPage() {
        // Check if we are on the front cover or at the back cover.
    }
}
