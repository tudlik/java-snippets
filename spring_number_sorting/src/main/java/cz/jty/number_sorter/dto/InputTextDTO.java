package cz.jty.number_sorter.dto;

public class InputTextDTO {
    private String textInput;
    private boolean ascOrder;
    public String getTextInput() {
        return textInput;
    }

    public boolean isAscOrder() {
        return ascOrder;
    }

    public void setAscOrder(boolean ascOrder) {
        this.ascOrder = ascOrder;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }




}
