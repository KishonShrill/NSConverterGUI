import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The NumberSystem class provides methods for converting numbers between
 * different base systems.
 */

public class NumberSystem {
  private String userInput = "";
  private int base = 0;
  private int conversion;
  public String bin = "", oct = "", dec = "", hex = "";
  private static final int DECIMAL_NUM = 10;

  /**
   * Sets the user input and the base system for the number.
   *
   * @param numberSystemInput the number input by the user
   * @param givenBase the base system of the number
   */
  public void setUserInput(String numberSystemInput, int givenBase) {
    this.userInput = numberSystemInput;
    this.base = givenBase;
  }

  /**
   * Converts the user input to the specified base system.
   *
   * @param input the input to be converted
   * @return the converted number in the specified base system
   */
  public String convertToBIN(String input) {
    int convertToBase = 2;
    int decimal = 0;

    try { //CHECK FOR ERRORS
      if (isHexadecimalSTRICT(userInput) || base == 16) {
        decimal = Integer.parseInt(input, 16);
      } else {
        decimal = Integer.parseInt(input, base);
      }
    } catch (NumberFormatException e) {
      System.out.println("Entered input is TOO HIGH of a number."); //TRY TO PUT THIS MESSAGE IN THE CONVERTER APP
    }

    bin = convertDecimalToOther(decimal, convertToBase);
    return bin;
  }

  public String convertToOCT(String input) {
    int convertToBase = 8;
    int decimal = 0;

    try { //CHECK FOR ERRORS
      if (isHexadecimalSTRICT(userInput) || base == 16) {
        decimal = Integer.parseInt(input, 16);
      } else {
        decimal = Integer.parseInt(input, base);
      }
    } catch (NumberFormatException e) {
      System.out.println("Entered input is TOO HIGH of a number.");
    }

    /* CONVERTING AREA */
    oct = convertDecimalToOther(decimal, convertToBase);

    return oct;
  }
  public String convertToDEC(String input) {
    int decimal = 0;

    try { //CHECK FOR ERRORS
      if (isHexadecimalSTRICT(userInput) || base == 16) {
        decimal = Integer.parseInt(input, 16);
      } else {
        decimal = Integer.parseInt(input, base);
      }
    } catch (NumberFormatException e) {
      System.out.println("Entered input is TOO HIGH of a number.");
    }

    /* CONVERTING AREA */
    if (base == 16) {
      dec = Integer.toString(decimal);
    } else {
      dec = String.valueOf(decimal);
    }

    return dec;
  }
  public String convertToHEX(String input) {
    int convertToBase = 16;
    int decimal = 0;

    try { //CHECK FOR ERRORS
      if (isHexadecimalSTRICT(userInput) || base == 16) {
        decimal = Integer.parseInt(input, 16);
      } else {
        decimal = Integer.parseInt(input, base);
      }
    } catch (NumberFormatException e) {
      System.out.println("Entered input is TOO HIGH of a number.");
    }

    /* CONVERTING AREA */
    hex = convertDecimalToOther(decimal, convertToBase);

    return hex;
  }

  /**
   * Converts a number in another base system to decimal.
   *
   * @param input the array representation of the number
   * @param base the base system of the number
   * @return the decimal representation of the number
   */
  private static String convertDecimalToOther(int input, int base) {
    String remainderString = "";
    String answer = "";
    String[] hexArray = {"A","B","C","D","E","F"};
    int result = input;
    int remainder = 0;

    while (result > 0) {
      remainder = result % base;
      result = result / base;

      if (remainder > 10){remainderString = hexArray[remainder - 10];}
      else {remainderString = Integer.toString(remainder);}

      answer = remainderString.concat(answer);
    }

    return answer;
  }

  private static int[] convertToArray(int decimal) {
    String decimalString = String.valueOf(decimal);
    int[] binaryArray = new int[decimalString.length()];
    for (int i = 0; i < decimalString.length(); i++) {
      binaryArray[i] = decimalString.charAt(i) - '0';
    }
    return binaryArray;
  }

  /**
   * Checks if a string represents a certain number system.
   *
   * @param data the string to be checked
   * @return true if the string represents an octal number, false otherwise
   */
  public static boolean isBinary(String data) {
    Pattern pattern = Pattern.compile("[01]+");
    Matcher matcher = pattern.matcher(data);
    return matcher.matches();
  }
  public static boolean isOctal(String data) {
    Pattern pattern = Pattern.compile("[0-7]+");
    Matcher matcher = pattern.matcher(data);
    return matcher.matches();
  }
  public static boolean isDecimal(String data) {
    Pattern pattern = Pattern.compile("[0-9]+");
    Matcher matcher = pattern.matcher(data);
    return matcher.matches();
  }
  public static boolean isHexadecimal(String data) {
    Pattern pattern = Pattern.compile("[0-9A-Fa-f]+");
    Matcher matcher = pattern.matcher(data);
    return matcher.matches();
  }
  public static boolean isHexadecimalSTRICT(String data) {
    Pattern pattern = Pattern.compile("[A-Fa-f]+");
    Matcher matcher = pattern.matcher(data);
    return matcher.matches();
  }

  // GETTER & SETTER
  /**
   * Returns the user input.
   *
   * @return the user input
   */
//  public String getUserInput() {
//    return this.userInput;
//  }
  /**
   * Sets the conversion type for the number.
   *
   * @param CTWB the conversion type (binary, octal, decimal, hexadecimal)
   */
//  public void setConvert(int CTWB) {
//    this.conversion = CTWB;
//  }
  /**
   * Returns the conversion type for the number.
   *
   * @return the conversion type
   */
//  public int getConvert() {return this.conversion;}
}