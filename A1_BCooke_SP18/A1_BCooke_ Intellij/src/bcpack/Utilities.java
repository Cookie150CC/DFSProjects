package bcpack;

import java.io.*;
import java.util.*;


public class Utilities {

    private static final String file   = "itemData.csv";
    private static BufferedReader inFile;
    
    public static Item[] readCSVToItem(Item[] itemArray)throws Exception{


        //Read in the file
        try {
            inFile   = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.print("FILE NOT FOUND!");
            System.exit(1);
        }
        


        //Iterate through the file Store in Item array;
        String temp = null;
        String[] tempArray;
        int n = 0;//while loop counter to iterate through the item array
        
        try {
            temp    = inFile.readLine();//Reads one line of the file makes sure it is intact
        } catch (IOException e) {
            System.err.print("INFILE ERROR!");
        }
        
        //System.out.println("First Line of the File: "+ temp);
        while((temp = inFile.readLine()) != null){
            tempArray = temp.split(",");

            int minStr =0;
            int maxStr =0;


            try {
                minStr = Integer.parseInt(tempArray[1]);
            }catch (Exception e){
                minStr =0;
            }

            try {
                maxStr = Integer.parseInt(tempArray[2]);
            }catch (Exception e){
                maxStr =1000;
            }

            itemArray[n] = new Item(tempArray[0], tempArray[3], minStr, maxStr);

         //   System.out.println("Item Print: " + itemArray[n].getName()+ " , "+ itemArray[n].getRarity()+" , "
           //         +itemArray[n].getMinStr()+" , "+itemArray[n].getMaxStr());

            n++;
        }

        System.out.println(n);
        return itemArray;
    }



    public static Item[] sortItemArray(Item[] itemArray, Item[] sortedItemArray){

        copyArray(itemArray, sortedItemArray);

        mergeSort(sortedItemArray);

        return sortedItemArray;


    }

    public static void copyArray(Item[] itemArray, Item[] sortedItemArray){

        for(int i=0; i< itemArray.length;i++){
            sortedItemArray[i] = itemArray[i];

        }
    }

     /**
     * This is the merge sort implementation for the array
     * @param nArray
     */
    public static void mergeSort(Item[] nArray){
        if(nArray.length<2){
            return;
        }
        int mid     = nArray.length/2;
        int lsize   = mid;
        int rsize   = nArray.length-mid;
        Item[] left  = new Item[lsize];
        Item[] right = new Item[rsize];
        for(int i=0;i<mid; i++){
            left[i]  = nArray[i];
        }
        for(int i=mid;i<nArray.length;i++){
            right[i-mid]    = nArray[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,nArray);
    }

    /**
     * This function is called by merge sort and has job of actually merging and sorting the separated array
     * @param left
     * @param right
     * @param nArray
     */
    public static void merge(Item[] left, Item[] right, Item[] nArray){
        int i   = 0;
        int j   = 0;
        int n   = 0;

        while(i<left.length && j<right.length){
                //System.out.println("Left Name: "+left[i].getName() + "Right Name: "+right[j].getName());
            if(left[i].getName().compareTo(right[j].getName())<=0){
               // System.out.println(i+ ": "+ left[i].getName()+ "was added");
                nArray[n]   = left[i];
                i++; n++;
            }else{
                //System.out.println(j+ ": "+ right[j].getName()+ "was added");
                nArray[n]   = right[j];
                j++; n++;
            }

        }

        while(i<left.length){
            nArray[n]   = left[i];
            i++; n++;
        }
        while(j<right.length){
            nArray[n]   = right[j];
            j++; n++;
        }
    }



}
