package advent;

public class DayFour {
    public boolean isValid(int number) {
        char[] chars = Integer.toString(number).toCharArray();
        boolean repeatedDigits = false;
        boolean numbersNeverDecrease = true;
        for (int i = 0; i < chars.length-1; i++) {
            if(!repeatedDigits) {
                repeatedDigits = chars[i]== chars[i +1];
            }
            if(numbersNeverDecrease){
                numbersNeverDecrease = chars[i]<=chars[i+1];
            }
        }
        return repeatedDigits && numbersNeverDecrease;
    }

    public static void main(String[] args) {
        DayFour dayFour = new DayFour();
        int countOfValidNumbers = 0;
        for(int candidate=146810; candidate<612564+1; candidate++){
            if(dayFour.isValid(candidate)){
                countOfValidNumbers++;
            }
        }
        System.out.println(countOfValidNumbers);
    }
}
