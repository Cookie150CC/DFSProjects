package bcpack;
/*
Brittain Cooke
CS3310
Instructor: Dr.Ajay Gupta
Notes: This program demonstrates the use of arrays to simulate a random bag generator for a video such as Guild Wars 2.

 */
public class Demo {


    public static void main(String[] args){

        // Item Storage: Item array(for initial storage of csv data), sorted item array (for sorted CSV data by item name
        // ), bag array(number of bags is not determined here), n array(All the values of n used for testing the program
        // at different sizes)

        Item[] itemArray        = new Item[750];
        Item[] sortedItemArray  = new Item[750];
        Bag[] bagArray;
        int[] nArray = {1,8,32,256,1024};

        //Other variables
        int cursor;//Used to fill up bags seqeuntially

        try {
            Utilities.readCSVToItem(itemArray);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(sortedItemArray.length);
        Utilities.sortItemArray(itemArray, sortedItemArray);


        for(int i=0; i<sortedItemArray.length;i++){

            System.out.println("Name: "+sortedItemArray[i].getName());
        }


    }

}
