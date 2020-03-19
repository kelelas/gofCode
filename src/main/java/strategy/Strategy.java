package strategy;

import java.util.Arrays;

public class Strategy {
    public static void main(String[] args) {
            StrategyClient strategyClient = new StrategyClient();

            int[] arr0 = {1,3,2,1};
            strategyClient.setStrategy(new SelectSort());
            strategyClient.executeStrategy(arr0);
            int[] arr1 = {111,23,23,5,6,7,8,323};
            strategyClient.setStrategy(new InsertingSort());
            strategyClient.executeStrategy(arr1);
            int[] arr2 = {12,31,2,13, 33, 4,55};
            strategyClient.setStrategy(new BubbleSort());
            strategyClient.executeStrategy(arr2);
    }
}

class StrategyClient{
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr){
        strategy.sort(arr);
    }
}
interface Sorting{
    void sort(int[] arr);
}
class BubbleSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sorting.....");
        System.out.println("Before: " + Arrays.toString(arr));
        for (int barier=arr.length-1; barier>=0; barier--){
            for (int i = 0; i<barier; i++){
                if (arr[i]>arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
    }
}

class SelectSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Select sorting.....");
        System.out.println("Before: " + Arrays.toString(arr));
        for (int barier=0; barier<arr.length-1; barier++){
            for (int i = barier + 1; i<arr.length; i++){
                if (arr[i]<arr[barier]){
                    int tmp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = tmp;
                }
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
    }
}

class InsertingSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Inserting sort.....");
        System.out.println("Before: " + Arrays.toString(arr));
        for (int barier=1; barier<arr.length; barier++){
            int index = barier;
            while (index-1>=0 && arr[index]<arr[index-1]){
                    int tmp = arr[index];
                    arr[index] = arr[index-1];
                    arr[index-1] = tmp;
                    index--;
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
    }
}
