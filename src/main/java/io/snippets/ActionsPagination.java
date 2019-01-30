package io.snippets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ActionsPagination {

    private int offset;
    private List<Object[]> rows;
    private int columnDateIndex = 0;
    private int columnDatePosition = 1;
    private Page<ActionDto> pagination;

    public ActionsPagination(List<Object[]> result, int offset, int limit) {
        this.rows = result;
        this.offset = offset + columnDatePosition;

        int defaultItemsPerPage = offset == 0 ? (limit - offset): (limit - (offset - 1));

        this.pagination = new Page<>(this.getItems(), defaultItemsPerPage);
    }

    private List<ActionDto> getItems() {
        List<ActionDto> actions = new ArrayList<>();

        for (Object[] row : rows) {
            for (int columnIndex = this.offset; columnIndex < row.length; columnIndex++) {
                if (columnIndex > this.columnDateIndex && row[columnIndex] != null) {
                    ActionDto actionDto = new ActionDto();
                    actionDto.setDate(row[0].toString());
                    actionDto.setName(EnumMovements.values()[columnIndex - 1].getDescription());
                    actionDto.setAmount(new BigDecimal(row[columnIndex].toString()));

                    actions.add(actionDto);
                }
            }

            this.offset = 0;
        }

        return actions;
    }

    public int numberOfPages() {
        return this.pagination.size();
    }

    public List<ActionDto> getPage(int numberOfPage) {
        return this.pagination.getPage(numberOfPage);
    }

}
