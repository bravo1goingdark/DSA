public class stringQuestion {
    public static void main(String[] args) {
        String a = "bacapplecd";
        // skipping("", a);
        System.out.println(skippingwords(a));

    }
    static void skipping(String newstring , String originalstring){ // skipping a character
        if(originalstring.isEmpty()){
            System.out.println(newstring);
            return;
        }
        char ch = originalstring.charAt(0);
        if(ch == 'a'){ // skipping 'a'
            skipping(newstring, originalstring.substring(1));
        }else {
            skipping(newstring + ch, originalstring.substring(1));
        }
    }
    static String skipping(String old){ // skipping a character
        if(old.isEmpty()){;
            return "";
        }
        char ch = old.charAt(0);
        if(ch == 'a'){ // skipping 'a'
            return skipping(old.substring(1));
        }else {
            return ch + skipping(old.substring(1));
        }
    }
    static String skippingwords(String old){ // skipping a character
        if(old.isEmpty()){;
            return "";
        }
        if(old.startsWith("apple")){ // skipping 'a'
            return skippingwords(old.substring(5));
        }else {
            return old.charAt(0) + skippingwords(old.substring(1));
        }
    }
    
}
