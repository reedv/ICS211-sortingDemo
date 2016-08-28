
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Reed Villanueva
 */
public class SortingDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //fields
        new_set.setPrefSize(600, 30);
        new_set.setEditable(false);
        
        intermediate_field.setPrefSize(600, 300);
        intermediate_field.setEditable(false);
        
        sorted_set.setPrefSize(600, 30);
        sorted_set.setEditable(false);
        
        Insets dPads = new Insets(5,4,5,4);
        display_stage.setPadding(dPads);
        display_stage.setStyle("-fx-background-color: mediumturquoise");
        display_stage.getChildren().addAll(nS, new_set, pSs, intermediate_field, sS, sorted_set);
        
        //Buttons
        set.setStyle("-fx-color: aquamarine");
        set.setPrefSize(90, 40);
        set.setOnAction(new setHandler());
        
        bubble.setStyle("-fx-color: aquamarine");
        bubble.setPrefSize(90, 40);
        bubble.setOnAction(new bubbleHandler());
        
        selection.setStyle("-fx-color: aquamarine");
        selection.setPrefSize(90, 40);
        selection.setOnAction(new selectionHandler());
        
        merge.setStyle("-fx-color: aquamarine");
        merge.setPrefSize(90, 40);
        merge.setOnAction(new mergeHandler());
        
        insert.setStyle("-fx-color: aquamarine");
        insert.setPrefSize(90, 40);
        insert.setOnAction(new insertHandler());
        
        quick.setStyle("-fx-color: aquamarine");
        quick.setPrefSize(90, 40);
        quick.setOnAction(new quickHandler());
        
        linear.setStyle("-fx-color: aquamarine");
        linear.setPrefSize(90, 40);
        linear.setOnAction(new linearHandlerInNewWindow());
        
        binary.setStyle("-fx-color: aquamarine");
        binary.setPrefSize(90, 40);
        binary.setOnAction(new binaryHandlerInNewWindow());
        
        buttons_stage.setHgap(4);
        buttons_stage.setVgap(8);
        buttons_stage.add(set, 1, 1);       //Column, Row
        buttons_stage.add(bubble, 2, 1);
        buttons_stage.add(selection, 3, 1);
        buttons_stage.add(merge, 4, 1);
        buttons_stage.add(insert, 5, 1);
        buttons_stage.add(linear, 2, 2);
        buttons_stage.add(binary, 3, 2);
        buttons_stage.add(quick, 6, 1);
        
        
        //root
        Insets pads = new Insets(10,8,10,8);
        root.setPadding(pads);
        root.setStyle("-fx-background-color: steelblue");
        root.getChildren().addAll(display_stage, buttons_stage);
        
        Scene scene = new Scene(root, 770, 560);    //root, W, H
        
        //Prime Stage
        primaryStage.setTitle("SortingDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //Main
    final VBox root = new VBox(8);
    final VBox display_stage = new VBox(4);
    final GridPane buttons_stage = new GridPane();
    
    //Inner
    final Label  nS = new Label("Unsorted set:");
    final Label  pSs = new Label("Passes:");
    final Label  sS = new Label("Sorted set:");
    final TextField new_set = new TextField();
    final TextArea intermediate_field = new TextArea();
    final TextField sorted_set = new TextField();
    
    final Button set = new Button("New\nSet");
    final Button bubble = new Button("Bubble\nSort");
    final Button selection = new Button("Selection\nSort");
    final Button merge = new Button("Merge\nSort");
    final Button insert = new Button("Insertion\nSort");
    final Button quick = new Button("Quick\nSort");
    final Button linear = new Button("Linear\nSearch");
    final Button binary = new Button("Binary\nSearch");
    
    final int cap = 20; 
    ArrayList<Integer> nums = new ArrayList<>(cap);
    boolean isSorted = false;
    
    //set
    private class setHandler implements EventHandler <ActionEvent>{     //Creates and dispays a randomized array
        @Override
        public void handle(ActionEvent e){
            nums.clear();
            new_set.clear();
            intermediate_field.clear();
            sorted_set.clear();
            isSorted = false;
            for(int i = 0; i < cap; i++){
                nums.add(i, (int) (Math.random() * 1000) + 1);
            }
            new_set.setText(seeNums(nums));
        }
    }
    //bubble sort
    private class bubbleHandler implements EventHandler <ActionEvent>{  
        @Override
        public void handle(ActionEvent e){
            bubbleSort(nums);
            isSorted = true;
        }
    }
    //selection sort
    private class selectionHandler implements EventHandler <ActionEvent>{   
        @Override
        public void handle(ActionEvent e){
            selectSort(nums);
            isSorted = true;
        }
    }
    //merge sort 
    private class mergeHandler implements EventHandler <ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            mergeSort(nums);
            isSorted = true;
        }
    }
     //insertion sort
    private class insertHandler implements EventHandler <ActionEvent>{  
        @Override
        public void handle(ActionEvent e){
            insertSort(nums);
            isSorted = true;
        }
    }
    
    //quicksort
    private class quickHandler implements EventHandler <ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            quickSort(nums);
            isSorted = true;
        }
    }
    
    //linear search
    private class linearHandlerInNewWindow implements EventHandler <ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            //Main pane
                final VBox main = new VBox(8);
                
                final Label uS = new Label("Unsorted set:");
                final Label sS = new Label("Sorted Set:");
                final Label l = new Label("Find element:");
                final Label fI = new Label("Index of element in sorted set:");
                
                final TextField unSorted = new TextField();
                final TextField seeSorted = new TextField();
                final TextField lookFor = new TextField();
                final TextField foundIndex = new TextField();
                
                final Button find = new Button("Linear\nSearch");
                
                Insets mainPads = new Insets(5, 10, 10, 10);
                
                //list veiwer
                if(isSorted == true)
                    seeSorted.setText(seeNums(nums));
                else if(isSorted == false)
                    unSorted.setText(seeNums(nums));
                unSorted.setEditable(false);
                seeSorted.setEditable(false);
                lookFor.setPromptText("Enter desired element here");
                foundIndex.setEditable(false);
                
                find.setPrefSize(90, 40);
                find.setStyle("-fx-color: lavender");
                
                main.setPadding(mainPads);
                main.getChildren().addAll(uS, unSorted, sS, seeSorted, l, lookFor, fI, foundIndex, find);
                main.setStyle("-fx-background-color: skyblue");
                
                //Stage
                final Stage abtBox = new Stage();
                abtBox.initModality(Modality.APPLICATION_MODAL);
                abtBox.setTitle("Linear Search");
                abtBox.setScene(new Scene(main, 770, 300)); //W, H
                abtBox.setResizable(false);
                abtBox.show();
                
                //search action
                    //ENTER key bind
                find.setOnAction(new EventHandler <ActionEvent>() {
                   @Override
                   public void handle(ActionEvent e){
                       int found;
                       try{
                       found = linearSearch(nums, Integer.parseInt(lookFor.getText()));
                       }
                       catch(NumberFormatException err){    //If input not an integer
                           return;
                       }
                       if(found == -1)
                           foundIndex.setText("Element not found.");
                       else
                           foundIndex.setText("" + found);
                       isSorted = true;
                       seeSorted.setText(seeNums(nums));
                   }
                });
        }
    }
    //binary search
    private class binaryHandlerInNewWindow implements EventHandler <ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            //Main pane
                final VBox main = new VBox(8);
                
                final Label uS = new Label("Unsorted set:");
                final Label sS = new Label("Sorted Set:");
                final Label l = new Label("Find element:");
                final Label fI = new Label("Index of element in sorted set:");
                
                final TextField unSorted = new TextField();
                final TextField seeSorted = new TextField();
                final TextField lookFor = new TextField();
                final TextField foundIndex = new TextField();
                
                final Button find = new Button("Binary\nSearch");
                
                Insets mainPads = new Insets(5, 10, 10, 10);
                
                //list veiwer
                if(isSorted == true)
                    seeSorted.setText(seeNums(nums));
                else if(isSorted == false)
                    unSorted.setText(seeNums(nums));
                unSorted.setEditable(false);
                seeSorted.setEditable(false);
                lookFor.setPromptText("Enter desired element here");
                foundIndex.setEditable(false);
                
                find.setPrefSize(90, 40);
                find.setStyle("-fx-color: lavender");
                
                main.setPadding(mainPads);
                main.getChildren().addAll(uS, unSorted, sS, seeSorted, l, lookFor, fI, foundIndex, find);
                main.setStyle("-fx-background-color: skyblue");
                
                //Stage
                final Stage abtBox = new Stage();
                abtBox.initModality(Modality.APPLICATION_MODAL);
                abtBox.setTitle("Binary Search");
                abtBox.setScene(new Scene(main, 770, 300)); //W, H
                abtBox.setResizable(false);
                abtBox.show();
                
                //search action
                    //ENTER key bind
                find.setOnAction(new EventHandler <ActionEvent>() {
                   @Override
                   public void handle(ActionEvent e){
                       int found;
                       try{
                       found = binarySearch(nums, Integer.parseInt(lookFor.getText()), 0, nums.size() - 1);
                       }
                       catch(NumberFormatException err){    //If input not an integer
                           return;
                       }
                       if(found == -1)
                           foundIndex.setText("Element not found.");
                       else
                           foundIndex.setText("" + found);
                       isSorted = true;
                       seeSorted.setText(seeNums(nums));
                   }
                });
        }
    }
    
    //---------------------------------------------------Sorting------------------------------------------//
    //bubble sort
    private void bubbleSort(ArrayList<Integer> list){       //Checking neighbor and swapping
            boolean swapped = false;
            for(int i = 1; i < cap; i++){
                for(int j = 0; j < cap - i; j++){
                    if(list.get(j) > list.get(j + 1)){
                        swap(j, j + 1);
                        swapped = true;
                    }
                }
                if(swapped == false)
                    break;
                intermediate_field.appendText("\n\n" + seeNums(nums));
            }
            sorted_set.setText(seeNums(nums));
        }
    
    //selection sort
    private void selectSort(ArrayList<Integer> list){       //Find min and add to left side
            int minIndex;
            for(int i = 0; i < cap; i++){
                minIndex = i;
                for(int j = i + 1; j < cap; j++){
                    if(list.get(j) < list.get(minIndex))
                        minIndex = j;
                }
                if(i != minIndex)   //That is, if a swap occured in 2nd for loop, then...
                    swap(i, minIndex);
                intermediate_field.appendText("\n\n" + seeNums(nums));
            }
            sorted_set.setText(seeNums(nums));
        }
    
    //merge sort
        private ArrayList<Integer> mergeSort(ArrayList<Integer> list){
        //base case for recursive call
        if(list.size() <= 1){
            intermediate_field.appendText("\n\n" + seeNums(list));
            return list;
        }
        //Split list into 2 lists
        int midPoint = list.size()/2;
        ArrayList<Integer> L1 = new ArrayList<>();     
        ArrayList<Integer> L2 = new ArrayList<>();
        L1.addAll(list.subList(0, midPoint));       //list.subList(inclusive, exclusive)
        L2.addAll(list.subList(midPoint, list.size()));
        //use recursion to merge the mergeSorted halfs
        ArrayList<Integer> result = merge(mergeSort(L1), mergeSort(L2));    //Recursive step

        intermediate_field.appendText("\n\n" + seeNums(result));
        sorted_set.setText(seeNums(result));
        nums = result;   
        return result;
    }
    
    //Merge
    private ArrayList<Integer> merge(ArrayList<Integer> L1, ArrayList<Integer> L2){ //returns a merged list of merges L1 and L2
        ArrayList<Integer> combo = new ArrayList<>();
        
        int x = L1.get(0);
        int y = L2.get(0);
        
        while(L1.size() > 0 && L2.size() > 0){    //Should run until L1 or L2 is one list is empty
            if(x <= y){                            
                combo.add(x);
                L1.remove(0);
                if(L1.size() > 0){
                    x = L1.get(0);
                }
            }
            else{
                combo.add(y);
                L2.remove(0);
                if(L2.size() > 0){
                    y = L2.get(0);
                }
            }
        }
        if(L1.size() > 0)
            combo.addAll(L1);
        if(L2.size() > 0)
            combo.addAll(L2);
        
        return combo; 
    }
        
    //insertion sort    
    private void insertSort(ArrayList<Integer> list){       //Moving to the left and inserting into correct position
        int traceIndex, insertIndex;
        //iterate through list
        for(int i = 1; i < cap; i++){   
            traceIndex = i;
            insertIndex = i;
                for(int j = i - 1; j >= 0; j--){     
                    if(list.get(traceIndex) < list.get(j))
                        insertIndex = j;
                    else
                        break;
                }
            if(traceIndex != insertIndex){      //That is, if swapIndex has been used, then do insert
                    int tmp = list.get(traceIndex);
                    list.remove(traceIndex);
                    list.add(insertIndex, tmp);
                }
                intermediate_field.appendText("\n\n" + seeNums(nums));
            }
            sorted_set.setText(seeNums(nums));
        }
    
    private ArrayList<Integer> quickSort(ArrayList<Integer> list){
        if(list.size() > 1){
            //create 3 seperate lists
            ArrayList<Integer> less = new ArrayList<>();
            ArrayList<Integer> equal = new ArrayList<>();
            ArrayList<Integer> greater = new ArrayList<>();
            //select pivot value from some index
            int pivot = list.get(0);
            //sort vals less, equal, and greater than pivot into proper list
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) < pivot){
                    less.add(list.get(i));
                    intermediate_field.appendText("\n\n" + seeNums(less));
                }
                else if(list.get(i) > pivot){
                    greater.add(list.get(i));
                    intermediate_field.appendText("\n\n" + seeNums(greater));
                }
                else{
                    equal.add(list.get(i));
                    intermediate_field.appendText("\n\n" + seeNums(equal));
                }
                
            }
            //recursvly do same to less and greater lists
            less = quickSort(less);
            greater = quickSort(greater);
            //concat the 3 lists
            less.addAll(equal);
            less.addAll(greater);
            intermediate_field.appendText("\n\n" + seeNums(less));
            sorted_set.setText(seeNums(less));
            nums = less;
            return less;
        }
        sorted_set.setText(seeNums(nums));
        nums = list;
        return list;
    }
    
    //------------------------------------------------Searching----------------------------------------//
    //linear search
    private int linearSearch(ArrayList<Integer> list, int find){
        ArrayList<Integer> sorted = mergeSort(list);
        for(int i = 0; i < sorted.size(); i++)
            if(sorted.get(i) == find)
                return i;
        return -1;
    }
    //binary search
    private int binarySearch(ArrayList<Integer> list, int find, int low, int high){
        ArrayList<Integer> sorted = mergeSort(list);
        if(high < low)
            return -1;
        int mid = (int)(low + high)/2;
        if(sorted.get(mid) > find){
            return binarySearch(sorted, find, low, mid - 1);
        }
        else if(list.get(mid) < find){
            return binarySearch(sorted, find, mid + 1, high);
        }
        else
            return mid;
    }
    
    //---------------------------------------------------Helpers----------------------------------------//
    
    private String seeNums(ArrayList<Integer> result){    
        String sNums;
        sNums = "";
        for(int i = 0; i < result.size(); i++)
            sNums += result.get(i) + "  "; 
        return sNums;
    }
    private void swap(int a, int b){    //Swap the values of the element at the indicated indices 
        int swap = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, swap);
    }
    
    //--------------------------------------------------Main--------------------------------------------//
    public static void main(String[] args) {
        launch(args);
    }
}


