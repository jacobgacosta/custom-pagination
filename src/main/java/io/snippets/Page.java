package io.snippets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {

    private List<T> items;
    private int itemsPerPage;
    private int counterPage = 0;
    private int counterItems = 0;
    private Map<Integer, List<T>> pages = new HashMap<>();

    public Page(List<T> items, int itemsPerPage) {
        this.items = items;
        this.itemsPerPage = itemsPerPage;

        this.paginate();
    }

    private void paginate() {
        List<T> paginatedItems = new ArrayList<>();

        for (int index = 0; index < this.items.size(); index++) {
            if (this.counterItems == this.itemsPerPage) {
                this.pages.put(this.counterPage, paginatedItems);

                this.counterPage++;

                this.counterItems = 0;

                paginatedItems = new ArrayList<>();
            }

            paginatedItems.add(items.get(index));

            int remainingItems = this.items.size() - index;

            if (remainingItems < this.itemsPerPage && remainingItems == 1) {
                this.pages.put(this.counterPage, paginatedItems);
            }

            this.counterItems++;
        }
    }

    public List<T> getPage(int numberOfPage) {
        return this.pages.get(numberOfPage);
    }

    public int size() {
        return this.pages.size();
    }

}
