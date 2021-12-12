import java.io.*;

import static java.lang.Integer.parseInt;

public class IceCream {

    private String name;
    private boolean isChocolate;
    private int fatPercentage;

    IceCream() throws IOException {
        String isChoc;

        //input stream
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));
        System.out.print("\nEnter ice cream name: ");
        this.name = input.readLine();

        while (true) {
            System.out.print("\nDoes ice cream has chocolate. Type true or false: ");
            isChoc = input.readLine();
            if ("true".equals(isChoc)) {
                this.isChocolate = true;
                break;
            }
            if ("false".equals(isChoc)) {
                this.isChocolate = false;
                break;
            }

            System.out.print("\nIncorrect value! Please, repeat");
        }

        System.out.print("\nFat percentage: ");
        this.fatPercentage = parseInt(input.readLine());
    }

    //put obj data in to document.doc
    public void InputObjInfoInFile() throws IOException {
        File file = new File("document.doc");
        file.deleteOnExit();
        FileWriter writer;
        writer = new FileWriter(file, true);
        writer.append("\nIce cream: " + this.name + "; fat percentage: " + this.fatPercentage + "; ");
        if (this.isChocolate)
            writer.append("with chocolate.\n");
        else writer.append("WO chocolate.\n");
        writer.flush();
        writer.close();
    }

    public static void InputCalculationInfoInFile(IceCream[] iceCreams) throws IOException {
        int averageFat = calculateAverageFatPercentage(iceCreams);
        int withChocCount = getIceCreamWithChocolateCount(iceCreams);
        File file = new File("document.doc");
        file.deleteOnExit();
        FileWriter writer;
        writer = new FileWriter(file, true);
        writer.append("\nAverage fat percentage: " + averageFat + "; Ice creams with chocolate: " + withChocCount);
        writer.flush();
        writer.close();
    }

    public static void OutputOfFile() throws IOException {
        File file = new File("document.doc");
        FileReader reader;
        char buffer[];
        int numb;
        buffer = new char[1];
        reader = new FileReader(file);
        do {
            numb = reader.read(buffer);
            System.out.print(buffer[0]);
        } while (numb == 1);
        reader.close();
    }

    public static int calculateAverageFatPercentage(IceCream[] iceCreams) {
        double fatPercentageOverall = 0;
        double result;
        int i;
        for (i = 0; i < iceCreams.length; i++) {
            fatPercentageOverall += iceCreams[i].getFatPercentage();
        }

        result = fatPercentageOverall / iceCreams.length;

        return ((int) Math.round(result));
    }

    public static int getIceCreamWithChocolateCount(IceCream[] iceCreams) {
        int count = 0;
        int i;
        for (i = 0; i < iceCreams.length; i++) {
            count = iceCreams[i].isChocolate ? ++count : count;
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChocolate() {
        return isChocolate;
    }

    public void setChocolate(boolean chocolate) {
        isChocolate = chocolate;
    }

    public int getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(int fatPercentage) {
        this.fatPercentage = fatPercentage;
    }
}
