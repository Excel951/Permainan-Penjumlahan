public class MyMathTools {
    public static int random(int min, int max) {
        int rand = 0;
        rand = (int) (Math.floor(Math.random() * (max - min + 1) + min));
        return rand;
    }

    public static int cariMin(int[] data) {
        int minimum = 100;
        int temp = 0;
        for (int i = 0; i < data.length - 1; i++) {
            temp = Math.min(data[i], data[i + 1]);
            if (temp < minimum)
                minimum = temp;
        }
        return minimum;
    }

    public static int cariMax(int[] data) {
        int maximal = 0;
        int temp = 0;
        for (int i = 0; i < data.length - 1; i++) {
            temp = Math.max(data[i], data[i + 1]);
            if (temp > maximal)
                maximal = temp;
        }
        return maximal;
    }
}