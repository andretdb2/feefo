import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FeefoNormalizer {
    private final Map<String, String> normalizedJobs;
    public FeefoNormalizer()
    {
        normalizedJobs = new HashMap<>();
        normalizedJobs.put("architect", "Architect");
        normalizedJobs.put("engineer", "Software engineer");
        normalizedJobs.put("quantity surveyor", "Quantity surveyor");
        normalizedJobs.put("accountant", "Accountant");

    }



    public String normalize(String input)
    {
            Optional<Map.Entry<String, String>> normalizedJob = normalizedJobs.entrySet().stream().filter(job -> input.toLowerCase().contains(job.getKey())).findFirst();
            return normalizedJob.isPresent() ? normalizedJob.get().getValue() : "Job not found";
    }
}
