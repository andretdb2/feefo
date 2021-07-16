public class Feefo {

    public static void main(String args[]) {
        FeefoNormalizer normalizer = new FeefoNormalizer();
        FeefoCalculator calculator = new FeefoCalculator(new int[]{2, 3, 3, 4, 5, 7, 6, 1, 9});
        System.out.println(normalizer.normalize("Chief Accountant"));
        System.out.println(calculator.calculate());
    }
}
