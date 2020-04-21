package InfoInBoard_input;


public class Movement {
    private int[] letters;

    public Movement() {}

    public int[] makeLettersList(String input){
        this.letters = new int[input.length()];
        for(int i = 0; i < input.length(); i++) {
            if(i % 2 == 1) {
                letters[i] = Integer.parseInt(String.valueOf(input.charAt(i))) - 1;
            } else {
                letters[i] = (int)Character.toUpperCase(input.charAt(i)) - 64 - 1;
            }
        }
        return letters;
    }

    public String convertIntToPosition(int[] position){
        String first = String.valueOf(Character.toChars(position[0] + 64 + 1));
        String next =  String.valueOf(position[1] + 1);
        return "[" + first + ", " +next + "]";
    }


}
