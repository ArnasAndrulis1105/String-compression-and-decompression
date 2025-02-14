public class App {
    public static void main(String[] args) throws Exception {

        /**
         * Test case 1:
         * This will print out "a3b2c1"
         */
        System.out.println("Test case 1:");
        String compressed = compressString("aaabbc");
        System.out.println(compressed);

        /**
         * Test case 2:
         * This will print out "Invalid format (input string must not contain digits or 0)"
         */
        System.out.println("Test case 2:");
        String compressed2 = compressString("4abc");
        System.out.println(compressed2);


        System.out.println("=====================================");
        System.out.println("Expanding strings:");
        /**
         * Test case 1:
         * This will print out "aaaaee"
         */
        System.out.println("Test case 1:");
        String expanded1 = expandString("a4e2");
        System.out.println(expanded1);

        /**
         * Test case 2:
         * This will print out "Invalid format (input string must start with a letter and end with digit)"
         */
        System.out.println("Test case 2:");
        String expanded2 = expandString("3a3b4c1");
        System.out.println(expanded2);

        /**
         * Test case 3:
         * This will print out "Invalid format (input string must start with a letter and end with digit)"
         */
        System.out.println("Test case 3:");
        String expanded3 = expandString("a3b4c1d");
        System.out.println(expanded3);
    }

    public static String compressString(String input) {
        StringBuilder compressedString = new StringBuilder();
        int count = 1;

        for(int i = 1; i < input.length(); i++){
            if(Character.isDigit(input.charAt(i)) || Character.isDigit(input.charAt(i-1)) || input.charAt(i) == '0'){
                return "Invalid format (input string must not contain digits or 0)";
            }
            if(input.charAt(i-1) == input.charAt(i)){
                count++;
            } else {
                compressedString.append(input.charAt(i-1)).append(count);
                count = 1;
            }

        }
        compressedString.append(input.charAt(input.length()-1)).append(count);
        return compressedString.toString();
    }

    public static String expandString(String input) {
        if (input.isEmpty() || !Character.isLetter(input.charAt(0)) || !Character.isDigit(input.charAt(input.length() - 1))) {
            return "Invalid format (input string must start with a letter and end with digit)";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                int count = 0;
                while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                    count = count * 10 + (input.charAt(++i) - '0');
                }
                for (int j = 0; j < count; j++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
