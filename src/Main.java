import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IceCream[] iceCreams;
        iceCreams = new IceCream[3];
        for (int i = 0; i < 3; i++)
            iceCreams[i] = new IceCream();

        for (int i = 0; i < 3; i++)
            iceCreams[i].InputObjInfoInFile();

        IceCream.InputCalculationInfoInFile(iceCreams);

        IceCream.OutputOfFile();
    }
}
