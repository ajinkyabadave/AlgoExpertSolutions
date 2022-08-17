public class SumOfLinkedLists {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        int num1 = 0;
        int num2 = 0;
        int itr1 = 0;
        int itr2 = 0;
        LinkedList llOneNode = linkedListOne;
        LinkedList llTwoNode = linkedListTwo;


        while(llOneNode !=null || llTwoNode !=null){
            if(llOneNode !=null ){
                num1 = num1 + (llOneNode.value * (int)Math.pow(10, itr1));
                itr1++;
                llOneNode = llOneNode.next;
            }

            if(llTwoNode !=null){
                num2 = num2 + (llTwoNode.value * (int) Math.pow(10,itr2));
                itr2++;
                llTwoNode = llTwoNode.next;

            }
        }
        Integer sum = num1 + num2;
        int digits = 1 + (int)Math.floor(Math.log10(sum));

        // Approach 1: mathematically but more time complexity
        // for(int i = digits-1; i>= 0; i--){
        // 	int number = (int)Math.floor(sum/(int)(Math.pow(10,i)));
        // 	LinkedList node = new LinkedList(number);
        // }

        // Approach 2: String based, easy
        String sumString = sum.toString();
        int sumStrLength = sumString.length();
        LinkedList finalList = null;

        for(int i = sumStrLength - 1; i>=0; i--){
            int number = Integer.parseInt(String.valueOf(sumString.charAt(i)));
            LinkedList node = new LinkedList(number);
            if(i == sumStrLength - 1){
                finalList = node;
            }
            else{
                finalList.next = node;
            }
        }
        return finalList;
    }
}
