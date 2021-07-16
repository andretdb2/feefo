import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FeefoCalculator {
    private final List<Integer> list;
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    public FeefoCalculator(int[] numbers)
    {
        this.list = Arrays.stream(numbers).boxed().collect(Collectors.toList()) ;
    }

    private String getMean()
    {
        double mean = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        return "\n Mean: "+decimalFormat.format(mean);
    }

    private String getMedian()
    {
            double median = list.stream().mapToInt(Integer::intValue).sorted().skip(Math.max(0, ((list.size() + 1) / 2) - 1))
                    .limit(1 + (1 + list.size()) % 2).average().getAsDouble();
            return "\n Median: "+decimalFormat.format(median);
    }


    private String getMode(){
        Integer mode = list.stream()
                .collect(Collectors.groupingBy(i -> i, () -> new TreeMap<Integer, Long>(), Collectors.counting()))
                .entrySet().stream().sorted((a, b) -> {
                    if (!a.getValue().equals(b.getValue()))
                        return b.getValue().compareTo(a.getValue());
                    return a.getKey().compareTo(b.getKey());
                }).findFirst().get().getKey();
         return "\n Mode: "+mode;
    }

    private  String getRange(){
        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
        int range = sorted.get(list.size() -1) - sorted.get(0);
        return "\n Range : " + range;
    }

    public String calculate()
    {
        StringBuilder result = new StringBuilder("Result: ");
        result.append(getMean());
        result.append(getMedian());
        result.append(getMode());
        result.append(getRange());
        return result.toString();
    }
}
