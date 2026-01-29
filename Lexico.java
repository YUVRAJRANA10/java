public class Lexico {

    public static void lexico(int curr, int n) {
        if (curr > n) return;

        System.out.println(curr);

        for (int i = 0; i <= 9; i++) {
            int next = curr * 10 + i;
            if (next > n) return;
            lexico(next, n);
            
        }
    }

    public static void main(String[] args) {
        int n = 13;

        for (int i = 1; i <= 9; i++) {
            lexico(i, n);
        }

    }
}
