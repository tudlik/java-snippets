package cz.jty.number_sorter.dto;

import java.util.ArrayList;

public class NumbersDTO {

    Integer sum;
    Integer max;
    Integer min;
    Double avg;

    ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();

    public int getSum() {
        return (int)sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public int getMax() {
        return (int)max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public int getMin() {
        return (int)min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public double getAvg() {
        return (double)avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public String getStringListOfNumbers(){
        StringBuilder temp = new StringBuilder();
        for (int number: listOfNumbers){
            temp.append(number+", ");
        }
        temp.delete(temp.length()-2, temp.length());
        return temp.toString();
    }

    public ArrayList<Integer> getListOfNumbers() {
        return listOfNumbers;
    }

    public void setListOfNumbers(ArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public String toString() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format("sum: %s\nmax: %s\nmin: %s\navg: %.2f\nSorted numbers: ",sum, max, min, avg));
        for (int number: listOfNumbers){
            statistics.append(number+", ");
        }
        statistics.delete(statistics.length()-2, statistics.length());
        return  statistics.toString();

    }
}
