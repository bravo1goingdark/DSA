import java.util.ArrayList;
public class StrSubSeq {
    public static void main(String[] args) {
        String alpha = "don";
        //permutationSeqCount("", alpha);
        ArrayList<String> comb = permutationSeqList("", alpha);
        System.out.println(comb);
    }
    static void SubSeq(String newString , String oldString){
        if(oldString.isEmpty()){
            System.out.println(newString);
            return;
        }

        char ch = oldString.charAt(0);
        SubSeq(newString + ch, oldString.substring(1));
        SubSeq(newString, oldString.substring(1));
    }
    static ArrayList<String> Subseq(String newString, String oldString){
        if(oldString.isEmpty()){
            ArrayList<String> res = new ArrayList<>();
            res.add(newString);
            return res;
        }
        char ch = oldString.charAt(0);
        ArrayList<String> added = Subseq(newString + ch, oldString.substring(1));
        ArrayList<String> notadded = Subseq(newString, oldString.substring(1));
        notadded.addAll(added);
        return notadded;
    }
    static void permutationSeq(String newString , String oldString){
        if (oldString.isEmpty()) {
            System.out.println(newString);
            return;
        }

        char ch = oldString.charAt(0);
        for (int i = 0; i <= newString.length(); i++) {
            String First = newString.substring(0, i);
            String Second = newString.substring(i, newString.length());
            permutationSeq(First + ch+ Second, oldString.substring(1));
        }
    }
    static int permutationSeqCount(String newString , String oldString){ // count number of times its calculating 
        if (oldString.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = oldString.charAt(0);
        for (int i = 0; i <= newString.length(); i++) {
            String First = newString.substring(0, i);
            String Second = newString.substring(i, newString.length());
            count = count + permutationSeqCount(First + ch+ Second, oldString.substring(1));
        }
        return count;
    }
    static ArrayList<String> permutationSeqList(String newString , String oldString){
        if (oldString.isEmpty()) {           
            ArrayList<String> list = new ArrayList<>();
            list.add(newString);
            return list;
        }
        char ch = oldString.charAt(0);
        ArrayList<String> allcombination = new ArrayList<>();
        for (int i = 0; i <= newString.length(); i++) {
            String First = newString.substring(0, i);
            String Second = newString.substring(i, newString.length());
            allcombination.addAll(permutationSeqList(First + ch+ Second, oldString.substring(1)));
        }
        return allcombination;
    }
}
