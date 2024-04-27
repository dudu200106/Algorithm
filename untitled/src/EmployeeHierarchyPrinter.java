import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeHierarchyPrinter {
    public static void main(String[] args) {
        // The file of exam data must be put in a same directory or use an absolute path.
        String inputFilePath = "exam-data-2022.txt";
        String outputFilePath = "employee-hierarchy.txt";

        try {
            List<String> lines = readLinesFromFile(inputFilePath);
            Map<String, List<String>> managerMap = buildManagerMap(lines);

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            if (managerMap.containsKey("")) {
                List<String> topEmployees = managerMap.get("");
                for (String topEmployee : topEmployees) {
                    printEmployeeHierarchy(topEmployee, managerMap, 0, writer);
                }
            }
            writer.close();

            System.out.println("Employee hierarchy printed to " + outputFilePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            // close IO resource
            e.printStackTrace();
        }
    }

    /**
     * To read all employee info into list.
     * @param filePath
     * @return
     * @throws IOException
     */
    private static List<String> readLinesFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    /**
     * To put all employee in a hashMap, which can represent relationship between superior and inferior
     * @param lines
     * @return
     */
    private static Map<String, List<String>> buildManagerMap(List<String> lines) {
        Map<String, List<String>> managerMap = new HashMap<>();
        for (String line : lines) {
            String[] parts = line.split(", ");
            String name = parts[0];
            String id = parts[1];
            String age = parts[2];
            String managerId;
            if(parts.length<4){
                managerId = "";
            }else {
                managerId = parts[3];
            }

            if (!managerMap.containsKey(managerId)) {
                managerMap.put(managerId, new ArrayList<>());
            }
            managerMap.get(managerId).add(name + ", " + age + ", " + id);
        }
        return managerMap;
    }

    /**
     * Printing Employee hierarchy by recursion.
     * @param employee
     * @param managerMap
     * @param depth
     * @param writer
     * @throws IOException
     */
    private static void printEmployeeHierarchy(String employee, Map<String, List<String>> managerMap, int depth, BufferedWriter writer) throws IOException {
        // Printing current employee info.
        writer.write(getIndentSpace(depth) + employee + "\n");

        // Printing employee hierarchy which depend on current employee.
        String employeeId = employee.split(", ")[2];
        if (managerMap.containsKey(employeeId)) {
            List<String> subordinates = managerMap.get(employeeId);
            for (String subordinate : subordinates) {
                printEmployeeHierarchy(subordinate, managerMap, depth + 1, writer);
            }
        }
    }

    /**
     * Computing indent space number
     * @param depth
     * @return
     */
    private static String getIndentSpace(int depth) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            // Each indentation of two spaces represents one dependency
            indentation.append("  ");
        }
        return indentation.toString();
    }
}
