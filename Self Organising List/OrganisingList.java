/**
 * Name:jesse mwirigi mwiti
 * Student Number: u17306192
 */

public class OrganisingList {

    public ListNode root = null;

    public OrganisingList() {

    }

    /**
     * Calculate the sum of keys recursively, starting with the given node
     * until the end of the list
     * @return The sum of keys from the current node to the last node in the list
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int sumRec(ListNode node) {
        // Your code here...
        if (node.next==null) {
               return node.key;
           }
           else{
             return sumRec(node.next)+node.key;
           }

    }
   // public int sum(ListNode node){
   //   ListNode temp = root;
   //   for (; temp.next != node; temp = temp.next);
   //   summ(temp);
   //  }
   //  public int summ(ListNode node){
   //    if (node.next==null) {
   //        return node.key;
   //    }
   //    else{
   //      return summ(node.next)+node.key;
   //    }
   //  }

    /**
     * Calculate and set the data for the given node.
     * @return The calculated data for the given node
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int dataRec(ListNode node) {
        // Your code here...
        node.data =rec(node);
        return node.data;
    }
    public static int rec(ListNode node){
      if (node.next==null) {
            //node.data= node.key;
            return  node.key;
      }
      else{
        //node.data=(node.key*sumRec(node) -dataRec(node.next));
        return (node.key*sumRec(node) -dataRec(node.next));
      }
    }

    /**
     * Calculate the data field of all nodes in the list using the recursive functions.
     * DO NOT MODIFY!
     */
    public void calculateData() {
        if (root != null) {
            dataRec(root);
        }
    }

    /**
     * Retrieve the data for the node with the specified key and move the
     * accessed node to the front and recalculate data fields.
     * @return The data of the node before it has been moved to the front,
     * otherwise 'null' if the key does not exist.
     */
    public Integer getData(Integer key) {
        // Your code here...
        if (contains(key)==true) {
                  //find they key

                  ListNode temp = root;
                   for (; temp.next != null; temp = temp.next)
                   {
                     if (temp.key==key) {
                        // data=temp.data;
                          break;
                     }
                   }
                   int data=temp.data;
                   ListNode tohead = temp;
                   ListNode fromhead = root;

                   //if its head do nothing
                   if (root.key==key) {
                     //do nothing
                   }
                   else{

                     //move to head and connect where it was at
                     // if only one // node on the list;
                     if (root.key==key&& root.next==null){
                           //do nothing
                     }
                     else
                     {                    // if more than one node in the list

                          ListNode pred, tmp;// and el is in a nonhead node;
                          for (pred = root, tmp = root.next;
                               tmp != null && !tmp.key.equals(key);
                               pred = pred.next, tmp = tmp.next);
                          if (tmp != null)
                          {   // if el was found;
                              pred.next = tmp.next;
                          }

                     }


                   }
                   ////inser the deleted value at head
                   root=tohead;
                   root.next=fromhead;
                   calculateData();
                   return data;
        }else{
          //do nothing
          return null;
        }
    }

    /**
     * Delete the node with the given key.
     * calculateData() should be called after deletion.
     * If the key does not exist, do nothing.
     */
    public void delete(Integer key) {
        // Your code here...
        //if it exists
        if (contains(key)==true) {
          // ListNode temp=;
          if (root.key==key&& root.next==null){// if only one // node on the list;
                root= null;
                calculateData();
          }
          else if(root.key==key && root.next!=null){ // if more than one node on the list;
               root=root.next;    // and el is in the head node;
               calculateData();
          }
          else
          {                    // if more than one node in the list

               ListNode pred, tmp;// and el is in a nonhead node;
               for (pred = root, tmp = root.next;
                    tmp != null && !tmp.key.equals(key);
                    pred = pred.next, tmp = tmp.next);
               if (tmp != null)
               {   // if el was found;
                   pred.next = tmp.next;
                   calculateData();
               }

          }

        }else{
          //do nothing
        }

    }

    /**
     * Insert a new key into the linked list.
     *
     * New nodes should be inserted to the back
     * Duplicate keys should not be added.
     */
    public void insert(Integer key) {
        // Your code here...
        if (contains(key)==true) {
             //do nothing
        }
        else{
              ////find keys SLLNode<T> tmp;    // find the predecessor of tail;
           ///insert head
           if (root==null) {
                ListNode newnode=new ListNode(key);
                root=newnode;
                root.next=null;
                calculateData();
           }
           else{
             ListNode newnode=new ListNode(key);
             newnode.next=null;
             ListNode temp = root;
             for (; temp.next != null; temp = temp.next);
             temp.next=newnode;
             calculateData();
           }
        }
    }

    /**
     * Check if a key is contained in the list
     * @return true if the key is in the list, otherwise false
     */
    public Boolean contains(Integer key) {
        // Your code here...
        ListNode temp=root;
        while(temp!=null){
          if (temp.key==key) {
            return true;
          }
          temp=temp.next;
        }
        return false;
    }


    /**
     * Return a string representation of the Linked List.
     * DO NOT MODIFY!
     */
    public String toString() {
        if (root == null) {
            return "List is empty";
        }

        String result = "";
        for (ListNode node = root; node != null; node = node.next) {
            result = result.concat("[K: " + node.key + ", D: " + node.data + "]");

            if (node.next != null) {
                result = result.concat(" ");
            }
        }

        return result;
    }

    /**
     * Return a string representation of the linked list, showing only the keys of nodes.
     * DO NOT MODIFY!
     */
    public String toStringKeysOnly() {

        if (root == null) {
            return "List is empty";
        }

        String result = "";
        for (ListNode node = root; node != null; node = node.next) {
            result = result + node.key;

            if (node.next != null) {
                result = result.concat(", ");
            }
        }

        return result;
    }


}
