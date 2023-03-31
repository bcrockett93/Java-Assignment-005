import java.util.Scanner;

public class TempConversion {
    static final Scanner input = new Scanner(System.in);

    public static double convertC2F(double celsius) {
        return (celsius * (9.0/5)) + 32.0;
    }

    public static double convertC2K(double celsius) {
        return celsius + 273.15;
    }

    public static double convertF2C(double fahrenheit) {
        return 5.0 * (fahrenheit - 32) / 9.0;
    }

    public static double convertF2K(double fahrenheit) {
        return convertC2K(convertF2C(fahrenheit));
    }

    public static double convertK2C(double kelvin) {
        return kelvin - 273.15;
    }

    public static double convertK2F(double kelvin) {
        return convertC2F(convertK2C(kelvin));
    }

    public static double getTemp(String unit) {
        System.out.printf("%-40s : ", String.format("Please enter °%s temperature to convert", unit));
        return Double.parseDouble(input.nextLine());
    }

    public static String getUnitChoice() {
        System.out.printf("%-4s : %40s%n", "C).", "To convert a °C temperature");
        System.out.printf("%-4s : %40s%n", "F).", "To convert a °F temperature");
        System.out.printf("%-4s : %40s%n", "K).", "To convert a °K temperature");
        System.out.printf("%-4s : %40s%n", "Q).", "To quit");
        return input.nextLine();
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("Enter the unit to convert from:");
            String fromUnit = getUnitChoice().toUpperCase();
            if (fromUnit.equals("Q")) {
                break;
            }

            System.out.println("Enter the unit to convert to:");
            String toUnit = getUnitChoice().toUpperCase();
            if (toUnit.equals("Q")) {
                break;
            }

            double inputValue = getTemp(fromUnit);
            double convertedValue;

            switch (fromUnit + toUnit) {
                case "CF":
                    convertedValue = convertC2F(inputValue);
                    break;
                case "CK":
                    convertedValue = convertC2K(inputValue);
                    break;
                case "FC":
                    convertedValue = convertF2C(inputValue);
                    break;
                case "FK":
                    convertedValue = convertF2K(inputValue);
                    break;
                case "KC":
                    convertedValue = convertK2C(inputValue);
                    break;
                case "KF":
                    convertedValue = convertK2F(inputValue);
                    break;
                default:
                    System.out.println("Invalid conversion. Please try again.");
                    continue;
            }
            System.out.printf("Result: %.6f°%s is %.6f°%s%n", inputValue, fromUnit, convertedValue, toUnit);
        }

        }
    }
