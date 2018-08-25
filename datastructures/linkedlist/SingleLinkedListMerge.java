package datastructures.linkedlist;

import java.util.Iterator;
import java.util.List;

public class SingleLinkedListMerge {

	
	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.add(23);
		ll1.add(22);
		ll1.add(19);
		ll1.add(16);
		ll1.add(13);
		ll1.add(11);
		
		LinkedList ll2 = new LinkedList();
		ll2.add(23);
		ll2.add(22);
		ll2.add(17);
		ll2.add(14);
		ll2.add(12);
		
		int sizeDiff = diffBetweenSize(ll1, ll2);
		LinkedList outer = null;
		LinkedList inner = null;
		
		if (sizeDiff >= 0) {
			outer = ll1;
			inner = ll2;
		}else{
			outer = ll2;
			inner = ll1;
			sizeDiff *= -1;
		}

		boolean isMerge = false;
		int i = 0;
		int j = 0;
		
		while(sizeDiff > 0)
		{
			outer.deleteFirst();
			sizeDiff--;
		}
		
		outer: while (i < outer.length) {
			while (j < inner.length) {
				int ll1Value = ll1.deleteFirst().value;
				int ll2Value = ll2.deleteFirst().value;
				System.out.println(ll1Value + " == " + ll2Value);
				if (ll1Value == ll2Value) {
					isMerge = true;
					break outer;
				}
				continue outer;
			}
		}
		
		System.out.println(isMerge);
	}
	
	//JMSE solution
	public static void twoListsAreMergingOrNot(List<Integer> l1, List<Integer> l2){
		 
	     List<Integer> smallLinkedList=l1;
	     List<Integer> largeLinkedList=l2;
	     Integer diffInSize= l2.size()-l1.size();
	     int ctr=0;
	     
	     if(diffInSize<0){   //if difference is negative, swap the references of lists.
	            smallLinkedList=l2;
	            largeLinkedList=l1;
	            diffInSize=Math.abs(diffInSize);
	     }
	     
	     Iterator<Integer> smallListIterator=smallLinkedList.iterator();
	     Iterator<Integer> largeListIterator=largeLinkedList.iterator();
	     
	     while(largeListIterator.hasNext()){
	            int listValue=largeListIterator.next();
	            if(ctr<diffInSize){
	                   ctr++;
	                   continue;
	            }
	            
	            if(listValue==smallListIterator.next()){
	                   System.out.println("Lists are merging at :"+listValue);
	                   return;
	            }
	     }
	     
	 }

	private static int diffBetweenSize(LinkedList ll1, LinkedList ll2) {
		return ll1.length-ll2.length;
	}

}
