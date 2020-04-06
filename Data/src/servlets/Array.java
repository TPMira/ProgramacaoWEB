package servlets;

public class Array {

    public static boolean in(int valor, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valor) {
                return true;
            }
        }
        return false;
    }
}